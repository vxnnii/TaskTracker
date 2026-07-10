/*
Author: Jovanni Elias

Purpose: This is the heart of the prorgram. This class will control the flow of the program. The user picks the option they want to perform. Input validation added so bad input (letters, out of range numbers, empty descriptions) doesn't crash the program.
*/

import java.util.Scanner;

public class MainApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    TaskManager manager = new TaskManager();

    System.out.println("=== Student Task Tracker (OOP Version) ===");

    while (true) {
      System.out.println("\nMenu:");
      System.out.println("1. Add Task");
      System.out.println("2. View Tasks");
      System.out.println("3. Complete Task");
      System.out.println("4. Remove Task");
      System.out.println("5. Exit");
      System.out.print("Enter choice: ");

      int choice;
      try {
        choice = Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Error: Please enter a valid number.");
        continue;
      }

      if (choice == 1) {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        if (desc.trim().isEmpty()) {
          System.out.println("Task description cannot be empty.");
        } else {
          manager.addTask(desc);
          System.out.println("Task added.");
        }

      } else if (choice == 2) {
        if (manager.size() == 0) {
          System.out.println("No tasks available. Please add a task first.");
        } else {
          int index = 0;
          for (Task task : manager.getTasks()) {
            System.out.println(index + ": " + task);
            index++;
          }
        }

      } else if (choice == 3) {
        int index = getValidIndex(scanner, manager, "complete");
        if (index != -1) {
          manager.completeTask(index);
          System.out.println("Task marked as complete.");
        }

      } else if (choice == 4) {
        int index = getValidIndex(scanner, manager, "remove");
        if (index != -1) {
          manager.removeTask(index);
          System.out.println("Task removed.");
        }

      } else if (choice == 5) {
        System.out.println("Exiting application...");
        break;

      } else {
        System.out.println("Invalid option. Please select 1-5.");
      }
    }

    scanner.close();
  }

  // Handles asking for a task index, checking it's a number and in range.
  // Returns -1 if the input was invalid so the caller can skip the action.
  private static int getValidIndex(Scanner scanner, TaskManager manager, String action) {
    if (manager.size() == 0) {
      System.out.println("No tasks available. Please add a task first.");
      return -1;
    }

    System.out.print("Enter task index to " + action + ": ");
    int index;
    try {
      index = Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
      System.out.println("Error: Please enter a valid number.");
      return -1;
    }

    if (index < 0 || index >= manager.size()) {
      System.out.println("Invalid task index. Please choose a number between 0 and " + (manager.size() - 1) + ".");
      return -1;
    }

    return index;
  }
}