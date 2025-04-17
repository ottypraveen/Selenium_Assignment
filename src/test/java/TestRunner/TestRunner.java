package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/Features",glue="StepDefinations",
monochrome=true, tags = "@ErrorValidation1", plugin= {"html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
