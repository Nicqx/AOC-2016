package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@DisplayName("Testing the utility class")
class FileReaderTest {

    @Test
    @DisplayName("Testing the one line inputs")
    void fileReaderString() {
        String testFile = new FileReader("test-resources/utility/string.txt").fileReaderString();
        Assertions.assertFalse(testFile.isEmpty(), "The test file is empty!");
        Assertions.assertEquals(testFile, "This is one line", "The file content is not correct!");
    }

    @Test
    @DisplayName("Testing multiple lines inputs")
    void fileReaderArrayList() {
        ArrayList<String> testFile = new FileReader("test-resources/utility/arrayList.txt").fileReaderArrayList();
        Assertions.assertFalse(testFile.isEmpty(), "The test file is empty!");
        Assertions.assertEquals(testFile, Arrays.asList("This", "is", "multiple", "lines"), "The file content is not correct!");
    }
}