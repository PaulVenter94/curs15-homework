package ro.fasttrackit.curs15Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaySchedule {
    private final DaysOfTheWeek day;
    private final List<String> activities;

    public DaySchedule(DaysOfTheWeek day, List<String> activities) {
        this.day = day;
        this.activities = activities == null ? new ArrayList<>() : new ArrayList<>(activities);
    }

    public void addActivity(String activity) {
        this.activities.add(activity);
    }

    public boolean removeActivity(String activity) {
        return activities.remove(activity);
    }

    public List<String> getActivities() {
        return new ArrayList<>(activities);
    }

    public DaysOfTheWeek getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DaySchedule)) return false;
        DaySchedule that = (DaySchedule) o;
        return getDay() == that.getDay() &&
                Objects.equals(getActivities(), that.getActivities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getActivities());
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }
}
