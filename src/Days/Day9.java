package Days;

import utility.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day9 {
    String text = new FileReader("resources/D9/input").fileReaderString();

    public Day9() {
        System.out.println("D9 - The decompressed length of the file is: " + resolve(text, true));
//        System.out.println(resolve(text, false));
//        System.out.println("D9/2 - The decompressed length of the file with new version two is: " + resolve(text, false));

    }

    private int resolve(String text, boolean oldMethod) {
        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            Matcher matcher = Pattern.compile("^\\((\\d+)x(\\d+)\\)(.*)").matcher(text.substring(i));
            if (matcher.find()) {
                i += matcher.group(1).length() + matcher.group(2).length() + Integer.parseInt(matcher.group(1)) + 2;
                result += resolve(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            } else {
                result++;
            }
        }

        return result;
    }

    private int resolve(int charCount, int amount) {
        int result = 0;
        result += charCount * amount;
        return result;
    }


}
