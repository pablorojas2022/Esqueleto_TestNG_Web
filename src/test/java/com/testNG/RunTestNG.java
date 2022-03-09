package com.testNG;

import org.testng.annotations.Test;
import com.PagsObjet.PagsObjetTestNG_Inicio;
import com.PagsObjet.PagsObjetTestNG_Register;
import com.PagsObjet.PagsObjetInicio;
import com.PagsObjet.PagsObjetMercadoLibre;
import com.Utilidades.ExcelUtilidades;
import com.Utilidades.GenerarReportePdf;
import com.Utilidades.MyScreenRecorder;
import com.PagsObjet.PagsObjetToolsQA_Flujos;
import com.PagsObjet.PagsObjetToolsQA_FlujosDos;
import com.PagsObjet.PagsObjetToolsQA_FlujosTres;
import com.PagsObjet.PagsObjetToolsQA_Inicio;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RunTestNG {
	private WebDriver driver;
	PagsObjetInicio paginas;
	PagsObjetMercadoLibre mercLibre;
	PagsObjetTestNG_Inicio pagHome;
	PagsObjetTestNG_Register pagRegister;
	PagsObjetToolsQA_Inicio pagHome1;
	PagsObjetToolsQA_Flujos pagFlujos;
	PagsObjetToolsQA_FlujosDos pagFlujosDos;
	PagsObjetToolsQA_FlujosTres pagFlujosTres;
	ClasesBase claseBase;
	File rutaCarpeta = null;
	GenerarReportePdf generarReportePdf;
	String valor;

	@BeforeClass
	@Parameters({ "url1", "url2", "url3", "url4", "rutaImagenReporte", "rutaOutut" })
	public void beforeClass(@Optional("default") String url1, @Optional("default") String url2,
			@Optional("default") String url3, @Optional("default") String url4,
			@Optional("default") String rutaImagenReporte, @Optional("default") String rutaOutut) throws Exception {
		// ASIGNAR PROPIEDADES A DRIVER
		driver = ClasesBase.chromeDriverConnection();
		// INSTANCIAR LA CLASE
		claseBase = new ClasesBase(driver);
		pagHome = new PagsObjetTestNG_Inicio(driver);
		pagRegister = new PagsObjetTestNG_Register(driver);
		paginas = new PagsObjetInicio(driver);
		mercLibre = new PagsObjetMercadoLibre(driver);
		pagHome1 = new PagsObjetToolsQA_Inicio(driver);
		pagFlujos = new PagsObjetToolsQA_Flujos(driver);
		pagFlujosDos = new PagsObjetToolsQA_FlujosDos(driver);
		pagFlujosTres = new PagsObjetToolsQA_FlujosTres(driver);
		generarReportePdf = new GenerarReportePdf(); 	
		// SETTIAR LAS CLASES
		pagHome.setUrl(url1);
		paginas.setUrl(url2);
		mercLibre.setUrl(url3);
		pagHome1.setUrl(url4);
		generarReportePdf.setRutaImagen(rutaImagenReporte);
		claseBase.setRutaOutut(rutaOutut);
	}

	@DataProvider(name = "busqueda")
	public Object[][] datos() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/dataTest.xlsx", "MercuryTours"); 
		return arreglo;
	}

	// TEST MERCURY TOURS
	// @Test(enable=false)
	// @Test(description="acceso a Periferia")
	// @Test(priority=1....n)

	@Test(dataProvider = "busqueda", description = "acceso a Mercury Tours")
	public void pruebaMercuryToursTestNG(String Ejecutar, String generarEvidencia, String firstName, String lastName,
			String numphone, String email, String address, String city, String state, String postalcode, String country,
			String username, String password, String cpassword) throws Exception
	{
		if (Ejecutar.equals("SI"))
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// ACCEDER A LA URL
			pagHome.urlAcceso();

			// VALIDAR SI SE GENERA EVIDENCIA
			if (generarEvidencia.contains("SI"))
			{
				// CREAR CARPETA PARA EL ALMACENAMIENTO DE EVIDENCIA
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.startRecording(nomTest,rutaCarpeta);

				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest,rutaCarpeta);

				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				valor=pagHome.IngresoaMercuryTours(rutaCarpeta,generarEvidencia);
				valor=pagRegister.RegistroMercuryTours(firstName, lastName, numphone, email, address, city, state,
						postalcode, country, username, password, cpassword, rutaCarpeta, generarEvidencia);

				// FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();

				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();

			}
			else 
			{
				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				valor=pagHome.IngresoaMercuryTours(rutaCarpeta, generarEvidencia);
				valor=pagRegister.RegistroMercuryTours(firstName, lastName, numphone, email, address, city, state,
						postalcode, country, username, password, cpassword, rutaCarpeta, generarEvidencia);
			}
			assert valor.contains(firstName);
		}
	}

	@DataProvider(name = "busqueda1")
	public Object[][] datos2() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/dataTest.xlsx", "Periferia");
		return arreglo;
	}

	// TEST PERIFERIA
	// @Test(enable=false)
	// @Test(description="acceso a Periferia")
	// @Test(priority=1....n)
	@Test(dataProvider = "busqueda1", description = "acceso a Perifeira")
	public void pruebaPeriferiaTestNG(String Ejecutar, String generarEvidencia, String busqueda) throws Exception
	{
		if (Ejecutar.equals("SI")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// ACCEDER A LA URL
			paginas.urlAcceso();

			// VALIDAR SI SE GENERA EVIDENCIA
			if (generarEvidencia.contains("SI"))
			{
				// CREAR CARPETA PARA EL ALMACENAMIENTO DE EVIDENCIAS
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.startRecording(nomTest,rutaCarpeta);
 
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest,rutaCarpeta);

				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				//valor=paginas.busquedaInicial(busqueda,rutaCarpeta,generarEvidencia);
				paginas.busquedaInicial(busqueda,rutaCarpeta,generarEvidencia);
				
				// FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();

				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();
			} 
			else
            {
				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				//valor=paginas.busquedaInicial(busqueda,rutaCarpeta,generarEvidencia);
				paginas.busquedaInicial(busqueda,rutaCarpeta,generarEvidencia);
			}
			//assert valor.contains(busqueda);
		}
	}

	@DataProvider(name = "busqueda2")
	public Object[][] datos3() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/dataTest.xlsx", "MercadoLibre");
		return arreglo;
	}

	// TEST MERCADO LIBRE
	// @Test(enable=false)
	// @Test(description="acceso a Periferia")
	// @Test(priority=1....n)
	@Test(dataProvider = "busqueda2", description = "acceso a Mercado Libre")
	public void pruebaMercadoLibreTestNG(String Ejecutar, String generarEvidencia, String Producto, String email)
			throws Exception
	{
		if (Ejecutar.equals("SI")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// ACCEDER A LA URL
			mercLibre.urlAcceso();

			// VALIDAR SI SE GENERA EVIDENCIA
			if (generarEvidencia.contains("SI"))
			{
				// CREAR CARPETA PARA EL ALMACENAMIENTO DE EVIDENCIAS
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);

				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				//valor=mercLibre.busquedaMercadoLibre(Producto,email,rutaCarpeta,generarEvidencia);
				mercLibre.busquedaMercadoLibre(Producto,email,rutaCarpeta,generarEvidencia);
				
				// FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();

				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();

			}
			else
			{
				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				//valor=mercLibre.busquedaMercadoLibre(Producto,email,rutaCarpeta,generarEvidencia);
				mercLibre.busquedaMercadoLibre(Producto,email,rutaCarpeta,generarEvidencia);
			}
			//assert valor.contains(Producto);
		}
	}

	@DataProvider(name = "busqueda3")
	public Object[][] datos4() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/dataTest.xlsx", "DemoQA");
		return arreglo;
	}

	// TEST DEMOQA
	// @Test(enable=false)
	// @Test(description="acceso a Periferia")
	// @Test(priority=1....n)
	@Test(dataProvider = "busqueda3", description = "acceso a DemoQA")
	public void pruebaDemoQATestNG(String Ejecutar, String generarEvidencia, String firstName, String lastName,
			String email, String age, String salary, String departament, String eliminar, String space, String date1,
			String date2, String date3, String name) throws Exception
	{
		if (Ejecutar.equals("SI"))
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// ACCEDER A LA URL
			pagHome1.urlAcceso();

			// VALIDAR SI SE GENERA EVIDENCIA
			if (generarEvidencia.contains("SI"))
			{
				// CREAR CARPETA PARA EL ALMACENAMIENTO DE EVIDENCIAS
				rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.startRecording(nomTest,rutaCarpeta);

				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest,rutaCarpeta);

				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				/*valor=pagFlujos.IngresoaToolsQAElement(rutaCarpeta, generarEvidencia);
				valor=pagFlujos.IngresoaWebtables(rutaCarpeta, generarEvidencia);
				valor=pagFlujos.AddaRegistro(firstName, lastName, email, age, salary, departament, rutaCarpeta, generarEvidencia);
				valor=pagFlujos.EliminarenRegistro(eliminar, space, rutaCarpeta, generarEvidencia);
				valor=pagFlujosDos.IngresoaWidgets(date1, date2, date3, rutaCarpeta, generarEvidencia);
                valor=pagFlujosTres.IngresoaAlert(name, rutaCarpeta, generarEvidencia);*/
				pagFlujos.IngresoaToolsQAElement(rutaCarpeta, generarEvidencia);
				pagFlujos.IngresoaWebtables(rutaCarpeta, generarEvidencia);
				pagFlujos.AddaRegistro(firstName, lastName, email, age, salary, departament, rutaCarpeta, generarEvidencia);
				pagFlujos.EliminarenRegistro(eliminar, space, rutaCarpeta, generarEvidencia);
				pagFlujosDos.IngresoaWidgets(date1, date2, date3, rutaCarpeta, generarEvidencia);
				pagFlujosTres.IngresoaAlert(name, rutaCarpeta, generarEvidencia);

				// FINALIZA GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();

				// FINALIZA CREACION DE REPORTE PDF
				generarReportePdf.cerrarPlantilla();

			} 
			else
			{
				// ACCEDER AL METODO DE PRUEBA INICIAL (EJECUCION DE CASO DE PRUEBA)
				/*valor=pagFlujos.IngresoaToolsQAElement(rutaCarpeta, generarEvidencia);
				valor=pagFlujos.IngresoaWebtables(rutaCarpeta, generarEvidencia);
				valor=pagFlujos.AddaRegistro(firstName, lastName, email, age, salary, departament, rutaCarpeta, generarEvidencia);
				valor=pagFlujos.EliminarenRegistro(eliminar, space, rutaCarpeta, generarEvidencia);
				valor=pagFlujosDos.IngresoaWidgets(date1, date2, date3, rutaCarpeta, generarEvidencia);
                valor=pagFlujosTres.IngresoaAlert(name, rutaCarpeta, generarEvidencia);*/
				pagFlujos.IngresoaToolsQAElement(rutaCarpeta, generarEvidencia);
				pagFlujos.IngresoaWebtables(rutaCarpeta, generarEvidencia);
				pagFlujos.AddaRegistro(firstName, lastName, email, age, salary, departament, rutaCarpeta, generarEvidencia);
				pagFlujos.EliminarenRegistro(eliminar, space, rutaCarpeta, generarEvidencia);
				pagFlujosDos.IngresoaWidgets(date1, date2, date3, rutaCarpeta, generarEvidencia);
				pagFlujosTres.IngresoaAlert(name, rutaCarpeta, generarEvidencia);

			}
			
			//assert valor.contains(firstName);
			//assert valor.contains(eliminar);
			//assert valor.contains(date1); 
			//assert valor.contains(name);
			 
		}
	}

	@AfterClass
	public void afterClass()
	{
		driver.close();
	}

}
