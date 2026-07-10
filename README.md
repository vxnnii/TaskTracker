# Student Task Tracker (OOP Version)

A console-based Java task manager, refactored from a single-file program into a proper object-oriented design. Split into three classes — `Task`, `TaskManager`, and `MainApp` — each with a clear, single responsibility.

## Features

- **Add tasks** – create new tasks with a description
- **View tasks** – list all tasks with their index and status
- **Complete tasks** – mark a task as done by index
- **Exit** – cleanly exits the program loop

## Architecture

This version moves away from tracking tasks with parallel `ArrayList`s and instead models each task as its own object.

### `Task.java`
Represents a single task. Holds the task's `description` and `completed` status, and knows how to mark itself complete and display itself (via an overridden `toString()`).

### `TaskManager.java`
Manages the collection of `Task` objects. Handles adding new tasks, marking a task complete by index, and returning the full list of tasks. Keeps all task-list logic out of `MainApp`.

### `MainApp.java`
The entry point and controller. Displays the menu, reads user input, and calls the appropriate `TaskManager` methods based on the user's choice. Doesn't do any task logic itself — just drives the flow.

## How It Works

```
=== Student Task Tracker (OOP Version) ===

Menu:
1. Add Task
2. View Tasks
3. Complete Task
4. Exit
```

Tasks are displayed with their index (starting at 0) and status tag, e.g.:

```
0: Finish COSC 4301 lab[Pending]
1: Push TaskTracker to GitHub[Done]
```

## Running the Project

1. Make sure you have a JDK installed (Java 8+).
2. Compile all three files:
   ```
   javac Task.java TaskManager.java MainApp.java
   ```
3. Run the program:
   ```
   java MainApp
   ```
4. Follow the on-screen menu to manage your tasks.

## Example Usage

```
Enter choice: 1
Enter task description: Finish COSC 4301 lab
Task added.

Enter choice: 2
0: Finish COSC 4301 lab[Pending]

Enter choice: 3
Enter task index to complete: 0
Task marked as complete.

Enter choice: 2
0: Finish COSC 4301 lab[Done]
```

## Project Structure

```
Task.java          # Represents an individual task
TaskManager.java   # Manages the collection of tasks
MainApp.java       # Entry point; controls program flow
```

## Known Limitations

- **No input validation yet.** Entering a non-numeric menu choice or an out-of-range task index will crash the program. This is intentionally left out for now and planned as the next addition, done in an Agile/iterative style.
- Tasks are stored in memory only — nothing persists between runs.
- No option to remove a task in this version (present in the original single-file version, not yet ported over).

## Planned Improvements

- Add input validation for menu choices and task indices
- Add a "Remove Task" option
- Save/load tasks from a file so they persist between runs
- Add due dates or priority levels
