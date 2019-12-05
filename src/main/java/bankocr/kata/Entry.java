package bankocr.kata;

import java.util.ArrayList;
import java.util.List;

public class Entry {

    List<Cell> cells = new ArrayList<>();

    public Entry(String firstLine, String secondLine, String thirdLine) {
        while (!firstLine.isEmpty()) {
            Cell cell = new Cell(firstLine.substring(0, 3) + secondLine.substring(0, 3) + thirdLine.substring(0, 3));
            cells.add(cell);
            firstLine = firstLine.substring(3);
            secondLine = secondLine.substring(3);
            thirdLine = thirdLine.substring(3);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        cells.forEach(cell -> stringBuilder.append(cell.toString()));
        String toReturn = stringBuilder.toString();
        if (toReturn.contains("?")) {
            toReturn += " ILL";
        } else if (!ValidateEntry.validateEntry(toReturn)) {
            toReturn += " ERR";
        }
        return toReturn;
    }
}
