
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null; // Keeps track of the current task for circular traversal

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head; // Circular link
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
        if (currentTask == null) currentTask = head; // Set first task as current task
    }

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
        if (currentTask == null) currentTask = head;
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
            tail.next = head;
        }
    }

    public void removeById(int taskId) {
        if (head == null) return;

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == taskId) {
                if (temp == head && temp == tail) { // Only one task
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                if (currentTask == temp) currentTask = head; // Reset current task if it was removed
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " | Priority: " + currentTask.priority + " | Due: " + currentTask.dueDate);
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void moveToNextTask() {
        if (currentTask != null) {
            currentTask = currentTask.next;
        }
        viewCurrentTask();
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        System.out.println("\nTask List:");
        do {
            System.out.println("Task ID: " + temp.taskId + " | " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + " | " + temp.taskName + " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();

        // Adding predefined tasks
        ts.addAtEnd(1, "Complete Assignment", 2, "2025-02-15");
        ts.addAtEnd(2, "Prepare Presentation", 1, "2025-02-18");
        ts.addAtEnd(3, "Attend Meeting", 3, "2025-02-12");
        ts.addAtBeginning(4, "Check Emails", 3, "2025-02-10");
        ts.addAtPosition(5, "Submit Report", 2, "2025-02-14", 3);

        // Display all tasks
        ts.displayTasks();

        // View and cycle through tasks
        System.out.println("\nViewing and cycling through tasks:");
        ts.viewCurrentTask();
        ts.moveToNextTask();
        ts.moveToNextTask();

        // Searching tasks by priority
        System.out.println("\nSearching for tasks with priority 2:");
        ts.searchByPriority(2);

        // Removing a task
        System.out.println("\nRemoving Task ID 3...");
        ts.removeById(3);

        // Display tasks after deletion
        ts.displayTasks();
    }
}

