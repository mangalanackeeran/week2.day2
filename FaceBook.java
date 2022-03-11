
  package week2.day2;
  
  import java.util.concurrent.TimeUnit;
  
  import org.openqa.selenium.By; import
  org.openqa.selenium.chrome.ChromeDriver; import
  org.openqa.selenium.support.ui.Select; import
  org.openqa.selenium.WebDriver.Timeouts; import
  org.openqa.selenium.WebElement;
  
  import io.github.bonigarcia.wdm.WebDriverManager;
  
  public class FaceBook {
  
  public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://en-gb.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.linkText("Create New Account")).click();
	driver.findElement(By.name("firstname")).sendKeys("ABCD");
	driver.findElement(By.name("lastname")).sendKeys("EFGH");
	driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
	driver.findElement(By.id("password_step_input")).sendKeys("ABCD1234!@#");
	WebElement elementDay = driver.findElement(By.id("day"));
	Select day = new Select(elementDay);
	day.selectByVisibleText("14");
	WebElement elementMonth = driver.findElement(By.id("month"));
	Select month = new Select(elementMonth);
	month.selectByValue("3");
	WebElement elementYear = driver.findElement(By.id("year"));
	Select year = new Select(elementYear);
	year.selectByIndex(20);
	driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/input[@value='2']")).click();
	driver.close(); }
  
  }
 