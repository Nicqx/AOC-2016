package Days;

import utility.FileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {
    String text = new FileReader("resources/D1/input").fileReaderString();

    private enum directions {N, S, E, W}

    private final Set<String> locations = new HashSet<>();

    directions actualState = directions.N;
    ArrayList<String> commandList = new ArrayList<>();
    Position poz = new Position();

    public Day1() {
        processFileContent();
        processCommands();
        System.out.println("D1 - The Easter Bunny is away: " + poz.getDistance());
        System.out.println("D1/2 - The Easter Bunny is first visit twice: " + poz.getFoundDistance());
    }

    private void processFileContent() {
        Matcher commands = Pattern.compile("(\\w+\\d+)").matcher(text);
        while (commands.find()) {
            commandList.add(commands.group(1));
        }
    }

    private void processCommands() {
        for (String element : commandList) {
            if (element.charAt(0) == 'R') {
                switch (actualState) {
                    case N -> actualState = directions.E;
                    case E -> actualState = directions.S;
                    case W -> actualState = directions.N;
                    case S -> actualState = directions.W;
                }
            } else {
                switch (actualState) {
                    case N -> actualState = directions.W;
                    case E -> actualState = directions.N;
                    case W -> actualState = directions.S;
                    case S -> actualState = directions.E;
                }
            }
            for (int i = 0; i < Integer.parseInt(element.substring(1)); i++) {
                goForwardOneStep();
                if (!locations.contains(poz.getX() + "," + poz.getY())) {
                    locations.add(poz.getX() + "," + poz.getY());
                } else {
                    if (poz.getFoundX() == 0 && poz.getFoundY() == 0) {
                        poz.setFoundX(poz.getX());
                        poz.setFoundY(poz.getY());
                    }
                }
            }
        }
    }

    private void goForwardOneStep() {
        switch (actualState) {
            case N -> poz.setY(poz.getY() + 1);
            case E -> poz.setX(poz.getX() + 1);
            case S -> poz.setY(poz.getY() - 1);
            case W -> poz.setX(poz.getX() - 1);
        }
    }

    private static class Position {
        private int x;
        private int y;
        private int foundX;
        private int foundY;

        public Position() {
            this.x = 0;
            this.y = 0;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getFoundX() {
            return foundX;
        }

        public void setFoundX(int foundX) {
            this.foundX = foundX;
        }

        public int getFoundY() {
            return foundY;
        }

        public void setFoundY(int foundY) {
            this.foundY = foundY;
        }

        public int getDistance() {
            return Math.abs(x + y);
        }

        public int getFoundDistance() {
            return Math.abs(foundX + foundY);
        }
    }
}
