package Test.AutoItTool;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoIT {
	public static void main(String args[]) throws InterruptedException, IOException
	{
	
	WebDriver driver;
	String projectPath=System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Abishek\\Desktop\\selenium\\chromedriver.exe");
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

	chromePrefs.put("profile.default_content_settings.popups", 0);

	chromePrefs.put("download.default_directory", projectPath);
	ChromeOptions options=new ChromeOptions();
	options.setExperimentalOption("pref", chromePrefs);
	driver = new ChromeDriver(options);	
	
	driver.get("https://altoconvertpdftoword.com/");
	
	driver.findElement(By.id("dropzoneInput-label")).click();
	
	Thread.sleep(3000);
	
	Runtime.getRuntime().exec("C:\\Users\\Abishek\\Desktop\\upload.exe");
	
	//Explicit Wait
	WebDriverWait wait= new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Convert Now!')]")));

	File f=new File(projectPath+"/example.pdf");
	if(f.exists())
	{
		System.out.println("file found");
	}
}
}