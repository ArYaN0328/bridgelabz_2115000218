
class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int timeQuantum = 4;  // Fixed time quantum
    private int totalProcesses = 0;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular connection
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        totalProcesses++;
    }

    public void executeRoundRobin() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        int timeElapsed = 0;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

        System.out.println("\nExecuting Round Robin Scheduling (Time Quantum: " + timeQuantum + "):");

        Process current = head;
        while (totalProcesses > 0) {
            System.out.println("\nCurrent Queue:");
            displayProcesses();

            if (current.remainingTime > 0) {
                int executedTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executedTime;
                timeElapsed += executedTime;

                System.out.println("Process " + current.processId + " executed for " + executedTime + " units. Remaining: " + current.remainingTime);

                if (current.remainingTime == 0) {
                    System.out.println("Process " + current.processId + " completed execution.");

                    int turnaroundTime = timeElapsed;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalTurnaroundTime += turnaroundTime;
                    totalWaitingTime += waitingTime;

                    removeProcess(current.processId);
                }
            }
            current = current.next;
        }

        System.out.println("\nAll processes completed.");
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / (totalProcesses + 1));
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / (totalProcesses + 1));
    }

    private void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head, prev = null;

        // If the process to be removed is the head
        if (head.processId == processId) {
            if (head == tail) { // Only one process in queue
                head = tail = null;
            } else {
                tail.next = head.next;
                head = head.next;
            }
            totalProcesses--;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.processId != processId);

        if (temp == head) return; // Process not found

        prev.next = temp.next;
        if (temp == tail) {
            tail = prev;
        }
        totalProcesses--;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " | Burst Time: " + temp.burstTime +
                    " | Priority: " + temp.priority + " | Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding predefined processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 12, 2);

        // Display initial process queue
        System.out.println("\nInitial Process Queue:");
        scheduler.displayProcesses();

        // Execute Round Robin Scheduling
        scheduler.executeRoundRobin();
    }
}

