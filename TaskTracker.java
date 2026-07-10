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


public static void viewTasks() {
    if (tasks.isEmpty()) {
      System.out.println("No tasks available.");
      return;
    }
    System.out.println("\nTasks:");
    for (int i = 0; i < tasks.size(); i++) {
      String status = completed.get(i) ? "[Completed]" : "[Pending]";
      System.out.println((i + 1) + ". " + tasks.get(i) + " " + status);
    }
  }

public static void markTaskComplete(Scanner scanner) {
    viewTasks();
    System.out.print("Enter task number to mark complete: ");
    if (scanner.hasNextInt()) {
      int index = scanner.nextInt() - 1;
      scanner.nextLine();
      if (index >= 0 && index < tasks.size()) {
        completed.set(index, true);
        System.out.println("Task marked as complete.");
      } else {
        System.out.println("Invalid task number.");
      }
    } else {
      System.out.println("Invalid input.");
      scanner.nextLine();
    }
  }
  
public static void removeTask(Scanner scanner) {
    viewTasks();
    System.out.print("Enter task number to remove: ");
    if (scanner.hasNextInt()) {
      int index = scanner.nextInt() - 1;
      scanner.nextLine();
      if (index >= 0 && index < tasks.size()) {
        tasks.remove(index);
        completed.remove(index);
        System.out.println("Task removed successfully.");
      } else {
        System.out.println("Invalid task number.");
      }
    } else {
      System.out.println("Invalid input.");
      scanner.nextLine();
    }
  }
}