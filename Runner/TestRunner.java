package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "D:\\masai\\Evaluate-Prograne\\Project\\Tutorial-Ninja_Automation\\src\\test\\resources\\Features\\ urban_ladder.feature",
    glue = {"Urban_StepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
