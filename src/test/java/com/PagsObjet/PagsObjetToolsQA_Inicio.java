package com.PagsObjet;

import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetToolsQA_Inicio;

public class PagsObjetToolsQA_Inicio extends MapsObjetToolsQA_Inicio 
{
	public String url4;

	public void setUrl(String url4)
	{
		this.url4 = url4;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetToolsQA_Inicio(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso()
	{
		driver.get(url4);
	}
}
