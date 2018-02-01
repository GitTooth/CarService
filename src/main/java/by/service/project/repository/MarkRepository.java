package by.service.project.repository;

import by.service.project.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    List<Mark> getByTitle(String title);
}
