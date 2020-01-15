package ru.mariaccord.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.security.SecurityUtil;
import ru.mariaccord.votingsystem.service.RestaurantService;
import ru.mariaccord.votingsystem.service.VoteService;
import ru.mariaccord.votingsystem.to.MealTo;
import ru.mariaccord.votingsystem.to.RestaurantVotesTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/rest/restaurant")
public class VoteController {

    private VoteService voteService;
    private RestaurantService restaurantService;

    @Autowired
    public VoteController(VoteService voteService, RestaurantService restaurantService) {
        this.voteService = voteService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/rating")
    public List<RestaurantVotesTo> getRating(@RequestParam(value = "date", required = false)
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        if (Objects.isNull(date)) {
            date = LocalDate.now();
        }
        return voteService.getRating(date);
    }

    @PostMapping("/{restaurantId}/vote")
    public String vote(@PathVariable int restaurantId){
        return voteService.makeVote(restaurantId, SecurityUtil.getCurrentUserName()).getValue();
    }

    @GetMapping("/")
    public List<Restaurant> getAllRestaurant()
    {
        return restaurantService.getAll();
    }

    @GetMapping("/{restaurantId}/menu")
    public List<MealTo> getMenu(@PathVariable int restaurantId) {
        return restaurantService.getMenu(LocalDate.now(), restaurantId);
    }
}
