package co.com.sofka.page;

import co.com.sofka.model.DespegarModel;
import co.com.sofka.page.common.CommonActionOnpages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class DespegarPage extends CommonActionOnpages {
    private final DespegarModel despegarModel;
    private static final Logger LOGGER = Logger.getLogger(DespegarPage.class);

    /*Locators*/
    private final By selectorIda = By.xpath("//span[text()='Solo ida']");
    private final By selectorIdaVuelta =By.xpath("//span[text()='Ida y vuelta']");

    private final By ciudadOrigen = By.xpath("//input[@placeholder='Ingresa desde dónde viajas']");
    private final By locatorCiudad = By.xpath("/html/body/div[4]/div/div[1]/ul/li/span");

    private final By ciudadDestino = By.xpath("//input[@placeholder='Ingresa hacia dónde viajas']");
    private final By locatorDestino = By.xpath("/html/body/div[4]/div/div[1]/ul/li");

    private final By fechaSalida = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[2]/div[3]/div[28]/div");

    private final By fechaRegreso =By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[2]/div[3]/div[3]/div");

    private final By tipoEquipaje = By.xpath("//*[@id=\"upselling-popup-position\"]/upselling-popup/div/div[2]/upselling-cards/div/div/div/upselling-card[2]/div/div[3]");

    private final By botonAplicar = By.cssSelector("button[class='sbox5-3-btn -primary -md']");

    private final By locatorSalida = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div/div");

    private final By botonBuscar = By.cssSelector("button[class='sbox5-box-button-ovr--3LK5x sbox5-3-btn -secondary -icon -lg']");

    private final By botonSeleccionar = By.xpath("//a[@tooltip-component='buy-button-tooltip']");
    private final By botonContinuar = By.xpath("//button[@class='eva-3-btn pricebox-sticky-button -lg -primary']");

    private final By selectorPse = By.xpath("//span[text()='PSE']");

    private final By selectorBanco = By.id("card-selector-0");

    private final By selectorBancolombia = By.xpath("//option[contains(text(),'Bancolombia')]");

    private final By nombreFactura = By.id("invoice-first-name-0");

    private final By apellidoFactura = By.id("invoice-last-name-0");

    private final By documentoFactura = By.id("invoice-fiscal-identification-number-0");

    private final By seleccionarEstado = By.id("invoice-fiscal-address-state-0");

    private final By seleccionAntioquia = By.xpath("//option[contains(text(),'Antioquia')]");

    private final By seleccionarCiudad = By.id("invoice-fiscal-address-city-CASH_TRANSFER_BOG-0");

    private final By seleccionMedellin = By.id("ui-id-1");

    private final By direccion = By.xpath("//input[starts-with(@class,'input-tag invoice-fiscal-address-street')]");

    private final By nombreViajero = By.xpath("//input[starts-with(@class,'input-tag traveler-first-name ng-untouched ng-pristine ng-invalid')]");

    private final By apellidoViajero = By.xpath("//input[starts-with(@class,'input-tag traveler-last-name ng-untouched ng-pristine ng-invalid')]");

    private final By documentoViajero = By.xpath("//input[starts-with(@class,'input-tag traveler-identification-number ng-untouched ng-pristine ng-invalid')]");

    private final By terminosCondiciones = By.xpath("//*[@id=\"checkout-content\"]/div[1]/buy-component/div/agreement-component/div/ol/li/terms-checkbox-component/checkbox-component/span/label/i");

    private final By nombreReserva = By.xpath("//*[@id=\"checkout-content\"]/div[1]/buy-component/div/form-data-revision-container/form-data-revision/div/ul/li/div[1]/span");

    private final By apellidoReserva = By.xpath("//*[@id=\"checkout-content\"]/div[1]/buy-component/div/form-data-revision-container/form-data-revision/div/ul/li/div[2]/span");

    private final By documentoReserva = By.xpath("//*[@id=\"checkout-content\"]/div[1]/buy-component/div/form-data-revision-container/form-data-revision/div/ul/li/div[3]/span");

    private final By mensajeConfirmacion =By.xpath("//h2[@class='chk-main-title -eva-3-hide-small -eva-3-hide-medium']");

    private final By recorridoPlaneado = By.xpath("//div[@class='dm-title-container']");

    /*Constructor*/

    public DespegarPage (WebDriver driver, DespegarModel despegarModel) {
        super(driver);
        this.despegarModel = despegarModel;
    }

    /*Functions*/

    public void travelSelection () {
        click(selectorIda);
        originDaysSelection();
        click(botonBuscar);

    }

    public void flySelection () {
        click(selectorIdaVuelta);
        originDaysSelection();
        click(fechaRegreso);
        click(botonAplicar);
        click(botonBuscar);

    }

    public void originDaysSelection (){
        click(ciudadOrigen);
        clearText(ciudadOrigen);
        typeInto(ciudadOrigen, despegarModel.getOrigen());
        click(locatorCiudad);
        pressEnter(ciudadOrigen);

        click(ciudadDestino);
        clearText(ciudadDestino);
        typeInto(ciudadDestino, despegarModel.getDestino());

        try {
            waitGeneral(locatorDestino);
            click(locatorDestino);

        }catch (Exception e){
            LOGGER.info(e.getMessage());
            click(ciudadDestino);
            clearText(ciudadDestino);
            typeInto(ciudadDestino, despegarModel.getDestino());
            click(locatorDestino);
        }
        pressEnter(ciudadDestino);

        click(locatorSalida);
        click(fechaSalida);
    }

    public void selectTicket () {
        scrollDown();
        click(botonSeleccionar);
        try {
            click(botonContinuar);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
        }

    }

    public void selectTicketBarranquilla () {
        scrollDown();
        click(botonSeleccionar);
        try {
            click(tipoEquipaje);
            click(botonContinuar);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
        }

    }


    public void fillMandatoryFields () {
        click(selectorPse);

        scrollDown();
        click(selectorBanco);
        click(selectorBancolombia);
        click(selectorBanco);

        scrollDown();
        typeInto(nombreFactura, despegarModel.getNombre());
        typeInto(apellidoFactura, despegarModel.getApellido());
        typeInto(documentoFactura, despegarModel.getNumeroDocumento());

        click(seleccionarEstado);
        click(seleccionAntioquia);
        click(seleccionarEstado);

        click(seleccionarCiudad);
        typeInto(seleccionarCiudad, despegarModel.getDestino());
        click(seleccionMedellin);
        pressTab(seleccionarCiudad);

        click(direccion);
        typeInto(direccion, despegarModel.getDireccion());
        pressTab(direccion);

        click(nombreViajero);
        typeInto(nombreViajero, despegarModel.getNombre());

        click(apellidoViajero);
        typeInto(apellidoViajero, despegarModel.getApellido());

        click(documentoViajero);
        typeInto(documentoViajero, despegarModel.getNumeroDocumento());

        scrollTo(terminosCondiciones);
        click(terminosCondiciones);

    }

    public List<String> fieldsResult () {
        List<String> result = new ArrayList<>();
        result.add(getText(nombreReserva).trim());
        result.add(getText(apellidoReserva).trim());
        result.add(getText(documentoReserva).trim());
        return result;
    }

    public List<String> messageResult () {
        waitGeneral(mensajeConfirmacion);
        waitGeneral(recorridoPlaneado);
        List<String> result = new ArrayList<>();
        result.add(getText(mensajeConfirmacion).trim());
        result.add(getText(recorridoPlaneado).trim());
        return result;
    }

}
