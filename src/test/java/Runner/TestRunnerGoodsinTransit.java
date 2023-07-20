package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = { "src/test/resources/BDD/Features/GoodsinTransit.feature" }, glue = {"StepDefinition","GoodsinTransitDetailsStepDefinition"}, monochrome = true,
        tags = "@Goods_in_TransitWithExcel",//scenarios under @sanity tag will be executed
        plugin = { "html:target/Reports/GoodsinTransitReports_html.html","json:target/Reports/GoodsinTransitReports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunnerGoodsinTransit extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}
}