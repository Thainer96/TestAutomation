package Acciones;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonFuntions.BaseTest;
import Pages.TestPages;
import io.cucumber.datatable.DataTable;


public class PruebaAccion extends BaseTest {
	
	WebDriver driver;
	private static Logger log = Logger.getLogger(PruebaAccion.class);
	TestPages testPage = new TestPages(driver);
		
	public PruebaAccion(WebDriver driver) {
		super(driver);
	}
	
	
	
	public void verificarCita(String usuario, String duracion, String horario) {
		log.info("************ verificando Cita*********");
		try {	
			log.info(extraerTextoElemento(testPage.informationName));
			log.info(extraerTextoElemento(testPage.tiempoAgendado));
			log.info(extraerTextoElemento(testPage.duracion));
			assertThat("texto no encontrado",extraerTextoElemento(testPage.informationName),containsString(usuario));
			assertThat("texto no encontrado",extraerTextoElemento(testPage.duracion),containsString(duracion));
			assertThat("texto no encontrado",extraerTextoElemento(testPage.tiempoAgendado),containsString(horario));
			adjuntarCaptura("PantallaInicial");
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - verificarCita() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - verificarCita() ##########"+ e,false);
		}
		
	}
	
	public void agendarCita(String dia, String mes, String zonaHoraria, String horario,String tipo) {
		log.info("************ Agendar cita *********");
		try {
			log.info(extraerTextoElemento(testPage.mescalendario));
			extraerTextoElemento(testPage.mescalendario);
			
			if(!extraerTextoElemento(testPage.mescalendario).equals(mes)) {				
				hacerClick(testPage.flechaCalendario);
			}			
			adjuntarCaptura("ChangeOfMonths");
			
			esperaExplicitaTexto(mes);	
			hacerClick(By.xpath("//div[@class='CCDatesView__days_day']//child::div[@data-number='"+dia+"']"));
			
			adjuntarCaptura("Selectday");
			
			esperaExplicita(testPage.bottonZona);
			hacerClick(testPage.bottonZona);
			
			selectValorLista(testPage.listZona, zonaHoraria);
			adjuntarCaptura("SelectZone");
			selectValorLista(testPage.listHorario, horario);
			adjuntarCaptura("SelectHour");
			
			if(!tipo.equals("Video Conference")) {
				hacerClick(testPage.selectPhone);
				adjuntarCaptura("SelectType");
			}
			
			hacerClick(testPage.confirmar);
			
			hacerClick(testPage.confirmarEntrevista);
			adjuntarCaptura("Success");
		
			
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - agendarCita() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - agendarCita() ##########"+ e,false);
		}
	}
	
	public void validarCita(String mensaje,String horario) {
		log.info("*** PruebaAccion - validarCita()***");
		try {
			esperaExplicita(testPage.mensajeConfirmacion);
			assertThat("Mensaje de confirmacion no coinciden",extraerTextoElemento(testPage.mensajeConfirmacion),containsString(mensaje));
			adjuntarCaptura("Success");
			Refrescar();
			assertThat("El Horario no coincide",extraerTextoElemento(testPage.tiempoAgendado),containsString(horario.toUpperCase()));
			adjuntarCaptura("Success");
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - validarCita() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - validarCita() ##########"+ e,false);
		}
		
	}
	
	/*Cancelamiento de citas*/
	
	public void selectButtonCancel() {
		log.info("**PruebaAccion - press button cancel**");
		try {
			hacerClick(testPage.buttonCancel);
			esperaExplicitaTexto("Cancel Meeting");
			adjuntarCaptura("buttonCancel");
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - selectButtonCancel() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - selectButtonCancel() ##########"+ e,false);
		}
	}
	
	public void selectRazonCancel(String razon) {
		log.info("**select option cancel**");
		try {
			esperaExplicita(testPage.selectRazonCancel);
			hacerClick(testPage.selectRazonCancel);
			selectValorLista(testPage.listOptionCancel, razon);
			adjuntarCaptura("SelectRazon");
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - selectRazonCancel() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - selectRazonCancel() ##########"+ e,false);
		}
	}
		
	public void selectAdvisorCancel(String option, String razon ) {
		log.info("**PruebaAccion - selectAdvisorCancel()**");
		try {
			log.info(extraerTextoElemento((testPage.selectRazonCancel)));
			if(!extraerTextoElemento((testPage.selectRazonCancel)).equals("I stopped looking for an advisor")) {
				esperaExplicita(testPage.selectAdvisorCancel);
				hacerClick(testPage.selectAdvisorCancel);
				selectValorLista(testPage.listOptionCancel, option);
				adjuntarCaptura("SelectOption");
				hacerClick(testPage.buttonConfirmCancel);
			}else {
				hacerClick(testPage.buttonConfirmCancel);
			}
			
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - selectRazonCancel() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - selectRazonCancel() ##########"+ e,false);
		}
	}	
	
	public void confirmCancelAppoiment(String message) {
		log.info("**PruebaAccion - confirm appointment cancellation()**");
		try {
			esperaExplicitaTexto(message);	
			adjuntarCaptura("CancelCita");
			assertThat("the cancellation message not match",extraerTextoElemento(testPage.messageCancel).toUpperCase(),containsString(message.toUpperCase()));
			Refrescar();
			adjuntarCaptura("HomePage");
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - confirmCancelAppoiment() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - confirmCancelAppoiment() ##########"+ e,false);
		}
	}
	
	public void selectDay(String day) {
		log.info("***PruebaAccion - Select day()***");
		try {
			hacerClick(By.xpath("//div[@class='CCDatesView__days_day']//child::div[@data-number='"+day+"']"));
			adjuntarCaptura("Selectday");
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - selectDay() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - selectDay() ##########"+ e,false);
		}
	}
	
	
	public void selectTimeZone(String zone) {
		log.info("***PruebaAccion - Select day()***");
		try {
			esperaExplicita(testPage.bottonZona);
			hacerClick(testPage.bottonZona);
			
			selectValorLista(testPage.listZona, zone);
			adjuntarCaptura("SelectZone");
		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - selectDay() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - selectDay() ##########"+ e,false);
		}
	}
	
	public void validateTimeZone(DataTable dataTable) {
		try {
			log.info("***PruebaAccion - validateTimeZone()***");
			List<String> listHours = returnStringListelement(testPage.listHorario);
			log.info(listHours.toString());
			
			
			List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            int contador = 0;
            for (Map<String, String> datos : data) {
            	if(!datos.get("Hours").equals(listHours.get(contador))) {
            		log.error("##Error##");
            		assertEquals("Error comparando la lista de Horarios",datos.get("Hours"),listHours.get(contador));
            		
            	}
				contador++;
            }

		} catch (Exception e) {
			log.error("####### ERROR PruebaAccion - selectDay() ##########"+ e);
			assertTrue("####### ERROR PruebaAccion - selectDay() ##########"+ e,false);
		}
	}
	
	

}
