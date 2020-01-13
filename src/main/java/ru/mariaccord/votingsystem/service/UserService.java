package ru.mariaccord.votingsystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.User;
import ru.mariaccord.votingsystem.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Transactional
    public User create(User user) {

        return null;
    }

    @Transactional
    public void delete(int id) {

        userRepository.delete(id);
    }

    @Transactional
    public User get(int id) {

        return userRepository.get(id);
    }

    @Transactional
    public void update(User user){

    }

    @Transactional
    public void enable(int id, boolean enabled){
        User user = get(id);
        user.setEnabled(enabled);
    }

    @Transactional
    public User getById(int userId){

        return userRepository.get(userId);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
