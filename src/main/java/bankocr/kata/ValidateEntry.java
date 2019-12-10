package bankocr.kata;

import java.util.ArrayList;
import java.util.List;

public class ValidateEntry {
    
    static boolean checkSum(List<Integer> input) {
        int sum = 0;
        
        for(int i = 0; i < input.size(); i++) {
            sum += input.get(i) * (input.size() - i);
        }
        return (sum % 11 == 0);
    }

    public static boolean validateEntry(String input) {
        ArrayList<Integer> validate = Converter.stringToIntegerList(input);
        
        return checkSum(validate);
    }
}
