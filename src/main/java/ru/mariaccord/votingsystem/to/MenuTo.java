package ru.mariaccord.votingsystem.to;

import java.time.LocalDate;
import java.util.List;

public class MenuTo {

    private List<MealTo> meals;
    private int restaurantId;
    private LocalDate date;

    public List<MealTo> getMeals() {
        return meals;
    }

    public void setMeals(List<MealTo> meals) {
        this.meals = meals;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
