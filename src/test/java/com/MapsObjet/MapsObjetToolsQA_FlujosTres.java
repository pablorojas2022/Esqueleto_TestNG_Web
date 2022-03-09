package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClasesBase;

public class MapsObjetToolsQA_FlujosTres extends ClasesBase {
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetToolsQA_FlujosTres(WebDriver driver) {
		super(driver);
		this.driver =driver;
	}
	
	/*protected By botonAlerts = By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[1]/div[1]/div[1]/div[3]/span[1]/div[1]/div[1]]");
	protected By botonAlerts1 = By.xpath("//*[@class='btn btn-light ']/span[contains(text(),'Alert')]");
	protected By btnRecoWidget = By.xpath("//div[1]//div[1]//div[4]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
	protected By btnFrame = By.xpath("//*[@class='left-pannel']/div/div[3]");
	protected By btnAlerts = By.xpath("//span[normalize-space()='Alerts']");
	protected By btnClic1 = By.xpath("//button[@id='alertButton']");
	protected By btnClic2 = By.xpath("//button[@id='timerAlertButton']");
	protected By btnClic3 = By.xpath("//button[@id='confirmButton']");
	protected By btnClic4 = By.xpath("//button[@id='promtButton']"); 
	protected By textAlerts = By.xpath("//span[contains(text(),'Alerts')]");*/
	
	
	
	protected By btnRecoWidget = By.xpath("//div[1]//div[1]//div[4]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']");
	protected By botonAlerts = By.xpath("//*[@class='header-wrapper']/div[contains(text(),'Alerts, Frame & Windows')]");
	protected By botonAlerts1 = By.xpath("//span[normalize-space()='Alerts']");
	protected By btnClic1 = By.xpath("//button[@id='alertButton']");
	protected By btnClic2 = By.xpath("//button[@id='timerAlertButton']");
	protected By btnClic3 = By.xpath("//button[@id='confirmButton']");
	protected By btnClic4 = By.xpath("//button[@id='promtButton']"); 
	//protected By resultado = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]");
	
}
