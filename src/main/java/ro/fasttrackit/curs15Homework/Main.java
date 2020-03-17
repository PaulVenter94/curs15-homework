package ro.fasttrackit.curs15Homework;


import static ro.fasttrackit.curs15Homework.DaysOfTheWeek.*;

public class Main {
    public static void main(String[] args) {
        DayPlanner planner = new DayPlanner();
        planner.addActivity(MONDAY, "Swim");
        planner.addActivity(TUESDAY, "JAVA");
        planner.addActivity(WEDNESDAY, "JAVA extra");
        planner.addActivity(THURSDAY, "Cook");
        planner.addActivity(FRIDAY, "Nothing");
        planner.addActivity(SATURDAY, "Coffee time");
        planner.addActivity(SUNDAY, "Church");
        Menu menu = new Menu(planner);
        menu.run();
    }
}
