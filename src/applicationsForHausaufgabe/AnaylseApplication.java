package applicationsForHausaufgabe;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnaylseApplication {

    private HashMap<String,Integer> wordAndFrenquency;

    public AnaylseApplication() {
        this.wordAndFrenquency = new HashMap<>();
    }

    public HashMap<String, Integer> getWordAndFrenquency() {
        return wordAndFrenquency;
    }

    /*
          in this case get the webadresse and count them
        */
    public HashMap<String,Integer> frenquenyOfHrefWithWebAdresse(Elements elementsTobeAnalyse){
        // find the href with "http" or "https"
        // TODO may be there another ends
        Pattern pattern = Pattern.compile("(.*)(http://|https://)(.*)(.pl|.com|.de|.com.cn)(/.*)");

        for (Element element: elementsTobeAnalyse) {
            Matcher matcher = pattern.matcher(element.toString());
            while(matcher.find()) {
                StringBuilder webAdress = new StringBuilder();

                webAdress.append(matcher.group(3));
                webAdress.append(matcher.group(4));
//                System.out.println(webAdress);

                constructHashmapWebsiteAdresseAndFrenquency(webAdress.toString());
            }
        }
        return this.wordAndFrenquency;
    }


    /*
    @return construct the hashmap
     */
    private void constructHashmapWebsiteAdresseAndFrenquency(String webSiteToInsert){
        // webAdresse existed
        if(this.wordAndFrenquency.containsKey(webSiteToInsert)){
            Integer integer = this.wordAndFrenquency.get(webSiteToInsert);
            integer++;
            this.wordAndFrenquency.put(webSiteToInsert,integer);
        }
       // webAdresse not existed
        else
            this.wordAndFrenquency.put(webSiteToInsert,1);
    }

}
