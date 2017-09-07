package models;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.UnknownHostException;

public class WebsiteInformation {
    private String webSiteToBeAnalyse;
    private String selectTagInWebsite;

    public WebsiteInformation(String webSiteToBeAnalyse, String selectTagInWebsite) {

        this.webSiteToBeAnalyse = webSiteToBeAnalyse;
        this.selectTagInWebsite = selectTagInWebsite;
    }


    /*
          @return the data of the website or null
        */
    private Document getAllDataFromWebSite() {
        try {
            Document dataFromWebsite = Jsoup.connect(this.webSiteToBeAnalyse).userAgent("Mozilla/5.9 (Windows NT 6.1; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.de")
                    .timeout(50000)
                    .followRedirects(true)
                    .get();

            return dataFromWebsite;

        } catch (UnknownHostException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /*
    @ return all the Elements, that are selected
     */
    public Elements getSelectedElements(){
        Document allWebsiteInfo = getAllDataFromWebSite();
        if(allWebsiteInfo != null){
            Elements selectedElements = (Elements)allWebsiteInfo.select(this.selectTagInWebsite);
            return selectedElements;
        } else
            return null;
    }
}
