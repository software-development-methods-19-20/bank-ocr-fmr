package bankocr.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter {
    
    static List<Integer> stringToIntegerList(String input) {
        
        return Arrays.stream(input.split("")).map(Integer::parseInt)
                        .collect(Collectors.toList());
    }

    static String integerListToString(List<Integer> input) {

        StringBuilder toReturn = new StringBuilder();
        input.forEach(toReturn::append);
        return toReturn.toString();
    }
    
}
