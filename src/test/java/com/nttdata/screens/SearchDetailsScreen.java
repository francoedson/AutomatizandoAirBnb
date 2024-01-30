package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class SearchDetailsScreen extends PageObject {

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Search destinations\"]")
    private WebElement searchDetailInput;

    @AndroidFindBy(id="com.airbnb.android:id/input_bar_input")
    private WebElement searchDetailInputText;


    @AndroidFindBy(id = "com.airbnb.android:id/n2_simple_search_footer_link")
    private WebElement skipButton;

    @AndroidFindBy(id = "com.airbnb.android:id/n2_dls_action_footer_gradient_button")
    private WebElement searchButton;

    public void enterSearchInput(String place){
        searchDetailInput.click();
        searchDetailInputText.sendKeys(place);
        enviarEnter();
    }


    public void clickSkip(){
        skipButton.click();
    }

    public void clickSearch(){
        searchButton.click();
    }

    public static void enviarEnter(){
        String cmd = "adb shell input keyevent 66";
        try {
            Runtime.getRuntime().exec(cmd);
        }catch(Exception e) {
        }
    }
}
