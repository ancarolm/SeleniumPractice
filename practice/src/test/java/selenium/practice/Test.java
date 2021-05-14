package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test {
	
	static WebDriver driver = new ChromeDriver();


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "../practice/src/main/resources/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		App app = new App();
		Test element = new Test();
		Test element2 = new Test();
		Test element3 = new Test();

		/*WebElements element = new WebElements();
		WebElements element2 = new WebElements();
		WebElements element3 = new WebElements();*/

		/*WebElement user = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement submit = driver.findElement(By.id("btnLogin"));*/
		
		File src = new File("../practice/src/main/resources/TestSelenium.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);		
		int count = sheet.getLastRowNum();
		
		String un, pass;
		
		//Test 1
		
		
		for (int i =1; i <= count;) {
			
			try {
				
				/*WebElement user = driver.findElement(By.xpath(app.getUser()));
				WebElement password = driver.findElement(By.xpath(app.getPassword()));
				WebElement submit = driver.findElement(By.xpath(app.submit()));*/
				
				
				un = sheet.getRow(i).getCell(0).getStringCellValue();
				pass = sheet.getRow(i).getCell(1).getStringCellValue();
				
				element.getElement(app.getUser()).sendKeys(un + "\n");
				element2.getElement(app.getPassword()).sendKeys(un + "\n");

				/*user.sendKeys(un + "\n");
				password.sendKeys(pass + "\n");*/
				
				if (un.equals("Admin") && pass.equals("admin123")) {
					
					element3.getElement(app.submit()).click();

					//submit.click();
					break;

				}			

				WebDriverWait wait = new WebDriverWait (driver, 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(app.getUser())));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(app.getPassword())));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(app.submit())));
				
			} catch (StaleElementReferenceException e) {
				// TODO Auto-generated catch block
			} catch (NoSuchElementException ex) {
				
			}
			//System.out.print("done");
			
			i++;
	
		}
		
		
		//driver.quit();


	}
	
	public WebElement getElement(String xPath) {
		
		
		WebElement element = driver.findElement(By.xpath(xPath));
		
		
		return element;
	}

}
