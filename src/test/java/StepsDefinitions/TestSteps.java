package StepsDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Acciones.PruebaAccion;
import CommonFuntions.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TestSteps {
	
	WebDriver driver;
	Logger log = Logger.getLogger(TestSteps.class);	
	BaseTest baseTest;
	PruebaAccion pruebaAccion;
	
	public TestSteps() {		
		//super(driver);
		this.driver = Driver.driver;		
		pruebaAccion = new PruebaAccion(driver);
	}
	
	@Given("a user enters the page")
	public void AUserEntersThePage() {
		log.info("Ingreso a la pagina");
	}
	
	
	@When("verify that you already have an appointment with the following data  {string}{string}{string}")
    public void verifyThatYouAlreadyHaveAnAppointmentWithTheFollowingData(String usuario, String duracion, String horario) throws Throwable {
		pruebaAccion.verificarCita( usuario,  duracion,  horario);
    }   

    @And("schedule a new appointment with the data {string}{string}{string}{string}{string}")
    public void scheduleANewAppointmentWithTheData(String dia,String zonaHoraria, String horaCita, String Mes,String tipo) throws Throwable {
    	pruebaAccion.agendarCita(dia,Mes,zonaHoraria,horaCita,tipo);
    	log.info("agendamiento de cita");
    }
    
    @Then("appointment assignment is validated {string}{string}")
    public void appointmentAssignmentIsValidated(String mensaje,String horario) throws Throwable {
    	pruebaAccion.validarCita(mensaje, horario);
    	log.info("Validacion nueva cita");
    }
    
    /*Cancelacion de citas*/
    @When("^select to button cancel metting$")
    public void selectToButtonCancelMetting() throws Throwable {    	
    	pruebaAccion.selectButtonCancel();
    }
    
    @And("select reason of cancell {string}")
    public void selectReasonOfCancell(String razoncancell) throws Throwable {
    	pruebaAccion.selectRazonCancel(razoncancell);
    }

    @And("select advisor option {string}{string}")
    public void selectAdvisorOption(String advisoropcion, String razoncancell) throws Throwable {
    	pruebaAccion.selectAdvisorCancel(advisoropcion, razoncancell);
    }

    @Then("^allows you to cancel the appointment showing following message \"([^\"]*)\"$")
    public void allowsYouToCancelTheAppointmentShowingFollowingMessage(String message) throws Throwable {
    	pruebaAccion.confirmCancelAppoiment(message);
    }
	
    
    /*Buscar Horarios*/
    
    @When("one day is selected {string}")
    public void oneDayIsSelected(String day) throws Throwable {
    	pruebaAccion.selectDay(day);
    }
    
    @And("a time zone is selected {string}")
    public void aTimeZoneIsSelected(String timeZone) throws Throwable {
    	pruebaAccion.selectTimeZone(timeZone);
    	log.info("selecciona hora ");
    }

   
    
    @Then("Validate the displayed List")
    public void ValidateTheDisplayedList(DataTable dataTable) throws Throwable {  
    	pruebaAccion.validateTimeZone(dataTable);
    	
    }
    
    


	
}
