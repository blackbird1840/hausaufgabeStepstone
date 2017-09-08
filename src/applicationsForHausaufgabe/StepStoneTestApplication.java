package applicationsForHausaufgabe;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepStoneTestApplication {

    private HashMap<String,Integer> wordAndFrenquency;

    public StepStoneTestApplication() {
        this.wordAndFrenquency = new HashMap<>();
    }

    public HashMap<String, Integer> getWordAndFrenquency() {
        return wordAndFrenquency;
    }

    /**
     * analyse info and save the data in hashmap
     * @param elementsTobeAnalyse  the date to be analysed
     * @return hashmap of "Website-frenquencyOfWebsite"
     */
    public HashMap<String,Integer> frenquenyOfHrefWithWebAdresse(Elements elementsTobeAnalyse){
        // TODO may be there another ends
        /** we may later add some new domains
         * use regex to parse source words, take out the parts and build as new words*
         */
        Pattern pattern = Pattern.compile("(.*)(http://|https://)(.*)(.pl|.com|.de|.com.cn)(/.*)");
        for (Element element: elementsTobeAnalyse) {
            /** get and parse the source element*/
            Matcher matcher = pattern.matcher(element.toString());
            while(matcher.find()) {
                /** build new words*/
                StringBuilder webAdress = new StringBuilder();
                webAdress.append(matcher.group(3));
                webAdress.append(matcher.group(4));
                /** save then in hashmap*/
                constructTableWebsiteAdresseAndFrenquency(webAdress.toString());
            }
        }
        return this.wordAndFrenquency;
    }


    /**
     *
     *@param webSiteToInsert the word, need to save
     * construct the hashmap
     */
    private void constructTableWebsiteAdresseAndFrenquency(String webSiteToInsert){
        /** webAdresse existed, then add 1 to the frenquency*/
        if(this.wordAndFrenquency.containsKey(webSiteToInsert)){
            Integer integer = this.wordAndFrenquency.get(webSiteToInsert);
            integer++;
            this.wordAndFrenquency.put(webSiteToInsert,integer);
        }
       /** webAdresse not existed,then insert it*/
        else
            this.wordAndFrenquency.put(webSiteToInsert,1);
    }

}
