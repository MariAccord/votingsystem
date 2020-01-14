package ru.mariaccord.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mariaccord.votingsystem.model.Meal;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.service.AdminService;
import ru.mariaccord.votingsystem.service.RestaurantService;
import ru.mariaccord.votingsystem.to.MenuTo;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin")
public class AdminController {

    private AdminService adminService;
    private RestaurantService restaurantService;

    @Autowired
    public AdminController(AdminService adminService, RestaurantService restaurantService) {
        this.adminService = adminService;
        this.restaurantService = restaurantService;
    }

    @PostMapping(value = "/restaurant/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant) {
        System.out.println(restaurant);
        return restaurantService.createRestaurant(restaurant);
    }

    @PostMapping("/restaurant/{restaurantId}/menu/new")
    public List<Meal> createMenu(@RequestBody MenuTo menuTo, @PathVariable int restaurantId) {
        return adminService.createMenu(menuTo, restaurantId);
    }

    @PostMapping("/{restaurantId}/delete")
    public void deleteRestaurant(@PathVariable int restaurantId){
        restaurantService.delete(restaurantId);
    }
}
