package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/BDD/Features/ProfessionalIndemnity.feature"}, glue = {"StepDefinition", "ProfessionalIndemnityDetailsStepDefinition"}, monochrome = true,
        tags = "@ProfessionalIndemnityApi",//scenarios under @sanity tag will be executed
        plugin = {"html:target/Reports/ProfessionalIndemnity_html.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunnerProfessionalIndemnity extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}
}