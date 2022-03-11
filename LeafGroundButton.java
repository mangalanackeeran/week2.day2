package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		System.out.println("Home page URL: "+driver.getCurrentUrl());
		driver.navigate().back();
		
		//Find position of button (x,y)
		int x=driver.findElement(By.xpath("//button[@id='position']")).getLocation().getX();
		int y=driver.findElement(By.xpath("//button[@id='position']")).getLocation().getY();
		System.out.println("x and y position is:"+x+","+y);
		
		//Find button color
		String color=driver.findElement(By.xpath("//button[@id='position']")).getCssValue("background-color");
		System.out.println("Color is:"+color);
		
		//Find the height and width
		int height=driver.findElement(By.xpath("//button[@id='size']")).getSize().getHeight();
		int width=driver.findElement(By.xpath("//button[@id='size']")).getSize().getWidth();
		System.out.println("height and width is:"+height+","+width);

	}

}
