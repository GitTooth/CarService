package by.service.project.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "markId")
    private int markId;

    @Column(name = "title")
    @NotNull(message="is required")
    @Size(min=1, max=45, message="is required")
    private String title;

    @OneToMany(mappedBy = "mark", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Car> cars;

    public Mark() {
    }

    public Mark(String title, List<Car> cars) {
        this.title = title;
        this.cars = cars;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        Mark mark = (Mark) o;
        return markId == mark.markId &&
                Objects.equals(title, mark.title) &&
                Objects.equals(cars, mark.cars);
    }

    @Override
    public int hashCode() {

        return Objects.hash(markId, title, cars);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", title='" + title + '\'' +
                ", cars=" + cars +
                '}';
    }
}
