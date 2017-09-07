package sample;

import applicationsForHausaufgabe.AnaylseApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.WebsiteInformation;
import tools.CheckInputURL;

import java.util.Iterator;
import java.util.Map;


public class Controller {

    @FXML
    private TextField websiteToBeAnalyse;
    @FXML
    private TextArea showResults;

    @FXML
    protected void submitWebsiteToAnalyse(){
        System.out.println(websiteToBeAnalyse.getText());
        //
        if(CheckInputURL.isURLWithHeader(websiteToBeAnalyse.getText()))
        {
            WebsiteInformation websiteInformation = new WebsiteInformation(websiteToBeAnalyse.getText(),"a");
            if(websiteInformation.getSelectedElements() != null) {
                AnaylseApplication anaylseApplication = new AnaylseApplication();
                System.out.println(websiteInformation.getSelectedElements().toString());
                anaylseApplication.frenquenyOfHrefWithWebAdresse(websiteInformation.getSelectedElements());

                // write out the results, first clear the TextArea
                showResults.clear();
                Iterator iter = anaylseApplication.getWordAndFrenquency().entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();

                    // write out
                    showResults.appendText(entry.getKey().toString() + " - ");
                    showResults.appendText(entry.getValue().toString() + "\n");
                }
            }
            else {
                showResults.clear();
                showResults.appendText("please check the adress, the URL is not reachable ");
            }

        }
        else {
            showResults.clear();
            showResults.appendText("please check the adress, what you put in. maybe 1.you forget 'http'or 'https' ");
        }

    }
}
