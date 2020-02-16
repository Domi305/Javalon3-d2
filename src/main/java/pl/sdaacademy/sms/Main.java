package pl.sdaacademy.sms;

public class Main {
    public static void main(String[] args) {
//        String longSms = new Scanner(System.in).nextLine();
        String longSms = "To jest dlugi sms";
        SmsShortener smsShortener = new SmsShortener();
        System.out.println(smsShortener.shortenSms(longSms));
    }
}
