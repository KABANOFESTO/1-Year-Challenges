package queue;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {
    private final Queue<String> tasks = new LinkedList<>();

    public void addTask(String task) {
        tasks.offer(task);
    }

    public void processNext() {
        String task = tasks.poll();
        if (task != null) {
            System.out.println("Processing: " + task);
        } else {
            System.out.println("No tasks left");
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("brush teeth");
        scheduler.addTask("write code");
        scheduler.addTask("read book");

        scheduler.processNext();
        scheduler.processNext();
        scheduler.processNext();
    }
}
