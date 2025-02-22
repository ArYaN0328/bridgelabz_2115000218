
public class TaskUtils {
    public static String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulates a long-running operation (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TaskUtilsTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test fails if execution takes longer than 2 seconds
    void testLongRunningTaskTimeout() {
        TaskUtils.longRunningTask(); // This should fail due to timeout
    }
}



