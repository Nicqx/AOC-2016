package Days;

import utility.FileReader;

import java.util.*;

public class Day6 {
    ArrayList<String> codes = new FileReader("resources/D6/input").fileReaderArrayList();
    Map<Character, Integer> population = new HashMap<>();

    public Day6() {
        System.out.println("D6 - The the error-corrected version is: " +getHighestValues());
        System.out.println("D6/2 - The the error-corrected version with the new methodology is: " +getLowestValues());
    }

    public String getHighestValues() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codes.get(0).length(); i++) {
            population.clear();
            for(String code: codes){
                if(population.containsKey(code.charAt(i))){
                    population.put(code.charAt(i), population.get(code.charAt(i))+1);
                }else{
                    population.put(code.charAt(i),1);
                }
            }
            int max = 0;
            Character maxCh = null;
            for(Character ch: population.keySet()){
                if(population.get(ch)>max){
                    max=population.get(ch);
                    maxCh=ch;
                }
            }
            sb.append(maxCh);
        }
        return sb.toString();
    }

    public String getLowestValues() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codes.get(0).length(); i++) {
            population.clear();
            for(String code: codes){
                if(population.containsKey(code.charAt(i))){
                    population.put(code.charAt(i), population.get(code.charAt(i))+1);
                }else{
                    population.put(code.charAt(i),1);
                }
            }
            int min = Integer.MAX_VALUE;
            Character minCh = null;
            for(Character ch: population.keySet()){
                if(population.get(ch)<min){
                    min=population.get(ch);
                    minCh=ch;
                }
            }
            sb.append(minCh);
        }
        return sb.toString();
    }

}
