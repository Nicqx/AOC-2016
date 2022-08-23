package Days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import java.util.ArrayList;

import static Days.Day8.*;

@DisplayName("Testing the Day8 class")
public class Day8Test {
    @ParameterizedTest
    @ValueSource(strings = {"input:128"})
    void checkOriginalInput(String files) {
        ArrayList<String> commands = new FileReader("resources/D8/" + files.split(":")[0]).fileReaderArrayList();
        init();
        processCommands(commands);

        Assertions.assertEquals(countLightsOn(), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }
}
