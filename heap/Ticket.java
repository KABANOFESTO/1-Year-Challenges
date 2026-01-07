package heap;

class Ticket implements Comparable<Ticket> {
    private final String description;
    private final int priority; 

    public Ticket(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public int compareTo(Ticket other) {
        return Integer.compare(other.priority, this.priority); 
    }

    @Override
    public String toString() {
        return "[" + description + " | priority=" + priority + "]";
    }
}

