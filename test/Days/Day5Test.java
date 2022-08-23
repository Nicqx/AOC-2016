package Days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import static Days.Day5.*;

@Disabled
@DisplayName("Testing the Day5 class")
public class Day5Test {
    @ParameterizedTest
    @ValueSource(strings = {"input1:18f47a30"})
    void testGenPass(String files) {
        String inputFile = "test-resources/D5/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        Assertions.assertEquals(genPass(text), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input1:05ace8e3"})
    void testGenPassSpecial(String files) {
        String inputFile = "test-resources/D5/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        Assertions.assertEquals(genPassSpecial(text), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input2:00000155f8105dff7f56ee10fa9b9abd"})
    void testHashMD5(String files) {
        String inputFile = "test-resources/D5/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        Assertions.assertEquals(hashMD5(text), files.split(":")[1], "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input:c6697b55:8c35d1ab"})
    void checkOriginalInput(String files) {
        String inputFile = "resources/D5/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        Assertions.assertEquals(genPass(text), files.split(":")[1], "Expected result is not correct");
        Assertions.assertEquals(genPassSpecial(text), files.split(":")[2], "Expected result is not correct");
    }
}
