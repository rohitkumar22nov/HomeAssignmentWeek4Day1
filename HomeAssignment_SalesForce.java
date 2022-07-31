package week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeAssignment_SalesForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//     		Salesforce Customer service:
//			1.Launch the browser
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
//			2.Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//			3.Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
//			4. Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password$123");
		
//			5.click on the login button
		driver.findElement(By.id("Login")).click();
		
//			6.click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
//			7.Switch to the next window using Windowhandles.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		String firstTab = listHandles.get(0);
		String secondTab = listHandles.get(1);
		driver.switchTo().window(secondTab);
		
//			8.click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
//			9.Get the title
		Set<String> windowHandlesNew = driver.getWindowHandles();
		List<String> listHandlesNew = new ArrayList<String>(windowHandles);
		String newTab = listHandles.get(1);
		driver.switchTo().window(newTab);
		String title = driver.getTitle();
		System.out.println(title);

				
//			10.Get back to the parent window
		driver.switchTo().window(firstTab);
		String titleMainPage = driver.getTitle();
		System.out.println(titleMainPage);
//			11.close the browser
		driver.close();

		

	}

}
