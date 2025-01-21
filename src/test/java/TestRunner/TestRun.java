package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/MortgageCalculatorFeatures.feature",
        glue = "StepDefinitions",
        plugin = {
                "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-reports.html",
                 "usage:target/cucumber-usage.json",
                "json:target/cucumber.json"
        },
        monochrome = true

)

public class TestRun {
    // This class remains empty
    // It serves as a holder for the above annotations
}

