package Utilities;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.javatuples.Quintet;
import org.openqa.selenium.WebDriver;

public class CommonFuntionsLib {
	public WebDriver Driver;

	public CommonFuntionsLib(WebDriver driver) {
		this.Driver = driver;
	}
	ExcelReader _objExcelReader = new ExcelReader();
	public void SwitchWindowToChild() {
		Set<String> listWindows = Driver.getWindowHandles();
		Iterator<String> windowsIterator = listWindows.iterator();
		windowsIterator.next();
		String childWindow = windowsIterator.next();
		Driver.switchTo().window(childWindow);
	}

	public List<Map<String, String>> GetExcelData(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = _objExcelReader.GetSheetByName(excelFilePath, sheetName);
		return _objExcelReader.ReadSheet(sheet);
	}

	public void PublishReport(List<Quintet<String, String, String, String, String>> excelData, String columnNames, String fileName){
		_objExcelReader.CreateExcel(excelData,columnNames, fileName);
	}

	public void PublishReportWithMapList(List<Map<String, String>> resultData, String columnNames, String fileName){
		_objExcelReader.CreateExcelWithListMap(resultData,columnNames, fileName);
	}
}