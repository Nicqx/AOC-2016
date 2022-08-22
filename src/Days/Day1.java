package Days;

import utility.FileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    public Day1() {
        String text = new FileReader("resources/D1/input").fileReaderString();
        ArrayList<String> commandList = processFileContent(text);
        Position poz = processCommands(commandList);
        System.out.println("D1 - The Easter Bunny is away: " + poz.getAbsoluteDistance());
        System.out.println("D1/2 - The Easter Bunny is first visit twice: " + poz.getFirstDoubleVisitedDistance());

    }

    static ArrayList<String> processFileContent(String text) {
        ArrayList<String> commandList = new ArrayList<>();
        Matcher commands = Pattern.compile("(\\w+\\d+)").matcher(text);
        while (commands.find()) {
            commandList.add(commands.group(1));
        }
        return commandList;
    }

    static Position processCommands(ArrayList<String> commandList){
        Position poz = new Position();
        for (String element : commandList) {
            if (element.charAt(0) == 'R') {
                switch (poz.actualState) {
                    case N -> poz.actualState = Position.directions.E;
                    case E -> poz.actualState = Position.directions.S;
                    case W -> poz.actualState = Position.directions.N;
                    case S -> poz.actualState = Position.directions.W;
                }
            } else {
                switch (poz.actualState) {
                    case N -> poz.actualState = Position.directions.W;
                    case E -> poz.actualState = Position.directions.N;
                    case W -> poz.actualState = Position.directions.S;
                    case S -> poz.actualState = Position.directions.E;
                }
            }
            for (int i = 0; i < Integer.parseInt(element.substring(1)); i++) {
                poz.goForwardOneStep();
                poz.addVisitedLocation(poz.getAbsoluteX(), poz.getAbsoluteY());
            }
        }

        return poz;
    }


    static class Position {
        private int absoluteX;
        private int absoluteY;
        private int doubleVisitedX;
        private int doubleVisitedY;
        private enum directions {N, S, E, W}
        directions actualState;
        private final Set<String> visitedLocations = new HashSet<>();

        public Position() {
            this.absoluteX = 0;
            this.absoluteY = 0;
            this.actualState = directions.N;
        }

        private void goForwardOneStep() {
            switch (actualState) {
                case N -> setAbsoluteY(getAbsoluteY() + 1);
                case E -> setAbsoluteX(getAbsoluteX() + 1);
                case S -> setAbsoluteY(getAbsoluteY() - 1);
                case W -> setAbsoluteX(getAbsoluteX() - 1);
            }
        }

        private void addVisitedLocation(int x, int y){
            if (!visitedLocations.contains(x + "," + y)) {
                visitedLocations.add(x + "," + y);
            } else {
                if (getDoubleVisitedX() == 0 && getDoubleVisitedY() == 0) {
                    setDoubleVisitedX(x);
                    setDoubleVisitedY(y);
                }
            }
        }

        public int getAbsoluteX() {
            return absoluteX;
        }

        public void setAbsoluteX(int absoluteX) {
            this.absoluteX = absoluteX;
        }

        public int getAbsoluteY() {
            return absoluteY;
        }

        public void setAbsoluteY(int absoluteY) {
            this.absoluteY = absoluteY;
        }

        public int getDoubleVisitedX() {
            return doubleVisitedX;
        }

        public void setDoubleVisitedX(int doubleVisitedX) {
            this.doubleVisitedX = doubleVisitedX;
        }

        public int getDoubleVisitedY() {
            return doubleVisitedY;
        }

        public void setDoubleVisitedY(int doubleVisitedY) {
            this.doubleVisitedY = doubleVisitedY;
        }

        public int getAbsoluteDistance() {
            return Math.abs(absoluteX + absoluteY);
        }

        public int getFirstDoubleVisitedDistance() {
            return Math.abs(doubleVisitedX + doubleVisitedY);
        }
    }
}
