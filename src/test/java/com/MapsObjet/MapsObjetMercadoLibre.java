package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClasesBase;

public class MapsObjetMercadoLibre extends ClasesBase {
	// CONSTRUCTOR DE LA CLASE
	public MapsObjetMercadoLibre(WebDriver driver) {
		super(driver);
	}

	// ELEMENTOS PAGINA INICIAL
	protected By txtBusquedaMercadoLibre = By.xpath("//input[@id='cb1-edit']");
	protected By btnBuscarLupa = By.xpath("//div[@aria-label='Buscar']");
	protected By resultadoMercadoLibre = By.xpath("//h3[contains(text(),'Mercado Libre Colombia - Envíos Gratís en el día)]");
	protected By btnEntendido = By.xpath("//body/div/div/button[contains(text(),'Entendido')]");
	protected By btnContinuar = By.xpath("//*[@role='button']");
	protected By regis = By.xpath("//nav[@id='nav-header-menu']//a[contains(text(),'Crea tu cuenta')]");
	protected By btnContinuar1 = By.xpath("//span[@class='andes-button__content']");
	protected By btnValidar = By.xpath("//span[@class='andes-button__text']");
	protected By txtMail = By.xpath("//input[@name='email']");
	protected By btnEnviarMail = By.xpath("//span[@class='andes-button__content']");
	//protected By resultado = By.xpath("//body/main[@id='root-app']/div[@id='enter-code']/div[2]/div[1]/p[1]");
}
