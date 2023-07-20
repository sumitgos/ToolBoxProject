package StepDefinition;

import Covers.GoodsinTransit.GoodsinTransitDetails;
import Utilities.CommonFuntionsLib;
import Utilities.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.javatuples.Quintet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsinTransitDetailsStepDefinition {

    TestContextSetup _testContextSetup;
    GoodsinTransitDetails _goodsinTransitDetails;
    String _currentUrl = "";

    List<Quintet<String, String, String, String, String>> _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();


    public GoodsinTransitDetailsStepDefinition(TestContextSetup testContextSetup) {
        this._testContextSetup = testContextSetup;
        this._goodsinTransitDetails = _testContextSetup.ObjPageObjectManager.GetGoodsinTransitDetailsPage();
    }

    @Given("GoodsinTransit Launch Browser and URL {string}")
    public void LaunchUrl(String url) throws InterruptedException {
        _currentUrl = System.getenv("Url") != null ? System.getenv("Url") : url;
        _testContextSetup.ObjTestBase.LaunchUrl(_currentUrl, _testContextSetup.Driver);
    }

    @When("GoodsinTransit Click on Accept All button in cookies popup")
    public void ClosePrivacyPopup() {
        _testContextSetup.ObjHelper.CloseCookiesPopup(_testContextSetup.Driver);
    }


    public void SwitchTab() {
        _testContextSetup.ObjCommonFunctionLib.SwitchWindowToChild();
    }

    @And("GoodsinTransit Execute Userinfo Page")
    public void InfoPageProcess(DataTable infoPageTable) {
        List<Map<String, String>> infoPageList = infoPageTable.asMaps();
        for (int counter = 0; counter < infoPageList.stream().count(); counter++) {
            ControlsProcessor(infoPageList, counter);
        }
    }

    @And("GoodsinTransit Fill Insurance Info and Claim Info Details")
    public void InsuranceInfoProcess(DataTable insuranceInfoDetailsTable) {
        List<Map<String, String>> insuranceInfoDetailsList = insuranceInfoDetailsTable.asMaps();
        for (int counter = 0; counter < insuranceInfoDetailsList.stream().count(); counter++) {
            ControlsProcessor(insuranceInfoDetailsList, counter);
        }
    }

    @And("GoodsinTransit Fill Business Info Address Details")
    public void BusinessInfoProcess(DataTable businessInfoDetailsTable) {
        List<Map<String, String>> businessInfoDetailsList = businessInfoDetailsTable.asMaps();
        for (int counter = 0; counter < businessInfoDetailsList.stream().count(); counter++) {
            ControlsProcessor(businessInfoDetailsList, counter);
        }
    }

    @And("GoodsinTransit Fill Payment Details Page Info")
    public void PaymentInfoProcess(DataTable paymentInfoDetailsTable) {
        List<Map<String, String>> paymentInfoDetailsList = paymentInfoDetailsTable.asMaps();
        for (int counter = 0; counter < paymentInfoDetailsList.stream().count(); counter++) {
            ControlsProcessor(paymentInfoDetailsList, counter);
        }
    }

    @And("GoodsinTransit Process cj controls")
    public void CjProcess() {

        try {
            String filePath = System.getenv("ExcelPath") != null ? System.getenv("ExcelPath") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelFilePath");
            String sheetName = System.getenv("ExcelSheetName") != null ? System.getenv("ExcelSheetName") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName");

            List<Map<String, String>> excelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName);

            for (int counter = 0; counter < excelData.stream().count(); counter++) {

                if (excelData.get(counter).get("GetQuote").toString().equals(""))
                    break;


                    if (counter > 0) {
                    _testContextSetup.Driver.quit();
//                    _testContextSetup.Driver = null;
//                    _testContextSetup = null;
                    _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();
                    _testContextSetup.Driver = _testContextSetup.ObjTestBase.WebDriverManager();
                    _testContextSetup.ObjCommonFunctionLib.Driver = _testContextSetup.Driver;
                    _testContextSetup.ObjPageObjectManager.Driver = _testContextSetup.Driver;
                    _goodsinTransitDetails = _testContextSetup.ObjPageObjectManager.GetGoodsinTransitDetailsPage();
                    LaunchUrl(_currentUrl);
                    ClosePrivacyPopup();
                }

                ControlsProcessor(excelData, counter);
                PublishReports();
                _goodsinTransitDetails = null;
                _resultReport.clear();
                _resultReport = null;
            }
            filePath = "";
            sheetName = "";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Then("GoodsinTransit Publish reports")
    public void PublishReports() {
        String sanityReportsColumnsName = "QuestionName,Values,TestStatus,Remarks, Screenshots";
        String createExcelFlag = System.getProperty("createExcelReportFlag") != null ? System.getProperty("createExcelReportFlag") : _testContextSetup.ObjProperties.getProperty("createExcelReportFlag");
        if (createExcelFlag.toLowerCase().equals("true"))
            _testContextSetup.ObjCommonFunctionLib.PublishReport(_resultReport, sanityReportsColumnsName, "GoodsinAndTransit");
    }

    private void ControlsProcessor(List<Map<String, String>> listData, int counter) {
        String elementActionStatus = "";
        List<String> list = new ArrayList<String>();
        String screenshotPath = "";
        String questionName = "";
        String controlValue = "";
        int itreation = 0;
        try {
            for (Map.Entry<String, String> cellData : listData.get(counter).entrySet()) {
                questionName =cellData.getKey();
                if (cellData.getValue().toLowerCase().equals("skip") ||cellData.getKey().toLowerCase().equals("questionname") ) {
                    ++itreation;
                    continue;
                }

                controlValue = _testContextSetup.ObjHelper.SpecialHandling(_testContextSetup.Driver, cellData.getKey(),cellData.getValue()) != "" ? _testContextSetup.ObjHelper.SpecialHandling(_testContextSetup.Driver, cellData.getKey(),cellData.getValue()) : cellData.getValue();

                //if (controlValue.toLowerCase() != "pass" & controlValue.toLowerCase() != "fail")
                if (_goodsinTransitDetails.controlInfo.containsKey(cellData.getKey())) {
                    var controlInfo = _goodsinTransitDetails.controlInfo.get(cellData.getKey());
                    elementActionStatus = _goodsinTransitDetails.AssignControl(controlInfo.getValue0(), controlInfo.getValue1(), controlInfo.getValue2(), controlValue);

                    if (controlInfo.getValue3() != "")
                        Thread.sleep(Integer.parseInt(controlInfo.getValue3()));
                } else
                    elementActionStatus = "Fail";


                if (elementActionStatus.toLowerCase().equals("fail") || itreation == 1 || (itreation == listData.get(counter).entrySet().size()-1)) {
                    //Take the screenshot
                    //Copy the file to a location and use try catch block to handle exception
                    try {
                        screenshotPath = (System.getenv("screenshotPath") != null ? System.getenv("screenshotPath") : _testContextSetup.ObjProperties.getProperty("screenshotPath")) + cellData.getKey().replace(" ", "_").replace("?", "") + ".jpg";
                        File screenshot = ((TakesScreenshot) _testContextSetup.Driver).getScreenshotAs(OutputType.FILE);
                        FileUtils.copyFile(screenshot, new File(screenshotPath));
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                list.add(cellData.getKey());
                list.add(controlValue);
                list.add(elementActionStatus);
                list.add("");
                list.add(screenshotPath);

                _resultReport.add(Quintet.fromCollection(list));

                if (cellData.getKey().toLowerCase().equals("getquote"))
                    SwitchTab();

                elementActionStatus = "";
                list.clear();
                elementActionStatus = "";
                list.clear();
                screenshotPath = "";
                questionName = "";
                controlValue = "";
                ++itreation;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "_"+ questionName);
        }
    }
}