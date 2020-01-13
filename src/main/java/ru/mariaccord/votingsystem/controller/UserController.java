package ru.mariaccord.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mariaccord.votingsystem.model.Meal;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestraunt()
    {
        return restaurantService.getAll();
    }


    @GetMapping("/menu")
    public List<Meal> getMenu(int restrauntId) {
        return null;
    }

}
