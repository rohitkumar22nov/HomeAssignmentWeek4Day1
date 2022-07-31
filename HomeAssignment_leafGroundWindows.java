package week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeAssignment_leafGroundWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String secondTab = list.get(1);
		String firstTab = list.get(0);
		
		driver.switchTo().window(secondTab);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.switchTo().window(firstTab);
		

		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandlesNew = driver.getWindowHandles();
		List<String> listNew = new ArrayList<String>(windowHandlesNew);
		System.out.println(listNew.size());
		
		
		//Close all except this window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> latestHandles = driver.getWindowHandles();
		List<String> latestList = new ArrayList<String>(latestHandles);
		int size = latestList.size();
		System.out.println("Total windows open at this point: "  + size); // 0123
		
		for(int i = 1; i<size; i++) {
		driver.switchTo().window(latestList.get(i));
		driver.close();
		
		}
		
		System.out.println("All windows closed at this point except the main");
		
		//Wait for 2 new Windows to open
		driver.switchTo().window(firstTab);
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		
		
		
		
	}

}
