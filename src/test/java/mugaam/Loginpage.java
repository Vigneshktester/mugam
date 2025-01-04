package mugaam;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends mugaammainpage {

	public void Login(WebDriver driver, Filereaderpage reader) {

		driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(1) > a")).click();

		WebElement continuebutton = null;
		
		continuebutton = driver.findElement(By.cssSelector("#submitform > div.d-grid.gap-2 > button"));

		Emailinput(driver,reader);

		// WebElement Newname =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
		WebElement Password = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// note this method if the element is not present use this to check

			WebElement Newname = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#name")));
			 Password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
			
			 // WebElement Password = driver.findElement(By.cssSelector("#password"));

			System.out.println("Element is present in the DOM.");

			if (Newname.isDisplayed()) {

				System.out.println(reader.myname());

				Newuser(reader, Newname, Password);

				continuebutton.click();
			} else {

				System.out.println(reader.name());

				existuser(reader, Password,driver);

				continuebutton.click();
			}
		} catch (Exception e) {
			System.out.println("Element is not present in the DOM.");
			e.printStackTrace();
		}

//	 
//	 Firstnormalflow first =new Firstnormalflow(); 
//	first.homepage(driver , reader);
		
		
		
		Logout(driver);
		

		For_Recruiter Recruiter = new For_Recruiter();

		Recruiter.Recruiterlogin(driver,reader,Password);

	}

	public void Newuser(Filereaderpage reader, WebElement Newname, WebElement Password) {

		Newname.sendKeys(reader.myname());

		System.out.println(reader.myname());

		Password.sendKeys(reader.password());

	}

	public void existuser(Filereaderpage reader, WebElement Password,WebDriver driver) {
		
		
		//if(driver.getCurrentUrl().contentEquals("https://employer.mugaam.com/login") ) {
			WebElement Passwords = driver.findElement(By.cssSelector("#password"));
			Passwords.sendKeys(reader.password());
			
			driver.findElement(By.id("showpico")).click();
		
		 driver.findElement(By.cssSelector("#submitform > div.d-grid.gap-2 > button")).click();;

//		}
//		else {
//		System.out.println(Password.isDisplayed() + "Passwordisvisible");
//
//		Password.sendKeys(reader.password());
//		}
	}

	public void Logout(WebDriver driver) {

		WebElement Droupdown = driver.findElement(By.id("dropdownMenuLink"));

		Droupdown.click();

		WebElement Logout = driver.findElement(By.linkText("Logout"));

		Logout.click();

	}
public void Emailinput(WebDriver driver, Filereaderpage reader) {
	
	
	System.out.println(reader.existmail());

	
	WebElement Email = driver.findElement(By.name("email"));

	Email.sendKeys(reader.existmail());
	
	WebElement submit =driver.findElement(By.cssSelector("#submitform > div.d-grid.gap-2 > button"));
System.out.println(submit.isDisplayed());

	if (submit.isDisplayed()) {
		submit.click();

	} else {

		System.out.println("The Continue button is not visible");
	}
}
}



