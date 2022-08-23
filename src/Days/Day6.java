package Days;

import utility.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day6 {

    public Day6() {
        ArrayList<String> codes = new FileReader("resources/D6/input").fileReaderArrayList();
        System.out.println("D6 - The error-corrected version is: " + getHighestValues(codes));
        System.out.println("D6/2 - The error-corrected version with the new methodology is: " + getLowestValues(codes));
    }

    static String getHighestValues(ArrayList<String> codes) {
        Map<Character, Integer> population = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codes.get(0).length(); i++) {
            population.clear();
            for (String code : codes) {
                if (population.containsKey(code.charAt(i))) {
                    population.put(code.charAt(i), population.get(code.charAt(i)) + 1);
                } else {
                    population.put(code.charAt(i), 1);
                }
            }
            int max = 0;
            Character maxCh = null;
            for (Character ch : population.keySet()) {
                if (population.get(ch) > max) {
                    max = population.get(ch);
                    maxCh = ch;
                }
            }
            sb.append(maxCh);
        }
        return sb.toString();
    }

    static String getLowestValues(ArrayList<String> codes) {
        Map<Character, Integer> population = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codes.get(0).length(); i++) {
            population.clear();
            for (String code : codes) {
                if (population.containsKey(code.charAt(i))) {
                    population.put(code.charAt(i), population.get(code.charAt(i)) + 1);
                } else {
                    population.put(code.charAt(i), 1);
                }
            }
            int min = Integer.MAX_VALUE;
            Character minCh = null;
            for (Character ch : population.keySet()) {
                if (population.get(ch) < min) {
                    min = population.get(ch);
                    minCh = ch;
                }
            }
            sb.append(minCh);
        }
        return sb.toString();
    }

}
