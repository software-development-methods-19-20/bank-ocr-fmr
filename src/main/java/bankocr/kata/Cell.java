package bankocr.kata;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

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

    private static final String EIGHT_CELL =
                    " _ " +
                    "|_|" +
                    "|_|";

    private static final String NINE_CELL =
                    " _ " +
                    "|_|" +
                    " _|";
private String cellAsText;

    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }


public String toString() {

        if(ZERO_CELL.equals(cellAsText))
            return "0";
        else if(ONE_CELL.equals(cellAsText))
            return "1";
        else if (TWO_CELL.equals(cellAsText))
            return "2";
        else if (EIGHT_CELL.equals(cellAsText))
            return "8";
        else if (NINE_CELL.equals(cellAsText))
            return "9";
        else return "3";
}
}
