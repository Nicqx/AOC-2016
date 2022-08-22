package Days;

import Days.Day1.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import java.util.ArrayList;

import static Days.Day1.processCommands;
import static Days.Day1.processFileContent;

@DisplayName("Testing the Day1 class")
class Day1Test {

    @ParameterizedTest
    @ValueSource(strings = {"input1:2", "input2:3", "input3:4"})
    void testProcessFileContent(String files) {
        String inputFile = "test-resources/D1/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        Assertions.assertEquals(processFileContent(text).size(), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input1:5", "input2:2", "input3:12"})
    void testProcessCommandsForAbsoluteDistance(String files) {
        String inputFile = "test-resources/D1/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        ArrayList<String> commandList = processFileContent(text);
        Position poz = processCommands(commandList);
        Assertions.assertEquals(poz.getAbsoluteDistance(), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }
    @ParameterizedTest
    @ValueSource(strings = {"input4:4"})
    void testProcessCommandsForFirstDoubleVisitedDistance(String files) {
        String inputFile = "test-resources/D1/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        ArrayList<String> commandList = processFileContent(text);
        Position poz = processCommands(commandList);
        Assertions.assertEquals(poz.getFirstDoubleVisitedDistance(), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }
    @ParameterizedTest
    @ValueSource(strings = {"input:161:110"})
    void checkOriginalInput(String files) {
        String inputFile = "resources/D1/" + files.split(":")[0];
        String text = new FileReader(inputFile).fileReaderString();
        ArrayList<String> commandList = processFileContent(text);
        Position poz = processCommands(commandList);
        Assertions.assertEquals(poz.getAbsoluteDistance(), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
        Assertions.assertEquals(poz.getFirstDoubleVisitedDistance(), Integer.parseInt(files.split(":")[2]), "Expected result is not correct");
    }
}