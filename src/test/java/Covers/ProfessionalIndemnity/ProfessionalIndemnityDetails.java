package Covers.ProfessionalIndemnity;

import API.ApiManager.APIProcessor;
import API.Util.ApiHelper;
import Covers.GetElement;
import io.restassured.path.json.JsonPath;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.*;

public class ProfessionalIndemnityDetails {
    public WebDriver _driver;

    public ProfessionalIndemnityDetails(){}
    public ProfessionalIndemnityDetails(WebDriver driver) {
        this._driver = driver;
    }

    public String AssignControl(String controlType, String controlIdentification, String controlIdentificationValue, String controlValue) {
        String elementStatus = "";
        try {
            GetElement objGetElement = new GetElement();
            elementStatus = objGetElement.GetActionElement(_driver, controlType, controlIdentification, controlIdentificationValue.replace("<Dy>",controlValue), controlValue);

            objGetElement = null;

            return elementStatus;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }

    public Map<String, String> PerformApi(String httpMethod, String payloadValue, String payloadValue2, String payloadValue3, String payloadValue4, String payloadValue5, String payloadValue6, String payloadValue7, String payloadValue8, String payloadValue9,
                                          String payloadValue10, String payloadValue11, String payloadValue12, String payloadValue13, String payloadValue14) {
        Map<String, String> responseData = new HashMap<>();

        try {
            APIProcessor objApiProcessor = new APIProcessor();
            FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
            Properties objProperties = new Properties();
            objProperties.load(fileInput);

            String baseUri = System.getenv("BaseUri") != null ? System.getenv("BaseUri") : objProperties.getProperty("BaseUri");

            String responseInfo = objApiProcessor.ProcessApi(baseUri, httpMethod, payloadValue, payloadValue2, payloadValue3, payloadValue4, payloadValue5, payloadValue6, payloadValue7, payloadValue8, payloadValue9, payloadValue10,
                    payloadValue11, payloadValue12, payloadValue13, payloadValue14);

            responseData = GetResponseValuefromApi(responseInfo, baseUri);


            objApiProcessor = null;
            fileInput = null;
            objProperties = null;


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return responseData;
    }

    public Map<String, String> GetResponseValuefromApi(String responseInfo, String baseUri) {
        Map<String, Triplet<String, String, String>> responseConditionBased = new HashMap<>(Map.ofEntries(
                Map.entry("https://dev-public-api.toolboxbyadmiral.com/graphql", new Triplet<>("data.createQuote", "premiumDetails.premiumProvisionalAmount_Premium Returned|premiumDetails.totalPayableAmount_totalPayableAmountReturned", "1000")),
                Map.entry("https://dev-public-api.toolboxbyadmiral.com/graphql_Metadata", new Triplet<>("data.getMetadatas.list", "description:id_TradeId",  "1000")),
                Map.entry("https://uat-public-api.toolboxbyadmiral.com/graphql", new Triplet<>("data.createQuote", "premiumDetails.premiumProvisionalAmount_Premium Returned|premiumDetails.totalPayableAmount_totalPayableAmountReturned", "1000")),
                Map.entry("https://uat-public-api.toolboxbyadmiral.com/graphql_Metadata", new Triplet<>("data.getMetadatas.list", "description:id_TradeId",  "1000")),
                Map.entry("https://admiral-justice.uat.cdlcloud.co.uk/api/v1/policies?detailLevel=FULL", new Triplet<>("", "webReference_Web Reference Number|quoteResults.premiumDetails.totalPayable_Premium Returned",  "200"))

        ));

        ApiHelper objApiHelper = new ApiHelper();
        Map<String, String> responseData = new HashMap<>();

        try {
            if (!responseInfo.contains("\"errorCode\":500") && !responseInfo.contains("\"errorMessage\":\"No Response\"")) {
                var apiInfo = responseConditionBased.get(baseUri);
                JsonPath responseJSon = objApiHelper.RawToJson(responseInfo);
                String dynamicValue = System.getProperty("Profession") != null ? System.getProperty("Profession") : "";

                for (String responseValue : apiInfo.getValue1().split("\\|")) {
                    if (responseValue.contains(":")) {
                        ArrayList responseArr =  responseJSon.getJsonObject(apiInfo.getValue0());
                        for (int counter = 0; counter < responseArr.size(); counter++) {

                            if (responseJSon.get(apiInfo.getValue0() == "" ? responseValue.split(":")[1].split("_")[0].toString() : (apiInfo.getValue0() + "[" + counter + "]." + responseValue.split(":")[0])).toString().toLowerCase().equals(dynamicValue.toLowerCase())) {
                                responseData.put(responseValue.split(":")[1].split("_")[1], responseJSon.get(apiInfo.getValue0() == "" ? responseValue.split(":")[1].split("_")[0].toString() : (apiInfo.getValue0()+ "[" + counter + "]." + responseValue.split(":")[1].split("_")[0]).toString()));
                            }
                        }
                        responseArr = null;
                    } else {
                        responseData.put(responseValue.split("_")[1],responseJSon.getString(apiInfo.getValue0() == "" ? responseValue.split("_")[0].replace("<Dy>", String.valueOf(0)).toString()
                                : (apiInfo.getValue0() + "." + responseValue.split("_")[0].replace("<Dy>", String.valueOf(0)).toString())).replace("[","").replace("]",""));
                    }
                }

                Thread.sleep(Integer.parseInt(apiInfo.getValue2()));

            } else {
                responseData.put("No Response", "No Response");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return responseData;
    }
}


