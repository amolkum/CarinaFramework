package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.Screenshot;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager extends ExtentManager implements IAbstractTest{

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    public static ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<String> categoryName = new ThreadLocal<>();
    byte[] encoded=null;

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public synchronized static void createTest(String testName, String description) {
        extentTestMap.put((int) Thread.currentThread().getId(), extent.createTest(testName, description));
    }

    public static ThreadLocal<String> getCategoryName() {
        return categoryName;
    }

    public static void setCategoryName(String categoryName) {
        getCategoryName().set(categoryName);
    }

    public synchronized static void reporterLog(String log) {
        if (ExtentTestManager.getTest() != null) {
                ExtentTestManager.getTest().log(Status.PASS, log);
            Reporter.log(log + "<br/>");
        }}
    public void attachAScreenshot() throws WebDriverException, IOException {
    	File file =(File)((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
    	encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
    }
    public  String captureScreen() throws IOException {
    	//Screenshot screenshot =new Screenshot();
    	//File file = screenshot.getScreenshotAs(OutputType.FILE);
    	TakesScreenshot screen = (TakesScreenshot) getDriver();
    	File src = screen.getScreenshotAs(OutputType.FILE);
    	String dest ="C:\\Carina\\project-qa\\Automation_Reports\\Screenshots"+".png";
    	File target = new File(dest);
    	FileUtils.copyFile(src, target);
    	return dest;}
}