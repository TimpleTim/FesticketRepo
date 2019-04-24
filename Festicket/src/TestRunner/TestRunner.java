package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//To get the definitions for the Given,When,And,Then.
@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue= "StepDefinitions")
public class TestRunner {

}
