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
import ru.mariaccord.votingsystem.to.RestaurantVotesTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/voting")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/rating")
    public List<RestaurantVotesTo> getRating(LocalDate date){

        return voteService.getRating(date);
    }

    @PostMapping("/vote")
    public void vote(int restaurantId, int userId){
        voteService.makeVote(restaurantId, userId);
    }
}
