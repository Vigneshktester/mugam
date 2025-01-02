package mugaam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class mugaammainpage {


	public static void main (String[]arg) {
	
		ChromeDriver driver = new ChromeDriver();
		
		Filereaderpage reader = new Filereaderpage();
        reader.Readerpage();
		
		websiteopenpages websiteopenpages = new websiteopenpages(); 
	
        websiteopenpages.openwebsite(driver,reader);
	
	}
	
	
}
