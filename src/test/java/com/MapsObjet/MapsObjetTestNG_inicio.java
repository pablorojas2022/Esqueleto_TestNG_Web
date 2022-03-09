package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testNG.ClasesBase;

public class MapsObjetTestNG_inicio extends ClasesBase{
	// CONSTRUCTOR DE LA CLASE
		public MapsObjetTestNG_inicio(WebDriver driver) {
			super(driver);
		}
		//ELEMENTOS PAGINA INICIAL
		protected By btnRegister = By.xpath("//a[normalize-space()='REGISTER']");	
		protected By resultado =By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td");
		
}
