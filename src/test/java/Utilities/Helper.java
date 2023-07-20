package Utilities;

//import Covers.PublicLiability.PublicLiabilityDetails;
import org.javatuples.Quintet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Helper {
    public void CloseCookiesPopup(WebDriver driver) {
        try {
            driver.findElement(By.xpath("//*[@id='cky-btn-accept']")).click();
            Thread.sleep(2000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String SpecialHandling(WebDriver driver, String questionName, String controlValue) {
        String value = "";
        try {
            if (questionName.toLowerCase().contains("want to start the cover")) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                Date today = Calendar.getInstance().getTime();
                value = dateFormat.format(today);
                dateFormat = null;
                today = null;
            }
            return value;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }

    }
