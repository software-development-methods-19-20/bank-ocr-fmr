package bankocr.kata;

public class Cell {

    private static final String ZERO_CELL =
                    " _ " +
                    "| |" +
                    "|_|";

    private static final String UNO_CELL =
            "   " + "  |" + "  |";

    private String cellAsText;

    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }

    @Override
    public String toString() {
        if (UNO_CELL.equals(cellAsText)) {
            return "1";
        } else if (ZERO_CELL.equals(cellAsText)) {
            return "0";
        } else return "none";
    }
}
