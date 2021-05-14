package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements implements Elements {
	
	
	WebDriver driver = new ChromeDriver();
	
	public WebElements() {
		
		System.setProperty("webdriver.chrome.driver", "../practice/src/main/resources/chromedriver.exe");

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}

	
	@Override
	public WebElement getElement(String xPath) {
		
		System.setProperty("webdriver.chrome.driver", "../practice/src/main/resources/chromedriver.exe");

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath(xPath));
		
		
		return element;
	}

	@Override
	public void setElement() {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

}
