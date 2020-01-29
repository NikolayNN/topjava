package ru.javawebinar.topjava.util;

import org.junit.Test;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserMealsUtilTest {

    @Test
    public void shouldReturnFourMealsBetween_7_and_15() {
        UserMeal m1 = new UserMeal(date(30, 10, 0), "Завтрак", 500);
        UserMeal m2 = new UserMeal(date(30, 13, 0), "Обед", 1000);
        UserMeal m3 = new UserMeal(date(30, 20, 0), "Ужин", 500);
        UserMeal m4 = new UserMeal(date(31, 0, 0), "Еда на граничное значение", 100);
        UserMeal m5 = new UserMeal(date(31, 10, 0), "Завтрак", 1000);
        UserMeal m6 = new UserMeal(date(31, 13, 0), "Обед", 500);
        UserMeal m7 = new UserMeal(date(31, 20, 0), "Ужин", 410);

        List<UserMeal> givenMeals = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);

        LocalTime givenStart = LocalTime.of(7, 0);
        LocalTime givenEnd = LocalTime.of(15, 0);
        int givenCalories = 2000;

        List<UserMealWithExcess> actualCycles = UserMealsUtil.filteredByCycles(givenMeals, givenStart, givenEnd, givenCalories);
        List<UserMealWithExcess> actualStreams = UserMealsUtil.filteredByStreams(givenMeals, givenStart, givenEnd, givenCalories);

        actualCycles.forEach(System.out::println);

        List<UserMealWithExcess> expected = Arrays.asList(
                new UserMealWithExcess(m1, false),
                new UserMealWithExcess(m2, false),
                new UserMealWithExcess(m5, true),
                new UserMealWithExcess(m6, true));

        assertEquals(expected, actualCycles);
        assertEquals(expected, actualStreams);
    }

    @Test
    public void shouldReturnOneMealsBetween_0_and_7() {
        UserMeal m1 = new UserMeal(date(30, 10, 0), "Завтрак", 500);
        UserMeal m2 = new UserMeal(date(30, 13, 0), "Обед", 1000);
        UserMeal m3 = new UserMeal(date(30, 20, 0), "Ужин", 500);
        UserMeal m4 = new UserMeal(date(31, 0, 0), "Еда на граничное значение", 100);
        UserMeal m5 = new UserMeal(date(31, 10, 0), "Завтрак", 1000);
        UserMeal m6 = new UserMeal(date(31, 13, 0), "Обед", 500);
        UserMeal m7 = new UserMeal(date(31, 20, 0), "Ужин", 410);

        List<UserMeal> givenMeals = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);

        LocalTime givenStart = LocalTime.of(0, 0);
        LocalTime givenEnd = LocalTime.of(7, 0);
        int givenCalories = 2000;

        List<UserMealWithExcess> actualCycles = UserMealsUtil.filteredByCycles(givenMeals, givenStart, givenEnd, givenCalories);
        List<UserMealWithExcess> actualStreams = UserMealsUtil.filteredByStreams(givenMeals, givenStart, givenEnd, givenCalories);

        actualCycles.forEach(System.out::println);

        List<UserMealWithExcess> expected = Arrays.asList(
                new UserMealWithExcess(m4, true));

        assertEquals(expected, actualCycles);
        assertEquals(expected, actualStreams);
    }

    @Test
    public void shouldReturnThreeMealsBetween_0_and_10() {
        UserMeal m1 = new UserMeal(date(30, 10, 0), "Завтрак", 500);
        UserMeal m2 = new UserMeal(date(30, 13, 0), "Обед", 1000);
        UserMeal m3 = new UserMeal(date(30, 20, 0), "Ужин", 500);
        UserMeal m4 = new UserMeal(date(31, 0, 0), "Еда на граничное значение", 100);
        UserMeal m5 = new UserMeal(date(31, 10, 0), "Завтрак", 1000);
        UserMeal m6 = new UserMeal(date(31, 13, 0), "Обед", 500);
        UserMeal m7 = new UserMeal(date(31, 20, 0), "Ужин", 410);

        List<UserMeal> givenMeals = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);

        LocalTime givenStart = LocalTime.of(0, 0);
        LocalTime givenEnd = LocalTime.of(10, 0);
        int givenCalories = 2000;

        List<UserMealWithExcess> actualCycles = UserMealsUtil.filteredByCycles(givenMeals, givenStart, givenEnd, givenCalories);
        List<UserMealWithExcess> actualStreams = UserMealsUtil.filteredByStreams(givenMeals, givenStart, givenEnd, givenCalories);

        actualCycles.forEach(System.out::println);

        List<UserMealWithExcess> expected = Arrays.asList(
                new UserMealWithExcess(m1, false),
                new UserMealWithExcess(m4, true),
                new UserMealWithExcess(m5, true));

        assertEquals(expected, actualCycles);
        assertEquals(expected, actualStreams);
    }

    @Test
    public void shouldReturnZeroMealsBetween_1_and_5() {
        UserMeal m1 = new UserMeal(date(30, 10, 0), "Завтрак", 500);
        UserMeal m2 = new UserMeal(date(30, 13, 0), "Обед", 1000);
        UserMeal m3 = new UserMeal(date(30, 20, 0), "Ужин", 500);
        UserMeal m4 = new UserMeal(date(31, 0, 0), "Еда на граничное значение", 100);
        UserMeal m5 = new UserMeal(date(31, 10, 0), "Завтрак", 1000);
        UserMeal m6 = new UserMeal(date(31, 13, 0), "Обед", 500);
        UserMeal m7 = new UserMeal(date(31, 20, 0), "Ужин", 410);

        List<UserMeal> givenMeals = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);

        LocalTime givenStart = LocalTime.of(1, 0);
        LocalTime givenEnd = LocalTime.of(5, 0);
        int givenCalories = 2000;

        List<UserMealWithExcess> actualCycles = UserMealsUtil.filteredByCycles(givenMeals, givenStart, givenEnd, givenCalories);
        List<UserMealWithExcess> actualStreams = UserMealsUtil.filteredByStreams(givenMeals, givenStart, givenEnd, givenCalories);

        actualCycles.forEach(System.out::println);

        List<UserMealWithExcess> expected = Arrays.asList();

        assertEquals(expected, actualCycles);
        assertEquals(expected, actualStreams);
    }

    @Test
    public void shouldReturnOneMealsBetween_0_and_1_ifOneEsceedMeal() {
        UserMeal m1 = new UserMeal(date(30, 10, 0), "Завтрак", 500);
        UserMeal m2 = new UserMeal(date(30, 13, 0), "Обед", 1000);
        UserMeal m3 = new UserMeal(date(30, 20, 0), "Ужин", 500);
        UserMeal m4 = new UserMeal(date(31, 0, 0), "Еда на граничное значение", 5000);
        UserMeal m5 = new UserMeal(date(31, 10, 0), "Завтрак", 1000);
        UserMeal m6 = new UserMeal(date(31, 13, 0), "Обед", 500);
        UserMeal m7 = new UserMeal(date(31, 20, 0), "Ужин", 410);

        List<UserMeal> givenMeals = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);

        LocalTime givenStart = LocalTime.of(0, 0);
        LocalTime givenEnd = LocalTime.of(1, 0);
        int givenCalories = 2000;

        List<UserMealWithExcess> actualCycles = UserMealsUtil.filteredByCycles(givenMeals, givenStart, givenEnd, givenCalories);
        List<UserMealWithExcess> actualStreams = UserMealsUtil.filteredByStreams(givenMeals, givenStart, givenEnd, givenCalories);

        actualCycles.forEach(System.out::println);

        List<UserMealWithExcess> expected = Arrays.asList(
                new UserMealWithExcess(m4, true));

        assertEquals(expected, actualCycles);
        assertEquals(expected, actualStreams);
    }

    @Test
    public void shouldReturnOneMealsBetween_7_and_15_ifOneEsceedMeal() {
        UserMeal m1 = new UserMeal(date(30, 10, 0), "Завтрак", 500);
        UserMeal m2 = new UserMeal(date(30, 13, 0), "Обед", 1000);
        UserMeal m3 = new UserMeal(date(30, 14, 0), "Ужин", 1000);
        UserMeal m4 = new UserMeal(date(31, 0, 0), "Еда на граничное значение", 500);
        UserMeal m5 = new UserMeal(date(31, 10, 0), "Завтрак", 1000);
        UserMeal m6 = new UserMeal(date(31, 13, 0), "Обед", 500);
        UserMeal m7 = new UserMeal(date(31, 14, 0), "Ужин", 1000);

        List<UserMeal> givenMeals = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);

        LocalTime givenStart = LocalTime.of(7, 0);
        LocalTime givenEnd = LocalTime.of(15, 0);
        int givenCalories = 2000;

        List<UserMealWithExcess> actualCycles = UserMealsUtil.filteredByCycles(givenMeals, givenStart, givenEnd, givenCalories);
        List<UserMealWithExcess> actualStreams = UserMealsUtil.filteredByStreams(givenMeals, givenStart, givenEnd, givenCalories);

        actualCycles.forEach(System.out::println);

        List<UserMealWithExcess> expected = Arrays.asList(
                new UserMealWithExcess(m1, true),
                new UserMealWithExcess(m2, true),
                new UserMealWithExcess(m3, true),
                new UserMealWithExcess(m5, true),
                new UserMealWithExcess(m6, true),
                new UserMealWithExcess(m7, true)
        );

        assertEquals(expected, actualCycles);
        assertEquals(expected, actualStreams);
    }

    @Test
    public void shouldReturnEmptyListIfGivrnListIsNUll() {

        List<UserMeal> givenMeals = null;

        LocalTime givenStart = LocalTime.of(0, 0);
        LocalTime givenEnd = LocalTime.of(23, 59);
        int givenCalories = 2000;

        List<UserMealWithExcess> actualCycles = UserMealsUtil.filteredByCycles(givenMeals, givenStart, givenEnd, givenCalories);
        List<UserMealWithExcess> actualStreams = UserMealsUtil.filteredByStreams(givenMeals, givenStart, givenEnd, givenCalories);

        List<UserMealWithExcess> expected = Arrays.asList();

        assertEquals(expected, actualCycles);
        assertEquals(expected, actualStreams);
    }

    private LocalDateTime date(int dayOfMonth, int hour, int minute) {
        return LocalDateTime.of(2020, Month.JANUARY, dayOfMonth, hour, minute);
    }
}
