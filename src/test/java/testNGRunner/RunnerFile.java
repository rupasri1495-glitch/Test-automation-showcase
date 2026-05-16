package testNGRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/featuresFiles",
glue = "stepDefinitions",
monochrome = true,
dryRun = true)

public class RunnerFile extends AbstractTestNGCucumberTests{

}
