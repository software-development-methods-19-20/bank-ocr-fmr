package bankocr.kata;

import javax.security.auth.login.AccountExpiredException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    
    static ArrayList<Integer> stringToIntegerList(String input) {
        ArrayList<Integer> toReturn = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));;

        return toReturn;
    }

    static String integerListToString(List<Integer> input) {

        StringBuilder toReturn = new StringBuilder();
        input.forEach(toReturn::append);
        
        return toReturn.toString();
    }
    
}
