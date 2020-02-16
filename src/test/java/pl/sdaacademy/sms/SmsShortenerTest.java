package pl.sdaacademy.sms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmsShortenerTest {

    @Test
    void shouldShortenValidSms() {
        //given
        String longSms = "Ala ma kota";
        String expectedOutput = "AlaMaKota";
        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithSpaces() {
        //given
        String longSms = "Ala  \t  ma kota";
        String expectedOutput = "AlaMaKota";
        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();
        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithTab() {
        //given
        String longSms = "        \t";
        String expectedOutput = "";
        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();
        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldCountZeroMessagesOnEmptyInput() {
        //given
        String longSms = "  \t";
        int expectedCount = 0;

        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();

        //then
        assertEquals(expectedCount, actualMessageCount);
    }

    @Test
    void shouldCountOneMessageOnShortInput() {
        //given
        String longSms = "Ala ma kota";
        int expectedCount = 1;
        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();
        //then
        assertEquals(expectedCount, actualMessageCount);
    }

    @Test
    void shouldCountMoreThanOneMessage() {
        //given
        String longSms = "Loremipsumdolorsitamet, consecteturadipiscingelit.Duisrutrumvestibulumdoloridpulvinar.Seddignissim, temporultrices,libe.Seddignissim, temporultrices, liberr.Seddigwsaa";
        int expectedCount = 2;
        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();
        //then
        assertEquals(expectedCount, actualMessageCount);
    }

}