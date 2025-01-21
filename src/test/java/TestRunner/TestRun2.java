package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features/MortgageCalculatorFeatures.feature", // Path to the feature file
        glue = "StepDefinitions",                                                   // Package with step definitions
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",                  // Allure plugin
                "html:target/cucumber-reports.html",                                 // HTML report
                "usage:target/cucumber-usage.json",                                  // Usage report
                "json:target/cucumber.json"                                         // JSON report
        },
        monochrome = true                                                            // Readable console output
)
public class TestRun2 extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        String runtimeTag = System.getProperty("cucumber.filter.tags");
        if (runtimeTag != null) {
            System.setProperty("cucumber.options", "--tags " + runtimeTag);
        }
    }

    // This class remains empty
    // It serves as a holder for the above annotations
}
