package bankocr.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmbiguousEntry {
    
    private static final List<Integer> substituteZero = Arrays.asList(8);
    private static final List<Integer> substituteOne = Arrays.asList(7);
    private static final List<Integer> substituteTwo = Arrays.asList();
    private static final List<Integer> substituteThree = Arrays.asList(9);
    private static final List<Integer> substituteFour = Arrays.asList();
    private static final List<Integer> substituteFive = Arrays.asList(6,9);
    private static final List<Integer> substituteSix = Arrays.asList(5,8);
    private static final List<Integer> substituteSeven = Arrays.asList(1);
    private static final List<Integer> substituteEight = Arrays.asList(0,6,9);
    private static final List<Integer> substituteNine = Arrays.asList(8);

    private static final List<List<Integer>> subsList;
    
    static {
        List<List<Integer>> aList = new ArrayList<>();
        aList.add(substituteZero);
        aList.add(substituteOne);
        aList.add(substituteTwo);
        aList.add(substituteThree);
        aList.add(substituteFour);
        aList.add(substituteFive);
        aList.add(substituteSix);
        aList.add(substituteSeven);
        aList.add(substituteEight);
        aList.add(substituteNine);
        subsList = Collections.unmodifiableList(aList);
    }
    
    public static List<String> correctEntries(String entry) {
        List<String> toReturn = new ArrayList<>();
        
        List<Integer> cellList = Converter.stringToIntegerList(entry);
        for(int i=0; i<cellList.size(); i++) {

            int currentNumber = cellList.get(i);

            List<Integer> currentNumbersSubs = subsList.get(currentNumber);

            for(int j=0; j<currentNumbersSubs.size(); j++) {

                List<Integer> attempt = new ArrayList<>();


                for(int k=0; k< 9; k++) {
                    attempt.add(cellList.get(k));
                }

                attempt.set(i, subsList.get(currentNumber).get(j));
                if(ValidateEntry.checkSum(attempt)) {
                    toReturn.add(Converter.integerListToString(attempt));
                }
            }
        }
        return toReturn;
    }
 
}
