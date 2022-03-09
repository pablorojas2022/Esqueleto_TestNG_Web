package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetToolsQA_FlujosTres;

public class PagsObjetToolsQA_FlujosTres extends MapsObjetToolsQA_FlujosTres {
	public PagsObjetToolsQA_FlujosTres(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// METODO SELECION BOTONES DE ALERTAS
	//public String IngresoaAlert(String name, File rutaCarpeta, String generarEvidencia) throws Exception
	public void IngresoaAlert(String name, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
			// BOTON ALERT MENU
			scrollelement(botonAlerts);
			clic(botonAlerts, rutaCarpeta, generarEvidencia);
			// BOTON ALERT OPTION
			scrollelement(botonAlerts1);
			clic(botonAlerts1, rutaCarpeta, generarEvidencia);
			// CLICK ACCEPT
			click(btnClic1, 10, rutaCarpeta, generarEvidencia);
			alert();
			captureScreen(rutaCarpeta, btnClic1, generarEvidencia);
			tiempoEspera(1000);
			// CLICK AFTER 5 SECONDS
			click(btnClic2, 10, rutaCarpeta, generarEvidencia);
			alert();
			captureScreen(rutaCarpeta, btnClic2, generarEvidencia);
			tiempoEspera(1000);
			// CLICK CONFIRM - ACCEPT
			click(btnClic3, 10, rutaCarpeta, generarEvidencia);
			alertCancel();
			captureScreen(rutaCarpeta, btnClic3, generarEvidencia);
			tiempoEspera(1000);
			// CLICK CONFIRM - CANCEL
			click(btnClic3, 10, rutaCarpeta, generarEvidencia);
			alert();
			captureScreen(rutaCarpeta, btnClic3, generarEvidencia);
			tiempoEspera(1000);
			// CLICK PROMPT
			click(btnClic4, 10, rutaCarpeta, generarEvidencia);
			// driver.switchTo().alert().sendKeys("pablo");
			alertaTexto(name, rutaCarpeta, generarEvidencia);
			alert();
			captureScreen(rutaCarpeta, btnClic4, generarEvidencia);
			tiempoEspera(1000);
			// TOTAL
			scrollelement(btnClic1);
			tiempoEspera(3000);
			captureScreen(rutaCarpeta, btnClic1, generarEvidencia);
			tiempoEspera(3000);
		} 
		catch (Exception e) 
		{
			System.out.println(e);  
		}
		//String valor = capturarValorSelenium(resultado);
		//return valor;
	}
}
