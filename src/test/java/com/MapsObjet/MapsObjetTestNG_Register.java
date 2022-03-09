package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClasesBase;

public class MapsObjetTestNG_Register extends ClasesBase {
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetTestNG_Register(WebDriver driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA DE REGISTRO
	// Contact Information
	protected By txtfirstName = By.xpath("//input[@name='firstName']");
	protected By txtlastName = By.xpath("//input[@name='lastName']");
	protected By txtnumphone = By.xpath("//input[@name='phone']");
	protected By txtemail = By.xpath("//input[@id='userName']");
	// Mailing Information
	protected By txtaddress = By.xpath("//input[@name='address1']");
	protected By txtcity = By.xpath("//input[@name='city']");
	protected By txtstate = By.xpath("//input[@name='state']");
	protected By txtpostalcode = By.xpath("//input[@name='postalCode']888");
	protected By txtcountry = By.xpath("//select[@name='country']");
	// User Information
	protected By txtusername = By.xpath("//input[@name='email']");
	protected By txtpassword = By.xpath("//input[@name='password']");
	protected By txtcpassword = By.xpath("//input[@name='confirmPassword']");
	protected By btnenviar = By.xpath("//input[@name='submit']");
	
	protected By resultado =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td");
}
