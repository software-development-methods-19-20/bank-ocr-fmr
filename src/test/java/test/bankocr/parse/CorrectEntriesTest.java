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

public class CorrectEntriesTest {
    
    @Test
    void testCorrection() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("correctEntriesOne");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayCorrectEntriesForWrongCheckSum(), is(equalTo("711111111")));
    }

    @Test
    void testAmbCorrection() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("correctEntriesAmb");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayCorrectEntriesForWrongCheckSum(), is(equalTo("888888888 AMB [888886888, 888888988, 888888880]")));
    }
}
