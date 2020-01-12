package ru.mariaccord.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mariaccord.votingsystem.model.*;
import ru.mariaccord.votingsystem.repository.MealRepository;
import ru.mariaccord.votingsystem.repository.RestaurantRepository;
import ru.mariaccord.votingsystem.repository.UserRepository;
import ru.mariaccord.votingsystem.repository.VoteRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@RestController
public class  TestController {

    private final UserRepository userRepository;
    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;
    @Autowired
    public TestController(UserRepository userRepository, MealRepository mealRepository, RestaurantRepository restaurantRepository, VoteRepository voteRepository) {
        this.userRepository = userRepository;
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
        this.voteRepository = voteRepository;
    }

    @Transactional
    @GetMapping("/vote/test")
    public String test() {
        User user = new User();
        user.setRoles(new HashSet<>(Arrays.asList(Role.ROLE_USER)));
        user.setEmail("a@mail.ru");
        user.setName("user");
        user.setPassword("12345");

        Restaurant restaurant = new Restaurant();
        restaurant.setName("Ресторан");

        Meal meal = new Meal();
        meal.setDateTime(LocalDateTime.now());
        meal.setName("Суп");
        meal.setPrice(BigDecimal.valueOf(200));
        meal.setRestaurant(restaurant);

        Vote vote = new Vote();
        vote.setDateTime(LocalDateTime.now());
        vote.setRestaurant(restaurant);
        vote.setUser(user);

        String s = userRepository.save(user).getId() + " " + restaurantRepository.save(restaurant).getId() + " "
                + mealRepository.save(meal).getId() + " " + voteRepository.save(vote).getId();
        return s;
    }
}
