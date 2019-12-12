package test.bankocr.parse;

import bankocr.kata.Entry;
import bankocr.kata.EntryReader;
import org.junit.jupiter.api.Test;
import test.bankocr.BankOcrAcceptanceTest;

import java.net.URL;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MessagesForIncorrectEntriesTest {

    @Test
    void testCheckSum() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("checkSumCorrectEntry");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayErrMessageForWrongCheckSum(), is(equalTo("000000051")));
    }

    @Test
    void testWrongCheckSum() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("checkSumIncorrectEntry");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayErrMessageForWrongCheckSum(), is(equalTo("000000052 ERR")));
    }

    @Test
    void testIllNumber() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("wrongCellEntry");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayQuestionMarkForWrongCells(), is(equalTo("1234?678? ILL")));
    }
}
