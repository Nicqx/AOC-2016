package Days;

import utility.FileReader;

import java.util.ArrayList;

public class Day7 {
    ArrayList<String> ips = new FileReader("resources/D7/input").fileReaderArrayList();
    ArrayList<Address> addresses = new ArrayList<>();

    public Day7() {
        readAddresses();
        System.out.println("D7 - the TLS supported addresses count is: " + countTLS());
        System.out.println("D7/2 - the SSL supported addresses count is: " + countSSL());
    }

    private void readAddresses() {
        for (String element : ips) {
            addresses.add(new Address(element));
        }
    }

    private int countTLS() {
        int counter = 0;
        for (Address element : addresses) {
            if (element.validateTLS()) {
                counter++;
            }
        }
        return counter;
    }

    private int countSSL() {
        int counter = 0;
        for (Address element : addresses) {
            if (element.validateSSL()) {
                counter++;
            }
        }
        return counter;
    }
    private static class Address {
        ArrayList<String> hypernets = new ArrayList<>(); // inside brackets
        ArrayList<String> subnets = new ArrayList<>(); // outside brackets

        public Address(String line) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < line.length()) {
                if (line.charAt(i) == '[') {
                    subnets.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    i++;
                    continue;
                } else if (line.charAt(i) == ']') {
                    hypernets.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    i++;
                    continue;
                }
                stringBuilder.append(line.charAt(i));
                i++;
            }
            subnets.add(stringBuilder.toString());
        }

        private ArrayList<String> findAba(ArrayList<String> list) {
            ArrayList<String> result = new ArrayList<>();
            for (String element : list) {
                for (int i = 0; i < element.length() - 2; i++) {
                    String a = String.valueOf((element.charAt(i)));
                    String b = String.valueOf((element.charAt(i + 1)));
                    String c = String.valueOf((element.charAt(i + 2)));
                    if (a.equals(c) && !a.equals(b)) {
                        result.add(a + b + c);
                    }
                }
            }
            return result;
        }

        private ArrayList<String> findAbba(ArrayList<String> list) {
            ArrayList<String> result = new ArrayList<>();
            for (String element : list) {
                for (int i = 0; i < element.length() - 3; i++) {
                    String a = String.valueOf(element.charAt(i));
                    String b = String.valueOf(element.charAt(i + 1));
                    String c = String.valueOf(element.charAt(i + 2));
                    String d = String.valueOf(element.charAt(i + 3));
                    if (a.equals(d) && b.equals(c) && !a.equals(b)) {
                        result.add(a + b + c + d);
                    }
                }
            }
            return result;
        }

        private String createBab(String aba) {
            String a = String.valueOf(aba.charAt(0));
            String b = String.valueOf(aba.charAt(1));
            return b + a + b;
        }

        public boolean validateSSL() {
            boolean result = false;
            if (findAba(subnets).isEmpty()) return false;
            //bab hypernet with aba subnet
            for (String aba : findAba(subnets)) {
                for (String hypernet : hypernets) {
                    if (hypernet.contains(createBab(aba))) result = true;
                }
            }

            return result;
        }

        public boolean validateTLS() {
            boolean result = false;
            //if subnet then false
            if (!findAbba(hypernets).isEmpty()) return false;
            //if hypernet but same then false - handled in collection
            //if hypernet then true
            if (!findAbba(subnets).isEmpty()) result = true;

            return result;
        }
    }
}
