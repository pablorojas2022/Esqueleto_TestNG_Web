package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetTestNG_inicio;

public class PagsObjetTestNG_Inicio extends MapsObjetTestNG_inicio
{
	public String url1;

	public void setUrl(String url1)
	{
		this.url1 = url1;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetTestNG_Inicio(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso()
	{
		driver.get(url1);
	}

//METODO PRIMERA PRUEBA
	public String IngresoaMercuryTours(File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try 
		{
			clic(btnRegister, rutaCarpeta, generarEvidencia);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
	   return valor;
		}
	}
