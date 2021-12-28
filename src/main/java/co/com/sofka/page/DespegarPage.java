package co.com.sofka.page;

import co.com.sofka.model.DespegarModel;
import co.com.sofka.page.common.CommonActionOnpages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DespegarPage extends CommonActionOnpages {
    private final DespegarModel despegarModel;
    private static final Logger LOGGER = Logger.getLogger(DespegarPage.class);

    /*Locators*/
    private final By selectorIda = By.xpath("//span[text()='Solo ida']");

    private final By ciudadOrigen = By.xpath("//input[@placeholder='Ingresa desde dónde viajas']");
    private final By locatorCiudad = By.xpath("/html/body/div[4]/div/div[1]/ul/li/span");

    private final By ciudadDestino = By.xpath("//input[@placeholder='Ingresa hacia dónde viajas']");
    private final By locatorDestino = By.xpath("/html/body/div[4]/div/div[1]/ul/li");

    private final By fechaSalida= By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[2]/div[3]/div[27]/div");

    private final By locatorSalida = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div/div");

    private final By botonBuscar = By.cssSelector("button[class='sbox5-box-button-ovr--3LK5x sbox5-3-btn -secondary -icon -lg']");

    private final By botonSeleccionar =By.xpath("//a[@tooltip-component='buy-button-tooltip']");
    private final By botonContinuar =By.xpath("//button[@class='eva-3-btn pricebox-sticky-button -lg -primary']");


    /*Constructor*/
    public DespegarPage (WebDriver driver, DespegarModel despegarModel) {
        super(driver);
        this.despegarModel = despegarModel;
    }

    /*Functions*/

    public void travelSelection () {
        click(selectorIda);

        click(ciudadOrigen);
        clearText(ciudadOrigen);
        typeInto(ciudadOrigen, despegarModel.getOrigen());
        click(locatorCiudad);
        pressEnter(ciudadOrigen);

        click(ciudadDestino);
        clearText(ciudadDestino);
        typeInto(ciudadDestino, despegarModel.getDestino());
        waitGeneral(locatorDestino);
        click(locatorDestino);
        pressEnter(ciudadDestino);

        click(locatorSalida);
        click(fechaSalida);

        click(botonBuscar);

        scrollDown();
        click(botonSeleccionar);

        click(botonContinuar);

    }
    public void fillMandatoryFields(){

    }

}
