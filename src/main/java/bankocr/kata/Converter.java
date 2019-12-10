package bankocr.kata;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    
    static ArrayList<Integer> stringToIntegerList(String input) {
        ArrayList<Integer> toReturn = new ArrayList<>();
        
        for(int i = 0; i < input.length(); i++) {
            int element = Character.getNumericValue(input.charAt(i));
            toReturn.add(element);
        }
        return toReturn;
    }

    static String integerListToString(List<Integer> input) {
        String toReturn = "";
        
        for(int i=0; i<input.size(); i++) {
            toReturn += String.valueOf(input.get(i));
        }
        return toReturn;
    }
    
}
