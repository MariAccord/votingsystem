package ru.mariaccord.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.mariaccord.votingsystem.model.Meal;
import ru.mariaccord.votingsystem.model.Restaurant;

import java.time.LocalDate;

@Transactional(readOnly = true)
public interface MealRepository extends JpaRepository<Meal, Integer> {

    void deleteAllByDateAndRestaurant(LocalDate date, Restaurant restaurant);


}
