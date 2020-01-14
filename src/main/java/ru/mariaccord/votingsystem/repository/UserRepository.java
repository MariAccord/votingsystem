package ru.mariaccord.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mariaccord.votingsystem.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
        Optional<User> findByName(String name);
}
