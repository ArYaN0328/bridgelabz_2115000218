
class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int historyLimit;
    private int historySize;

    public TextEditor(int limit) {
        this.historyLimit = limit;
        this.historySize = 0;
        this.current = new TextState(""); // Initial empty state
    }

    // Add new state when user types or performs an action
    public void addState(String newText) {
        TextState newState = new TextState(newText);
        newState.prev = current;
        if (current != null) {
            current.next = newState;
        }
        current = newState;
        historySize++;

        // Trim history to the last `historyLimit` states
        if (historySize > historyLimit) {
            removeOldestState();
        }
    }

    // Undo: Move to the previous state
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Undo not possible. Already at the first state.");
        }
    }

    // Redo: Move to the next state
    public void redo() {
        if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("Redo not possible. Already at the latest state.");
        }
    }

    // Remove the oldest state to maintain history limit
    private void removeOldestState() {
        TextState temp = current;
        while (temp.prev != null && temp.prev.prev != null) {
            temp = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev = null; // Remove reference to the oldest state
            historySize--;
        }
    }

    // Display the current text state
    public void displayCurrentState() {
        System.out.println("Current State: \"" + current.content + "\"");
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // History limited to last 10 states

        // User typing or performing actions
        editor.addState("Hello");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! This is a text editor.");
        editor.addState("Hello, World! This is a text editor. Undo/Redo enabled.");

        // Display current state
        editor.displayCurrentState();

        // Undo actions
        System.out.println("\nUndoing...");
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // Redo actions
        System.out.println("\nRedoing...");
        editor.redo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();
    }
}

