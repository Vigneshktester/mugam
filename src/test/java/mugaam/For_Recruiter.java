package mugaam;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class For_Recruiter extends mugaammainpage {
	

	public void Recruiterlogin(WebDriver driver, Filereaderpage reader, WebElement Password) {

		driver.findElement(By.linkText("For Recruiter")).click();

		String originalWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		try {
			WebDriverWait tabWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			System.out.println(driver.getCurrentUrl());

//	        WebElement element = tabWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-container > main > div.resulty-width1.mt-4.mb-4 > div > span > a")));
//	        element.click();

			System.out.println("Successfully interacted with the new tab.");
		} catch (NoSuchElementException e) {
			System.err.println("Element not found in the new tab.");
		}

		WebElement Login = driver.findElement(By.linkText("Login"));

		if (Login.isDisplayed()) {

			Login.click();
		} else {
			System.out.println("Login is not found");
		}

		try {
			WebDriverWait tabWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			System.out.println(driver.getCurrentUrl() + "New va ");
//		        WebElement element = tabWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-container > main > div.resulty-width1.mt-4.mb-4 > div > span > a")));
//		        element.click();

			System.out.println("Successfully interacted with the new tab.");
		} catch (NoSuchElementException e) {
			System.err.println("Element not found in the new tab.");
		}

		Loginpage existuser = new Loginpage();

		existuser.Emailinput(driver, reader);

		existuser.existuser(reader, Password, driver);
		
			
		try {
			RecruiterAnalystics(driver);
			
			RecruiterMessages(driver);
			RecruiterMyAccount(driver);
			RecruiterIndustry(driver);
			RecruiterJobLists(driver);
		}
	catch(NoSuchElementException e) {
		System.err.println("Element not found in.");

	}
	}

	
	
	public void RecruiterAnalystics(WebDriver driver) {
		 Firstnormalflow first = new Firstnormalflow();

WebElement Analystics = driver.findElement(By.cssSelector("#page-container > div.wrapper > nav > div.menu_container > div > ul:nth-child(1) > li:nth-child(2)"));

		Analystics.click();
		
		first.scroll(driver);
		
		try {
			WebDriverWait Waits = new WebDriverWait(driver, Duration.ofSeconds(20));

		//	WebElement Active =	Waits.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analytics > div.row > div.col-xl-4.col-lg-4.col-4.job-filter > div > div.d-flex.justify-content-around.jsmenufid > div > button:nth-child(1)")));
//			WebElement inactive =	Waits.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analytics > div.row > div.col-xl-4.col-lg-4.col-4.job-filter > div > div.d-flex.justify-content-around.jsmenufid > div > button:nth-child(2)")));
//				WebElement experied =	Waits.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analytics > div.row > div.col-xl-4.col-lg-4.col-4.job-filter > div > div.d-flex.justify-content-around.jsmenufid > div > button:nth-child(3)")));
//			
//				if(Active.isEnabled()) {
//					
//				}else if(inactive.isEnabled()) {
//					
//				}else {
//					
//				}
				//first.scrollup(driver);
				//Active.click();
				
//				
//				inactive.click();
//				
//				experied.click();
				
		}	catch(NoSuchElementException e) {
 
			System.err.println("Element not found in.");

		}
		
	
		
		
	}
	public void RecruiterMessages(WebDriver driver) {
		
		WebElement Messages = driver.findElement(By.cssSelector("#page-container > div > nav > div.menu_container > div > ul:nth-child(1) > li:nth-child(3)"));
		
		Messages.click();
		
		WebElement dropdown = driver.findElement(By.id("MessageStatus"));
		
		dropdown.click();
		
		WebElement archive = driver.findElement(By.id("archive"));
		
		archive.click();
	}
	public void RecruiterMyAccount(WebDriver driver) {
		
		WebElement MyAccount = driver.findElement(By.cssSelector("#page-container > div > nav > div.menu_container > div > ul:nth-child(1) > li:nth-child(4)"));
		
		MyAccount.click();
		
	}
	public void RecruiterIndustry(WebDriver driver) {
		
		WebElement Industry = driver.findElement(By.cssSelector("#page-container > div > nav > div.menu_container > div > ul:nth-child(1) > li:nth-child(5)"));
		
		Industry.click();
		
	}
	public void RecruiterJobLists(WebDriver driver) {
		
		WebElement JobLists = driver.findElement(By.cssSelector("#page-container > div > nav > div.menu_container > div > ul:nth-child(1) > li:nth-child(6)"));
		
		JobLists.click();
		
	WebElement add=	driver.findElement(By.cssSelector("#page-container > div > div.main-panel.main-panel-custom.main-panel-customize > div > div.page-inner > div > div > div > div.card-body.mt-2 > div > div.col-lg-8.col-md-9 > div:nth-child(2) > div.row.align-items-center.current_phone_number > div.col-xl-6.col-lg-6.col-md-6.col-sm-4.col-xs-6.col-4 > div > button"));
		add.click();
		
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9788758914");
	}
}
