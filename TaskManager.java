/*
Author: Jovanni Elias

Purpose: This class will manage a collection of Task objects, allowing for adding, removing, and viewing tasks.
*/

import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks = new ArrayList<>();
    
    public void addTask(String desc) {
        tasks.add(new Task(desc));
    }

    public void completeTask(int index) {
        tasks.get(index).markComplete();
    }
    
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}