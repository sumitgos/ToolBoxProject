package StepDefinition;

import API.ApiManager.APIProcessor;
import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.javatuples.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Covers.ToolInsurance.ToolInsuranceDetails;
import Utilities.TestContextSetup;
import io.cucumber.java.en.*;

import java.io.File;
import java.util.*;

public class ToolInsuranceDetailsStepDefinition {

    TestContextSetup _testContextSetup;
    ToolInsuranceDetails _toolInsuranceDetails;
    String _currentUrl = "";

    List<Quintet<String, String, String, String, String>> _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();


    public ToolInsuranceDetailsStepDefinition(TestContextSetup testContextSetup) {
        this._testContextSetup = testContextSetup;
        this._toolInsuranceDetails = _testContextSetup.ObjPageObjectManager.GetToolInsuranceDetailsPage();
    }

    @Given("Launch Browser and URL {string}")
    public void LaunchUrl(String url) throws InterruptedException {
        _currentUrl = System.getenv("Url") != null ? System.getenv("Url") : url;
        _testContextSetup.ObjTestBase.LaunchUrl(_currentUrl, _testContextSetup.Driver);
    }

    @When("Click on Accept All button in cookies popup")
    public void ClosePrivacyPopup() {
        _testContextSetup.ObjHelper.CloseCookiesPopup(_testContextSetup.Driver);
    }


    public void SwitchTab() {
        _testContextSetup.ObjCommonFunctionLib.SwitchWindowToChild();
    }

    @And("Execute Info Page")
    public void InfoPageProcess(DataTable infoPageTable) {
        List<Map<String, String>> infoPageList = infoPageTable.asMaps();
        for (int counter = 0; counter < infoPageList.stream().count(); counter++) {
            ControlsProcessor(infoPageList, counter);
        }
    }

    @And("Fill Personal Details")
    public void PersonalDetailsProcess(DataTable personalDetailsTable) {
        List<Map<String, String>> personalDetailsList = personalDetailsTable.asMaps();
        for (int counter = 0; counter < personalDetailsList.stream().count(); counter++) {
            ControlsProcessor(personalDetailsList, counter);
        }
    }

    @And("Fill Home Address Details")
    public void HomeAddressProcess(DataTable homeAddressTable) {
        List<Map<String, String>> homeAddressList = homeAddressTable.asMaps();
        for (int counter = 0; counter < homeAddressList.stream().count(); counter++) {
            ControlsProcessor(homeAddressList, counter);
        }
    }

    @And("Fill Business Address Page Details")
    public void BusinessAddressProcess(DataTable businessDetailsTable) {
        List<Map<String, String>> businessDetailsList = businessDetailsTable.asMaps();
        for (int counter = 0; counter < businessDetailsList.stream().count(); counter++) {
            ControlsProcessor(businessDetailsList, counter);
        }
    }

    @And("Fill Employee Info Page Details")
    public void EmployeeInfoProcess(DataTable employeeInfoDetailsTable) {
        List<Map<String, String>> employeeInfoList = employeeInfoDetailsTable.asMaps();
        for (int counter = 0; counter < employeeInfoList.stream().count(); counter++) {
            ControlsProcessor(employeeInfoList, counter);
        }
    }

    @And("Fill Payment Details Page Info")
    public void PaymentInfoProcess(DataTable paymentInfoDetailsTable) {
        List<Map<String, String>> aymentInfoList = paymentInfoDetailsTable.asMaps();
        for (int counter = 0; counter < aymentInfoList.stream().count(); counter++) {
            ControlsProcessor(aymentInfoList, counter);
        }
    }

    @And("Process cj controls")
    public void CjProcess() {
        try {
            String filePath = System.getenv("ExcelPath") != null ? System.getenv("ExcelPath") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelFilePath");
            String sheetName = System.getenv("ExcelSheetName") != null ? System.getenv("ExcelSheetName") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName");

            List<Map<String, String>> excelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName);

            for (int counter = 0; counter < excelData.stream().count(); counter++) {

                if (excelData.get(counter).get("GetQuote").toString().equals(""))
                    break;

//                if (counter > 0) {
//                    _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();
//                    _testContextSetup = new TestContextSetup();
//                    _toolInsuranceDetails = _testContextSetup.ObjPageObjectManager.GetToolInsuranceDetailsPage();
//                    LaunchUrl(_currentUrl);
//                    ClosePrivacyPopup();
//                }
                if (counter > 0) {
                    _testContextSetup.Driver.quit();
                    _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();
                    _testContextSetup.Driver = _testContextSetup.ObjTestBase.WebDriverManager();
                    _testContextSetup.ObjCommonFunctionLib.Driver = _testContextSetup.Driver;
                    _testContextSetup.ObjPageObjectManager.Driver = _testContextSetup.Driver;
                    _toolInsuranceDetails = _testContextSetup.ObjPageObjectManager.GetToolInsuranceDetailsPage();
                    LaunchUrl(_currentUrl);
                    ClosePrivacyPopup();
                }
                ControlsProcessor(excelData, counter);
                PublishReports();
                _toolInsuranceDetails = null;
                _resultReport.clear();
                _resultReport = null;

//                ControlsProcessor(excelData, counter);
//                PublishReports();
//                _testContextSetup.Driver.quit();
//                _testContextSetup.Driver = null;
//                _testContextSetup = null;
//                _toolInsuranceDetails = null;
//                _resultReport.clear();
//                _resultReport = null;
            }
            filePath = "";
            sheetName = "";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Then("Publish reports")
    public void PublishReports() {
        String sanityReportsColumnsName = "QuestionName,Values,TestStatus,Remarks, Screenshots";
        String createExcelFlag = System.getProperty("createExcelReportFlag") != null ? System.getProperty("createExcelReportFlag") : _testContextSetup.ObjProperties.getProperty("createExcelReportFlag");
        if (createExcelFlag.toLowerCase().equals("true"))
            _testContextSetup.ObjCommonFunctionLib.PublishReport(_resultReport, sanityReportsColumnsName, "ToolInsuranceSanity");
    }

    private void ControlsProcessor(List<Map<String, String>> listData, int counter) {
        String elementActionStatus = "";
        List<String> list = new ArrayList<String>();
        String screenshotPath = "";
        String questionName = "";
        String controlValue = "";
        try {
            for (Map.Entry<String, String> cellData : listData.get(counter).entrySet()) {
                questionName = cellData.getKey();
                if (cellData.getValue().toLowerCase().equals("skip") || cellData.getKey().toLowerCase().equals("questionname"))
                    continue;

                controlValue = _testContextSetup.ObjHelper.SpecialHandling(_testContextSetup.Driver, cellData.getKey(),cellData.getValue()) != "" ? _testContextSetup.ObjHelper.SpecialHandling(_testContextSetup.Driver, cellData.getKey(),cellData.getValue()) : cellData.getValue();

                if (_toolInsuranceDetails.controlInfo.containsKey(cellData.getKey())) {
                    var controlInfo = _toolInsuranceDetails.controlInfo.get(cellData.getKey());
                    elementActionStatus = _toolInsuranceDetails.AssignControl(controlInfo.getValue0(), controlInfo.getValue1(), controlInfo.getValue2(), controlValue);

                    if (controlInfo.getValue3() != "")
                        Thread.sleep(Integer.parseInt(controlInfo.getValue3()));
                } else
                    elementActionStatus = "Fail";


                if (elementActionStatus.toLowerCase().equals("fail")) {
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

                if (cellData.getKey().toLowerCase().equals("getquote")) {
                    SwitchTab();
                    Thread.sleep(7000);
                }

                elementActionStatus = "";
                list.clear();
                screenshotPath = "";
                questionName = "";
                controlValue = "";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "_" + questionName);
        }
    }

    @Given("Testing the Price check Api Tool Insurance")
    public void ApiTesting(){
        List<String> list = new ArrayList<String>();
        try {
            String filePath = System.getenv("ExcelPath") != null ? System.getenv("ExcelPath") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelFilePath");
            String sheetName = System.getenv("ExcelSheetName") != null ? System.getenv("ExcelSheetName") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName");
            String sheetName2 = System.getenv("ExcelSheetName2") != null ? System.getenv("ExcelSheetName2") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName2");

            List<Map<String, String>> excelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName);

            List<Map<String, String>> staticExcelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName2);

            APIProcessor objApiProcessor = new APIProcessor();
           for (int counter = 0; counter < excelData.stream().count(); counter++) {
                String value =excelData.get(counter).get("TradeId");
               //objApiProcessor.ProcessApi();
               //excelData.get(counter).put("Premium Returned","abc");

               //objApiProcessor.ProcessApi("Post","da2-tr3wk33xjbfqbfm6jicbf4p23m",staticExcelData.get(counter).get("Email"),staticExcelData.get(counter).get("Postcode"),staticExcelData.get(counter).get("Date of birth"),staticExcelData.get(counter).get("Fornames"),staticExcelData.get(counter).get("Lastname"),staticExcelData.get(counter).get("Payment Type"),staticExcelData.get(counter).get("House Name/Number"),staticExcelData.get(counter).get("Business Name"),staticExcelData.get(counter).get("Address Line 1"),excelData.get(counter).get("PI LOI"),excelData.get(counter).get("Turnover"),excelData.get(counter).get("Days Experience "),excelData.get(counter).get("Profession"),excelData.get(counter).get("Profession"));

            }


        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}