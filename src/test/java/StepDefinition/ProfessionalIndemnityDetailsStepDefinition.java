package StepDefinition;

import API.ApiManager.APIProcessor;
import Covers.ProfessionalIndemnity.ProfessionalIndemnityDetails;
import Covers.ToolInsurance.ToolInsuranceDetails;
import DBLayer.Cover.ProfessionalIndemnityDB;
import DBLayer.DBExecutor;
import Utilities.TestContextSetup;
import io.cucumber.java.en.Given;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProfessionalIndemnityDetailsStepDefinition {

    TestContextSetup _testContextSetup;
    ProfessionalIndemnityDetails _professionalIndemnityDetails;
    ProfessionalIndemnityDB _professionalIndemnityDB = new ProfessionalIndemnityDB();
    String _currentUrl = "";

    List<Quintet<String, String, String, String, String>> _resultReport = new ArrayList<Quintet<String, String, String, String, String>>();

    public ProfessionalIndemnityDetailsStepDefinition(TestContextSetup testContextSetup) {
        this._testContextSetup = testContextSetup;
        this._professionalIndemnityDetails = _testContextSetup.ObjPageObjectManager.GetProfessionalIndemnityDetailsPage();
    }


    @Given("Testing the Price check Api")
    public void ApiTesting() {
        List<String> list = new ArrayList<String>();
       // _testContextSetup.Driver.quit();
        try {
            String filePath = System.getenv("ExcelPath") != null ? System.getenv("ExcelPath") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelFilePath");
            String sheetName = System.getenv("dataDrivenExcelSheetName") != null ? System.getenv("dataDrivenExcelSheetName") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName");
            String sheetName2 = System.getenv("dataDrivenExcelSheetName2") != null ? System.getenv("dataDrivenExcelSheetName2") : _testContextSetup.ObjProperties.getProperty("dataDrivenExcelSheetName2");
            String ProfessionName = System.getenv("ProfessionAndTrade") != null ? System.getenv("ProfessionAndTrade") : _testContextSetup.ObjProperties.getProperty("ProfessionAndTrade");

            List<Map<String, String>> excelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName);
            String columnNames = String.join(",", excelData.get(0).keySet());

            List<Map<String, String>> staticExcelData = _testContextSetup.ObjCommonFunctionLib.GetExcelData(filePath, sheetName2);

            String httpMethod = System.getenv("HttpMethod") != null ? System.getenv("HttpMethod") : _testContextSetup.ObjProperties.getProperty("HttpMethod");
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date today = Calendar.getInstance().getTime();
            System.setProperty("PreTime",dateFormat.format(today));

            for (int counter = 0; counter < excelData.stream().count(); counter++) {
                try {
                    today = Calendar.getInstance().getTime();
                    System.setProperty("CurrTime",dateFormat.format(today));
                    if (excelData.get(counter).get("Profession").equals(""))
                        break;

                    var responseData = _professionalIndemnityDetails.PerformApi(httpMethod, staticExcelData.get(0).get("Email"), staticExcelData.get(0).get("Postcode"), staticExcelData.get(0).get("Date of birth"),
                            excelData.get(counter).get("Days Experience"), excelData.get(counter).get("PL LOI"),
                            excelData.get(counter).get("PL No. People"), excelData.get(counter).get("PL Y/N"),
                            excelData.get(counter).get("EL (Y/N)"), staticExcelData.get(0).get("Address Line 1"), excelData.get(counter).get("PI LOI"),
                            excelData.get(counter).get("Turnover"), excelData.get(counter).get("Days Experience "), excelData.get(counter).get(ProfessionName), "");

                    if (responseData.size() > 0) {
                        for (Map.Entry<String, String> cellData : responseData.entrySet())
                            excelData.get(counter).put(cellData.getKey(), cellData.getValue().replace("[","").replace("]",""));

                        excelData.get(counter).put("Test Pass (Y/N)", (String.valueOf(Math.round(Float.valueOf(excelData.get(counter).get("Final Premium (with 12% IPT)")))).
                                equals(String.valueOf(Math.round(Float.valueOf(excelData.get(counter).get("Premium Returned"))))) ? "Pass" : "Fail"));
                    } else
                        excelData.get(counter).put("Test Pass (Y/N)", "NA");

                    excelData.get(counter).put("Time of Test", System.getProperty("ResponseTime"));

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            _testContextSetup.ObjCommonFunctionLib.PublishReportWithMapList(excelData, columnNames, "ProfessionalIndemnityApiResult");
            columnNames = "";
            dateFormat = null;
            today = null;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void PublishReports() {
        String sanityReportsColumnsName = "QuestionName,Values,TestStatus,Remarks, Screenshots";
        String createExcelFlag = System.getProperty("createExcelReportFlag") != null ? System.getProperty("createExcelReportFlag") : _testContextSetup.ObjProperties.getProperty("createExcelReportFlag");
        if (createExcelFlag.toLowerCase().equals("true"))
            _testContextSetup.ObjCommonFunctionLib.PublishReport(_resultReport, sanityReportsColumnsName, "ProfessionalIndemnitySanity");
    }
}