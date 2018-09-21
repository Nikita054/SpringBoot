package ru.spring.boot.kotov.nikita.simplelibrary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spring.boot.kotov.nikita.simplelibrary.entities.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
