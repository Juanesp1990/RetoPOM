package co.com.sofka.stepdefinitions;

import co.com.sofka.model.DespegarModel;
import co.com.sofka.page.DespegarPage;
import co.com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DespegarStepDefinition extends WebUI {
    private DespegarModel despegarModel;
    private DespegarPage despegarPage;

    @Given("el cliente se encuentra en la url de la página en la opcion de vuelos")
    public void elClienteSeEncuentraEnLaUrlDeLaPáginaEnLaOpcionDeVuelos() {
        generalSetUp();
        generateClient();
    }

    @When("el cliente selecciona el lugar de destino")
    public void elClienteSeleccionaElLugarDeDestino() {
        despegarPage = new DespegarPage(driver,despegarModel);
        despegarPage.travelSelection();

    }
    @When("llena el formulario de datos personales y confirma su información")
    public void llenaElFormularioDeDatosPersonalesYConfirmaSuInformación() {

    }
    @Then("la página deberá mostrar un mensaje indicando selección")
    public void laPáginaDeberáMostrarUnMensajeIndicandoSelección() {

    }

    private void generateClient () {
        despegarModel =new DespegarModel();
        despegarModel.setOrigen(" Bogota");
        despegarModel.setDestino(" Medellin");
    }
}
