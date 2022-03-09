package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClasesBase;

public class MapsObjetInicio extends ClasesBase {
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetInicio(WebDriver driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA INICIAL
	protected By txtBusquedaGoogle = By.name("q");
	By btnBuscar = By.name("bntK");
	protected By resultado =By.xpath("//h3[contains(text(),'Periferia IT Group – Somos innovación en tecnología y')]");
	//protected By resultado1 =By.xpath("//div[@class='container header']//a[@class='nav-link active'][normalize-space()='Inicio']");
}
 