package Days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
    ArrayList<Room> rooms = new ArrayList<>();

    public Day4() {
        fileReader("resources/D4/input");
        System.out.println("D4 - The valid room sectorID's sum: " + sumValidRooms());
        System.out.println("D4/2 - The north pole storage ID: " + getNorthPoleStorageID());

    }

    private void fileReader(String res) {
        try (Scanner scanner = new Scanner(new File(res))) {
            while (scanner.hasNext()) {
                rooms.add(new Room(scanner.nextLine()));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    private int getNorthPoleStorageID() {
        return Integer.parseInt(rooms.stream().filter(dcn -> dcn.getDecryptName().equals("northpole object storage")).map(Room::getSectorId).toArray()[0].toString());
    }

    private int sumValidRooms() {
        return rooms.stream().filter(room -> room.valid).mapToInt(Room::getSectorId).sum();
    }

    private static class Room {
        private String name;
        private int sectorId;
        boolean valid;
        String checksum;

        public Room(String input) {
            Matcher matcher = Pattern.compile("(.+)-(\\d+)\\[(\\w+)]").matcher(input);
            if (matcher.find()) {
                name = matcher.group(1);
                sectorId = Integer.parseInt(matcher.group(2));
                checksum = matcher.group(3);
                valid = checkValidity(name, checksum);
            }
        }

        private String getDecryptName() {
            int inc = sectorId % 26;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == '-') {
                    sb.append(" ");
                    continue;
                }
                if (((int) name.charAt(i) + inc) > 122) {
                    sb.append((char) ((int) name.charAt(i) + inc - 26));
                } else {
                    sb.append((char) ((int) name.charAt(i) + inc));
                }
            }
            return sb.toString();
        }

        public int getSectorId() {
            return sectorId;
        }

        private boolean checkValidity(String name, String checksum) {
            ArrayList<Chars> charPopulation = new ArrayList<>();
            for (int i = 0; i < name.length(); i++) {
                Character tmp = name.charAt(i);
                if (name.charAt(i) == '-') {
                    continue;
                }
                if (charPopulation.stream().noneMatch(chars -> chars.getName().equals(tmp))) {
                    charPopulation.add(new Chars(tmp));
                } else {
                    charPopulation.stream().filter(chars -> chars.getName().equals(tmp)).forEach(Chars::incCount);
                }
            }
            Comparator<Chars> compareByCountAndName = Comparator
                    .comparing(Chars::getCount).reversed()
                    .thenComparing(Chars::getName);

            List<Chars> collect = charPopulation.stream().sorted(compareByCountAndName).limit(5).toList();
            StringBuilder sb = new StringBuilder();
            for (Chars c : collect) {
                sb.append(c.getName());
            }
            return sb.toString().equals(checksum);
        }
    }

    private static class Chars {
        private final Character name;
        private int count;

        public Chars(Character name) {
            this.name = name;
            this.count = 1;
        }

        public Character getName() {
            return this.name;
        }

        public int getCount() {
            return this.count;
        }

        public void incCount() {
            this.count++;
        }
    }

}
