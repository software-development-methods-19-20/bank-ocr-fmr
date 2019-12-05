package bankocr.kata;

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


private String cellAsText;

    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }

@Override
public String toString() {

        if(ZERO_CELL.equals(cellAsText))
            return "0";
        else if(ONE_CELL.equals(cellAsText))
            return "1";
        else if (TWO_CELL.equals(cellAsText))
            return "2";
        else if(THREE_CELL.equals(cellAsText))
            return "3";
        else if(FOUR_CELL.equals(cellAsText))
            return "4";
        else if (FIVE_CELL.equals(cellAsText))
            return "5";
        else if (SIX_CELL.equals(cellAsText))
            return "6";
        else if(SEVEN_CELL.equals(cellAsText))
            return "7";
        else if (EIGHT_CELL.equals(cellAsText))
            return "8";
        else if (NINE_CELL.equals(cellAsText))
            return "9";
        else return "err";
    }
}
