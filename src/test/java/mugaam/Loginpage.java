package mugaam;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends mugaammainpage {
	
	
	public void Login(WebDriver driver , Filereaderpage reader) {
		
            driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(1) > a")).click();
		
	 WebElement Email =	driver.findElement(By.name("email"));
	 
	 Email.sendKeys(reader.existmail());
	 
	 WebElement continuebutton =	driver.findElement(By.cssSelector("#submitform > div.d-grid.gap-2 > button"));
		
	 if(continuebutton.isDisplayed()) {
		continuebutton.click();
		
	 }else {
		 
		 System.out.println("The Continue button is not visible");
	 }
	 
	 
	 
	// WebElement Newname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
	 

	 
	 
	 try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    
		    //note this method if the element is not present use this to check
		    
		    WebElement Newname = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#name")));
		    WebElement Password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
			// WebElement Password = driver.findElement(By.cssSelector("#password"));

		    System.out.println("Element is present in the DOM.");
		    
		    if(Newname.isDisplayed() ) {
				 
				 System.out.println(reader.myname());
				 
				 Newuser(reader , Newname,Password);
				 
				 continuebutton.click();
			 }
			 else {
				 
				 System.out.println(reader.name());
				 
				 existuser(reader,Password);
				 
				 continuebutton.click();
			 }
		} catch (Exception e) {
		    System.out.println("Element is not present in the DOM.");
		    e.printStackTrace();
		}

	 
	 
	 Firstnormalflow first =new Firstnormalflow();
	 
	first.homepage(driver , reader);
	 

		 
	
		
	}

	
	public void Newuser(Filereaderpage reader, WebElement Newname ,WebElement Password) {
		
		
		Newname.sendKeys(reader.myname());
		
		System.out.println(reader.myname());
		
		Password.sendKeys(reader.password());
		
		
	}
	
	
	public void existuser(Filereaderpage reader ,WebElement Password) {
		
		Password.sendKeys(reader.password());
	}
	
}
