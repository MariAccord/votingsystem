package ru.mariaccord.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mariaccord.votingsystem.model.Meal;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.service.AdminService;
import ru.mariaccord.votingsystem.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/new")
    public Restaurant createNewRestaurant(Restaurant restaurant) {

        return null;
    }

    @PostMapping("/menu")
    public List<Meal> createNewMenu(int id, Meal meal) {
        return
    }

    @PostMapping("/delete")
    public void deleteRestaurant(int id){

    }
}
