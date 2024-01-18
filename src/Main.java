import java.util.ArrayList;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.util.Collections;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Task t1 = new Task("study",1,3);
        Task t2 = new Task("sleep", 2,1);
        Task t3 = new Task("practice", 3,2);
        Task t4 = new Task("play piano", 4,1);
        Task t5 = new Task("make dinner", 2,5);
        Task t6 = new Task("make cheese", 3,3);
        //Variables and sorting them
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(t2);
        tasks.add(t1);
        tasks.add(t3);
        tasks.add(t4);
        tasks.add(t5);
        tasks.add(t6);

        // for loop printing tasks not sorted
        for(int i=0; i<3; i++){
            System.out.println("Your Task: " + tasks.get(i).getTask() + " Priority of task:" +tasks.get(i).getPriority() + " Complexity of task: " + tasks.get(i).getComplexity() );
        }
        System.out.println();

        Task Priority = tasks.get(0);
        Task Complexity = tasks.get(0);
        Collections.sort(tasks);
        for(int i=0; i<5; i++){
            System.out.println("Your Task: " + tasks.get(i).getTask() + " Priority of task:" +tasks.get(i).getPriority() + " Complexity of task: " + tasks.get(i).getComplexity() );
        }

    }

}

class Task implements  Priority, Complexity, Comparable<Task> {
    int priority;
    String task;
    int Complexity;

    // Constructor: Sets up the question with a default complexity.
    public Task(String task, int Priority, int Complexity) {
        this.task = task;
        this.priority = Priority;
        this.Complexity = Complexity;
    }

    // Sets the complexity level for the task.
    public void setComplexity(int level) {
        Complexity = level;
    }

    // Returns the complexity level for this question.
    public int getComplexity() {
        return Complexity;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    //@Override
    public void setPriority(int level) {
        priority = level;

    }

    //@Override
    public int getPriority() {

        return priority;


    }

    public int compareTo(Task t) {
        int result = 0;

        if (this.priority < t.getPriority()) {
            result = -1;
        } else if (this.priority > t.getPriority()) {
            result = 1;
        } else if (this.priority == t.getPriority()) {
            if (this.Complexity < t.getComplexity()) {
                result = -1;
            } else if (this.Complexity > t.getComplexity()) {
                result = 1;
            } else {
                result = 0;
            }
        }
/*
            if (this.Complexity < t.getComplexity()) {
            result = -1;
        } else if (this.Complexity > t.getComplexity()) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }
*/
        return result;
    }
}

    // Interface for priority of task
    interface Priority {
        public void setPriority(int priority);

        public int getPriority();
    }

    // interface for complexity of task
    interface Complexity {
        public void setComplexity(int complexity);

        public int getComplexity();
    }
