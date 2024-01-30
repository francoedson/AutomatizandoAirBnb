package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AirbnbSearchSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class AirbnbSearchStepsDefs {

    @Steps
    AirbnbSearchSteps airbnbSearchSteps;

    @Given("que ingreso a la aplicación Airbnb")
    public void queIngresoALaAplicaciónAirbnb() {
    }

    @And("cierro la ventana de inciar sesión")
    public void cierroLaVentanaDeInciarSesión() {
        airbnbSearchSteps.clickClose();
    }

    @When("ingreso al formulario Where To?")
    public void ingresoAlFormularioWhereTo() {
        airbnbSearchSteps.goWhereTo();
    }

    @And("realizo la busqueda {string}")
    public void realizoLaBusqueda(String place) {
        airbnbSearchSteps.searchByText(place);
    }
    @And("salto la seleción de días y demás filtros")
    public void saltoLaSeleciónDeDíasYDemásFiltros() {
        airbnbSearchSteps.skipFilters();
    }

    @Then("debo encontrar más de un resultado disponible")
    public void deboEncontrarMásDeUnResultadoDisponible() {
        int results =airbnbSearchSteps.getCards();
        System.out.println("Total de resultados hasta este momento de carga:"+results);
        Assert.assertTrue("El tamaño de la lista es: " + results,results>0);
    }

    @And("muestra el texto {string}")
    public void muestra_el_texto(String expectText) {
        String text=airbnbSearchSteps.getResultText();
        System.out.println(text+" - "+expectText);
        Assert.assertEquals(text, expectText);
    }



}
