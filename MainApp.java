/*
Author: Jovanni Elias

Purpose: This is the heart of the prorgram. This class will control the flow of the program. The user picks the option they want to perform. This does not validate user input. That will be the next addition in agile style. 
*/


import java.util.AbstractList;
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
      System.out.println("4. Exit");
      System.out.print("Enter choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      if (choice == 1) {
        System.out.print("Enter task description: ");
        manager.addTask(scanner.nextLine());
        System.out.println("Task added.");
      } else if (choice == 2) {
        int index = 0;
        for (Task task : manager.getTasks()) {
          System.out.println(index + ": " + task);
          index++;
        }
      } else if (choice == 3) {
        System.out.print("Enter task index to complete: ");
        manager.completeTask(scanner.nextInt());
        System.out.println("Task marked as complete.");
      } else if (choice == 4) {
        System.out.println("Exiting application...");
        break;
      } else {
        System.out.println("Invalid option.");
      }
    }
  }
}