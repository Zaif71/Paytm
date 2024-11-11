package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Features/MortgageCalculatorFeatures.feature",
        glue = "StepDefinitions",
        plugin = {
                "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        tags = "@Links"
)
public class TestRun {
    // This class remains empty
    // It serves as a holder for the above annotations
}

