package Covers.MultiCoverQTB;

import API.ApiManager.APIProcessor;
import API.Util.ApiHelper;
import Covers.GetElement;
import io.restassured.path.json.JsonPath;
import org.javatuples.*;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.*;

import org.json.*;
import org.openqa.selenium.json.Json;

public class MultiCoverDetails {
    public WebDriver _driver;

    public MultiCoverDetails(WebDriver driver) {
        this._driver = driver;
    }

    public Map<String, Quartet<String, String, String, String>> controlInfo = new HashMap<>(Map.ofEntries(
            Map.entry("GetQuote", new Quartet<>("Button", "XPath", "//*[contains(@Class,'styles__Typography-sc') and @mode and (text()='Get a quote')]", "6000")),
            Map.entry("What is your main trade or profession?", new Quartet<>("TextBox", "XPath", "//*[contains(@id,'react-select') and @spellcheck]", "4000")),
            Map.entry("Does your business have any employees?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("How many employees does your business have?", new Quartet<>("RadioButton", "XPath", "//*[contains(@Class,'placeholder') and @id]", "1000")),
            Map.entry("Do you offer certification, advice, or design in your work?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
            Map.entry("NextPage_Dy1", new Quartet<>("Button", "XPath", "//span[text()='Select Cover']", "4000")),
            Map.entry("Select additional cover", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[1]", "1000")),
            Map.entry("NextPage_Dy2", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("What best describes your.", new Quartet<>("Button", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy3", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("What best describes your business", new Quartet<>("Button", "XPath", "//span[text()='<Dy>']//parent::*//parent::*//parent::*", "1000")),
            Map.entry("NextPage_Dy4", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("What year was your business established", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "2000")),
            Map.entry("How many years of working experience do you have ?", new Quartet<>("CustomComboBox", "XPath", "//*[contains(@id,'react-select') and contains(@id,'placeholder')]", "2000")),
            Map.entry("NextPage_Dy5", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("Bankruptcy", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("Past Insurance", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
            Map.entry("Criminal records", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[3]", "1000")),
            Map.entry("Health & safety records", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[4]", "1000")),
            Map.entry("NextPage_Dy6", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("Have you had any claims, losses or incidents in the past 3 years", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy7", new Quartet<>("Button", "XPath", "//span[text()='Next']", "1000")),
            Map.entry("First name", new Quartet<>("TextBox", "XPath", "//input[@placeholder='First name' and contains(@class,'styles__Input')]", "1000")),
            Map.entry("Surname", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Surname' and contains(@class,'styles__Input')]", "1000")),
            Map.entry("NextPage_Dy8", new Quartet<>("Button", "XPath", "//span[text()='Next']", "4000")),
            Map.entry("What’s your home address?", new Quartet<>("TextBox", "XPath", "//input[@name='postcode']", "1000")),
            Map.entry("What’s your home FindAddress?", new Quartet<>("Button", "XPath", "//span[text()='Find address']", "7000")),
            Map.entry("What’s your home SelectAddress?", new Quartet<>("Button", "XPath", "(//div[text()='Select'])[1]", "5000")),
            Map.entry("Select Manual Address", new Quartet<>("TextBox", "XPath", "//span[text()='Enter address manually']", "1000")),
            Map.entry("Select Manual AddressLine1", new Quartet<>("TextBox", "XPath", "//input[@name='addressLine1']", "1000")),
            Map.entry("Select Manual houseNameOrNumber", new Quartet<>("TextBox", "XPath", "//input[@name='houseNameOrNumber']", "1000")),
            Map.entry("Select Manual addressLine3", new Quartet<>("TextBox", "XPath", "//input[@name='addressLine3']", "1000")),
            Map.entry("Select Manual postcode", new Quartet<>("TextBox", "XPath", "//input[@name='postcode']", "2000")),
            Map.entry("NextPage_Dy9", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("What’s your business Mobile Number?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Phone number' and contains(@class,'styles__Input')]", "2000")),
            Map.entry("What is your date of birth?", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "1000")),
            Map.entry("What’s your business email address?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Email address']", "1000")),
            Map.entry("What’s your business confirm email address?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Confirm Email address']", "1000")),
            Map.entry("I agree to the T&Cs and Privacy Policy", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[5]", "1000")),
            Map.entry("marketing from Toolbox", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[6]", "1000")),
            Map.entry("NextPage_Dy10", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("Do you have a trading or company name", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("What is your trading name", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Your trading name']", "1000")),
            Map.entry("NextPage_Dy11", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("Do you have any parent or subsidiary companies?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("Is your parent or subsidiary company covered under this policy?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
            Map.entry("What is the name of your parent or subsidiary company?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Add name']", "1000")),
            Map.entry("NextPage_Dy12", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("NextPage_Dy13", new Quartet<>("Button", "XPath", "//span[text()='Next']", "7000")),
            Map.entry("Select the level of Public Liability cover you require", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("Does any of your work take place outside the United Kingdom", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy14", new Quartet<>("Button", "XPath", "//span[text()='Next']", "7000")),
            Map.entry("Turnover is your total business income taken in a particular period", new Quartet<>("CustomTextBox", "XPath", "//*[contains(@class,'styles__Input')]", "1000")),
            Map.entry("NextPage_Dy15", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Do you have a separate dedicated business premises", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy16", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Do you undertake 3-phase electrical work?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("Is any gas fitting or installation work undertaken?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
            Map.entry("NextPage_Dy17", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("NexDo you use any form of heat equipment such as an Angle Grinder.", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("NextPage_Dy18", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Do you or any employee in your business ever work at height?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("What is the maximum depth? at which work is undertaken?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "2000")),
            Map.entry("Do you or any employee in your business ever work below ground level?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
            Map.entry("What is the maximum height worked at?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "2000")),
            Map.entry("NextPage_Dy19", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Does your work involve any discharge of fumes, effluent or anything of a noxious nature?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("Does your work involve the use of substances which could be harmful to health?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
            Map.entry("NextPage_Dy20", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("NextPage_Dy21", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("How many of your company's employees perform administrative tasks or non-manual work?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
            Map.entry("How many employees perform manual work?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
            Map.entry("How many employees perform administrative tasks or non-manual work?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
            Map.entry("NextPage_Dy22", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("How many labour-only subcontractors do you have at any given time?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
            Map.entry("How many bona fide subcontractors do you have at any given time?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
            Map.entry("NextPage_Dy23", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Are all your employees paid below the PAYE threshold", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy24", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("NextPage_Dy25", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Do you currently hold a Professional Indemnity policy, with a retroactive date", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("What is your retroactive date", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "1000")),
            Map.entry("NextPage_Dy26", new Quartet<>("Button", "XPath", "//span[text()='Next']", "6000")),
            Map.entry("What level of Professional Indemnity cover do you require", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy27", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Do you undertake any structural, computer software or computer hardware design work", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy28", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Do you undertake any property management?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
            Map.entry("Do you give any taxation advice?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
            Map.entry("NextPage_Dy29", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("Do one or more of the business partners", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy30", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("NextPage_Dy31", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("How much will the maximum value of any of your contracts be worth?", new Quartet<>("TextBox", "XPath", "//*[contains(@id,'react-select') and contains(@id,'input')]", "1000")),
            Map.entry("What limit of indemnity do you require?", new Quartet<>("TextBox", "XPath", "//*[contains(@class,'styles__Input')]", "1000")),
            Map.entry("NextPage_Dy32", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("NextPage_Dy33", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("What level of cover do you require?", new Quartet<>("TextBox", "XPath", "//*[contains(@id,'react-select') and contains(@id,'input')]", "1000")),
            Map.entry("What is your estimated annual cost for hired in plant?", new Quartet<>("TextBox", "XPath", "//*[contains(@class,'styles__Input')]", "1000")),
            Map.entry("NextPage_Dy34", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("NextPage_Dy35", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("What level of cover do you require for Own  plant?", new Quartet<>("TextBox", "XPath", "//*[contains(@id,'react-select') and contains(@id,'input')]", "1000")),
            Map.entry("What is your estimated annual cost for Own  plant ?", new Quartet<>("TextBox", "XPath", "//*[contains(@class,'styles__Input')]", "1000")),
            Map.entry("NextPage_Dy36", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
            Map.entry("You can choose any date within the next 30 days", new Quartet<>("TextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "1000")),
            Map.entry("Renewal", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("Billing", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy37", new Quartet<>("Button", "XPath", "//span[text()='Confirm']", "8000")),
            Map.entry("How do you want to pay?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
            Map.entry("NextPage_Dy38", new Quartet<>("Button", "XPath", "//span[text()='Confirm cover']", "14000")),
            Map.entry("I confirm I have read the above information", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[2]", "1000")),
            Map.entry("Click Continue To Payment", new Quartet<>("Button", "XPath", "//span[text()='Continue to payment']", "8000")),
            Map.entry("Please Enter Account Holder Name Info", new Quartet<>("TextBox", "XPath", "//input[@name='accountHoldername']", "1000")),
            Map.entry("Please Enter Account Sort Code", new Quartet<>("TextBox", "XPath", "//input[@name='accountSortcode']", "1000")),
            Map.entry("AccountNumberNameInfo", new Quartet<>("TextBox", "XPath", "//input[@name='accountNumber']", "1000")),
            Map.entry("ConfirmPage", new Quartet<>("Button", "XPath", "//span[text()='Confirm']", "10000")),
            Map.entry("NextPage_14", new Quartet<>("Button", "XPath", "//span[text()='Next']", "7000")),
            Map.entry("PayCardNumber", new Quartet<>("TextBox", "XPath", "//input[@id='PayCardNumber']", "1000")),
            Map.entry("PayCardHolderName", new Quartet<>("TextBox", "XPath", "//input[@id='PayCardHolder']", "1000")),
            Map.entry("Card ExpiryDateMonth", new Quartet<>("ComboBox", "XPath", "//select[@id='PayCardExpireSplitMM']", "1000")),
            Map.entry("PayCardExpireSplitYear", new Quartet<>("ComboBox", "XPath", "//select[@id='PayCardExpireSplitYY']", "1000")),
            Map.entry("CardSecurityCode", new Quartet<>("TextBox", "XPath", "//input[@id='CardSecurityCode']", "1000")),
            Map.entry("CardHolderHouseNumber", new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderHouseNumber']", "1000")),
            Map.entry("CardHolderAddressLine1", new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderAddressLine1']", "1000")),
            Map.entry("PayCardHolder", new Quartet<>("TextBox", "XPath", "//input[@id='PayCardHolder']", "1000")),
            Map.entry("CardHolderPostcode", new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderPostcode']", "1000")),
            Map.entry("PayCardExpire", new Quartet<>("ComboBox", "XPath", "//select[@id='PayCardExpireSplitMM']", "1000")),
            Map.entry("ProposerIsCardHolder", new Quartet<>("RadioButton", "XPath", "//input[@id='ProposerIsCardHolderY']", "1000")),
            Map.entry("CardAutoReuseConsent", new Quartet<>("RadioButton", "XPath", "//input[@id='CardAutoReuseConsentN']", "1000")),
            Map.entry("nextbtn", new Quartet<>("Button", "XPath", "//button[@class='next btn btn-primary']", "10000"))
    ));


    public String AssignControl(String controlType, String controlIdentification, String controlIdentificationValue, String controlValue) {
        String elementStatus = "";
        try {

            GetElement objGetElement = new GetElement();
            elementStatus = objGetElement.GetActionElement(_driver, controlType, controlIdentification, controlIdentificationValue.replace("<Dy>", controlValue), controlValue);

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
                Map.entry("https://dev2-public-api.toolboxbyadmiral.com/graphql", new Triplet<>("data.getIndicativePrice.covers", "code:premiumDetails[<Dy>].amount_PL Prem Retrun", "4000"))
        ));

        ApiHelper objApiHelper = new ApiHelper();
        Map<String, String> responseData = new HashMap<>();

        try {
            if (!responseInfo.contains("\"errorCode\":500") && !responseInfo.contains("\"errorMessage\":\"No Response\"")) {
                var apiInfo = responseConditionBased.get(baseUri);
                String coverType = System.getenv("CoverType") != null ? System.getenv("CoverType") : "PL";
                JsonPath responseJSon = objApiHelper.RawToJson(responseInfo);
                ArrayList responseArr = responseJSon.getJsonObject(apiInfo.getValue0());

                for (String responseValue : apiInfo.getValue1().split("\\|")) {
                    if (responseValue.contains(":")) {
                        for (int counter = 0; counter < responseArr.size(); counter++) {

                            if (responseJSon.get(apiInfo.getValue0() + "[" + counter + "]." + responseValue.split(":")[0]).toString().toLowerCase().equals(coverType.toLowerCase())) {
                                responseData.put(responseValue.split(":")[1].split("_")[1], responseJSon.get(apiInfo.getValue0() + "." + responseValue.split(":")[1].split("_")[0].replace("<Dy>", String.valueOf(counter))).toString());
                            }
                        }
                        responseArr = null;
                    } else {
                        responseData.put(responseValue.split("_")[1],responseJSon.get(apiInfo.getValue0() + "." + responseValue.split("_")[0].replace("<Dy>", String.valueOf(0))).toString());
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
