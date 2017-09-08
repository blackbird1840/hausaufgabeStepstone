package sample;

import applicationsForHausaufgabe.StepStoneTestApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.WebsiteInformation;
import tools.CheckInputURL;

import java.util.Iterator;
import java.util.Map;

/**
 * conbine the View and the model
 */
public class Controller {

    /**
     * websiteToBeanalyse input in the UI
     * showReults output in UI
     * */
    @FXML
    private TextField websiteToBeAnalyse;
    @FXML
    private TextArea showResults;

    /**
     * "button" controller
     */
    @FXML
    protected void submitWebsiteToAnalyse(){
        /** check, if input is with "protocol" information*/
        if(CheckInputURL.isURLWithHeader(websiteToBeAnalyse.getText()))
        {
            WebsiteInformation websiteInformation = new WebsiteInformation(websiteToBeAnalyse.getText(),"a");
            /** check, if the website is reachable*/
            if(websiteInformation.getSelectedElements() != null) {
                StepStoneTestApplication anaylseApplication = new StepStoneTestApplication();
                anaylseApplication.frenquenyOfHrefWithWebAdresse(websiteInformation.getSelectedElements());

                /** write out the results, first clear the TextArea*/
                showResults.clear();
                /** get information from the Site-Frenquency and build the strings to output*/
                Iterator iter = anaylseApplication.getWordAndFrenquency().entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    /** build string to output*/
                    showResults.appendText(entry.getKey().toString() + " - ");
                    showResults.appendText(entry.getValue().toString() + "\n");
                }
            }
            /** case: unreachable website*/
            else {
                showResults.clear();
                showResults.appendText("please check the adress, the URL is not reachable ");
            }
        }
        /** case: input without "protocol"*/
        else {
            showResults.clear();
            showResults.appendText("please check the adress, what you put in. " +
                    "\n 1. maybe you forget 'http://'or 'https://:' " +
                    "\n 2. you forgot the domain");

        }
    }
}
