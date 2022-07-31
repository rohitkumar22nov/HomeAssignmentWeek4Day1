package week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeAssignment_MergeLead {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		String userName = "demosalesmanager";
		String password = "crmsfa";
		
//		 * //Pseudo Code
//		 * 
//		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		 * 
//		 * 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//p[@class='top']//following::input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@class='inputLogin']//following::input[@id='password']")).sendKeys(password);
		
//		 * 
//		 * 3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@class='inputLogin']//following::input[2]")).click();
		
//		 * 
//		 * 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@id='label']//following::a")).click();
		
//		 * 
//		 * 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
//		 * 	
//		 * 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
//		 * 
//		 * 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img[1]")).click();
		

//		 * 
//		 * 8. Click on First Resulting Contact
		Set<String> handles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(handles);
		String firstHandle = listHandles.get(0);
		String secondHandle = listHandles.get(1);
		System.out.println("first Handle = " + firstHandle);
		System.out.println("second Handle = " + secondHandle);
		
		driver.switchTo().window(secondHandle);
		System.out.println("switched to second handle " + secondHandle);
		driver.findElement(By.xpath("//div[text()='Contact ID']/following::a[@class='linktext'][1]")).click();		
	
//		 * 
//		 * 9. Click on Widget of To Contact
		driver.switchTo().window(firstHandle);
		System.out.println("switched to first window " + firstHandle);
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img[2]")).click();
		System.out.println(driver.getWindowHandle());
	
//		 * 
//		 * 10. Click on Second Resulting Contact
		
		Thread.sleep(5000);
		Set<String> handleNew = driver.getWindowHandles();
		List<String> listHandleNew = new ArrayList<String>(handleNew);
		String firstNew = listHandleNew.get(0);
		String secondNew = listHandleNew.get(1);
		
		System.out.println("-------");
		System.out.println("firstNew " + firstNew);
		System.out.println("firstOld " + firstHandle);
		System.out.println("-------");
		System.out.println("secondNew " + secondNew);
		System.out.println("secondOld " + secondHandle);
		System.out.println("-------");
		
		
		driver.switchTo().window(secondNew);
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Contact ID']/following::table[1]/following::a[1]")).click();
//		 * 
//		 * 11. Click on Merge button using Xpath Locator
		driver.switchTo().window(firstHandle);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
//		 * 
//		 * 12. Accept the Alert
		driver.switchTo().alert().accept();
		
//		 * 
//		 * 13. Verify the title of the page
		
		driver.switchTo().window(firstHandle);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);

	}

}
