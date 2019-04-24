package StepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import POMFile.FesticketPOM;
import POMFile.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FesticketStepFile extends Hooks{
	
	FesticketPOM fpom;
	@Given("^User is on the chrome browser$")
	public void user_is_on_the_chrome_browser()  {
		System.setProperty("webdriver.chrome.driver", "CHROME_DRIVER_PATH\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^User navigates to the Festicket homepage$")
	public void user_navigates_to_the_Festicket_homepage()  {
	    driver.get("https://www.festicket.com/");
	}

	@When("^Click on search$")
	public void click_on_search()  {
	    fpom=new FesticketPOM(driver);
	    fpom.clickSearch();
	}

	@When("^Enters the festival \"([^\"]*)\"$")
	public void enters_the_festival(String arg1) {
	    fpom.enterSearch(arg1);
	}
	
	@When("^User select the festival \"([^\"]*)\"$")
	public void user_select_the_festival(String festName) throws Exception {
		fpom.festivalSelect(festName);
		
	}
	
	@Then("^User should be presented with the festival result page and verify the festival name$")
	public void user_should_be_presented_with_the_festival_result_page_and_verify_the_festival_name() {
		
		fpom.verifyNames();
		System.out.println("Verified");
	}
	
	@Then("^Browser Closes$")
	public void browser_Closes() {
	    driver.quit();
	}
	
	@When("^Enter the invalid festival \"([^\"]*)\"$")
	public void enter_the_invalid_festival(String invalidFestNmae) throws Throwable {
	    fpom.enterSearch(invalidFestNmae);
	}

	@Then("^User should see the empty list and cannot proceed$")
	public void user_should_see_the_empty_list_and_cannot_proceed() throws Throwable {
	    fpom.invalidSearch();
		System.out.println("Not present");
	}

	
}
