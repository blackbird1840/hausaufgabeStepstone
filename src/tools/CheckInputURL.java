package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInputURL {

    public static boolean isURLWithHeader(String inputURL){
        String regex = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputURL);
        return matcher.matches();
    }
}
