package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import DBLayer.DBExecutor;
import org.openqa.selenium.WebDriver;

import StepDefinition.PageObjectManager;

//import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver Driver;
	public TestBase ObjTestBase;
	public CommonFuntionsLib ObjCommonFunctionLib;
	public Properties ObjProperties;
	public Helper ObjHelper;
	public PageObjectManager ObjPageObjectManager;
	public DBExecutor ObjDBExecutor;

	public TestContextSetup() throws IOException {
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
		ObjTestBase = new TestBase();
		Driver = ObjTestBase.WebDriverManager();
		ObjCommonFunctionLib = new CommonFuntionsLib(Driver);
		ObjPageObjectManager = new PageObjectManager(Driver);
		ObjProperties = new Properties();
		ObjProperties.load(fileInput);
		ObjHelper = new Helper();
		fileInput = null;
		ObjDBExecutor = new DBExecutor();
	}
}
