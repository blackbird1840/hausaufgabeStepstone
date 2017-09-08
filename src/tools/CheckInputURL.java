package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * here are some small tool functions, which can be reused.
 */
public class CheckInputURL {

    /** check, if the input with "transfer protocol". In this homework, "http" and "https" are concerned */
    public static boolean isURLWithHeader(String inputURL){
        String regex = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputURL);
        return matcher.matches();
    }
}
