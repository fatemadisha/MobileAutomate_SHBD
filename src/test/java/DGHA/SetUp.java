package DGHA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class SetUp 
{	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	public WebElement listView;
    public List<WebElement> listItems;
	
		
		@BeforeClass
public void genericRun() throws MalformedURLException{
		
		//create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Mobile2");
		options.setApp("C:\\Users\\Kaniz\\eclipse-workspace\\DGHA\\src\\test\\java\\Apk\\opensrp-mis-unicef-19.166-debug.apk");
		
		// Keep session and avoid clearing cache
        options.setCapability(MobileCapabilityType.NO_RESET, true);  // Prevent clearing app data
        options.setCapability(MobileCapabilityType.FULL_RESET, false);  // Avoid reinstalling the app
		
//create object for android user
		driver = new AndroidDriver(new URL("http://192.168.22.38:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}	
public void loginToApp() throws InterruptedException {
		
		// Login
	    driver.findElement(By.id("org.smartregister.unicef.mis:id/login_user_name_edit_text")).sendKeys("dnccw06team4");
	    driver.findElement(By.id("org.smartregister.unicef.mis:id/login_password_edit_text")).sendKeys("123456");
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"org.smartregister.unicef.mis:id/login_login_btn\"]")).click();
		Thread.sleep(150000);
		}
		
//Common method to find an element
protected WebElement findElementById(String id) {
    return driver.findElement(By.id(id));
}

// Common method to click an element
protected void clickElement(WebElement element) {
    element.click();
}

//Reusable method to select drop-down by index
public void selectDropdownItemByIndex(int index) {
    
    // Locate the ListView element and initialize listItems
    listView = driver.findElement(By.className("android.widget.ListView"));
    listItems = listView.findElements(By.className("android.widget.TextView"));
    
    // Select the item by index, make sure the index is within bounds
    if (index < listItems.size()) {
        listItems.get(index).click();
    } else {
        System.out.println("Index out of bounds for dropdown selection");
    }
}

public void selectCheckbox(String checkboxText) {
    try {
        WebElement checkbox = driver.findElement(By.xpath("//android.widget.CheckBox[@text='" + checkboxText + "']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    } catch (Exception e) {
        System.out.println("Checkbox not found: " + checkboxText);
    }
}
	@AfterClass
	public void tearDown() {
		
		// Close the driver and stop the Appium service
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }

		
	}
}

