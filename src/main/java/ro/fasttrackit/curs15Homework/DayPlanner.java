package ro.fasttrackit.curs15Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayPlanner {
    private final List<DaySchedule> schedules;

    public DayPlanner(List<DaySchedule> schedules) {
        this.schedules = schedules == null ? new ArrayList<>() : new ArrayList<>(schedules);
    }

    public DayPlanner() {
        this.schedules = new ArrayList<>();
    }

    public void addActivity(DaysOfTheWeek day, String activity) {
        if (activity != null) {
            if (findDay(day) != null) {
                findDay(day).addActivity(activity);
            } else {
                schedules.add(new DaySchedule(day, new ArrayList<>(List.of(activity))));
            }
        } else {
            throw new NoActivityException();
        }
    }

    public void removeActivity(DaysOfTheWeek day, String activity) {
        if (findDay(day) != null) {
            if (!findDay(day).removeActivity(activity)) {
                throw new NoActivityException();
            }
        }
    }

    public List<String> getActivities(DaysOfTheWeek day) {
        if (findDay(day).getActivities() == null) {
            return new ArrayList<>();
        } else {
            return findDay(day).getActivities();
        }
    }

    public Map<DaysOfTheWeek, List<String>> endPlanning() throws NoActivitiesForDay {
        Map<DaysOfTheWeek, List<String>> result = new HashMap<>();
        for (DaySchedule schedule : schedules) {
            result.put(schedule.getDay(), schedule.getActivities());
        }
        if (result.size() < DaysOfTheWeek.values().length) {
            throw new NoActivitiesForDay();

        } else {
            return result;
        }

    }

    private DaySchedule findDay(DaysOfTheWeek day) {
        for (DaySchedule schedule : schedules) {
            if (schedule.getDay().equals(day)) {
                return schedule;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DayPlanner{" +
                "schedules=" + schedules +
                '}';
    }
}
