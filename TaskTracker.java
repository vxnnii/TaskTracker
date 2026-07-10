/*
Author: Jovanni Elias

Purpose: This program will be used to track users tasks. 

    They will be able to
    - Add a task
    - View tasks
    - Mark task as complete
    - Remove tasks 
    - Exit the program

I am purposefuly going to put everything under one single file to start and then show how we break it down for us to have a running, loose coupled program. This would be the heart of Object Oriented Programming with multiple classes rather that one huge class. 
*/

import java.util.ArrayList;
import java.util.Scanner;


public class TaskTracker {

  static ArrayList<String> tasks = new ArrayList<>();
  static ArrayList<Boolean> completed = new ArrayList<>();

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    boolean running = true;
    System.out.println("=== Student Task Tracker ===");

    while (running) {
      System.out.println("\nMenu:");
      System.out.println("1. Add Task");
      System.out.println("2. View Tasks");
      System.out.println("3. Mark Task Complete");
      System.out.println("4. Remove Task");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      if (!scanner.hasNextInt()) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine();
        continue;
        }
    }
}



/***** Methods *****/

public static void addTask(Scanner scanner) {
    System.out.print("Enter task description: ");
    String task = scanner.nextLine();
    tasks.add(task);
    completed.add(false);
    System.out.println("Task added successfully.");
  }
}