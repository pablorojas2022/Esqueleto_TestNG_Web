package com.testNG;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilidades.GenerarReportePdf;

public class ClasesBase {
	protected WebDriver driver;
	String rutaOutut;

	public void setRutaOutut(String rutaOutut) {
		this.rutaOutut = rutaOutut;
	}

	// CONSTRUCTOR DE CLASE
	public ClasesBase(WebDriver driver) {
		super();
	}

	// METODO NAVEGADOR
	public static WebDriver chromeDriverConnection() 
	{
		WebDriver _driver = null;
		try 
		{
			// SETEAR LAS OPCIONES DEL NAVEGADOR
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			// SETEAR LAS PROPIEDADES DEL NAVEGADOR
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			_driver = new ChromeDriver();

			// MAXIMIZAR NAVEGADOR
			_driver.manage().window().maximize();
			return _driver;
		}
		catch (Exception e)
		{
			System.out.println(e);
		} 
		return _driver;
	}

	// METODO CLICK
	public void clic(By locator, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
			driver.findElement(locator).click();
			tiempoEspera(2000);
			captureScreen(rutaCarpeta,locator,generarEvidencia);
		} 
		
		catch (Exception e)
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
		
	}

	// CLICK
	public void click(By locator, int t, File rutaCarpeta, String generarEvidencia) throws Exception 
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, t);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();
			tiempoEspera(2000);
		} 
		catch (Exception e) 
		{
			captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
			throw new InterruptedException();
		}
	}

	// METODO BORRAR
	public void borrar(By locator, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
			driver.findElement(locator).clear();
			tiempoEspera(2000);
			captureScreen(rutaCarpeta, locator, generarEvidencia);
		} 
		catch (Exception e)
		{
			captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
			throw new InterruptedException();
		}
	}

	// METODO ENVIAR TEXTO
	public void sendKey(String inputText, By locator, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(2000);
			captureScreen(rutaCarpeta, locator, generarEvidencia);
		} 
		catch (Exception e)
		{
			captureScreenError(rutaCarpeta,locator,generarEvidencia,e.toString());
			throw new InterruptedException();
		}
	}

	// METODO ENTER SUBMIT
	public void submit(By locator,File rutaCarpeta,String generarEvidencia) throws Exception
	{
			driver.findElement(locator).submit();
			captureScreen(rutaCarpeta, locator,generarEvidencia);
	}

	public String capturarValorSelenium(By locator) throws Exception
	{
		String valor = driver.findElement(locator).getText();
		return valor;
	}

	// METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException 
	{
		Thread.sleep(tiempo);
	}

	public File crearCarpeta(String nomTest)
	{
		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		// CREAREMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest+"-"+fecha;
		// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File(rutaOutut+nomCarpeta);
		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}

	public void captureScreen(File rutaCarpeta, By locator, String generarEvidencia) throws Exception
	{
		if (generarEvidencia.equals("SI"))
		{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen =new File(rutaCarpeta+"\\"+hora+".png").toString();

			// INSTANCIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			// SE PROCEDE A INSERTAR LOCALIZADOR E IMAGEN EN EL PDF
			informePdf.crearbody(locator, rutaImagen);
			// ELIMINAR IMAGEN CREADA
			
			eliminarArchivo(rutaImagen);
		}
	}

	public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError) throws Exception
	{
		if (generarEvidencia.equals("SI"))
		{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen =new File(rutaCarpeta+"\\"+hora+".png").toString();

			// INSTACIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			// SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
			informePdf.crearbodyError(locator,rutaImagen,msnError);
			// ELIMINAR IMAGEN CREADA

			eliminarArchivo(rutaImagen);
		}
	}

	public void eliminarArchivo(String rutaImagen)
	{
		File fichero = new File(rutaImagen);
		fichero.delete();
	}

	public static String fechaHora() 
	{
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public static String fechaHora2()
	{
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String HoraSistema()
	{
		// TOMAMOS LA HORA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		// DEFINIR FORMATO HORA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		// DAR FORMATO A LA HORA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	// METODO INICIAL
	public void urlAcceso(String url) throws InterruptedException

	{
		driver.get(url);
		tiempoEspera(2000);
		// busquedaInicial();
	}

	public void scrollPage(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}
	
	// METODO CONTROL + A
	public void comando(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
		captureScreen(rutaCarpeta, locator, generarEvidencia);
	}

	// METODO CONTROL + A
	public void bspace(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
		captureScreen(rutaCarpeta, locator, generarEvidencia);
	}

	// METODO ENTER
	public void intro(By locator, File rutaCarpeta, String generarEvidencia) throws Exception {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		captureScreen(rutaCarpeta, locator, generarEvidencia);
	}

	public void alert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alertCancel() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			tiempoEspera(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alertaTexto(String texto, File rutaCarpeta, String generarEvidencia) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(texto);
			tiempoEspera(2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// METODO SCROLL
	public void scrollelement(By locator) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public boolean confirmar(By locator, int t) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, t);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void desplazarseElemento(By locator) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void capture(File rutaCarpeta, String generarEvidencia) throws Exception {
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
	}

	// METODO ALERTA EMERGENTE
	public void alert(By locator, File rutaCarpeta, String generarEvidencia) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(3000);
			captureScreen(rutaCarpeta, locator, generarEvidencia);
			tiempoEspera(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
