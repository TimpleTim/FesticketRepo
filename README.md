# FesticketRepo
Search functionality in Festicket Web Page

Instructions:
The module I selected was Search functionality for the application Festicket.
To execute:
1) Replace "CHROME_DRIVER_PATH" in FesticketStepFile.java" with the installed chrome driver path from your local machine .
2) Run the "Festicket.feature" file.

Analysis:

Issue: 
Got Element not found error when used xpath, so I used "cssSelector" to rectify it.
Got StaleElement when searched for a element before entering the list column, so used it after the list was made.

Challenges:
While trying to verify empty search, I was thinking the way to verify it, so handled it by using exception handling.

If I had more time, would have checked the search functionality using artist, genre, country etc and also would have tried using keyboard instead of cursor to click.

The other test cases I need to automate are by using special character, numbers, etc.

Framework used is Cucumber BDD with Selenium WebDriver using POM( Page Object Model)
BDD format used so that code is readable to non technical people and Page Object Model to avoid duplication of code for finding elements on page and for better code maintainability.

Libraries used are:
import org.openqa.selenium.By;  -  Used for Selecting the locator
import org.openqa.selenium.NoSuchElementException; - exception handling
import org.openqa.selenium.WebDriver; - to automate web application for a specific driver called 
import org.openqa.selenium.WebElement; - To store the element location in a WebElement
import org.openqa.selenium.support.FindBy; - To locate element in page using locators without using "findElement" or "findElements"
import org.openqa.selenium.support.PageFactory; - used to initialize elements of the page
import static org.junit.Assert.*; - To verify the text present by giving expected and actual outcome

libraries used to link the step file and feature file:
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

Resources used is Eclipse IDE