package Days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import java.util.ArrayList;

import static Days.Day6.getHighestValues;
import static Days.Day6.getLowestValues;

@DisplayName("Testing the Day6 class")
public class Day6Test {
    @ParameterizedTest
    @ValueSource(strings = {"input1:easter"})
    void testGetHighestValues(String files) {
        ArrayList<String> codes = new FileReader("test-resources/D6/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(getHighestValues(codes), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input1:advent"})
    void testGetLowestValues(String files) {
        ArrayList<String> codes = new FileReader("test-resources/D6/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(getLowestValues(codes), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input:nabgqlcw:ovtrjcjh"})
    void checkOriginalInput(String files) {
        ArrayList<String> codes = new FileReader("resources/D6/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(getHighestValues(codes), files.split(":")[1], "Expected result is not correct");
        Assertions.assertEquals(getLowestValues(codes), files.split(":")[2], "Expected result is not correct");
    }
}
