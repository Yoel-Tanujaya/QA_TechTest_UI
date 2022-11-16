package webautomationtest;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("webautomationtest")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@RunWith(Cucumber.class)
@CucumberOptions(
  features = {
    "src/test/resources/webautomationtest/selectmenu.feature",
    "src/test/resources/webautomationtest/books.feature",
  },
  glue={
    "webautomationtest.SelectMenuDefinitions.java",
    "webautomationtest.BooksDefinitions.java",
  }
)
public class RunCucumberTest {
}
