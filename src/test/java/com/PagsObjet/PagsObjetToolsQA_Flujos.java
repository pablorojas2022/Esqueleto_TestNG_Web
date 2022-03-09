package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetToolsQA_Flujos;

public class PagsObjetToolsQA_Flujos extends MapsObjetToolsQA_Flujos
{

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetToolsQA_Flujos(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	public void IngresoaToolsQAElement(File rutaCarpeta, String generarEvidencia) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		tiempoEspera(1000); 
		clic(botonElement, rutaCarpeta, generarEvidencia);
	}

	public void IngresoaWebtables(File rutaCarpeta, String generarEvidencia) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		tiempoEspera(1000);
		clic(botonWebtables, rutaCarpeta, generarEvidencia);
	}

	//public String AddaRegistro(String firstName, String lastName, String email, String age, String salary, String departament, File rutaCarpeta, String generarEvidencia) throws Exception 	
	public void AddaRegistro(String firstName, String lastName, String email, String age, String salary,
			String departament, File rutaCarpeta, String generarEvidencia) throws Exception 
	{
		try 
		{
			clic(botonAdd, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			// Registration Form
			sendKey(firstName, txtfirstName, rutaCarpeta, generarEvidencia);
			sendKey(lastName, txtlastName, rutaCarpeta, generarEvidencia);
			sendKey(email, txtemail, rutaCarpeta, generarEvidencia);
			sendKey(age, txtage, rutaCarpeta, generarEvidencia);
			sendKey(salary, txtsalary, rutaCarpeta, generarEvidencia);
			sendKey(departament, txtdepartament, rutaCarpeta, generarEvidencia);
			clic(botonsubmit, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		//String valor = capturarValorSelenium(resultado);
		//return valor;
	}

	//public String EliminarenRegistro(String eliminar, String space, File rutaCarpeta, String generarEvidencia
	public void EliminarenRegistro(String eliminar, String space, File rutaCarpeta, String generarEvidencia)
			throws Exception
	{
		try {
			clic(celdasearch, rutaCarpeta, generarEvidencia);
			sendKey(eliminar, celdasearch, rutaCarpeta, generarEvidencia);
			clic(celdasearch, rutaCarpeta, generarEvidencia);
			clic(botonlupa, rutaCarpeta, generarEvidencia);
			clic(botonborrar, rutaCarpeta, generarEvidencia);
			clic(celdasearch, rutaCarpeta, generarEvidencia);
			borrar(celdasearch, rutaCarpeta, generarEvidencia);
			sendKey(space, celdasearch, rutaCarpeta, generarEvidencia); 
			clic(botonCElements, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
        //String valor = capturarValorSelenium(resultado);
		//return valor;
	}

}
