package bankocr.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ValidateEntry {
    
    static boolean checkSum(List<Integer> input) {

        int sum = IntStream.range(0, input.size()).
                parallel().
                map(id -> input.get(id) * (input.size() - id)).
                reduce(0, Integer::sum);
        return (sum % 11 == 0);
    }

    public static boolean validateEntry(String input) {
        ArrayList<Integer> validate = Converter.stringToIntegerList(input);
        
        return checkSum(validate);
    }
}
