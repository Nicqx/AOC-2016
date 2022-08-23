package Days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import java.util.ArrayList;

import static Days.Day4.*;

@DisplayName("Testing the Day4 class")
public class Day4Test {
    @ParameterizedTest
    @ValueSource(strings = {"input1:1514"})
    void testSumValidRooms(String files) {
        ArrayList<String> fileContent = new FileReader("test-resources/D4/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(sumValidRooms(processFileContent(fileContent)), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input2:very encrypted name"})
    void testGetDecryptName(String files) {
        ArrayList<String> fileContent = new FileReader("test-resources/D4/" + files.split(":")[0]).fileReaderArrayList();
        Room room = processFileContent(fileContent).get(0);
        Assertions.assertEquals(room.getDecryptName(), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input1:true"})
    void testCheckValidity(String files) {
        ArrayList<String> fileContent = new FileReader("test-resources/D4/" + files.split(":")[0]).fileReaderArrayList();
        Room room = processFileContent(fileContent).get(0);
        Assertions.assertEquals(room.checkValidity(), Boolean.parseBoolean(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input:361724:482"})
    void checkOriginalInput(String files) {
        ArrayList<String> fileContent = new FileReader("resources/D4/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(sumValidRooms(processFileContent(fileContent)), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
        Assertions.assertEquals(getNorthPoleStorageID(processFileContent(fileContent)), Integer.parseInt(files.split(":")[2]), "Expected result is not correct");
    }
}
