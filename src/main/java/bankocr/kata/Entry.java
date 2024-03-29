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
        
        return toReturn;
    }
    
    public String displayIllMessageForWrongCells() {
        String toReturn = this.toString();
        if (toReturn.contains("?")) {
            toReturn += " ILL";
        }
        
        return toReturn;
    }
    
    public String displayErrMessageForWrongCheckSum() {
        String toReturn = this.toString();
        if (!ValidateCheckSum.validateCheckSum(this.toString())) {
            toReturn += " ERR";
        }
        
        return toReturn;
    }
    
    public String displayCorrectEntriesForErrMessage() {
        String toReturn = this.toString();
        
        if (!ValidateCheckSum.validateCheckSum(toReturn)) {
            List<String> correctEntries = GenerateCorrectEntries.correctEntries(toReturn);
            if(correctEntries.size() == 1) {
                toReturn = String.valueOf(correctEntries.get(0));
            } else if (correctEntries.size() > 1) {
                toReturn = toReturn + " AMB " + correctEntries.toString();
            }
        }
        
        return toReturn;
    }
    
    public String displayCorrectEntriesForIllMessage() {
        String tmp = this.toString();
        
        int wrongCellPosition = tmp.indexOf("?");
        Cell wrongCell = cells.get(wrongCellPosition);
        List<Cell> possibleCells = Cell.getListOfPossibleCells(wrongCell);
        
        if(possibleCells.isEmpty()) {
            return "ILL";
        } else {
            int positionInPossibleCells = 0;
            do {
                this.cells.set(wrongCellPosition, possibleCells.get(positionInPossibleCells));
                tmp = this.toString();
                positionInPossibleCells++;
            } while (!ValidateCheckSum.validateCheckSum(tmp));

            return tmp;
        }
    }
}
