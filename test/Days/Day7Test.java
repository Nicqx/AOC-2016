package Days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.FileReader;

import java.util.ArrayList;

import static Days.Day7.*;

@DisplayName("Testing the Day7 class")
public class Day7Test {
    @ParameterizedTest
    @ValueSource(strings = {"input1:4"})
    void testReadAddresses(String files) {
        ArrayList<String> ips = new FileReader("test-resources/D7/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(readAddresses(ips).size(), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input1:2"})
    void testCountTLS(String files) {
        ArrayList<String> ips = new FileReader("test-resources/D7/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(countTLS(readAddresses(ips)), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input2:3"})
    void testCountSSL(String files) {
        ArrayList<String> ips = new FileReader("test-resources/D7/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(countSSL(readAddresses(ips)), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input1:true:false"})
    void testValidateTLS(String files) {
        ArrayList<String> ips = new FileReader("test-resources/D7/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(readAddresses(ips).get(0).validateTLS(), Boolean.parseBoolean(files.split(":")[1]), "Expected result is not correct");
        Assertions.assertEquals(readAddresses(ips).get(1).validateTLS(), Boolean.parseBoolean(files.split(":")[2]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input2:true:false"})
    void testValidateSSL(String files) {
        ArrayList<String> ips = new FileReader("test-resources/D7/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(readAddresses(ips).get(0).validateSSL(), Boolean.parseBoolean(files.split(":")[1]), "Expected result is not correct");
        Assertions.assertEquals(readAddresses(ips).get(1).validateSSL(), Boolean.parseBoolean(files.split(":")[2]), "Expected result is not correct");
    }

    @ParameterizedTest
    @ValueSource(strings = {"input:105:258"})
    void checkOriginalInput(String files) {
        ArrayList<String> ips = new FileReader("resources/D7/" + files.split(":")[0]).fileReaderArrayList();
        Assertions.assertEquals(countTLS(readAddresses(ips)), Integer.parseInt(files.split(":")[1]), "Expected result is not correct");
        Assertions.assertEquals(countSSL(readAddresses(ips)), Integer.parseInt(files.split(":")[2]), "Expected result is not correct");
    }

}
