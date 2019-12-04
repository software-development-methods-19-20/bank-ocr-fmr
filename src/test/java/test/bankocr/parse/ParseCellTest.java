package test.bankocr.parse;

import bankocr.kata.Cell;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ParseCellTest {

    @Test
    void zeroCell() {
        String zeroAsText =
                        " _ " +
                        "| |" +
                        "|_|";
        assertThat(new Cell(zeroAsText).toString(), is(equalTo("0")));
    }

    @Test
    void oneCell() {
        String oneAsText =
                        "   " +
                        "  |" +
                        "  |";
        assertThat(new Cell(oneAsText).toString(), is(equalTo("1")));
    }

    @Test
    void twoCell(){
        String twoAsText =
                 " _ " +
                 " _|" +
                 "|_ ";
        assertThat(new Cell(twoAsText).toString(), is(equalTo("2")));
    }

    @Test
    void eightCell(){
        String eightAsText =
                        " _ " +
                        "|_|" +
                        "|_|";
        assertThat(new Cell(eightAsText).toString(), is(equalTo("8")));
    @Test
    void threeCell(){
        String threeAsText =
                " _ " +
                " _|" +
                " _|";
        assertThat(new Cell(threeAsText).toString(), is(equalTo("3")));
    }

    @Test
    void fourCell() {
        String fourAsText =
                "   " +
                "|_|" +
                "  |";
        assertThat(new Cell(fourAsText).toString(), is(equalTo("4")));
    }

    @Test
    void nineCell(){
        String nineAsText =
                        " _ " +
                        "|_|" +
                        " _|";
        assertThat(new Cell(nineAsText).toString(), is(equalTo("9")));
    }


}
