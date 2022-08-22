package Days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import java.util.ArrayList;

import static Days.Day2.*;

@DisplayName("Testing the Day2 class")
class Day2Test {

    @ParameterizedTest
    @ValueSource(strings = {"input1:1985"})
    void testProcessCodesOld(String files) {
        ArrayList<String> fileContent = new FileReader("test-resources/D2/" + files.split(":")[0]).fileReaderArrayList();
        StringBuffer oldCode = processCodes(new OldKeypad(), fileContent);
        Assertions.assertEquals(oldCode.toString(), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input1:5DB3"})
    void testProcessCodesNew(String files) {
        ArrayList<String> fileContent = new FileReader("test-resources/D2/" + files.split(":")[0]).fileReaderArrayList();
        StringBuffer newCode = processCodes(new NewKeypad(), fileContent);
        Assertions.assertEquals(newCode.toString(), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input:92435:C1A88"})
    void checkOriginalInput(String files) {
        ArrayList<String> fileContent = new FileReader("resources/D2/" + files.split(":")[0]).fileReaderArrayList();
        StringBuffer oldCode = processCodes(new OldKeypad(), fileContent);
        Assertions.assertEquals(oldCode.toString(), files.split(":")[1], "Expected result is not correct");
        StringBuffer newCode = processCodes(new NewKeypad(), fileContent);
        Assertions.assertEquals(newCode.toString(), files.split(":")[2], "Expected result is not correct");
    }
}