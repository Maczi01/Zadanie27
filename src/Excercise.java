import java.time.LocalDateTime;
import java.util.Objects;

public class Excercise {

    String trescZadania;
    LocalDateTime datawykonania;
    boolean czyWykonane;

    public Excercise() {
        this.setCzyWykonane(false);
    }


    public Excercise(String trescZadania, LocalDateTime datawykonania, boolean czyWykonane) {
        this.trescZadania = trescZadania;
        this.datawykonania = datawykonania;
        this.czyWykonane = czyWykonane;
    }

    public String getTrescZadania() {
        return trescZadania;
    }

    public void setTrescZadania(String trescZadania) {
        this.trescZadania = trescZadania;
    }

    public LocalDateTime getDatawykonania() {
        return datawykonania;
    }

    public void setDatawykonania(LocalDateTime datawykonania) {
        this.datawykonania = datawykonania;
    }

    public boolean isCzyWykonane() {
        return czyWykonane;
    }

    public void setCzyWykonane(boolean czyWykonane) {
        this.czyWykonane = czyWykonane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excercise excercise = (Excercise) o;
        return czyWykonane == excercise.czyWykonane &&
                Objects.equals(trescZadania, excercise.trescZadania) &&
                Objects.equals(datawykonania, excercise.datawykonania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trescZadania, datawykonania, czyWykonane);
    }

    @Override
    public String toString() {
        return "Zadanie o tresci "  + trescZadania + '\'' +
                " z data wykonania " + datawykonania +
                ". Czy zostalo wykonane ? :" + czyWykonane +
                "\n";
    }
}
