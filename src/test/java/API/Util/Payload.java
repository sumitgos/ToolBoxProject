package API.Util;

import API.ApiManager.APIProcessor;
import Covers.ProfessionalIndemnity.ProfessionalIndemnityDetails;
import com.google.errorprone.annotations.Var;
import groovy.util.MapEntry;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.javatuples.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.reflect.Method;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Payload {

    public Map<String, Quintet<String, String, String, String, String>> ApiInfo = new HashMap<>(Map.ofEntries(
            Map.entry("https://dev-public-api.toolboxbyadmiral.com/graphql", new Quintet<>("ProfessionalIndemnityPayLoad", "GraphQL", "x-api-key:da2-4x5iddzkurbhlfdqadxuubhx4q|User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.3", "", "")),

            Map.entry("https://dev2-public-api.toolboxbyadmiral.com/graphql", new Quintet<>("MultiCoverPayLoad", "GraphQL", "x-api-key:da2-an5adzltyzhylgpxi4i54vz2wq", "", "")),
            Map.entry("https://dev-public-api.toolboxbyadmiral.com/graphql_Metadata", new Quintet<>("GetMetadatasTradeId", "GraphQL", "x-api-key:da2-4x5iddzkurbhlfdqadxuubhx4q|User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.3", "","")),
            Map.entry("https://uat-public-api.toolboxbyadmiral.com/graphql", new Quintet<>("ProfessionalIndemnityPayLoad", "GraphQL", "x-api-key:da2-tr3wk33xjbfqbfm6jicbf4p23m|User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.3", "","")),
            Map.entry("https://uat2-public-api.toolboxbyadmiral.com/graphql", new Quintet<>("MultiCoverPayLoad", "GraphQL", "x-api-key:da2-an5adzltyzhylgpxi4i54vz2wq", "", "")),
            Map.entry("https://uat-public-api.toolboxbyadmiral.com/graphql_Metadata", new Quintet<>("GetMetadatasTradeId", "GraphQL", "x-api-key:da2-tr3wk33xjbfqbfm6jicbf4p23m|User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.3", "","")),

            Map.entry("https://toren1-admiral-uat.auth.eu-west-1.amazoncognito.com/oauth2/token", new Quintet<>("Urlencoded", "grant_type;client_credentials|scope;https://www.cdl.co.uk/System", "username:5cq8b78kdr58fh9426okhiq3ha|Password:9m0p6mukgg8aej18ugesq86e1rjettvhsv2k2l9j5epm794cqs9", "access_token","")),
            Map.entry("https://admiral-justice.uat.cdlcloud.co.uk/api/v1/policies?detailLevel=FULL", new Quintet<>("ProfessionalIndemnityEc2", "JSON", "Content-Type:application/json", "", "Auth|https://toren1-admiral-uat.auth.eu-west-1.amazoncognito.com/oauth2/token"))
    ));

    public String GetPayload(String apiUri, String payloadValue, String payloadValue2, String payloadValue3, String payloadValue4, String payloadValue5, String payloadValue6, String payloadValue7, String payloadValue8, String payloadValue9,
                             String payloadValue10, String payloadValue11, String payloadValue12, String payloadValue13, String payloadValue14) {
        String payLoad = "";
        try {
            if (ApiInfo.containsKey(apiUri)) {
                Class classRef = Class.forName("API.Util." + ApiInfo.get(apiUri).getValue1());
                Method objMethod = classRef.getMethod(ApiInfo.get(apiUri).getValue0(), String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
                        , String.class, String.class, String.class, String.class, String.class);
                Object classObject = classRef.newInstance();
                payLoad = (String) objMethod.invoke(classObject, payloadValue, payloadValue2, payloadValue3, payloadValue4, payloadValue5, payloadValue6, payloadValue7, payloadValue8,
                        payloadValue9, payloadValue10, payloadValue11, payloadValue12, payloadValue13, payloadValue14);

                classRef = null;
                objMethod = null;
                classObject = null;
            }

                return payLoad;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }
}

class GraphQL {
    public String ProfessionalIndemnityPayLoad(String email, String postalCode, String dateOfBirth, String firstName, String lastName, String payementType, String houseNumber, String businessName, String addressLine1,
                                               String lOI, String turnOver, String dayOfExperience, String profession, String numberOfPeople) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String todayDate = dateFormat.format(today);
        dateFormat = null;
        today = null;
        String nestedBaseUri = "";
        String nestedApiFlag = System.getenv("EnvironmentWiseApi") != null ? System.getenv("NestedApiFlag") : "False";
        String EnvironmentWise = System.getenv("EnvironmentWiseApi") != null ? System.getenv("EnvironmentWiseApi") : "dev";

        if (nestedApiFlag.toLowerCase().equals("true")) {
            APIProcessor objApiProcessor = new APIProcessor();
            ProfessionalIndemnityDetails objProfessionalIndemnityDetails = new ProfessionalIndemnityDetails();
            if (EnvironmentWise.toLowerCase().contains("dev")) {
                nestedBaseUri = "https://dev-public-api.toolboxbyadmiral.com/graphql_Metadata";
            } else {
                nestedBaseUri = "https://uat-public-api.toolboxbyadmiral.com/graphql_Metadata";
            }

            String responseInfo = objApiProcessor.ProcessApi(nestedBaseUri, "Post", email, postalCode, dateOfBirth, firstName, lastName, payementType, houseNumber, businessName, addressLine1,
                    lOI, turnOver, dayOfExperience, profession, numberOfPeople);

            System.setProperty("Profession", profession);
            var responseData = objProfessionalIndemnityDetails.GetResponseValuefromApi(responseInfo, nestedBaseUri);

            objProfessionalIndemnityDetails = null;
            objApiProcessor = null;
            System.setProperty("Profession", "");
            profession = responseData.get("TradeId");
        }

        return "mutation Mutation {\n" +
                "  createQuote(input: {\n" +
                "    version: 1,\n" +
                "    cmsTemplateReference: \"18865-24233-89352\",\n" +
                "    cmsTemplateStepReference: \"275b55bf-ce73-4e98-9808-07040565d9ff\",\n" +
                "    productCode: PII,\n" +
                "    data: \"{\\\"paymentType\\\":\\\"" + payementType + "\\\",\\\"consentToAutoRenew\\\":true," +
                "\\\"paperless\\\":false,\\\"discountCode\\\":\\\"SCREW20\\\"," +
                "\\\"policyStartDate\\\":\\\"" + todayDate + "\\\"," +
                "\\\"dateOfBirth\\\":\\\"" + dateOfBirth + "\\\",\\\"email\\\":\\\"" + email + "\\\"," +
                "\\\"isEmailOptIn\\\":true,\\\"residentSince\\\":\\\"2019-01-01\\\"," +
                "\\\"forenames\\\":\\\"" + firstName + "\\\",\\\"lastname\\\":\\\"" + lastName + "\\\"," +
                "\\\"phoneNumber\\\":\\\"+447000123456\\\"," +
                "\\\"correspondenceAddress\\\":{\\\"" + houseNumber + "\\\":\\\"34\\\"," +
                "\\\"addressLine1\\\":\\\"" + addressLine1 + "\\\"," +
                "\\\"addressLine2\\\":\\\"NEATH\\\",\\\"addressLine3\\\":\\\"\\\"," +
                "\\\"postcode\\\":\\\"" + postalCode + "\\\",\\\"country\\\":\\\"GB\\\"}," +
                "\\\"risks\\\":{\\\"cover\\\":{\\\"professions\\\":" + profession + "," +
                "\\\"turnover\\\":" + turnOver + ",\\\"noOfEmployee\\\":1," +
                "\\\"limitOfIndemnity\\\":" + lOI + ",\\\"businessName\\\":\\\"" + businessName + "\\\"," +
                "\\\"businessType\\\":\\\"LTD\\\",\\\"workingYear\\\":" + dayOfExperience + "}," +
                "\\\"mainCoverLiabilities\\\":{\\\"publicLiabilityIndemnity\\\":1000000}," +
                "\\\"declarations\\\":{\\\"bankrupt\\\":false,\\\"refused\\\":false,\\\"health\\\":false," +
                "\\\"convict\\\":false,\\\"court\\\":false,\\\"computer\\\":false,\\\"contract\\\":false," +
                "\\\"hazardous\\\":false,\\\"manufactureorfinance\\\":false,\\\"subcontractor\\\":false}}}\"\n" +
                "  }) {\n" +
                "    success\n" +
                "    errorCode\n" +
                "    errorMessage\n" +
                "    errors\n" +
                "    customerId\n" +
                "    policyId\n" +
                "    isNewCustomer\n" +
                "    policyReference\n" +
                "    policyEventNumber\n" +
                "    isReferred\n" +
                "    isDeclined\n" +
                "    declineReason\n" +
                "    productCode\n" +
                "    discountCode\n" +
                "    currency {\n" +
                "        id\n" +
                "        code\n" +
                "        symbol\n" +
                "        description\n" +
                "    }\n" +
                "    premiumDetails {\n" +
                "        insurancePremiumTaxAmount\n" +
                "        insurancePremiumTaxPercent\n" +
                "        loadDiscountAmount\n" +
                "        loadDiscount\n" +
                "        bookPremiumAmount\n" +
                "        insurerPremiumAmount\n" +
                "        maxDiscountedAmount\n" +
                "        premiumAlgAmount\n" +
                "        premiumProvisionalAmount\n" +
                "        totalPayableAmount\n" +
                "        discountAmount\n" +
                "        discountPercent\n" +
                "    }\n" +
                "    installmentDetails {\n" +
                "        depositFeeAmount\n" +
                "        depositAmount\n" +
                "        interestAmount\n" +
                "        interestRate\n" +
                "        paymentCount\n" +
                "        payableAmount\n" +
                "        totalPayableAmount\n" +
                "        code\n" +
                "    }\n" +
                "    preferredCollectionDay\n" +
                "    paymentDate\n" +
                "    excessTotal\n" +
                "    endorsementsHtml\n" +
                "    termsHtml\n" +
                "  }\n" +
                "}";
    }

    public String MultiCoverPayLoad(String PILOI, String postalCode, String CWCLOI, String HIPHiringCharge, String OPMarketValue, String NCB, String houseNumber, String businessName, String addressLine1,
                                    String TradeId, String PLLOI, String PLnoOfEmployees, String profession, String numberOfPeople) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String todayDate = dateFormat.format(today);
        dateFormat = null;
        today = null;

        return "query Query { getIndicativePrice(factors:{tradeId: "+ TradeId + ", noOfEmployees: "+ PLnoOfEmployees +"}, cover :{ PL: {\n" +
                "postCode: \""+ postalCode +"\",ncbRates:"+NCB+",\n" +
                "limitOfIndemnity:"+ PLLOI + "\n" +
                "},\n" +
                "EL: {\n" +
                "postCode: \""+ postalCode +"\",ncbRates:"+NCB+"\n" +
                "},\n" +
                "PI: {\n" +
                "postCode: \""+ postalCode +"\",ncbRates:"+NCB+",\n" +
                "limitOfIndemnity:"+PILOI+"\n" +
                "},\n" +
                "CWC: {\n" +
                "limitOfIndemnity:"+CWCLOI+"\n" +
                "},\n" +
                "OP: {\n" +
                "marketValue:"+OPMarketValue+"\n" +
                "},\n" +
                "HIP: {\n" +
                "hiringCharges:"+HIPHiringCharge+"\n" +
                "},\n" +
                "\n" +
                "\n" +
                "}, fullTimeEmployees:true,  certification:true) { success errorCode errorMessage covers { code preselect premiumDetails { amount        }    }  }}";
    }

    public String GetMetadatasTradeId(String email, String postalCode, String dateOfBirth, String firstName, String lastName, String payementType, String houseNumber, String businessName, String addressLine1,
                                      String TradeId, String lOI, String noOfEmployees, String profession, String numberOfPeople) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String todayDate = dateFormat.format(today);
        dateFormat = null;
        today = null;


        return "query Query {\n" +
                "  getMetadatas(meta: TRADE, search: \"\", productCode: PII partnerCode: null) {\n" +
                "    success\n" +
                "    errorCode\n" +
                "    errorMessage\n" +
                "    list {\n" +
                "        id\n" +
                "        code\n" +
                "        docType\n" +
                "        alphathree\n" +
                "        alphatwo\n" +
                "        description\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
    }
}

class JSON {
    public String ProfessionalIndemnityEc2(String email, String postalCode, String dateOfBirth, String Exp, String PLLOI, String NoEmployee, String PLYN, String ELYN, String addressLine1,
                                           String lOI, String turnOver, String dayOfExperience, String profession, String numberOfPeople) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        String todayDate = dateFormat.format(today);
        dateFormat = null;
        today = null;
        Map<String, String> loiType = new HashMap<>(Map.ofEntries(
                Map.entry("50000", "A"),
                Map.entry("100000", "B"),
                Map.entry("250000", "C"),
                Map.entry("500000", "D"),
                Map.entry("1000000", "E"),
                Map.entry("2000000", "F")
        ));
        Map<String, String> WorkYearExp = new HashMap<>(Map.ofEntries(
                Map.entry("0", "2023"),
                Map.entry("365", "2022"),
                Map.entry("730", "2021"),
                Map.entry("1095", "2020"),
                Map.entry("1460", "2019"),
                Map.entry("1835", "2018"),
                Map.entry("3650", "2013"),
                Map.entry("99999", "2012")
        ));
        Map<String, String> PLYesNO = new HashMap<>(Map.ofEntries(
                Map.entry("Y", "Yes"),
                Map.entry("N", "No")
        ));
        Map<String, String> ELYesNO = new HashMap<>(Map.ofEntries(
                Map.entry("Y", "Yes"),
                Map.entry("N", "No")
        ));
        Map<String, String> PLLOIValue = new HashMap<>(Map.ofEntries(
                Map.entry("1000000", "1"),
                Map.entry("2000000", "2")
        ));

        return "{\n" +
                "  \"fsaSaleType\": \"NON-ADV\",\n" +
                "  \"maxNumToStore\": 1,\n" +
                "  \"requestedQuoteGrade\": \"ALL\",\n" +
                "  \"risk\": {\n" +
                "    \"affinity\": \"TOOLBOX\",\n" +
                "    \"policyTypeCode\": \"C_GLPI\",\n" +
                "    \"preferredDeliveryMethod\": \"Download\",\n" +
                "    \"startDate\": \""+ todayDate +"T00:00:00Z\",\n" +
                "    \"proposer\": {\n" +
                "      \"dateOfBirth\": \"1990-02-16\",\n" +
                "      \"email\": \"customer4@toolboxbyadmiral.com\",\n" +
                "      \"gender\": \"NotKnown\",\n" +
                "      \"insuranceRefused\": false,\n" +
                "      \"nonRTAConviction\": false,\n" +
                "      \"maritalStatus\": \"NotKnown\",\n" +
                "      \"residentSince\": \"2019-01-01\",\n" +
                "      \"smoker\": false,\n" +
                "      \"name\": {\n" +
                "        \"title\": \"NotKnown\",\n" +
                "        \"forenames\": \"Joe\",\n" +
                "        \"surname\": \"Boe\",\n" +
                "        \"suffix\": \"\",\n" +
                "        \"salutation\": \"\"\n" +
                "      },\n" +
                "      \"fullTimeOccupation\": {\n" +
                "        \"empStatus\": \"NotKnown\",\n" +
                "        \"occupation\": \"NON\",\n" +
                "        \"employersBusiness\": \"NON\"\n" +
                "      },\n" +
                "      \"partTimeOccupation\": {\n" +
                "        \"empStatus\": \"NotKnown\",\n" +
                "        \"occupation\": \"NON\",\n" +
                "        \"employersBusiness\": \"NON\"\n" +
                "      },\n" +
                "      \"correspondenceAddress\": {\n" +
                "        \"houseNameOrNumber\": \"34\",\n" +
                "        \"addressLine1\": \"Edith Mills close,\",\n" +
                "        \"addressLine2\": \"NEATH\",\n" +
                "        \"addressLine3\": \"West Glamorgan\",\n" +
                "        \"addressLine4\": \"\",\n" +
                "        \"postcode\": \"SA11 2JL\",\n" +
                "        \"country\": \"GB\",\n" +
                "        \"abodeType\": \"NotKnown\",\n" +
                "        \"usage\": \"Main\"\n" +
                "      },\n" +
                "      \"telephoneNumbers\": [\n" +
                "        {\n" +
                "          \"number\": \"07000123456\",\n" +
                "          \"usage\": \"NotKnown\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"bespokeDetails\": {\n" +
                "      \"C_GLPI_DETAILS\": {\n" +
                "        \"C_GLPI_PROFESSIONSET\": [{ \"UDT_C_GLPI_PROF:PROFESSION_L\": \""+ profession +"\" }],\n" +
                "        \"UDT_C_GLPI_MAIN:BANKRUPT_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:BTYPE_L\": \"LTD\",\n" +
                "        \"UDT_C_GLPI_MAIN:BUSINESS_S\": \"ACME LTD\",\n" +
                "        \"UDT_C_GLPI_MAIN:CCJ_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:COMPUTER_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:CONTRACT_L\": \"Yes\",\n" +
                "        \"UDT_C_GLPI_MAIN:CONVICT_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:EL_L\": \""+ ELYesNO.get(ELYN) +"\",\n" +
                "        \"UDT_C_GLPI_MAIN:HAZARD_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:HEALTH_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:INDEMNITY_L\": \""+ loiType.get(lOI) +"\",\n" +
                "        \"UDT_C_GLPI_MAIN:PAYE_L\": \"Yes\",\n" +
                "        \"UDT_C_GLPI_MAIN:PEOPLE_L\": \""+ NoEmployee +"\",\n" +
                "        \"UDT_C_GLPI_MAIN:PL_L\": \""+ PLLOIValue.get(PLLOI) +"\",\n" +
                "        \"UDT_C_GLPI_MAIN:PUBLIC_L\": \""+ PLYesNO.get(PLYN) +"\",\n" +
                "        \"UDT_C_GLPI_MAIN:REFUSED_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:RETRO_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:RUNOFF_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:SERVICE_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:SUBC_L\": \"No\",\n" +
                "        \"UDT_C_GLPI_MAIN:TURNOVER_I\": "+ turnOver + ",\n" +
                "        \"UDT_C_GLPI_MAIN:WORKYEAR_I\": "+ WorkYearExp.get(Exp) + "\n" +
                "      },\n" +
                "      \"policyType\": \"C_GLPI\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

}