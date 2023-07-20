package StepDefinition;


import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.javatuples.Quintet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Covers.MultiCoverQTB.MultiCoverDetails;
import Utilities.ExcelReader;
import Utilities.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MultiCoverDetailsSetpDefinition {

    TestContextSetup _testContextSetup;
    MultiCoverDetails _multiCoverDetails;
    String _currentUrl = "";

    List<Quintet<String, String, String, String, String>> _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();

    SoftAssert _objSoftAssert = new SoftAssert();

    public MultiCoverDetailsSetpDefinition(TestContextSetup testContextSetup) {
        this._testContextSetup = testContextSetup;
        this._multiCoverDetails = _testContextSetup.ObjPageObjectManager.GetMultiCoverDetailsPage();
    }

    @Given("MultiCover Launch Browser and URL {string}")
    public void LaunchUrl(String url) throws InterruptedException {
        _currentUrl = System.getenv("Url") != null ? System.getenv("Url") : url;
        _testContextSetup.ObjTestBase.LaunchUrl(_currentUrl, _testContextSetup.Driver);
    }

    @When("MultiCover Click on Accept All button in cookies popup")
    public void ClosePrivacyPopup() {
        _testContextSetup.ObjHelper.CloseCookiesPopup(_testContextSetup.Driver);
    }


    public void SwitchTab() {
        _testContextSetup.ObjCommonFunctionLib.SwitchWindowToChild();
    }

    @And("MultiCover Execute Userinfo Page")
    public void InfoPageProcess(DataTable infoPageTable) {
        List<Map<String, String>> infoPageList = infoPageTable.asMaps();
        for (int counter = 0; counter < infoPageList.stream().count(); counter++) {
            ControlsProcessor(infoPageList, counter);
        }
    }

    @And("MultiCover Fill Insurance Info and other Info Details")
    public void InsuranceInfoProcess(DataTable insuranceInfoDetailsTable) {
        List<Map<String, String>> insuranceInfoDetailsList = insuranceInfoDetailsTable.asMaps();
        for (int counter = 0; counter < insuranceInfoDetailsList.stream().count(); counter++) {
            ControlsProcessor(insuranceInfoDetailsList, counter);
        }
    }

    @And("MultiCover Fill Business Info Address Details")
    public void BusinessInfoProcess(DataTable businessInfoDetailsTable) {
        List<Map<String, String>> businessInfoDetailsList = businessInfoDetailsTable.asMaps();
        for (int counter = 0; counter < businessInfoDetailsList.stream().count(); counter++) {
            ControlsProcessor(businessInfoDetailsList, counter);
        }
    }

    @And("MultiCover Fill Payment Details Page Info")
    public void PaymentInfoProcess(DataTable paymentInfoDetailsTable) {
        List<Map<String, String>> paymentInfoDetailsList = paymentInfoDetailsTable.asMaps();
        for (int counter = 0; counter < paymentInfoDetailsList.stream().count(); counter++) {
            ControlsProcessor(paymentInfoDetailsList, counter);
        }
    }

    @And("MultiCover Process cj controls")
    public void CjProcess() {

        try {
            String filePath = System.getenv("ExcelPath") != null ? System.getenv("ExcelPath") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelFilePath");
            String sheetName = System.getenv("ExcelSheetName") != null ? System.getenv("ExcelSheetName") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName");

            List<Map<String, String>> excelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName);

            for (int counter = 0; counter < excelData.stream().count(); counter++) {

                if (excelData.get(counter).get("GetQuote").toString().equals(""))
                    break;

                if (counter > 0) {
                    _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();
                    _testContextSetup = new TestContextSetup();
                    _multiCoverDetails = _testContextSetup.ObjPageObjectManager.GetMultiCoverDetailsPage();
                    LaunchUrl(_currentUrl);
                    ClosePrivacyPopup();
                }

                ControlsProcessor(excelData, counter);
                PublishReportsForExcelExecution();
                _testContextSetup.Driver.quit();
                _testContextSetup.Driver = null;
                _testContextSetup = null;
                _multiCoverDetails = null;
                _resultReport.clear();
                _resultReport = null;
            }
            filePath = "";
            sheetName = "";
            _objSoftAssert.assertAll();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Then("MultiCover Publish reports")
    public void PublishReports() {
        String sanityReportsColumnsName = "QuestionName,Values,TestStatus,Remarks, Screenshots";
        String createExcelFlag = System.getProperty("createExcelReportFlag") != null ? System.getProperty("createExcelReportFlag") : _testContextSetup.ObjProperties.getProperty("createExcelReportFlag");
        if (createExcelFlag.toLowerCase().equals("true"))
            _testContextSetup.ObjCommonFunctionLib.PublishReport(_resultReport, sanityReportsColumnsName, "MultiCover");

        _objSoftAssert.assertAll();
    }

    public void PublishReportsForExcelExecution() {
        String sanityReportsColumnsName = "QuestionName,Values,TestStatus,Remarks, Screenshots";
        String createExcelFlag = System.getProperty("createExcelReportFlag") != null ? System.getProperty("createExcelReportFlag") : _testContextSetup.ObjProperties.getProperty("createExcelReportFlag");
        if (createExcelFlag.toLowerCase().equals("true"))
            _testContextSetup.ObjCommonFunctionLib.PublishReport(_resultReport, sanityReportsColumnsName, "MultiCover");
    }


    @Given("MultiCover Testing the Price check Api")
    public void ApiTesting() {
        List<String> list = new ArrayList<String>();
        _testContextSetup.Driver.quit();


        try {
            String filePath = System.getenv("ExcelPath") != null ? System.getenv("ExcelPath") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelFilePath");
            String sheetName = System.getenv("dataDrivenExcelSheetName") != null ? System.getenv("dataDrivenExcelSheetName") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName");
            String sheetName2 = System.getenv("dataDrivenExcelSheetName2") != null ? System.getenv("dataDrivenExcelSheetName2") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName2");

            List<Map<String, String>> excelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName);
            String columnNames = String.join(",", excelData.get(0).keySet());

            List<Map<String, String>> staticExcelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName2);

            String httpMethod = System.getenv("HttpMethod") != null ? System.getenv("HttpMethod") : _testContextSetup.ObjProperties.getProperty("HttpMethod");
            for (int counter = 0; counter < excelData.stream().count(); counter++) {
                try {
                    if (excelData.get(counter).get("TradeID").equals("") && excelData.get(counter).get("Trade").equals(""))
                        break;

                    var responseData = _multiCoverDetails.PerformApi(httpMethod, excelData.get(counter).get("PI LOI"), excelData.get(counter).get("Postocde"), excelData.get(counter).get("CWC LOI"),
                            excelData.get(counter).get("HIP Hiring Charge"), excelData.get(counter).get("OP Market Value"),
                            excelData.get(counter).get("NCB"), staticExcelData.get(0).get("House Name/Number"),
                            staticExcelData.get(0).get("Business Name"), staticExcelData.get(0).get("Address Line 1"), excelData.get(counter).get("TradeID"),
                            excelData.get(counter).get("PL LOI"), excelData.get(counter).get("PL Number of Workers"), "", "");

                    if (responseData.size() > 0) {
                        for (Map.Entry<String, String> cellData : responseData.entrySet())
                            excelData.get(counter).put(cellData.getKey(), cellData.getValue());

                        excelData.get(counter).put("PLTest Pass (Y/N)", (String.valueOf(Math.round(Float.valueOf(excelData.get(counter).get("PL Prem(In. IPT)")))).
                                equals(String.valueOf(Math.round(Float.valueOf(excelData.get(counter).get("PL Prem Retrun"))))) ? "Pass" : "Fail"));
                    } else
                        excelData.get(counter).put("PLTest Pass (Y/N)", "NA");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            _testContextSetup.ObjCommonFunctionLib.PublishReportWithMapList(excelData, columnNames, "MultiCoverApiResult");
            columnNames = "";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
                questionName = cellData.getKey();
                if (cellData.getValue().toLowerCase().equals("skip") || cellData.getKey().toLowerCase().equals("questionname")) {
                    ++itreation;
                    continue;
                }

                controlValue = _testContextSetup.ObjHelper.SpecialHandling(_testContextSetup.Driver, cellData.getKey(), cellData.getValue()) != "" ? _testContextSetup.ObjHelper.SpecialHandling(_testContextSetup.Driver, cellData.getKey(), cellData.getValue()) : cellData.getValue();

                if (_multiCoverDetails.controlInfo.containsKey(cellData.getKey())) {
                    var controlInfo = _multiCoverDetails.controlInfo.get(cellData.getKey());
                    elementActionStatus = _multiCoverDetails.AssignControl(controlInfo.getValue0(), controlInfo.getValue1(), controlInfo.getValue2(), controlValue);

                    if (controlInfo.getValue3() != "")
                        Thread.sleep(Integer.parseInt(controlInfo.getValue3()));
                } else
                    elementActionStatus = "Fail";


                if (elementActionStatus.toLowerCase().equals("fail") || itreation == 1 || (itreation == listData.get(counter).entrySet().size() - 1)) {
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

                //for report failed
                try {
                    _objSoftAssert.assertEquals(elementActionStatus.toLowerCase(), "Pass".toLowerCase());

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }



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
            System.out.println(ex.getMessage() + "_" + questionName);
        }
    }
}
