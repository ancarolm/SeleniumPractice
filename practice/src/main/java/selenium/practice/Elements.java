package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Elements {
	
	public WebElement getElement(String xPath);
	public void setElement();

}
