package foo.petNanny.domain;

import java.time.LocalDate;
import java.util.Objects;

public final class PlageDeDate {
    private final LocalDate debut;
    private final LocalDate fin;

    public PlageDeDate(LocalDate debut, LocalDate fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDate debut() {
        return debut;
    }

    public LocalDate fin() {
        return fin;
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PlageDeDate) obj;
        return Objects.equals(this.debut, that.debut) &&
                Objects.equals(this.fin, that.fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debut, fin);
    }
*/
    @Override
    public String toString() {
        return "PlageDeDate[" +
                "debut=" + debut + ", " +
                "fin=" + fin + ']';
    }

    public boolean estInclusDans(PlageDeDate plage2) {
        return false;
    }
}
