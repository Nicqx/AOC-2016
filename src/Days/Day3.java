package Days;

import utility.FileReader;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public Day3() {
        ArrayList<String> triangles = new FileReader("resources/D3/input").fileReaderArrayList();
        System.out.println("D3 - These triangles are possible: " + processList(triangles));
        System.out.println("D3/2 - These triangles are possible vertically: " + processListVertically(triangles));
    }

    static int processListVertically(ArrayList<String> triangles) {
        int result = 0;
        for (int i = 0; i < triangles.get(0).split("\\W+").length; i++) {
            for (int j = 0; j < triangles.size(); j += 3) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(triangles.get(j).split("\\W+")[i]);
                tmp.append(" ");
                tmp.append(triangles.get(j + 1).split("\\W+")[i]);
                tmp.append(" ");
                tmp.append(triangles.get(j + 2).split("\\W+")[i]);
                if (isTriangle(tmp.toString())) {
                    result++;
                }
            }
        }

        return result;
    }

    static int processList(ArrayList<String> triangles) {
        int result = 0;
        for (String element : triangles) {
            if (isTriangle(element)) {
                result++;
            }
        }
        return result;
    }

    static boolean isTriangle(String input) {
        boolean result = false;
        Matcher matcher = Pattern.compile("(\\d+)\\W+(\\d+)\\W+(\\d+)").matcher(input);
        if (matcher.find()) {
            result = ((Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(2)) > Integer.parseInt(matcher.group(3)))
                    && (Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3)) > Integer.parseInt(matcher.group(2)))
                    && (Integer.parseInt(matcher.group(2)) + Integer.parseInt(matcher.group(3)) > Integer.parseInt(matcher.group(1))));

        }
        return result;
    }
}
