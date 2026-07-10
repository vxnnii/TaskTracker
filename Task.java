/* 
Author: Jovanni Elias

Purpose: This class will handle each task object individually. Each task accepts a description and is paired with either the boolean Done or Pending under the variable completed.
*/

public class Task {

    private String description;
    private boolean completed;

    public Task (String description) {

        this.description = description;
        this.completed = false;
    }

    public void markComplete() {
        
        completed = true;
    }

    @Override 
    public String toString() {
        return description + (completed ? "[Done]" : "[Pending]");
    }
}