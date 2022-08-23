package Days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import java.util.ArrayList;

import static Days.Day3.*;

@DisplayName("Testing the Day2 class")
public class Day3Test {
    @ParameterizedTest
    @ValueSource(strings = {"input1:0"})
    void testProcessList(String files) {
        ArrayList<String> fileContent = new FileReader("test-resources/D3/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(processList(fileContent), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input3:false"})
    void testIsTriangle(String files) {
        String inputFile = "test-resources/D3/" + files.split(":")[0];
        Assertions.assertEquals(isTriangle(inputFile), Boolean.parseBoolean(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input2:6"})
    void testProcessListVertically(String files) {
        ArrayList<String> fileContent = new FileReader("test-resources/D3/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(processListVertically(fileContent), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input:993:1849"})
    void checkOriginalInput(String files) {
        ArrayList<String> fileContent = new FileReader("resources/D3/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(processList(fileContent), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
        Assertions.assertEquals(processListVertically(fileContent), Integer.parseInt(files.split(":")[2]), "Expected result is not correct");
    }
}
