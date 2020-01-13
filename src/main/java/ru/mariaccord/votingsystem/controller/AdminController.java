package ru.mariaccord.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mariaccord.votingsystem.model.Meal;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.service.AdminService;
import ru.mariaccord.votingsystem.service.RestaurantService;
import ru.mariaccord.votingsystem.service.UserService;
import ru.mariaccord.votingsystem.to.MenuTo;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurant/new")
    public Restaurant createNewRestaurant(Restaurant restaurant) {

        return restaurantService.createRestaurant(restaurant);
    }

    @PostMapping("/restaurant/{restaurantId}/menu/new")
    public List<Meal> createMenu(@RequestBody MenuTo menuTo, @RequestParam int restaurantId) {
        return adminService.createMenu(menuTo, restaurantId);
    }

    @PostMapping("/delete")
    public void deleteRestaurant(int restaurantId){
        restaurantService.delete(restaurantId);
    }
}
