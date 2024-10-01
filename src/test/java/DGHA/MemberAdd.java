package DGHA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

import java.time.Duration;
import java.util.List;

public class MemberAdd extends SetUp {

    @Test
    public void searchAndClickLatestHousehold() throws InterruptedException {
        //loginToApp(); 

        String householdNameToSearch = "Helena"; 
        searchAndClickHousehold(householdNameToSearch);
    }

    // Method to search for the latest created household by name and click it
    public void searchAndClickHousehold(String householdName) {
    	
        // Locate the search input field and enter the household name
    	WebElement searchInput = driver.findElement(By.xpath("//android.widget.EditText[@text='নাম বা আইডি বা মোবাইল নম্বর দ্বারা অনুসন্ধান করুন']"));
        searchInput.sendKeys(householdName);

        // Allow some time for the results to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Locate the list of households (assuming the results are in a RecyclerView or ListView)
        WebElement listView = driver.findElement(By.className("android.support.v7.widget.RecyclerView"));
        List<WebElement> households = listView.findElements(By.className("android.widget.RelativeLayout"));
        

        // Assuming the latest created household is the first one in the list after searching
        if (!households.isEmpty()) {
            WebElement latestHousehold = households.get(0); // Get the first household
            clickElement(latestHousehold); // Click on the household
            
        //Click and fill up form
            
         //click 5+ year member   
         driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"org.smartregister.unicef.mis:id/add_member\"]")).click();
         //New ID registration
         driver.findElement(By.id("org.smartregister.unicef.mis:id/id_less_btn")).click();
         
         //Identity check
         driver.findElement(By.xpath("//android.widget.CheckBox[@text=\"আইডি কার্ড নেই\"]")).click();
         
         //Relation with head
         driver.findElement(By.id("android:id/text1")).click();
         driver.findElement(By.xpath("//android.widget.TextView[@text=\"কন্যা\"]")).click();
         
         //First name
         driver.findElement(By.xpath("//android.widget.EditText[@text=\"নামের প্রথম অংশ (ইংরেজীতে) *\"]")).sendKeys("Rehana");
         
         //Mobile no
         driver.findElement(By.xpath("//android.widget.EditText[@text=\"মোবাইল নম্বর *\"]")).sendKeys("01334567897");
         
         //Scroll down to last
         driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"রক্তের গ্রুপ\"));"));
         
         //Birth date
 		driver.findElement(By.xpath("//android.widget.TextView[@text=\"জন্ম তারিখ জানা আছে কি? *\"]")).click();
 		driver.findElement(By.xpath("//android.widget.TextView[@text='না']")).click();
 		
         //Select age
 		driver.findElement(By.xpath("//android.widget.EditText[@text=\"বয়স লিখুন (বছর) *\"]")).sendKeys("25");
 		
 		
 		 //Gender
 		 driver.findElement(By.xpath("//android.widget.TextView[@text='লিঙ্গ *']")).click();
 		 selectDropdownItemByIndex(2);
 		 
 		 //Martial Status
 		 driver.findElement(By.xpath("//android.widget.TextView[@text=\"বৈবাহিক অবস্থা *\"]")).click();
 		 driver.findElement(By.xpath("//android.widget.TextView[@text=\"বিবাহিত\"]")).click();
 		 
 		 
 		//Scroll down to last
         driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"জমা দিন\"));"));
         
         //Handicap status
         driver.findElement(By.xpath("//android.widget.TextView[@text=\"প্রতিবন্ধী\"]")).click();
         driver.findElement(By.xpath("//android.widget.TextView[@text=\"না\"]")).click();
         
         //Blood group
         driver.findElement(By.xpath("//android.widget.TextView[@text=\"রক্তের গ্রুপ\"]")).click();
         selectDropdownItemByIndex(2);
         
         
 	    //submit Button
 	       driver.findElement(By.className("android.widget.Button")).click();
 		 
          }
    }
    
    @Test(dependsOnMethods = "searchAndClickLatestHousehold")
    public void fillPregnancyRegistration() {
    	
        // Click on the pregnancy registration button
        driver.findElement(By.id("org.smartregister.unicef.mis:id/patient_name_age")).click();
        

        // last period date
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"শেষ মাসিকের তারিখ *\"]")).click();
        List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
        buttons.get(1).click();  // Click month
        driver.findElement(By.id("org.smartregister.unicef.mis:id/ok_button")).click();  // Confirm date selection
        

        // Number of previous pregnancies
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"পূর্বে কতবার অন্তঃসত্ত্বা হয়েছেন *\"]")).sendKeys("1");
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"কতজন জীবিত সন্তান জন্ম হয়েছে? *\"]")).sendKeys("1");

        // Previous pregnancy history
        selectCheckbox("সিজারের ইতিহাস আছে"); // Example: Cesarean Section
        selectCheckbox("উচ্চ রক্তচাপের ইতিহাস আছে"); // Example: Hypertension
        
      //Scroll down to last
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"জমা দিন\"));"));
        
        //Previous medical record
        selectCheckbox("থ্যালাসেমিয়া আছে"); 
        
        // Submit Button for Pregnancy Registration
        driver.findElement(By.className("android.widget.Button")).click();
    }

}
