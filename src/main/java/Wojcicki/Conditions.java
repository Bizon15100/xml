package Wojcicki;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Conditions {
    public int IbanFitter(String iban){
        Pattern pattern = Pattern.compile("PL(\\d{26})");
        Matcher matcher = pattern.matcher(iban);
        if(matcher.matches()){
            return 1;
        }
        else return 0;
    }

    public int CurrencyFitter(String currency){
        Pattern pattern = Pattern.compile("PLN");
        Matcher matcher = pattern.matcher(currency);
        if(matcher.matches()){
            return 1;
        }
        else return 0;
    }
    public int DateComparator (String date) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateNow = LocalDate.now();
        LocalDate closingDate = LocalDate.from(sdf.parse(date));

        if (dateNow.isBefore(closingDate)) {
            return 1;
        } else return 0;
    }
}
