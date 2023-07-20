package Covers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.*;

class ElementById {
    public WebElement GetElement(WebDriver driver, String controlIdentificationValue) {
        WebElement objWebElement = null;
        try {
            objWebElement = driver.findElement(By.id(controlIdentificationValue));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objWebElement;
    }
}


class ElementByClass {
    public WebElement GetElement(WebDriver driver, String controlIdentificationValue) {
        WebElement objWebElement = null;
        try {
            objWebElement = driver.findElement(By.className(controlIdentificationValue));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objWebElement;
    }
}

class ElementByName {
    public WebElement GetElement(WebDriver driver, String controlIdentificationValue) {
        WebElement objWebElement = null;
        try {
            objWebElement = driver.findElement(By.name(controlIdentificationValue));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objWebElement;
    }
}

class ElementByXPath {
    public WebElement GetElement(WebDriver driver, String controlIdentificationValue) {
        WebElement objWebElement = null;
        try {
            objWebElement = driver.findElement(By.xpath(controlIdentificationValue));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objWebElement;
    }
}

class ElementByTagName {
    public WebElement GetElement(WebDriver driver, String controlIdentificationValue) {
        WebElement objWebElement = null;
        try {
            objWebElement = driver.findElement(By.tagName(controlIdentificationValue));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objWebElement;
    }
}

class ElementByCss {
    public WebElement GetElement(WebDriver driver, String controlIdentificationValue) {
        WebElement objWebElement = null;
        try {
            objWebElement = driver.findElement(By.cssSelector(controlIdentificationValue));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objWebElement;
    }
}

class ElementByPartiallink {
    public WebElement GetElement(WebDriver driver, String controlIdentificationValue) {
        WebElement objWebElement = null;
        try {
            objWebElement = driver.findElement(By.partialLinkText(controlIdentificationValue));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return objWebElement;
    }
}

public class GetElement {
    public String GetActionElement(WebDriver driver, String controlType, String controlIdentification, String controlIdentificationValue, String controlValue) {
        String elementStatus = "";
        try {
            String className = "Covers." + (controlType.toLowerCase().equals("textbox") || controlType.toLowerCase().equals("customtextbox") ||
                    controlType.toLowerCase().equals("combobox") || controlType.toLowerCase().equals("specialcombobox") || controlType.toLowerCase().equals("specialtextbox") ||controlType.toLowerCase().equals("specialcustomcombobox") || controlType.toLowerCase().equals("customcombobox") ? controlType : "Other");

            Class<?> classRef = Class.forName(className);
            Method objMethod = classRef.getMethod("ProcessAction", WebDriver.class, String.class, String.class, String.class);
            Object classObject = classRef.newInstance();
            elementStatus = (String) objMethod.invoke(classObject, driver, controlIdentification, controlIdentificationValue, controlValue);

            classRef = null;
            objMethod = null;
            classObject = null;

            return elementStatus;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class Other {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class<?> classRef = Class.forName("Covers.ElementBy" + controlIdentification);
            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            objWebElement.click();

            classRef = null;
            objMethod = null;
            classObject = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class TextBox {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class classRef = Class.forName("Covers.ElementBy" + controlIdentification);
            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            objWebElement.click();
            Thread.sleep(2000);
            objWebElement.sendKeys(controlValue);
            Thread.sleep(3000);
            objWebElement.sendKeys(Keys.TAB);
            Thread.sleep(1000);

            classRef = null;
            objMethod = null;
            classObject = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class ComboBox {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class classRef = Class.forName("Covers.ElementBy" + controlIdentification);

            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            Select comboBox = new Select(objWebElement);
            comboBox.selectByValue(controlValue);

            classRef = null;
            comboBox = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class SpecialComboBox {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class classRef = Class.forName("Covers.ElementBy" + controlIdentification);

            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            objWebElement.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[text()='" + controlValue + "']")).click();
            Thread.sleep(2000);

            classRef = null;
            objWebElement = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class SpecialTextBox {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class classRef = Class.forName("Covers.ElementBy" + controlIdentification);

            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            objWebElement.click();
            Thread.sleep(1000);
            objWebElement.sendKeys(controlValue);
            Thread.sleep(2000);
            objWebElement.sendKeys(Keys.ESCAPE);
            Thread.sleep(1000);

            classRef = null;
            objWebElement = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class CustomComboBox {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class classRef = Class.forName("Covers.ElementBy" + controlIdentification);

            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            objWebElement.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[contains(@id,'react-select')and contains(@id,'listbox')]//child::*[contains(text(),'" + controlValue + "')]")).click();
            Thread.sleep(2000);

            classRef = null;
            objWebElement = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class SpecialCustomComboBox {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class classRef = Class.forName("Covers.ElementBy" + controlIdentification);

            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            objWebElement.click();
            Thread.sleep(2000);
            //objWebElement =null;

            objWebElement = (WebElement) objMethod.invoke(classObject, driver, "//*[contains(@id,'react-select')and contains(@id,'listbox')]//following::*[contains(text(),'" + controlValue + "')]");
            objWebElement.click();

            //driver.findElement(By.xpath("//*[contains(@id,'react-select')and contains(@id,'listbox')]//following::*[contains(text(),'" + controlValue + "')]")).click();
            Thread.sleep(2000);

            classRef = null;
            objWebElement = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}

class CustomTextBox {
    public String ProcessAction(WebDriver driver, String controlIdentification, String controlIdentificationValue, String controlValue) {
        try {

            Class classRef = Class.forName("Covers.ElementBy" + controlIdentification);
            Method objMethod = classRef.getMethod("GetElement", WebDriver.class, String.class);
            Object classObject = classRef.newInstance();
            WebElement objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);

            objWebElement.click();
            Thread.sleep(1000);
            objWebElement =null;
            objWebElement = (WebElement) objMethod.invoke(classObject, driver, controlIdentificationValue);
            objWebElement.sendKeys(controlValue);

            classRef = null;
            objMethod = null;
            classObject = null;

            return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}



