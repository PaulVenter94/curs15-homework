package ro.fasttrackit.curs15Homework;

import java.util.Scanner;

public class Menu {
    private final DayPlanner planner;

    public Menu(DayPlanner planner) {
        this.planner = planner;
    }

    public Menu() {
        planner = new DayPlanner();
    }

    public void run() {
        int input = 0;
        do {
            printMenu();
            input = getInput();
            doInput(input);
        } while (input != 5);
    }

    private void doInput(int input) {
        switch (input) {
            case 1:
                listActivity();
                break;
            case 2:
                add();
                break;
            case 3:
                remove();
                break;
            case 4:
                endPlanning();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void endPlanning() {
        try {
            System.out.println(planner.endPlanning());
        } catch (NoActivitiesForDay noActivitiesForDay) {
            System.out.println(noActivitiesForDay.getMessage());
        }
    }

    private void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("From which day you wish to remove activity:");
        String day = scanner.nextLine();
        System.out.println("What activity:");
        String activity = scanner.nextLine();
        try {
            planner.removeActivity(DaysOfTheWeek.valueOf(day.toUpperCase()), activity);
            System.out.println("Done!");
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
    }

    private void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which day you wish to add:");
        String day = scanner.nextLine();
        System.out.println("What activity:");
        String activity = scanner.nextLine();
        try {
            planner.addActivity(DaysOfTheWeek.valueOf(day.toUpperCase()), activity);
            System.out.println("Done!");
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For which day?");
        String day=scanner.nextLine();
        System.out.println(planner.getActivities(DaysOfTheWeek.valueOf(day.toUpperCase())));
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void printMenu() {
        System.out.println("1)List all current activities for a day" +
                "\n" +
                "2)Add activity " +
                "\n" +
                "3)Remove activity" +
                "\n" +
                "4)End planning " +
                "\n" +
                "5)Exit");
    }
}
