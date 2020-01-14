package ru.mariaccord.votingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.model.User;
import ru.mariaccord.votingsystem.model.Vote;
import ru.mariaccord.votingsystem.model.VoteStatus;
import ru.mariaccord.votingsystem.repository.UserRepository;
import ru.mariaccord.votingsystem.repository.VoteRepository;
import ru.mariaccord.votingsystem.to.RestaurantVotesTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.mariaccord.votingsystem.model.VoteStatus.*;

@Service
@Transactional(readOnly = true)
public class VoteService {

    private final VoteRepository voteRepository;
    private final RestaurantService restaurantService;
    private final UserService userService;
    private final LocalTime REVOTE_END_TIME = LocalTime.of(11, 0, 0);

    public VoteService(VoteRepository repository, RestaurantService restaurantService, UserRepository userRepository, UserService userService) {
        this.voteRepository = repository;
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @Transactional
    public VoteStatus makeVote(int restaurantId, String userName) {
        Restaurant restaurant = restaurantService.getById(restaurantId);
        User user = userService.getByName(userName);
        Optional<Vote> voteOfDay = voteRepository.findByUserAndDateTimeAfter(user, LocalDate.now().atStartOfDay());
        if (voteOfDay.isPresent()) {
            if (LocalTime.now().isAfter(REVOTE_END_TIME)) {
                return LATE;
            }
            voteOfDay.get().setRestaurant(restaurant);
            return REVOTE;
        }
        Vote vote = new Vote();
        vote.setRestaurant(restaurant);
        vote.setUser(user);
        vote.setDateTime(LocalDateTime.now());
        return SUCCESSFULL;
    }

    @Transactional
    public List<RestaurantVotesTo> getRating(LocalDate date) {
        return voteRepository.getRating(date.atStartOfDay(), date.plusDays(1L).atStartOfDay())
                .stream()
                .map(e -> {
                    RestaurantVotesTo restaurantVotesTo = new RestaurantVotesTo();
                    restaurantVotesTo.setId(e.getId());
                    restaurantVotesTo.setCount(e.getCount());
                    restaurantVotesTo.setName(e.getName());
                    return restaurantVotesTo;
                })
                .collect(Collectors.toList());
    }
}
