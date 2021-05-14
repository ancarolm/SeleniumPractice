package selenium.practice;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App implements WElements
{
	
	
	File src;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	int count, cells;
	String xPathUN, xPathPASS, xPathBTN;
	
	
    public App() throws Exception {
    	
    	
    	src = new File("../practice/src/main/resources/Variables.xlsx");
		
		fis = new FileInputStream(src);

		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheetAt(0);

		row = sheet.getRow(0);
		cell = row.getCell(0);
		
		cells = row.getLastCellNum();
		count = sheet.getLastRowNum();
		
		
    }

	@Override
	public String getUser() {
		
		
		for (int i = 0; i <= count; i++) {
			
			String valor = sheet.getRow(i).getCell(0).toString();
			String xpath = sheet.getRow(i).getCell(1).toString();
			
			if (valor.equals("login_user")) {
				
				xPathUN = xpath;
				
			}
					
		}
		
		return xPathUN;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= count; i++) {
			
			String valor = sheet.getRow(i).getCell(0).toString();
			String xpath = sheet.getRow(i).getCell(1).toString();
			
			if (valor.equals("login_password")) {
				
				xPathPASS = xpath;
				
			}
					
		}
		
		return xPathPASS;
	}

	@Override
	public String submit() {
		
		for (int i = 1; i <= count; i++) {
			
			String valor = sheet.getRow(i).getCell(0).getStringCellValue();
			String xpath = sheet.getRow(i).getCell(1).toString();
			
			if (valor.equals("login_button")) {
				
				xPathBTN = xpath;
				
			}
					
		}
		
		return xPathBTN;
	}
}
