package io.cucumber.skeleton;

import foo.petNanny.domain.PlageDeDate;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class StepDefinitions {
    Belly belly;
    private List<PlageDeDate> plageDeDateList;

    @Given("I have {int} cuke(s) in my belly")
    public void iHaveCukes(int cukes) {
        this.belly = new Belly();
        this.belly.eat(cukes);
    }

    @Given("I have {int} cukes in my belly and I wait {int} hour")
    public void i_have_cukes_in_my_belly_and_i_wait_hour(Integer cukes, Integer hours) {
        this.belly = new Belly();
        this.belly.eat(cukes);
        this.belly.waitX(hours);
    }

    @Given("I have this cukes in my belly")
    public void i_have_this_cukes_in_my_belly(io.cucumber.datatable.DataTable dataTable) {
        this.belly = new Belly();
        int cukes = dataTable.height() - 1;
        for (int row = 1; row < dataTable.height(); row++) {
            this.belly.eat(Integer.parseInt(dataTable.cell(row, 1)));
        }
    }

    @When("I wait {int} hour(s)")
    public void i_wait_hour(Integer hours) {
        this.belly.waitX(hours);
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        assertThat(this.belly.getCakes().toString(), this.belly.isGrowling(), equalTo(true));
    }

    @Then("my belly should not growl")
    public void my_belly_should_not_growl() {
        assertThat(this.belly.getCakes().toString(), this.belly.isGrowling(), equalTo(false));
    }

    @Then("I take a coffee")
    public void i_take_a_coffee() {
        assertThat(true, equalTo(false));

    }

    @DataTableType
    public PlageDeDate plageDeDateFromDataDable(Map<String, String> entry) {
        return new PlageDeDate(
                LocalDate.parse(entry.get("Debut")),
                LocalDate.parse(entry.get("Fin"))
        );
    }

    @Etantdonné("ces plages de date")
    public void ces_plages_de_date(List<PlageDeDate> plageDeDateList) {
        this.plageDeDateList = plageDeDateList;
    }

    @Alors("les plages ne se chevauchent pas")
    public void les_plages_ne_se_chevauchent_pas() {
        var plage1 = this.plageDeDateList.get(0);
        var plage2 = this.plageDeDateList.get(this.plageDeDateList.size() - 1);

        assertThat(plage1.estInclusDans(plage2), is(false));
    }

    @Alors("les plages se chevauchent")
    public void les_plages_se_chevauchent() {
        var plage1 = this.plageDeDateList.get(0);
        var plage2 = this.plageDeDateList.get(this.plageDeDateList.size() - 1);

        assertThat(plage1.estInclusDans(plage2), is(true));
    }
}
