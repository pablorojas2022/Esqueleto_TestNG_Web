package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapsObjetMercadoLibre;

public class PagsObjetMercadoLibre extends MapsObjetMercadoLibre
{
	public String url3;

	public void setUrl(String url3) 
	{
		this.url3 = url3;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetMercadoLibre(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	// METODO INICIAL
	public void urlAcceso()
	{
		driver.get(url3);
	}

	public void continuar(File rutaCarpeta, String generarEvidencia) throws Exception  
	{
		Boolean cookie = confirmar(btnEntendido, 10);
		if (Boolean.TRUE.equals(cookie))
		{
			click(btnEntendido, 10, rutaCarpeta, generarEvidencia);
			desplazarseElemento(btnContinuar);
			click(btnContinuar, 10, rutaCarpeta, generarEvidencia);
		}
	}

	// METODO PRIMERA PRUEBA
	//public String busquedaMercadoLibre(String Producto, String email, File rutaCarpeta, String generarEvidencia)
	public void busquedaMercadoLibre(String Producto, String email, File rutaCarpeta, String generarEvidencia)
			throws Exception {
		try {
			// ENVIAMOS EL VALOR DE BUSQUEDA AL NAVEGADOR
			sendKey(Producto, txtBusquedaMercadoLibre, rutaCarpeta, generarEvidencia);
			submit(txtBusquedaMercadoLibre, rutaCarpeta, generarEvidencia);
			tiempoEspera(2000);
			clic(btnBuscarLupa, rutaCarpeta, generarEvidencia);
			tiempoEspera(2000);
			clic(regis, rutaCarpeta, generarEvidencia);
			tiempoEspera(2000);
			continuar(rutaCarpeta, generarEvidencia);
			tiempoEspera(3000);
			clic(btnValidar, rutaCarpeta, generarEvidencia);
			tiempoEspera(3000);
			sendKey(email, txtMail, rutaCarpeta, generarEvidencia);
			tiempoEspera(2000);
			clic(btnEnviarMail, rutaCarpeta, generarEvidencia);
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
