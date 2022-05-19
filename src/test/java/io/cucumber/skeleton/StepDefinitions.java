package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StepDefinitions {
    Belly belly;
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

    @When("I wait {int} hour(s)")
    public void i_wait_hour(Integer hours) {
        this.belly.waitX(hours);
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        assertThat(  this.belly.isGrowling(), equalTo(true));
    }

    @Then("my belly should not growl")
    public void my_belly_should_not_growl() {
        assertThat(  this.belly.isGrowling(), equalTo(false));
    }

    @Then("I take a coffee")
    public void i_take_a_coffee() {
      assertThat(true, equalTo(false));

    }
}
