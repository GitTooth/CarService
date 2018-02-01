package by.service.project.entities;

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
    @Column(name = "carId")
    private int carId;

    @Column(name = "model")
    @NotNull(message="is required")
    @Size(min=1, max=45, message="is required")
    private String model;

    @Column(name = "color")
    @NotNull(message="is required")
    @Size(min=1, max=45, message="is required")
    private String color;

    @Column(name = "releaseDate")
    @NotNull(message="is required")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "country")
    @NotNull(message="is required")
    @Size(min=1, max=45, message="is required")
    private String country;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="mark")
    private Mark mark;

    public Car() {
    }

    public Car(int carId, Mark mark, String model, String color, Date releaseDate, String country) {
        this.carId = carId;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.releaseDate = releaseDate;
        this.country = country;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(releaseDate != null) {
            return dateFormat.format(releaseDate);
        }else {
            return dateFormat.format(new Date());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(releaseDate, car.releaseDate) &&
                Objects.equals(country, car.country) &&
                Objects.equals(mark, car.mark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carId, model, color, releaseDate, country, mark);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", releaseDate=" + releaseDate +
                ", country='" + country + '\'' +
                ", mark=" + mark +
                '}';
    }
}
