package rahulshettyacademy.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;

    @BeforeTest
    public void config() {
        //ExtentReports , ExtentSparkReporter
        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Achmad Fikry");
    }

    @Test
    public void initialDemo(){
        ExtentTest test = extent.createTest("Initial Demo");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
//        test.addScreenCaptureFromBase64String(driver.getPageSource());
        driver.close();
        test.fail("Result do not match");
        extent.flush();
    }
}
