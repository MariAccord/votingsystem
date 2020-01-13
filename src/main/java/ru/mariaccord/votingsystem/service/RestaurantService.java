package ru.mariaccord.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.repository.RestaurantRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant getById(int restaurantId){
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Can`t find restaurant by id = " + restaurantId));
    }

    @Transactional
    public void delete(int restaurantId){
        getById(restaurantId).setEnabled(false);
    }

    @Transactional
    public List<Restaurant> getAll(){
        return restaurantRepository.findAllByEnabled();
    }

    @Transactional
    public getMenu
}
