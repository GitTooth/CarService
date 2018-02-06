package by.service.project.entities;

import by.service.project.app.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "colours")
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colour_id")
    private int colourId;

    @Column(name = "name")
    @NotNull(message = Constants.REQUIRED)
    @Size(min = 1, max = 45, message = Constants.REQUIRED)
    private String name;

    @OneToMany(mappedBy = "colour", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Car> cars;

    public Colour() {
    }

    public Colour(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public int getColourId() {
        return colourId;
    }

    public void setColourId(int colourId) {
        this.colourId = colourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return colourId == colour.colourId &&
                Objects.equals(name, colour.name) &&
                Objects.equals(cars, colour.cars);
    }

    @Override
    public int hashCode() {

        return Objects.hash(colourId, name, cars);
    }
}
