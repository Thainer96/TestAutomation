package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPages {
	WebDriver driver;
	
	// elementos del landing page
			public By informationName;
			public By selectDia ;
			public By tiempoAgendado ;
			public By duracion ;
			public By mescalendario;
			
			public By bottonZona;
			public By listZona;
			
			public By listHorario;
			public By selectPhone;
			
			public By confirmar;
			public By confirmarEntrevista;
			
			public By mensajeConfirmacion;
			
			public By flechaCalendario;
			
			/*Cancelar*/
			public By buttonCancel;
			public By selectRazonCancel;			
			public By selectAdvisorCancel;
			public By listOptionCancel;
			
			public By buttonConfirmCancel;
			public By messageCancel;
			
		
		public TestPages(WebDriver driver) {
			this.driver = driver;		
			informationName = By.xpath("(*//h2[@class='jsx-1005577674 advisor-profile__info_name'])");
			selectDia = By.xpath("//div[@class='CCDatesView__days_day']//child::div[@data-number='");
			tiempoAgendado = By.xpath("(*//span[@class='jsx-2536202604 meeting__time'])[2]");
			duracion = By.xpath("(*//span[@class='jsx-2536202604 meeting__time'])[3]");
			
			
			/*Agendamiento de cita*/
			mescalendario = By.xpath("//div[@class='ZUIViewHeader__left ZUIViewHeader__left--disabled']//following-sibling::span");
			flechaCalendario = By.xpath("(*//div[@class='ZUIViewHeader__right'])[1]");
			bottonZona = By.xpath("*//button[@class ='ZUIDropdown__main-selector  ']");
			listZona = By.xpath("*//button[@class='ZUIDropdown__options_single-option']//child::div");
			listHorario = By.xpath("*//div[contains(@class,'CCTimesView__times_time')]");
			
			selectPhone = By.xpath("*//label[@class='styles__ZUICardLabel-sc-m472j1-0 boggvt']//child::div//child::p[text()='Phone Call']");
			confirmar = By.xpath("*//button[@class='styles__ButtonContainer-sc-umeyty-0 fJcHyo ZUIButton ZUIButton--primary ZUIButton--medium']");
			confirmarEntrevista = By.xpath("*//button[@class='styles__ButtonContainer-sc-umeyty-0 fJcHyo ZUIButton ZUIButton--primary ZUIButton--medium confirmation-schedule__cta_confirm']");
			
			mensajeConfirmacion = By.xpath("*//p[@class='jsx-2506347748 jsx-60401089 modal-dashboard__message']//child::span[2]");
			
			
			/*Cancelamiento*/
			buttonCancel = By.xpath("*//div[@class='jsx-2498531115 schedule-dashboard__cancel-wrapper']//child::button");
			selectRazonCancel = By.xpath("(*//button[contains(@class,'ZUIDropdown')])[2]");	
			selectAdvisorCancel = By.xpath("(*//button[contains(@class,'ZUIDropdown')])[3]");
			listOptionCancel = By.xpath("(*//button[contains(@class,'ZUIDropdown__options_single-option')])//child::div");
			buttonConfirmCancel = By.xpath("(*//button[contains(@class,'styles__ButtonContainer')])[5]");
			
			messageCancel = By.xpath("(*//h3[contains(@class,'modal-info__title')])");
		}	
}
