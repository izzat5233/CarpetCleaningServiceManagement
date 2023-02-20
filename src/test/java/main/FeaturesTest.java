package main;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        features = {"src/test/resources/features"},
        glue = {"features"}
)
public class FeaturesTest {
    /*
    This class servers as an entry point for Cucumber tests.
    Don't add any step definitions or tests here.
     */
}
