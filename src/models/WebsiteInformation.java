package models;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class WebsiteInformation {

    private String webSiteToBeAnalyse;
    /**the Tag, whose elements we want to.*/
    private String selectTagInWebsite;

    public WebsiteInformation(String webSiteToBeAnalyse, String selectTagInWebsite) {

        this.webSiteToBeAnalyse = webSiteToBeAnalyse;
        this.selectTagInWebsite = selectTagInWebsite;
    }

    /**
     * 1. get all information from the Website
     * 2. handel with some Exceptions, which can hanppen. If so, we will get "null"
     * @return the data of the website or null
     */
    private Document getAllDataFromWebSite() {
        try {
            Document dataFromWebsite = Jsoup.connect(this.webSiteToBeAnalyse).userAgent("Mozilla/5.9 (Windows NT 6.1; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.de")
                    .timeout(50000)
                    .followRedirects(true)
                    .get();

            return dataFromWebsite;

        } catch (UnknownHostException e) {
            //e.printStackTrace();

        }catch (SocketException e){
           // e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * pick out the Tag-Information, which we want to
     *@ return all the Elements, that are selected
     */
    public Elements getSelectedElements(){
        Document allWebsiteInfo = getAllDataFromWebSite();
        if(allWebsiteInfo != null){
            Elements selectedElements = allWebsiteInfo.select(this.selectTagInWebsite);
            return selectedElements;
        } else
            return null;
    }
}
