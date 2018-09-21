package ru.spring.boot.kotov.nikita.simplelibrary.repos;

import org.springframework.data.repository.CrudRepository;
import ru.spring.boot.kotov.nikita.simplelibrary.entities.Text;

public interface TextRepo extends CrudRepository<Text,Long> {
}
