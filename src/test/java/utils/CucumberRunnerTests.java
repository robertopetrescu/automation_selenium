
package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features"}, glue = {"Tests"},
        plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}
