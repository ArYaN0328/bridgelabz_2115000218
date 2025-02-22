
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileProcessor {

    public static void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE)); // Ensure a clean start
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, File Testing!";
        FileProcessor.writeToFile(TEST_FILE, content);

        assertTrue(Files.exists(Path.of(TEST_FILE)), "File should exist after writing");
        String readContent = FileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "Content should match after writing and reading");
    }

    @Test
    void testReadNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"),
                "Reading a nonexistent file should throw IOException");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE)); // Clean up after tests
    }
}



