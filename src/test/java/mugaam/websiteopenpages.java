package mugaam;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class websiteopenpages{


public void openwebsite(WebDriver driver , Filereaderpage reader) {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(reader.url());
	
WebElement	Loginbutton  = driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(1) > a"));
	
	if(Loginbutton.isDisplayed()) {
	Loginpage Login = new Loginpage();
	
	Login.Login(driver,reader);
	}
	else {
		
	}
}
	

}


