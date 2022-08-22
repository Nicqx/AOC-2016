package Days;

import utility.FileReader;

import java.util.ArrayList;

public class Day2 {

    public Day2() {
        ArrayList<String> codes = new FileReader("resources/D2/input").fileReaderArrayList();
        StringBuffer oldCode = processCodes(new OldKeypad(), codes);
        System.out.println("D2 - The bathroom code is: " + oldCode);
        StringBuffer newCode = processCodes(new NewKeypad(), codes);
        System.out.println("D2/2 - The other bathroom code is: " + newCode);
    }

    static StringBuffer processCodes(Keypad keypad, ArrayList<String> codes) {
        StringBuffer code = new StringBuffer();
        for (String oneCode : codes) {
            keypad.processCode(oneCode);
            code.append(keypad.getNumber());
        }
        return code;
    }


    public interface Keypad {
        void incX();

        void decX();

        void incY();

        void decY();

        String getNumber();

        void processCode(String oneCode);
    }

    static class NewKeypad implements Keypad {
        int x;
        int y;

        public NewKeypad() {
            x = -2;
            y = 0;
        }

        @Override
        public void incX() {
            if (x == 2 || (x == 1 && (y == 1 || y == -1)) || (x == 0 && (y == 2 || y == -2))) {
                return;
            }
            x++;
        }

        @Override
        public void decX() {
            if (x == -2 || (x == -1 && (y == 1 || y == -1)) || (x == 0 && (y == 2 || y == -2))) {
                return;
            }
            x--;
        }

        @Override
        public void incY() {
            if (y == 2 || (y == 1 && (x == 1 || x == -1)) || (y == 0 && (x == 2 || x == -2))) {
                return;
            }
            y++;
        }

        @Override
        public void decY() {
            if (y == -2 || (y == -1 && (x == 1 || x == -1)) || (y == 0 && (x == 2 || x == -2))) {
                return;
            }
            y--;
        }

        @Override
        public String getNumber() {
            String result = "";
            if (x == 0 && y == 2) {
                result = "1";
            }
            if (x == -1 && y == 1) {
                result = "2";
            }
            if (x == 0 && y == 1) {
                result = "3";
            }
            if (x == 1 && y == 1) {
                result = "4";
            }
            if (x == -2 && y == 0) {
                result = "5";
            }
            if (x == -1 && y == 0) {
                result = "6";
            }
            if (x == 0 && y == 0) {
                result = "7";
            }
            if (x == 1 && y == 0) {
                result = "8";
            }
            if (x == 2 && y == 0) {
                result = "9";
            }
            if (x == -1 && y == -1) {
                result = "A";
            }
            if (x == 0 && y == -1) {
                result = "B";
            }
            if (x == 1 && y == -1) {
                result = "C";
            }
            if (x == 0 && y == -2) {
                result = "D";
            }

            return result;
        }

        @Override
        public void processCode(String oneCode) {
            for (int i = 0; i < oneCode.length(); i++) {
                switch (oneCode.charAt(i)) {
                    case 'R' -> incX();
                    case 'L' -> decX();
                    case 'U' -> incY();
                    case 'D' -> decY();
                }
            }
        }
    }

    static class OldKeypad implements Keypad {
        int x;
        int y;

        public OldKeypad() {
            x = 0;
            y = 0;
        }

        @Override
        public void incX() {
            if (x == 1) {
                return;
            }
            x++;
        }

        @Override
        public void decX() {
            if (x == -1) {
                return;
            }
            x--;
        }

        @Override
        public void incY() {
            if (y == 1) {
                return;
            }
            y++;
        }

        @Override
        public void decY() {
            if (y == -1) {
                return;
            }
            y--;
        }

        @Override
        public String getNumber() {
            String result = "";
            if (x == -1 && y == 1) {
                result = "1";
            }
            if (x == 0 && y == 1) {
                result = "2";
            }
            if (x == 1 && y == 1) {
                result = "3";
            }
            if (x == -1 && y == 0) {
                result = "4";
            }
            if (x == 0 && y == 0) {
                result = "5";
            }
            if (x == 1 && y == 0) {
                result = "6";
            }
            if (x == -1 && y == -1) {
                result = "7";
            }
            if (x == 0 && y == -1) {
                result = "8";
            }
            if (x == 1 && y == -1) {
                result = "9";
            }
            return result;
        }

        @Override
        public void processCode(String oneCode) {
            for (int i = 0; i < oneCode.length(); i++) {
                switch (oneCode.charAt(i)) {
                    case 'R' -> incX();
                    case 'L' -> decX();
                    case 'U' -> incY();
                    case 'D' -> decY();
                }
            }
        }
    }

}
