package heap;

import java.util.PriorityQueue;

public class SupportCenter {
    public static void main(String[] args) {
        PriorityQueue<Ticket> queue = new PriorityQueue<>();

        queue.add(new Ticket("Family Issue", 1));
        queue.add(new Ticket("Meeting", 5));
        queue.add(new Ticket("Code review", 3));

        while (!queue.isEmpty()) {
            System.out.println("Handling: " + queue.poll());
        }
    }
}