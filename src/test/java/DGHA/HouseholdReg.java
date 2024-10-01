package DGHA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HouseholdReg extends SetUp{
	
public ExtentTest test;
	
	@Test
	public void house() throws InterruptedException {
		
		//loginToApp();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'খানা নিবন্ধন']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'ইউনিয়ন/ জোন *']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'ZONE-02']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'পুরাতন ওয়ার্ড *']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'NO OLD WARD']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'নতুন ওয়ার্ড *']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'DNCC:WARD 06']")).click();
		
		
		//sub-block site
		driver.findElement(By.xpath("//android.widget.TextView[@text='সাব-ব্লক/ সাইট *']")).click();
		selectDropdownItemByIndex(4);
 
        
		//Scroll to "স্থায়ী ঠিকানা কি একই"
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"স্থায়ী ঠিকানা কি একই *\"));"));
        
        //Choose if permanent address is same or not
        driver.findElement(By.xpath("//android.widget.TextView[@text='স্থায়ী ঠিকানা কি একই *']")).click();
        
        driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();
        
        //HH head name
        driver.findElement(By.xpath("//android.widget.EditText[@text='পরিবারের প্রধানের নাম এর প্রথম অংশ (ইংরেজীতে) *']")).sendKeys("Helena");
        
        //Mobile Number
        driver.findElement(By.xpath("//android.widget.EditText[@text='পরিবারের গুরুত্বপূর্ণ মোবাইল নাম্বার *']")).sendKeys("01634563742");
        
        //Family member count
        driver.findElement(By.xpath("//android.widget.EditText[@text='খানার মোট সদস্য সংখ্যা *']")).sendKeys("5");
        
        //scroll down to last
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"জমা দিন\"));"));

        // Locate the 'জমা দিন' button and click it
        WebElement submitButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='জমা দিন']"));
        submitButton.click();
        
        //submit Button
        //driver.findElement(By.id("org.smartregister.unicef.mis:id/next")).click();
        //Wait for sync to finish
        Thread.sleep(15000);
        
      //Click on side menu
        driver.findElement(AppiumBy.accessibilityId("Open")).click();
        
        //Sync
        driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id= 'org.smartregister.unicef.mis:id/action_family']")).click();
        
        //Wait for sync to finish
        Thread.sleep(15000);
		
		
		
	}

}
