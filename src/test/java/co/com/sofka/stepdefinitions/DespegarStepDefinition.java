package co.com.sofka.stepdefinitions;

import co.com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.python.modules.Setup;

public class DespegarStepDefinition extends WebUI {
    @Given("el cliente se encuentra en la url de la página en la opcion de vuelos")
    public void elClienteSeEncuentraEnLaUrlDeLaPáginaEnLaOpcionDeVuelos() {
        generalSetUp();
    }
    @When("el cliente selecciona el lugar de destino")
    public void elClienteSeleccionaElLugarDeDestino() {

    }
    @When("llena el formulario de datos personales y confirma su información")
    public void llenaElFormularioDeDatosPersonalesYConfirmaSuInformación() {

    }
    @Then("la página deberá mostrar un mensaje indicando selección")
    public void laPáginaDeberáMostrarUnMensajeIndicandoSelección() {

    }
}
