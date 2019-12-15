package bankocr.kata;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Cell {

    private static final String ZERO_CELL =
                    " _ " +
                    "| |" +
                    "|_|";

    private static final String ONE_CELL =
                    "   " +
                    "  |" +
                    "  |";

    private static final String TWO_CELL =
                    " _ " +
                    " _|" +
                    "|_ ";

    private static final String THREE_CELL =
                    " _ " +
                    " _|" +
                    " _|";

    private static final String FOUR_CELL =
                    "   " +
                    "|_|" +
                    "  |";

    private static final String FIVE_CELL =
                    " _ " +
                    "|_ " +
                    " _|";

    private static final String SIX_CELL =
                    " _ " +
                    "|_ " +
                    "|_|";

    private static final String SEVEN_CELL =
                    " _ " +
                    "  |" +
                    "  |";

    private static final String EIGHT_CELL =
                    " _ " +
                    "|_|" +
                    "|_|";

    private static final String NINE_CELL =
                    " _ " +
                    "|_|" +
                    " _|";
    
    private static final List<String> correctCellsAsTextList = Arrays.asList(ZERO_CELL,  ONE_CELL,   TWO_CELL,
                                                                             THREE_CELL, FOUR_CELL,  FIVE_CELL,
                                                                             SIX_CELL,   SEVEN_CELL, EIGHT_CELL,
                                                                             NINE_CELL);                                                                   

    private String cellAsText;
    
    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }

    @Override
    public String toString() {

        if (ZERO_CELL.equals(cellAsText))
            return "0";
        else if (ONE_CELL.equals(cellAsText))
            return "1";
        else if (TWO_CELL.equals(cellAsText))
            return "2";
        else if (THREE_CELL.equals(cellAsText))
            return "3";
        else if (FOUR_CELL.equals(cellAsText))
            return "4";
        else if (FIVE_CELL.equals(cellAsText))
            return "5";
        else if (SIX_CELL.equals(cellAsText))
            return "6";
        else if (SEVEN_CELL.equals(cellAsText))
            return "7";
        else if (EIGHT_CELL.equals(cellAsText))
            return "8";
        else if (NINE_CELL.equals(cellAsText))
            return "9";
        else return "?";
    }

    private static int numberOfDifferentCharacters(String wrongCellAsText, String correctCellAsText) {
        int counter = 0;
        int cellLength = 9;

        for(int i=0; i<cellLength; i++) {
            if(wrongCellAsText.charAt(i) != correctCellAsText.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
    
    static List<Cell> getListOfPossibleCells(Cell wrongCell) {
        return correctCellsAsTextList.stream().filter(cell -> numberOfDifferentCharacters(cell, wrongCell.cellAsText) == 1)
                .map(Cell::new).collect(Collectors.toList());
    }
}
