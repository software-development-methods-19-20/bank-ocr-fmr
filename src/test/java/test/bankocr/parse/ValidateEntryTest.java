package test.bankocr.parse;

import bankocr.kata.Entry;
import bankocr.kata.EntryReader;
import bankocr.kata.validateEntry;
import org.junit.jupiter.api.Test;
import test.bankocr.BankOcrAcceptanceTest;

import java.net.URL;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ValidateEntryTest {
    @Test
    void isValid (){
        assertThat(validateEntry.validateEntry("345882865"), is( Boolean.TRUE));
    }

}
