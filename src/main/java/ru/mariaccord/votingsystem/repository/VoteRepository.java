package ru.mariaccord.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.Restaurant;
import ru.mariaccord.votingsystem.model.User;
import ru.mariaccord.votingsystem.model.Vote;
import ru.mariaccord.votingsystem.model.VoteResult;
import ru.mariaccord.votingsystem.to.RestaurantVotesTo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    public Optional<Vote> findByUserAndDateTimeAfter(User user, LocalDateTime dateTime);

    @Query(nativeQuery = true, value = "SELECT restaurants.id, restaurants.name, count(votes.id) AS count FROM votes\n" +
            "    RIGHT JOIN restaurants ON restaurant_id = restaurants.id\n" +
            "    WHERE restaurants.enabled = true\n" +
            "    AND votes.date_time BETWEEN :startTime AND :endTime\n" +
            "GROUP BY restaurants.id\n" +
            "ORDER BY count DESC")
    public List<VoteResult> getRating(LocalDateTime startTime, LocalDateTime endTime);
}
