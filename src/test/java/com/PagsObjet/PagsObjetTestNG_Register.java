package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetTestNG_Register;

public class PagsObjetTestNG_Register extends MapsObjetTestNG_Register
{

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetTestNG_Register(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}

//METODO PRIMERA PRUEBA
	public String  RegistroMercuryTours(String firstName, String lastName, String numphone, String email, String address,
			String city, String state, String postalcode, String country, String username, String password,
			String cpassword, File rutaCarpeta, String generarEvidencia) throws Exception 
	{
		try 
		{
			tiempoEspera(1000);
			sendKey(firstName, txtfirstName, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(lastName, txtlastName, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(numphone, txtnumphone, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(email, txtemail, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(address, txtaddress, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(city, txtcity, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(state, txtstate, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(postalcode, txtpostalcode, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(country, txtcountry, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(username, txtusername, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(password, txtpassword, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			sendKey(cpassword, txtcpassword, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
			clic(btnenviar, rutaCarpeta, generarEvidencia);
			tiempoEspera(1000);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		String valor = capturarValorSelenium(resultado);
        return valor;
	}
	
}
