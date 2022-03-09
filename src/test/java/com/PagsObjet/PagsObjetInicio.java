package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetInicio;

public class PagsObjetInicio extends MapsObjetInicio
{
	public String url2;

	public void setUrl(String url2) {
		this.url2 = url2;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetInicio(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso()
	{
		driver.get(url2);
	}

	// METODO PRIMERA PRUEBA
	//public String busquedaInicial(String busqueda, File rutaCarpeta, String generarEvidencia) throws Exception
	public void busquedaInicial(String busqueda, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try {
			// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR
			sendKey(busqueda, txtBusquedaGoogle, rutaCarpeta, generarEvidencia);
			submit(txtBusquedaGoogle, rutaCarpeta, generarEvidencia);
			tiempoEspera(2000);
			clic(resultado, rutaCarpeta, generarEvidencia);
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
