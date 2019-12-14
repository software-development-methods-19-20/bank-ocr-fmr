package bankocr.kata;

import java.util.List;
import java.util.stream.IntStream;

public class ValidateCheckSum {
    
    static boolean checkSum(List<Integer> input) {
        
        int sum = IntStream.range(0, input.size())
                    .parallel()
                    .map(id -> input.get(id) * (input.size() - id))
                    .reduce(0, Integer::sum);
         
        return (sum % 11 == 0);
    }

    static boolean validateCheckSum(String input) {
        
        List<Integer> validate = StringListConverter.stringToIntegerList(input);
        return checkSum(validate);
    }
}
