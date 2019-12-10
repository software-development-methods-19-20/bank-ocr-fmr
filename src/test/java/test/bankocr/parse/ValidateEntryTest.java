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
    void testIllNumber() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("useCaseThreeIll");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("1234?678? ILL")));
    }
    
    @Test
    void testCorrection() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("useCaseFour");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("711111111")));
    }

    @Test
    void testAmbCorrection() throws Exception {
        URL numberEntry = BankOcrAcceptanceTest.class.getClassLoader().getResource("useCaseFourAmb");
        EntryReader reader = new EntryReader(Path.of(numberEntry.toURI()));
        Entry entry = reader.newReadEntry();
        assertThat(entry.toString(), is(equalTo("888888888 AMB [888886888, 888888988, 888888880]")));
    }
}
