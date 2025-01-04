package mugaam;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firstnormalflow {

	public void homepage(WebDriver driver, Filereaderpage reader) {

		WebElement searchbycompany = driver.findElement(By.cssSelector("#designation"));
		WebElement searchbyLoacation = driver.findElement(By.cssSelector("#location"));

		// searchbycompany.sendKeys(reader.searchcompanyname());
		searchbycompany.sendKeys("frontend developer");
		// searchbycompany.sendKeys(reader.Loacation());

		WebElement button = driver.findElement(By.cssSelector("#msearch_btn"));

		button.click();
		// WebElement searchbyLo =
		// driver.findElement(By.cssSelector("#search-res-containr >
		// div.col-lg-9.col-md-12.col-sm-12.col-xs-12"));

		
	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// note this method if the element is not present use this to check

//		WebElement searchbyLo = wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.cssSelector("#search-res-containr > div.col-lg-9.col-md-12.col-sm-12.col-xs-12")));
		WebElement searchbyLo = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#search-res-containr > div.col-lg-9.col-md-12.col-sm-12.col-xs-12 > div.job-list")));
		
		
		System.out.println(searchbyLo + "not found");
//		if (searchbyLo.isDisplayed()) {
//			scroll(driver);
//			scroll(driver);
//		} else {
//			System.out.println("some");
//		}
		  if (searchbyLo.isDisplayed()) {
		        scroll(driver);
		    } else {
		        System.out.println("Search results container not found.");
		        return;
		    }
		String originalWindow = driver.getWindowHandle();
	
		Selector(driver);

	//	
		

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
			fav(driver);
			applybutton(driver);
			backbutton(driver);
//	        WebElement element = tabWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-container > main > div.resulty-width1.mt-4.mb-4 > div > span > a")));
//	        element.click();
	       
	        System.out.println("Successfully interacted with the new tab.");
	    } catch (NoSuchElementException e) {
	        System.err.println("Element not found in the new tab.");
	    }
	
		WebElement select = driver.findElement(By.id("chk10-Coimbatore"));
		
		select.click();
		
		WebElement locationclose = driver.findElement(By.partialLinkText("#FilterCitylo"));
	    
	    
		locationclose.click();
		
	    
	    
	    
	}

	public void Selector(WebDriver driver) {

		WebElement developer = driver.findElement(By.cssSelector(
				"#search-res-containr > div.col-lg-9.col-md-12.col-sm-12.col-xs-12 > div.job-list > div:nth-child(4) > div"));

		developer.click();
		System.out.println("selector");
		

		
		//

	}

	public void applybutton(WebDriver driver) {

		WebElement Apply = driver.findElement(By.cssSelector(
				"#page-container > main > div.resulty-width2.mb-5 > div.card.pb-3 > div > div.col-md-12.col-12 > div > div.col-md-2.col-2.col-xl-3.col-lg-3 > div > img"));
		
		System.out.println(Apply.isEnabled());
		
		if (!Apply.isEnabled()) {
			Apply.click();
			WebElement submit = driver.findElement(
					By.cssSelector("#screenings > div > div > div > div > div > div.col-md-5.col-6 > div > button"));

			submit.click();

			WebElement finalsubmit = driver
					.findElement(By.cssSelector("#screeningQuiz > div > div.content_mcv > div.quizs > div > button"));
			finalsubmit.click();
		} else {
			System.out.println("Already Applied");
		}

	}

	public void fav(WebDriver driver) {
		System.out.println("ffffff");
		WebElement fav = driver.findElement(By.cssSelector("#page-container > main > div.resulty-width2.mb-5 > div.card.pb-3 > div > div.col-md-12.col-12 > div > div.col-md-2.col-2.col-xl-3.col-lg-3 > div > span"));		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	
		//fav.click();

		System.out.println(fav.isSelected());
		
		
		if (fav.isSelected()) {
			fav.click();
		} else {
			fav.click();
		}
		System.out.println("Favo" + fav.isSelected());


	}

	public void backbutton(WebDriver driver) {
		WebElement back = driver
				.findElement(By.cssSelector("#page-container > main > div.resulty-width1.mt-4.mb-4 > div > span > a"));
		back.click();
	}

	public void scroll(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 500).perform();
	}

	public void scrollup(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(500, 0).perform();
	}

}
