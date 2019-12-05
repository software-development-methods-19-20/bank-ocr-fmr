package bankocr.kata;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class validateEntry {
    private static ArrayList<Integer> charConvert(String input){
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < input.length(); i++){
            int element = Character.getNumericValue(input.charAt(i));
            result.add(element);
        }

        return result;
    }



    public static boolean validateEntry(String input){
        ArrayList<Integer> validate = charConvert(input);
        int sum = 0;
        for(int i = 0; i < validate.size(); i++){
            sum += validate.get(i) * (validate.size() - i);
        }

        return (sum % 11 == 0);
    }
}
