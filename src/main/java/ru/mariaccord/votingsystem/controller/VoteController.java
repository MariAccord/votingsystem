package ru.mariaccord.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mariaccord.votingsystem.model.Meal;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.model.Vote;
import ru.mariaccord.votingsystem.service.VoteService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest/users")
public class VoteController {

    @Autowired
    private VoteService service;

    @GetMapping("/id")
    public List<Restaurant> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/menu")
    public List<Meal> getAll(int restrauntId) {
        return service.getAll();
    }

    @GetMapping("/rating")
    public Map<Restaurant, Integer> getRating(){
        return service.getRating;
    }

    @PostMapping("/vote")
    public void vote(){
        
    }
}
