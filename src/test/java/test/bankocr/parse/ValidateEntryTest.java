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

public class ValidateEntryTest {

    @Test
    void testCorrectNumber() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("useCaseThreeCorrect");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("000000051")));
    }

    @Test
    void testErrNumber() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("useCaseThreeErr");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("000000052 ERR")));
    }
    
    @Test
    void testIllNumber() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("useCaseThreeIll");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("1234?678? ILL")));
    }
}
