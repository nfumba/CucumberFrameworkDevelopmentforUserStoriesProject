package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
////div[@class='message warning fadable']
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/",
        glue = "steps",
        dryRun = false,
        tags = "@ExistingId",
        plugin = {"pretty"}





)







public class TestRunner {
}