package com.nttdata.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.GridView[@content-desc=\"Explore Airbnb\"]/androidx.compose.ui.platform.ComposeView")
    private List<WebElement> cardItems;
    @AndroidFindBy(id = "com.airbnb.android:id/search_bar")
    private WebElement searchInput;

    @AndroidFindBy(id = "com.airbnb.android:id/n2_bottom_sheet_title_title")
    private WebElement resultText;

    public int getItemSize(){
        return cardItems.size();
    }

    public void clickSearchInput(){
        searchInput.click();
    }

    public String getResultText(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        swipeDown();
        return resultText.getText();
    }
    public static void swipeDown() {
        String cmd = "adb shell input touchscreen swipe 500 500 500 1000 5000";
        try {
            Runtime.getRuntime().exec(cmd);
        }catch(Exception e) {
        }
    }

}
