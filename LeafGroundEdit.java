package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Enter a text
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testuser@gmail.com");
		
		//Append a text and press keyboard tab
		driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).sendKeys(Keys.END+"test"+Keys.TAB);
		String appendedText = driver.findElement(By.xpath("//input[@value='Append ']")).getAttribute("value");
		System.out.println("Test after appending:"+appendedText);
		
		//Get default text entered
		String defaultText = driver.findElement(By.xpath("//label[text()='Get default text entered']/following-sibling::input")).getAttribute("value");
		System.out.println("Default text is:"+defaultText);
		
		//Clear the text
		driver.findElement(By.xpath("//label[text()='Clear the text']/following-sibling::input")).clear();
		
		//Confirm that edit field is disabled
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'field is disabled')]/following-sibling::input"));
		if(element.isEnabled()==false)
		{
			System.out.println("Field is disabled");
		}
		else
		{
			System.out.println("Field is enabled");
		}

	}

}
