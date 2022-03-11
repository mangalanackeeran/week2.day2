package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement elementUsername = driver.findElement(By.xpath("//label[@for = 'username']/following-sibling::input[@id = 'username']"));
		elementUsername.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.xpath("//label[@for = 'password']/following-sibling::input[@id = 'password']"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementSubmit = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementSubmit.click();
		WebElement elementCRMSFA = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		elementCRMSFA.click();
		WebElement elementLead = driver.findElement(By.linkText("Leads"));
		elementLead.click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//em[@class='x-tab-left']//span[@class='x-tab-strip-text '])[2]")).click();
		WebElement elementPhone = driver.findElement(By.xpath("//div[@class='x-plain-body x-plain-body-noheader x-plain-body-noborder']/input[@name='phoneNumber']"));
		elementPhone.sendKeys("9876543210");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(3000);
		WebElement elementFirstRecord = driver.findElement(By.xpath("(//div[contains(@class,'-col-partyId')]/a[@class='linktext'])[1]"));
		String leadid = elementFirstRecord.getText();
		System.out.println("Lead id is : "+leadid);
		elementFirstRecord.click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys(leadid);
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		Thread.sleep(3000);
		WebElement elementIdCheck = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		String str = elementIdCheck.getText();
		System.out.println(str);
		if (str.contains("No records to display")) {
			System.out.println("Record deleted successfully - Test case passed");
		}
		else {
			System.out.println("Record Available - Test case failed");
		}
		driver.close();	}

}
