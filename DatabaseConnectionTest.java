
public class DatabaseConnection {
    private boolean isConnected;

    public void connect() {
        isConnected = true;
        System.out.println("Database connected");
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected");
    }

    public boolean isConnected() {
        return isConnected;
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
        assertTrue(dbConnection.isConnected(), "Database should be connected before each test");
    }

    @Test
    void testConnectionIsActive() {
        assertTrue(dbConnection.isConnected(), "Database should be connected during the test");
    }

    @Test
    void testAnotherConnectionCheck() {
        assertTrue(dbConnection.isConnected(), "Database should still be connected in another test");
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database should be disconnected after each test");
    }
}

