package ru.mariaccord.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.User;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);

    boolean delete(int id);

    User get(int id);
}
