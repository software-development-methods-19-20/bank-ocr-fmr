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

public class GenerateCorrectEntriesTest {
    
    @Test
    void testErrCorrection() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allOnesEntry");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayCorrectEntriesForErrMessage(), is(equalTo("711111111")));
    }

    @Test
    void testAmbCorrection() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("allEightsEntry");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayCorrectEntriesForErrMessage(), is(equalTo("888888888 AMB [888886888, 888888988, 888888880]")));
    }
    
    @Test
    void testIllCorrection() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("wrongCellEntry");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.displayCorrectEntriesForIllMessage(), is(equalTo("490867715")));
    }
}
