package POMFile;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

import java.util.List;

public class FesticketPOM {
	WebDriver driver;
	String searchName;
	
	@FindBy(css="#root > main > div.styles__c-pujc8f-0.idXsDl > div > div > a > span")
	WebElement searchColumn;
	
	@FindBy(xpath="//*[@id=\"search-input\"]")
	WebElement searchTextBox;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/ul/li/a/div/div[2]")
	WebElement searchItem;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/ul/li/a/div/div[2]/h3")
	WebElement searchNameVerify;
	
	@FindBy(xpath="//*[@id=\"root\"]/main/div[1]/div[1]/div/div[1]/h1")
	WebElement nameToVerify;
	
	@FindBy(css="#root > div > div > div.app-containers-Search-search__result_wrapper > ul")
	WebElement searchTotal;
	
	//To initialise the elements
	public FesticketPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//To click the search button on home page
	public void clickSearch()
	{
		searchColumn.click();
	}
	
	//To enter text inside search filed
	public void enterSearch(String name)
	{
		searchTextBox.clear();
		searchTextBox.sendKeys(name);

	}
	
	//Search for the desired festival name and click on it
	public void festivalSelect(String festName) throws Exception 
	{
		Thread.sleep(3000);
		//Store the number of search options in a list
		WebElement columnList= searchTotal;
		List<WebElement> options= columnList.findElements(By.tagName("li"));
		for(WebElement option: options)
		{	
			String text=option.findElement(By.xpath("a/div/div[2]/h3")).getText();
			
			if(text.equals(festName))
			{	
				searchName=text;
				option.click();
				break;
				
			}

		}
	}
	
	
	//To verify the Page result as per the search entered
	public void verifyNames()
	{
		assertEquals(searchName,nameToVerify.getText());
	}
	
	public void invalidSearch()
	{
		try {
		searchTotal.click();
		}catch(NoSuchElementException e)
		{
			System.out.println("No match for the search entered");
		}
		
	}
	
	
}
