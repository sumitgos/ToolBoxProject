package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/BDD/Features/ToolInsurance.feature" }, glue = {"StepDefinition","ToolInsuranceDetailsStepDefinition"}, monochrome = true,
		tags = "@ToolInsurance",//scenarios under @sanity tag will be executed
		plugin = { "html:target/Reports/ToolInsurancereports_html.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunnerToolInsurance extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}

}