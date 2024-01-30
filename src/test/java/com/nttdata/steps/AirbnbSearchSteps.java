package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;
import com.nttdata.screens.SearchDetailsScreen;
import com.nttdata.screens.SearchScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import net.thucydides.core.annotations.Step;

public class AirbnbSearchSteps {

    LoginScreen loginScreen;
    SearchScreen searchScreen;
    SearchDetailsScreen searchDetailsScreen;


    @Step("Click en cerrar")
    public void clickClose(){
        loginScreen.clickClose();
    }

    @Step("Búsqueda por texto {0}")
    public void searchByText(String place){
        searchDetailsScreen.enterSearchInput(place);
    }

    @Step("Ingresar a Where To?")
    public void goWhereTo(){
        searchScreen.clickSearchInput();
    }

    @Step("Obtiene el texto del resultado")
    public String getResultText(){
        return searchScreen.getResultText();
    }

    @Step("Salta filtros de busqueda")
    public void skipFilters() {
        searchDetailsScreen.clickSkip();
        searchDetailsScreen.clickSearch();
    }
    @Step("Encuentra cantidad de resultados")
    public int getCards() {
        return searchScreen.getItemSize();
    }

}
