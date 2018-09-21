package ru.spring.boot.kotov.nikita.simplelibrary.repos;

import org.springframework.data.repository.CrudRepository;
import ru.spring.boot.kotov.nikita.simplelibrary.entities.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message,Long> {
    List<Message> findByName(String name);
}
