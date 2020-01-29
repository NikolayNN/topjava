package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserMealsUtil {

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime,
                                                            LocalTime endTime, int caloriesPerDay) {
        if (meals == null) {
            return new ArrayList<>();
        }
        final Map<LocalDate, Integer> caloriesDate = new HashMap<>();
        meals.forEach(meal -> caloriesDate.merge(meal.getDate(), meal.getCalories(), Integer::sum));

        final List<UserMealWithExcess> result = new ArrayList<>(meals.size());
        for (UserMeal m : meals) {
            if (TimeUtil.isBetweenInclusive(m.getTime(), startTime, endTime)) {
                result.add(new UserMealWithExcess(m, caloriesDate.get(m.getDate()) > caloriesPerDay));
            }
        }
        return result;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime,
                                                             LocalTime endTime, int caloriesPerDay) {
        if (meals == null) {
            return new ArrayList<>();
        }
        Map<LocalDate, Integer> caloriesDate = meals.stream()
                .collect(Collectors.groupingBy(um -> um.getDateTime().toLocalDate(),
                        Collectors.summingInt(UserMeal::getCalories)));
        return meals.stream()
                .filter(um -> TimeUtil.isBetweenInclusive(um.getDateTime().toLocalTime(), startTime, endTime))
                .map(um -> new UserMealWithExcess(um, caloriesDate.get(um.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }
}
