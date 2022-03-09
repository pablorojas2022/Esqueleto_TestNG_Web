package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetToolsQA_FlujosDos;

public class PagsObjetToolsQA_FlujosDos extends MapsObjetToolsQA_FlujosDos 
{
	public PagsObjetToolsQA_FlujosDos(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	@SuppressWarnings("unused")
	//public String IngresoaWidgets(String date1, String date2, String date3, File rutaCarpeta, String generarEvidencia) throws Exception 
	public void IngresoaWidgets(String date1, String date2, String date3, File rutaCarpeta, String generarEvidencia)
			throws Exception 
	{
		try 
		{
			// SELECCION FECHA
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			tiempoEspera(1000);
			clic(btnWidgets, rutaCarpeta, generarEvidencia);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			clic(btnDatePïcker, rutaCarpeta, generarEvidencia);
			comando(txtSelectDate, rutaCarpeta, generarEvidencia);
			bspace(txtSelectDate, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(date1, txtSelectDate, rutaCarpeta, generarEvidencia);
			intro(txtSelectDate, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			// SELECCION DE FECHA Y HORA
			comando(txtDateTime, rutaCarpeta, generarEvidencia);
			bspace(txtDateTime, rutaCarpeta, generarEvidencia);
			sendKey(date2 + " " + date3, txtDateTime, rutaCarpeta, generarEvidencia); 
			intro(txtDateTime, rutaCarpeta, generarEvidencia);
			tiempoEspera(2000);
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		//String valor = capturarValorSelenium(resultado);
		//return valor;
	}
}