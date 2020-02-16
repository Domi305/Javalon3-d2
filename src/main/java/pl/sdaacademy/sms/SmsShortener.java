package pl.sdaacademy.sms;

import java.util.Scanner;

public class SmsShortener {

    public String shortenSms(String longSms) {
        String[] words = longSms.split(" ");

        StringBuilder shortenedSmsBuilder = new StringBuilder();
        for (String word : words) {
            if (word != null && !word.isBlank()) {
                String capitalLetter = word.substring(0, 1).toUpperCase();
                String capitalizedWord = capitalLetter + word.substring(1);
                //String upperCaseWord = word.toUpperCase();
                shortenedSmsBuilder.append(capitalizedWord);
                }
            }
            return shortenedSmsBuilder.toString();
        }

}
