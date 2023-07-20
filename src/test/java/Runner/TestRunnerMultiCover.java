package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/BDD/Features/MultiCoverQTB.feature" }, glue = {"StepDefinition","MultiCoverDetailsSetpDefinition"}, monochrome = true,
		tags = "@MultiCoverApi",//scenarios under @sanity tag will be executed
		plugin = { "html:target/Reports/MultiCoverreports_html.html","json:target/Reports/MultiCoverreports.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },publish = true)
public class TestRunnerMultiCover extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}
}