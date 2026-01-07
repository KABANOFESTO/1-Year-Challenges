package stack;
import java.util.Stack;

public class UndoHistory {
    private final Stack<String> history = new Stack<>();

    public void write(String text) {
        history.push(text);
        System.out.println("Typed: " + text);
    }

    public void undo() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("Undo: " + removed);
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public String getCurrent() {
        return history.isEmpty() ? "" : history.peek();
    }

    public static void main(String[] args) {
        UndoHistory editor = new UndoHistory();
        editor.write("Hello africa");
        editor.write("Hello africa continent");
        editor.undo();
        System.out.println("Current text: " + editor.getCurrent());
    }
}
