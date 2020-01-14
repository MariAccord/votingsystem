package ru.mariaccord.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.repository.MealRepository;
import ru.mariaccord.votingsystem.repository.RestaurantRepository;
import ru.mariaccord.votingsystem.to.MealTo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MealRepository mealRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, MealRepository mealRepository) {
        this.restaurantRepository = restaurantRepository;
        this.mealRepository = mealRepository;
    }

    @Transactional
    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant getById(int restaurantId){
        return restaurantRepository.getOne(restaurantId);
    }

    @Transactional
    public void delete(int restaurantId){
        getById(restaurantId).setEnabled(false);
    }

    @Transactional
    public List<Restaurant> getAll(){
        return restaurantRepository.findAllByEnabledIsTrue();
    }

    @Transactional
    public List<MealTo> getMenu(LocalDate date, int restaurantId){
        Restaurant restaurant = getById(restaurantId);

        return mealRepository.findAllByDateAndAndRestaurant(date, restaurant)
                .stream().map(meal -> {
                    MealTo mealTo = new MealTo();
                    mealTo.setName(meal.getName());
                    mealTo.setPrice(meal.getPrice());
                    return mealTo;
                }).collect(Collectors.toList());
    }
}
