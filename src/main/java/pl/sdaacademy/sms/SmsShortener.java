package pl.sdaacademy.sms;

public class SmsShortener {

    private  final String longSms;

    public SmsShortener(String longSms) {
        this.longSms = longSms;
    }

    public int countMessages() {
        String shortenedSms = shortenSms();
        if (shortenedSms.isBlank()) { // ? 0 : 1;
            return 0;
        }
        /*double count = (double) shortenedSms.length() / 160;
        return (int) Math.ceil(count);*/

        int fullMessagesCount = shortenedSms.length() / 160;
        if (hasRemainingCharacters(shortenedSms)) {
            return fullMessagesCount + 1;
        }
        return fullMessagesCount;

    }

    private boolean hasRemainingCharacters(String shortenedSms) {
        return shortenedSms.length() % 160 !=0;
    }


    public String shortenSms() {
        String[] words = longSms.split(" ");

        StringBuilder shortenedSmsBuilder = new StringBuilder();
        for (String word : words) {
            String trimmeWord = word.trim();
            if (!trimmeWord.isEmpty()) {
                String capitalLetter = trimmeWord.substring(0, 1).toUpperCase();
                String capitalizedWord = capitalLetter + trimmeWord.substring(1);
                //String upperCaseWord = word.toUpperCase();
                shortenedSmsBuilder.append(capitalizedWord);
                }
            }
            return shortenedSmsBuilder.toString();
        }
}
