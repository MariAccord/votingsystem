package ru.mariaccord.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mariaccord.votingsystem.model.User;
import ru.mariaccord.votingsystem.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User create(User user) {

        return null;
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public User getById(int userId){
        return userRepository.get(userId);
    }

}
