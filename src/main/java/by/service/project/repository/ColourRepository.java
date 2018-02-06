package by.service.project.repository;

import by.service.project.entities.Colour;
import by.service.project.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColourRepository extends JpaRepository<Colour, Integer> {
    List<Colour> getByName(String name);
}
