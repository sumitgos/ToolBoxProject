package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/BDD/Features/PublicLiability.feature" }, glue = {"StepDefinition","PublicLiabilityDetailsStepDefinition"}, monochrome = true,
		tags = "@PublicLiabilityExcel",//scenarios under @sanity tag will be executed
		plugin = { "html:target/Reports/PublicLiabilityreports_html.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunnerPublicLiability extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}

}