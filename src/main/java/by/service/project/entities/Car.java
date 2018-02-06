package by.service.project.entities;

import by.service.project.app.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "model")
    @NotNull(message = Constants.REQUIRED)
    @Size(min = 1, max = 45, message = Constants.REQUIRED)
    private String model;

    @Column(name = "release_date")
    @NotNull(message = Constants.REQUIRED)
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "country")
    @NotNull(message = Constants.REQUIRED)
    @Size(min = 1, max = 45, message = Constants.REQUIRED)
    private String country;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "mark")
    private Mark mark;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "colour")
    private Colour colour;

    public Car() {
    }

    public Car(int id, String model, Date releaseDate, String country, Mark mark, Colour colour) {
        this.carId = id;
        this.model = model;
        this.releaseDate = releaseDate;
        this.country = country;
        this.mark = mark;
        this.colour = colour;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour clolour) {
        this.colour = clolour;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.PATTERN_DATE);
        if (releaseDate != null) {
            return dateFormat.format(releaseDate);
        } else {
            return dateFormat.format(new Date());
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", releaseDate=" + releaseDate +
                ", country='" + country + '\'' +
                ", mark=" + mark +
                ", colour=" + colour +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                Objects.equals(model, car.model) &&
                Objects.equals(releaseDate, car.releaseDate) &&
                Objects.equals(country, car.country) &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(colour, car.colour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carId, model, releaseDate, country, mark, colour);
    }
}
