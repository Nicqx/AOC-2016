package Days;

import utility.FileReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8 {
    static private final boolean[][] matrix = new boolean[50][6];

    public Day8() {
        ArrayList<String> commands = new FileReader("resources/D8/input").fileReaderArrayList();
        init();
        processCommands(commands);
        System.out.println("D8 - The count of switched lights on : " + countLightsOn());
        readOut();

    }

    static void processCommands(ArrayList<String> commands) {
        for (String command : commands) {
            Matcher matcher = Pattern.compile("rect (\\d+)x(\\d+)").matcher(command);
            if (matcher.find()) {
                rect(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                continue;
            }
            matcher = Pattern.compile("rotate row y=(\\d+) by (\\d+)").matcher(command);
            if (matcher.find()) {
                rotateRow(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                continue;
            }
            matcher = Pattern.compile("rotate column x=(\\d+) by (\\d+)").matcher(command);
            if (matcher.find()) {
                rotateColumn(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            }
        }
    }

    static int countLightsOn() {
        int result = 0;
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 6; y++) {
                if (matrix[x][y]) {
                    result++;
                }
            }
        }
        return result;
    }

    static void init() {
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 6; y++) {
                matrix[x][y] = false;
            }
        }
    }

    static void readOut() {
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 50; i++) {
                if (matrix[i][j]) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    static void rotateColumn(int x, int amount) {
        LinkedList<Boolean> column = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            column.add(matrix[x][i]);
        }
        for (int i = 0; i < amount; i++) {
            column.add(0, column.removeLast());
        }
        for (int i = 0; i < 6; i++) {
            matrix[x][i] = column.get(i);
        }
    }

    static void rotateRow(int y, int amount) {
        LinkedList<Boolean> row = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            row.add(matrix[i][y]);
        }
        for (int i = 0; i < amount; i++) {
            row.add(0, row.removeLast());
        }
        for (int i = 0; i < 50; i++) {
            matrix[i][y] = row.get(i);
        }
    }

    static void rect(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = true;
            }
        }
    }
}
