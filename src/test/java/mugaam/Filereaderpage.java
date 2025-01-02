package mugaam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Filereaderpage {

	Properties pro;
	
	public void Readerpage() {
		
	FileInputStream file = null;
	try {
	file = new  FileInputStream("./config.properties");
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	pro = new Properties();
	
	try {
		pro.load(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	public String name() {
		return pro.getProperty("Name");
	}
	public String Loacation() {
		return pro.getProperty("Loacation");
	}
	
	public String searchcompanyname() {
		return pro.getProperty("searchcompanyname");
	}
	public String searchjobname() {
		return pro.getProperty("searchjobname");
	}
	
	public String myname() {
		return pro.getProperty("myname");
	
}
	public String url() {
	return pro.getProperty("url");	
	}
	
	
	public String Email() {
	return pro.getProperty("email");	
	}
	public String existmail() {
		return pro.getProperty("existmail");	
	}
	
	public String password() {
	return pro.getProperty("password");	
	}
	public String wrongpassword() {
		return pro.getProperty("wrongpassword");	
	}
	public String wrongemail() {
		return pro.getProperty("wrongemail");	
	}
}
