package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

		// TODO Auto-generated method stub
		static ChromeDriver driver;
		
		public void launchBrowser() {
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			 driver= new ChromeDriver();
		}
		
		public void loginLeafTaps() {
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		}
		
		public void duplicateLead() throws InterruptedException {
			driver.findElement(By.xpath("//a[text()='Leads']")).click();
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			driver.findElement(By.xpath("//span[text()='Email']")).click();
			driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(".com");
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			Thread.sleep(1000);
			WebElement elementFirstName = driver.findElement(By.xpath("(//div[text()='First name']/following::a[@class='linktext'])[3]"));
			String firstName=elementFirstName.getText();
			WebElement elementLastName = driver.findElement(By.xpath("(//div[text()='Last name']/following::a[@class='linktext'])[4]"));
			String lastName=elementLastName.getText();
			System.out.println("First name:"+firstName);
			System.out.println("Last name:"+lastName);		
			elementFirstName.click();
			driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
			String pageTitle=driver.getTitle();
			if(pageTitle.equals("Duplicate Lead | opentaps CRM"))
			{
				System.out.println("Page title verified. Title is: "+pageTitle);
			}
			else
			{
				System.out.println("Page title is incorrect. Title displayed as:"+pageTitle);
			}
			driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
			WebElement elementDupFName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
			String dupFName=elementDupFName.getText();
			WebElement elementDupLName = driver.findElement(By.xpath("//span[@id='viewLead_lastName_sp']"));
			String dupLName=elementDupLName.getText();
			if(firstName.equals(dupFName))
			{
				System.out.println("Duplicated lead first name is same as captured name");
			}
			else
			{
				System.out.println("Duplicated lead first name doesn't match with captured name");
			}
			if(lastName.equals(dupLName))
			{
				System.out.println("Duplicated lead first name is same as captured name");
			}
			else
			{
				System.out.println("Duplicated lead first name doesn't match with captured name");
			}
			
		}
		
		public void closeBrowser() {
			driver.close();
		}
		
		public static void main(String[] args) throws InterruptedException {
			DuplicateLead dl=new DuplicateLead();
			dl.launchBrowser();
			dl.loginLeafTaps();
			dl.duplicateLead();
			dl.closeBrowser();

	}

}
