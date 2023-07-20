package API.ApiManager;

import API.Util.Payload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.cucumber.messages.JSON;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.JsonSerializer;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import API.Util.ApiHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.javatuples.Quintet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;


import java.util.*;
import java.util.concurrent.TimeUnit;

class Post {
    public String ProcessAction(String baseUri, String payloadValue, String payloadValue2, String payloadValue3, String payloadValue4, String payloadValue5, String payloadValue6, String payloadValue7, String payloadValue8, String payloadValue9,
                                String payloadValue10, String payloadValue11, String payloadValue12, String payloadValue13, String payloadValue14) {
        String response = "";
        try {
            ApiHelper objApiHelper = new ApiHelper();
            Payload objPayLoad = new Payload();
            Response objResponse = null;

//            RestAssured.baseURI = baseUri.split("_")[0];

            var apiInfo = objPayLoad.ApiInfo.get(baseUri);
            String payLoad = objPayLoad.GetPayload(baseUri, payloadValue, payloadValue2, payloadValue3, payloadValue4, payloadValue5, payloadValue6, payloadValue7, payloadValue8,
                    payloadValue9, payloadValue10, payloadValue11, payloadValue12, payloadValue13, payloadValue14);

            String jsonString = apiInfo.getValue1().toLowerCase().equals("json") ? payLoad : objApiHelper.graphqlToJson(payLoad);

            Map<String, String> headers = new HashMap<>();
            if (!apiInfo.getValue2().equals("")) {
                for (String hearderValues : apiInfo.getValue2().split("\\|")) {
                    headers.put(hearderValues.split(":")[0], hearderValues.split(":")[1]);
                }
            }

            RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(baseURI).addHeaders(headers).build();

            if (apiInfo.getValue4().toLowerCase().contains("auth")) {
                var authApiInfo = objPayLoad.ApiInfo.get(apiInfo.getValue4().split("\\|")[1]);
                Map<String, String> authResponse = new HashMap<>();
                switch (authApiInfo.getValue0().toLowerCase()) {
                    case "urlencoded":
                        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                        Date preTime = dateFormat.parse(System.getProperty("PreTime"));

                        if (dateFormat.parse(System.getProperty("CurrTime")).after(preTime) || !System.getProperties().containsKey("Token")) {
                            authResponse = GetAuthUrlEncoded(apiInfo.getValue4().split("\\|")[1], authApiInfo);
                            System.setProperty("Token", authResponse.get(authApiInfo.getValue3().split("\\|")[0].toString()));

                            Calendar cal = Calendar.getInstance();
                            cal.setTime(dateFormat.parse(System.getProperty("CurrTime")));
                            cal.add(Calendar.MINUTE, 40);
                            System.setProperty("PreTime", dateFormat.format(cal.getTime()));
                            cal = null;
                        }
                        objResponse = given().log().all().auth().oauth2(System.getProperty("Token")).headers(headers).body(jsonString).when().post(baseUri.split("_")[0]).then().extract().response();

                        dateFormat = null;
                        preTime = null;
                        break;
                }

                authApiInfo = null;

            } else
                objResponse = given().log().all().spec(requestSpec).body(jsonString).when().post(baseUri.split("_")[0]).then().extract().response();

            response = objResponse.asPrettyString();

            System.setProperty("ResponseTime", String.valueOf(objResponse.getTimeIn(TimeUnit.MILLISECONDS)));

            jsonString = "";
            objApiHelper = null;
            payLoad = "";
            requestSpec = null;
            objPayLoad = null;
            headers = null;
            objResponse = null;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }

    private Map<String, String> GetAuthUrlEncoded(String uri, Quintet<String, String, String, String, String> apiInfo) {
        Map<String, String> authValues = new HashMap<>();
        try {
            Map<String, String> formParams = new HashMap<>();
            for (String formValues : apiInfo.getValue1().split("\\|")) {
                formParams.put(formValues.split(";")[0], formValues.split(";")[1]);
            }
            RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(uri).setContentType(ContentType.URLENC).addFormParams(formParams).build();

            String authResponse = given().log().all().auth().preemptive().basic(apiInfo.getValue2().split("\\|")[0].split(":")[1], apiInfo.getValue2().split("\\|")[1].split(":")[1])
                    .spec(requestSpec).when().post().then().extract().response().asString();

            JsonPath authJSon = new JsonPath(authResponse);
            for (String authResponseValue : apiInfo.getValue3().split("\\|")) {
                authValues.put(authResponseValue, authJSon.getString(authResponseValue));
            }

            requestSpec = null;
            authJSon = null;
            authResponse = "";
            formParams = null;
            apiInfo = null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return authValues;
    }
}


class Put {
    public Map<String, String> ProcessAction() {
        Map<String, String> responseData = new HashMap<>();
        try {
            ApiHelper objApiHelper = new ApiHelper();
            FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
            Properties objProperties = new Properties();
            objProperties.load(fileInput);
            Payload objPayLoad = new Payload();

            RestAssured.baseURI = System.getenv("BaseUri") != null ? System.getenv("BaseUri") : objProperties.getProperty("BaseUri");
            var apiInfo = objPayLoad.ApiInfo.get(RestAssured.baseURI.toString());
            RequestSpecification requestSpec = apiInfo.getValue3() != "" ?
                    new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).addHeader("x-api-key", apiInfo.getValue2()).addHeader("User-Agent", apiInfo.getValue3()).build() :
                    new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).addHeader("x-api-key", apiInfo.getValue2()).build();

            String response = given().log().all().spec(requestSpec).when().get().then().extract().response().asString();

            JsonPath responseJSon = objApiHelper.RawToJson(response);

            if (!response.contains("\"errorCode\":500")) {
                for (String responsevaluePath : apiInfo.getValue4().split("\\|")) {
                    responseData.put(responsevaluePath.split(":")[0].toString(), responseJSon.get(responsevaluePath.split(":")[1]).toString());
                }
            }

            responseJSon = null;
            objApiHelper = null;
            requestSpec = null;
            fileInput = null;
            objProperties = null;
            objPayLoad = null;


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return responseData;

    }
}

class Get {
    public Map<String, String> ProcessAction() {
        Map<String, String> responseData = new HashMap<>();
        try {
            ApiHelper objApiHelper = new ApiHelper();
            FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
            Properties objProperties = new Properties();
            objProperties.load(fileInput);
            Payload objPayLoad = new Payload();

            RestAssured.baseURI = System.getenv("BaseUri") != null ? System.getenv("BaseUri") : objProperties.getProperty("BaseUri");
            var apiInfo = objPayLoad.ApiInfo.get(RestAssured.baseURI.toString());
            RequestSpecification requestSpec = apiInfo.getValue3() != "" ?
                    new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).addHeader("x-api-key", apiInfo.getValue2()).addHeader("User-Agent", apiInfo.getValue3()).build() :
                    new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).addHeader("x-api-key", apiInfo.getValue2()).build();

            String response = given().log().all().spec(requestSpec).when().get().then().extract().response().asString();

            JsonPath responseJSon = objApiHelper.RawToJson(response);

            if (!response.contains("\"errorCode\":500")) {
                for (String responsevaluePath : apiInfo.getValue4().split("\\|")) {
                    responseData.put(responsevaluePath.split(":")[0].toString(), responseJSon.get(responsevaluePath.split(":")[1]).toString());
                }
            }

            responseJSon = null;
            objApiHelper = null;
            requestSpec = null;
            fileInput = null;
            objProperties = null;
            objPayLoad = null;


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return responseData;
    }
}

public class APIProcessor {
    public String ProcessApi(String baseUri, String httpMethod, String payloadValue, String payloadValue2, String payloadValue3, String payloadValue4, String payloadValue5, String payloadValue6, String payloadValue7, String payloadValue8, String payloadValue9,
                             String payloadValue10, String payloadValue11, String payloadValue12, String payloadValue13, String payloadValue14) {
        String responseData = "";
        try {
            Class<?> classRef = Class.forName("API.ApiManager." + httpMethod);
            Method objMethod = classRef.getMethod("ProcessAction", String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class,
                    String.class, String.class, String.class, String.class, String.class);
            Object classObject = classRef.newInstance();
            responseData = (String) objMethod.invoke(classObject, baseUri, payloadValue, payloadValue2, payloadValue3, payloadValue4, payloadValue5, payloadValue6, payloadValue7, payloadValue8, payloadValue9, payloadValue10,
                    payloadValue11, payloadValue12, payloadValue13, payloadValue14);

            classRef = null;
            objMethod = null;
            classObject = null;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return responseData;
    }
}