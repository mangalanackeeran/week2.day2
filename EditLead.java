package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input[@name='firstName']")).sendKeys("Test");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    
		driver.findElement(By.xpath("(//div[text()='Lead ID']/following::a[@class='linktext'])[1]")).click();
		String pageTitle=driver.getTitle();
		if(pageTitle.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Page title verified. Title is: "+pageTitle);
		}
		else
		{
			System.out.println("Page title is incorrect. Title displayed as:"+pageTitle);
		}
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement elementCompanyName = driver.findElement(By.xpath("//span[text()='Company Name']/following::input[@id='updateLeadForm_companyName']"));
		elementCompanyName.sendKeys("Zoho");
		String updatedCompanyName=elementCompanyName.getText();
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
		WebElement elementViewCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		String companyName=elementViewCompanyName.getText();
		if(companyName.contains(updatedCompanyName))
		{
			System.out.println("Company name is updated");
		}
		else
		{
			System.out.println("Company name is not updated");
		}
		driver.close();
	}

}
