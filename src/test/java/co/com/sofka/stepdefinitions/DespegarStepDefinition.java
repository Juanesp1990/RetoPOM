package co.com.sofka.stepdefinitions;

import co.com.sofka.model.DespegarModel;
import co.com.sofka.page.DespegarPage;
import co.com.sofka.setup.WebUI;
import co.com.sofka.util.Documento;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class DespegarStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(DespegarStepDefinition.class);
    private static final String MESSAGE_OK = "PROCESO EXITOSO";
    private static final String MESSAGE_ERROR_OPEN = "Error Iniciando la página despegar.com ";
    private static final String MESSAGE_ERROR_SEARCH_FLY = "Error en la busqueda del vuelo";
    private static final String MESSAGE_ERROR_SELECT_FLY = "Error seleccionando la información /llenado";
    private static final String MESSAGE_ERROR_COMPARATION = "Error comparando la información";

    private DespegarModel despegarModelBogota;
    private DespegarPage despegarPageBogota;

    private DespegarModel despegarModelBarranquilla;
    private DespegarPage despegarPageBarranquilla;


    @Given("el cliente se encuentra en la url de la página de despegar.com en la sección de vuelos")
    public void elClienteSeEncuentraEnLaUrlDeLaPaginaDeDespegarComEnLaSeccionDeVuelos () {
        try {
            generateClient();
            generalSetUp();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_OPEN);
        }
    }

    @When("el cliente selecciona el lugar de origen-destino, solo ida y oprime el botón buscar")
    public void elClienteSeleccionaElLugarDeOrigenDestinoSoloIdaYOprimeElBotonBuscar () {
        try {
            despegarPageBogota = new DespegarPage(driver, despegarModelBogota);
            despegarPageBogota.travelSelection();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_SEARCH_FLY);

        }

    }

    @When("el cliente escoge el vuelo, indica su equipaje y completa la información de la reserva")
    public void elClienteEscogeElVueloIndicaSuEquipajeYCompletaLaInformacionDeLaReserva () {
        try {
            despegarPageBogota.selectTicket();
            despegarPageBogota.fillMandatoryFields();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_SELECT_FLY);

        }

    }

    @Then("el cliete debería ver los datos de la persona que viaja antes de presionar el botón comprar")
    public void elClieteDeberiaVerLosDatosDeLaPersonaQueViajaAntesDePresionarElBotonComprar () {
        try {
            Assertions.assertEquals(
                    despegarPageBogota.fieldsResult(),
                    ExpectecResult(), "");
            LOGGER.info(MESSAGE_OK);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_COMPARATION);
        } finally {
            quiteDriver();
        }

    }

    @Given("el cliente se encuentra en la url de la página de despegar en la sección de vuelos")
    public void elClienteSeEncuentraEnLaUrlDeLaPaginaDeDespegarEnLaSeccionDeVuelos () {
        try {
            generateFly();
            generalSetUp();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_OPEN);
        }
    }


    @When("el cliente selecciona el lugar de origen-destino, ida y vuelta y oprime el botón buscar")
    public void elClienteSeleccionaElLugarDeOrigenDestinoIdaYVueltaYOprimeElBotonBuscar () {
        try {
            despegarPageBarranquilla = new DespegarPage(driver, despegarModelBarranquilla);
            despegarPageBarranquilla.flySelection();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_SEARCH_FLY);

        }

    }

    @When("el cliente escoge el vuelo, indica su equipaje adicional")
    public void elClienteEscogeElVueloIndicaSuEquipajeAdicional () {
        try {
            despegarPageBarranquilla.selectTicketBarranquilla();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_SELECT_FLY);

        }

    }

    @Then("el cliete debería ver un mensaje de falta poco y el lugar de origen-destino")
    public void elClieteDeberiaVerUnMensajeDeFaltaPocoYElLugarDeOrigenDestino () {
        try {
            Assertions.assertEquals(despegarPageBarranquilla.messageResult(), ResultExpectBarranquilla(), "");
            LOGGER.info(MESSAGE_OK);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_COMPARATION);
        } finally {
            quiteDriver();
        }


    }

    private void generateClient () {
        despegarModelBogota = new DespegarModel();
        despegarModelBogota.setOrigen(" Bogota");
        despegarModelBogota.setDestino(" Medellin");
        despegarModelBogota.setNombre("Marcela");
        despegarModelBogota.setApellido("Acevedo Aguilar");
        despegarModelBogota.setTipoDocumento(Documento.CEDULA);
        despegarModelBogota.setNumeroDocumento("1017468973");
        despegarModelBogota.setEstado("Antioquia");
        despegarModelBogota.setCiudad("Medellín");
        despegarModelBogota.setDireccion("Diagonal 76 DD 4-55 BL 56-103");
    }

    private void generateFly () {
        despegarModelBarranquilla = new DespegarModel();
        despegarModelBarranquilla.setOrigen(" Medellin");
        despegarModelBarranquilla.setDestino(" Barranquilla");
    }

    private List<String> ExpectecResult () {
        List<String> result = new ArrayList<>();
        result.add(despegarModelBogota.getNombre().trim());
        result.add(despegarModelBogota.getApellido().trim());
        result.add(despegarModelBogota.getNumeroDocumento().trim());
        return result;
    }

    public List<String> ResultExpectBarranquilla () {

        List<String> result = new ArrayList<>();
        result.add("¡Falta poco! Completa tus datos y finaliza tu compra".trim());
        result.add("Medellín - Barranquilla".trim());
        return result;
    }

}
