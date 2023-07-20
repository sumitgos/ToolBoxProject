package Covers.PublicLiability;

import Covers.GetElement;
import org.javatuples.Quartet;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class PublicLiabilityDetails {
	public WebDriver _driver;

	public PublicLiabilityDetails(WebDriver driver) {
		this._driver = driver;	}
	public Map<String, Quartet<String, String, String, String>> controlInfo = new HashMap<>(Map.ofEntries(
			Map.entry("GetQuote", new Quartet<>("Button", "XPath", "//*[contains(@Class,'styles__Typography-sc') and @mode and (text()='Get a quote')]", "5000")),
			Map.entry("What’s your current occupation?", new Quartet<>("TextBox", "XPath", "//*[contains(@id,'react-select') and @spellcheck]", "5000")),
			Map.entry("NextPage_Dy1", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "4000")),
			Map.entry("In what year was the business established?", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "2000")),
			Map.entry("How many years of experience do you have?", new Quartet<>("CustomComboBox", "XPath", "//*[contains(@id,'react-select') and contains(@id,'placeholder')]", "1000")),
			Map.entry("NextPage_Dy2", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "4000")),
			Map.entry("We just need some details about you.First Name", new Quartet<>("TextBox", "XPath", "//input[@placeholder='First name']", "1000")),
			Map.entry("We just need some details about you.Last Name", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Last name']", "1000")),
			Map.entry("We just need some details about you.DateBirth", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "1000")),
			Map.entry("What is your employment status?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "2000")),
			Map.entry("NextPage_Dy3", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "1000")),
			Map.entry("What’s your home address?", new Quartet<>("TextBox", "XPath", "//input[@name='postcode']", "2000")),
			Map.entry("What’s your home FindAddress?", new Quartet<>("Button", "XPath", "//span[text()='Find address']", "6000")),
			Map.entry("What’s your home SelectAddress?", new Quartet<>("Button", "XPath", "(//div[text()='Select'])[1]", "3000")),
			Map.entry("Select Manual Address", new Quartet<>("TextBox", "XPath", "//span[text()='Enter address manually']", "1000")),
			Map.entry("Select Manual AddressLine1", new Quartet<>("TextBox", "XPath", "//input[@name='addressLine1']", "1000")),
			Map.entry("Select Manual houseNameOrNumber", new Quartet<>("TextBox", "XPath", "//input[@name='houseNameOrNumber']", "1000")),
			Map.entry("Select Manual addressLine3", new Quartet<>("TextBox", "XPath", "//input[@name='addressLine3']", "1000")),
			Map.entry("Select Manual postcode", new Quartet<>("TextBox", "XPath", "//input[@name='postcode']", "1000")),
			Map.entry("NextPage_Dy4", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "5000")),
			Map.entry("What’s your business email address?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Email address']", "1000")),
			Map.entry("What’s your business confirm email address?", new Quartet<>("SpecialTextBox", "XPath", "//input[@placeholder='Confirm email address']", "1000")),
			Map.entry("What’s your business Mobile Number?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Mobile number' and contains(@class,'styles__Input')]", "1000")),
			Map.entry("What’s your business alternative Mobile Number?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Alternative number' and contains(@class,'styles__Input')]", "1000")),
			Map.entry("I agree to the T&Cs and Privacy Policy", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[5]", "1000")),
			Map.entry("marketing from Toolbox", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[6]", "1000")),
			Map.entry("NextPage_Dy5", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "15000")),
			Map.entry("Bankruptcy", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
			Map.entry("Past Insurance", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
			Map.entry("Criminal records", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[3]", "1000")),
			Map.entry("Health & safety records", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[4]", "1000")),
			Map.entry("NextPage_Dy6", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "6000")),
			Map.entry("Have you had any claims?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']","1000")),
			Map.entry("NextPage_Dy7", new Quartet<>("Button", "XPath", "//span[text()='Next Step']","1000")),
			Map.entry("Do you have a trading or company name?",  new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']","1000")),
			Map.entry("Do you have a limited company name?",  new Quartet<>("TextBox", "XPath", "//input[@placeholder='Add trading name']","1000")),
			Map.entry("NextPage_Dy8", new Quartet<>("Button", "XPath", "//span[text()='Next Step']","4000")),
			Map.entry("NextPage_Dy9", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "6000")),
			Map.entry("Do you have any parent or subsidiary companies?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("Is your parent or subsidiary company covered under this policy?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
			Map.entry("What is the name of your parent or subsidiary company?", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Add name']", "1000")),
			Map.entry("NextPage_Dy10", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "5000")),
			Map.entry("What is your business yearly turnover?", new Quartet<>("CustomTextBox", "XPath", "//*[contains(@class,'styles__Input')]", "1000")),
			Map.entry("NextPage_Dy11", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "4000")),
			Map.entry("Do you need contract? works cover?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("Contract value", new Quartet<>("TextBox", "XPath", "(//*[contains(@class,'styles__Input')])[3]", "1000")),
			Map.entry("What limit of indemnity do you require?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy12", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "7000")),
			Map.entry("What level of Public Liability cover do you require? cover do you require?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("Is all your work within the UK?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy13",  new Quartet<>("Button", "XPath", "//span[text()='Next Step']","5000")),
			Map.entry("Do you have a separate dedicated business premises? dedicated business premises?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']","1000")),
			Map.entry("NextPage_Dy14", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "6000")),
			Map.entry("Do you require hired in plant cover?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("What level of cover do you require?", new Quartet<>("TextBox", "XPath", "(//*[contains(@class,'styles__Input')])[6]", "1000")),
			Map.entry("What is the your estimated annual costs for hiring in plant?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy15", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "5000")),
			Map.entry("Do you require own plant cover?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "2000")),
			Map.entry("cover do you require?", new Quartet<>("TextBox", "XPath", "(//*[contains(@class,'styles__Input')])[6]", "1000")),
			Map.entry("What is the current total value of own plant equipment that you require cover for?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy16", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "5000")),
			Map.entry("Does your work involve any discharge of fumes, effluent or anything of a noxious nature?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
			Map.entry("Does your work involve the use of substances which could be harmful to health?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "2000")),
			Map.entry("NextPage_Dy17", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "7000")),
			Map.entry("Do you use any form of heat equipment?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "2000")),
			Map.entry("Please select the tools you are using", new Quartet<>("CheckBox", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy18",  new Quartet<>("Button", "XPath", "//span[text()='Next Step']","4000")),
			Map.entry("What is the maximum depth? at which work is undertaken?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]","1000")),
			Map.entry("What is the maximum height worked at?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "6000")),
			Map.entry("NextPage_Dy19", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "5000")),
			Map.entry("Is 3-phase work undertaken?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[1]", "1000")),
			Map.entry("Is any gas fitting or installation work undertaken?", new Quartet<>("RadioButton", "XPath", "(//span[text()='<Dy>'])[2]", "1000")),
			Map.entry("NextPage_Dy20", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "2000")),
			Map.entry("Do you require Employers Liability insurance?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy21", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "7000")),
			Map.entry("How many partners / principles /proprietors or directors perform manual work?", new Quartet<>("CustomComboBox", "XPath", "//*[contains(@id,'react-select') and contains(@id,'placeholder')]", "4000")),
			Map.entry("How many partners / principles /proprietors or directors perform non-manual work?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
			Map.entry("How many employees perform manual work?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
			Map.entry("How many employees perform administrative tasks or non-manual work?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "1000")),
			Map.entry("NextPage_Dy22", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "7000")),
			Map.entry("How many labour-only subcontractors do you have at any given time?", new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]", "3000")),
			Map.entry("How many bona fide subcontractors do you have at any given time?",  new Quartet<>("CustomComboBox", "XPath", "(//*[contains(@id,'react-select') and contains(@id,'placeholder')])[1]","1000")),
			Map.entry("NextPage_Dy23", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "5000")),
			Map.entry("Are all your employees paid below the PAYE threshold?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "2000")),
			Map.entry("Please provide your employer Reference Number (ERN)", new Quartet<>("TextBox", "XPath", "//input[@placeholder='Add ERN']", "2000")),
			Map.entry("NextPage_Dy24", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
			Map.entry("Do you require Professional Indemnity insurance?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "2000")),
			Map.entry("NextPage_Dy25", new Quartet<>("Button", "XPath", "//span[text()='Next Step']", "2000")),
			Map.entry("Do you currently hold a Professional Indemnity policy, with a retroactive date?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("What is your retroactive date?", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "1000")),
			Map.entry("NextPage_Dy26", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
			Map.entry("What level of Professional Indemnity cover do you require?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy27", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
			Map.entry("Do you undertake any structural, computer software or computer hardware design work?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy28", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
			Map.entry("Do you undertake any property management?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("Do you give any taxation advice?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy29", new Quartet<>("Button", "XPath", "//span[text()='Next']", "5000")),
			Map.entry("Do one or more of the business partners?", new Quartet<>("RadioButton", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("NextPage_Dy30", new Quartet<>("Button", "XPath", "//span[text()='Next']", "1000")),
			Map.entry("How do you want to pay?", new Quartet<>("Label", "XPath", "//span[text()='<Dy>']", "1000")),
			Map.entry("When do you want to start the cover?", new Quartet<>("SpecialTextBox", "XPath", "//*[contains(@Class,'styles__Input') and @spellcheck]", "4000")),
			Map.entry("Auto Renew", new Quartet<>("RadioButton", "XPath", "//span[text()='Continue to payment']", "1000")),
			Map.entry("NextPage_Dy31", new Quartet<>("Button", "XPath", "//span[text()='Next']", "18000")),
			Map.entry("I confirm I have read the above information", new Quartet<>("CheckBox", "XPath", "(//*[contains(@class,'styles__Input')])[2]", "1000")),
			Map.entry("Click Continue To Payment", new Quartet<>("Button", "XPath", "//span[text()='Continue to payment']", "9000")),
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
			Map.entry("CardHolderAddressLine1",new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderAddressLine1']", "1000")),
			Map.entry("PayCardHolder",new Quartet<>("TextBox", "XPath", "//input[@id='PayCardHolder']", "1000")),
			Map.entry("CardHolderPostcode",new Quartet<>("TextBox", "XPath", "//Input[@id='CardHolderPostcode']", "1000")),
			Map.entry("PayCardExpire", new Quartet<>("ComboBox", "XPath", "//select[@id='PayCardExpireSplitMM']", "1000")),
			Map.entry("ProposerIsCardHolder", new Quartet<>("RadioButton", "XPath", "//input[@id='ProposerIsCardHolderY']", "1000")),
			Map.entry("CardAutoReuseConsent", new Quartet<>("RadioButton", "XPath", "//input[@id='CardAutoReuseConsentN']", "1000")),
			Map.entry("nextbtn", new Quartet<>("Button", "XPath", "//button[@class='next btn btn-primary']", "10000"))
	));


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

}