package ru.mariaccord.votingsystem.to;

import java.time.LocalDate;
import java.util.List;

public class MenuTo {

    private List<MealTo> meals;
    private LocalDate date;

    public List<MealTo> getMeals() {
        return meals;
    }

    public void setMeals(List<MealTo> meals) {
        this.meals = meals;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
