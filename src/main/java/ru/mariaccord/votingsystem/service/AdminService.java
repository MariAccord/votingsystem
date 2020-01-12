package ru.mariaccord.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.Meal;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.repository.MealRepository;
import ru.mariaccord.votingsystem.to.MenuTo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AdminService {

    private final MealRepository mealRepository;
    private final RestaurantService restaurantService;

    @Autowired
    public AdminService(MealRepository mealRepository, RestaurantService restaurantService) {
        this.mealRepository = mealRepository;
        this.restaurantService = restaurantService;
    }

    @Transactional
    public void createMenu(MenuTo menuTo){
        Restaurant restaurant = restaurantService.getById(menuTo.getRestaurantId());

        mealRepository.deleteAllByDateAndRestaurant(menuTo.getDate(), restaurant);

        List<Meal> meals = menuTo.getMeals().stream()
                .map(mealTo -> {
                    Meal meal = new Meal();
                    meal.setName(mealTo.getName());
                    meal.setPrice(mealTo.getPrice());
                    meal.setDate(menuTo.getDate());
                    meal.setRestaurant(restaurant);
                    return meal;
                }).collect(Collectors.toList());
        mealRepository.saveAll(meals);
    }
}
