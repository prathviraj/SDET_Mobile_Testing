package Practice.AppiumFramework;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class TC_01 extends Capability {
	
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws IOException, InterruptedException
	{
		service = startServer();
		driver = Capability(appPackage,appActivity,deviceName,chromedriverExecutable);
	}

//Khans Academy
	@Test(enabled=false)
	public void KATestCase2() throws IOException, InterruptedException
	{
		service = startServer();
		Thread.sleep(5000);
		driver = Capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		Thread.sleep(5000);
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		driver.findElement(By.xpath("//*[@text='Continue with Google']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='prathviraj.s.m@gmail.com']")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Settings"));		
		Thread.sleep(5000);
		service.stop();
		
	}
	
	@Test(enabled=false) //Khans Academy 
	public void KATestCase1() throws IOException, InterruptedException
	{
		service = startServer();
		Thread.sleep(5000);
		driver = Capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		Thread.sleep(5000);
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		driver.findElement(By.xpath("//*[@text='Continue with Google']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='prathviraj.s.m@gmail.com']")).click();
		Thread.sleep(5000);
		
		 driver.findElement(By.xpath("//*[@text='Join class']")).click();
		
		 Thread.sleep(10000);
		 driver.findElement(By.className("android.widget.EditText")).sendKeys(
		 "prathviraj.s.m@gmail.com"); Thread.sleep(9000); driver.hideKeyboard();
		 Thread.sleep(5000);
		 //driver.findElements(By.className("android.widget.Button")).get(2);
		 Thread.sleep(3000); driver.findElement(By.xpath("//*[@text='ADD']")).click();
		service.stop();
		
	}
	
	
	@Test(enabled=false)
	public void TestCase1() throws IOException, InterruptedException
	{
		service = startServer();
		driver = Capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
        String Expected = "India";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}
	
	@Test(enabled=false)
	public void TestCase2() throws MalformedURLException
	{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //i am passing data to the name field using id and sendkeys
        //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
        String Expected = "India";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();  
        String errormsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(errormsg);
        String expected = "Please enter your name";
        Assert.assertEquals(errormsg, expected);
	}
	
	@Test(enabled=false)
	public void TestCase3() throws InterruptedException, IOException
	{
		driver = Capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='Australia']")).getText();
        String Expected = "Australia";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();  	
        
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(textMatches(\"Air Jordan 9 Retro\").instance(2))");
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.println(count);
        // Know i want to click on the element which i wanted
        for(int i=1;i<count;i++)
        {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equals("Air Jordan 9 Retro"))
            {
                System.out.println(productName);
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).getText();
                driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
                break;
            }         
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000); 
        String checkoutname = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Thread.sleep(3000); 
        String expectedname = "Air Jordan 9 Retro";
        Assert.assertEquals(expectedname, checkoutname);      
	}
	@Test
	public void TestCase4() throws InterruptedException, IOException
	{
	service.start();
	driver = Capability(appPackage,appActivity,deviceName,chromedriverExecutable);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //i am passing data to the name field using id and sendkeys
    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
    //i want to select the radio button which is female // i want to use xpath
    driver.findElement(By.xpath("//*[@text='Female']")).click();
    // i have to work with drop down
    //i will click on the value which is by default 
    driver.findElement(By.id("android:id/text1")).click();
    //then scroll and select india
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
    //i want to verify(assert) to check the country is selected
    String country = driver.findElement(By.xpath("//*[@text='Australia']")).getText();
    String Expected = "Australia";
    Assert.assertEquals(country, Expected);
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();  
    driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
    driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
    Thread.sleep(3000);
    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    Thread.sleep(3000);
    
		/*
		 * String amount1 =
		 * driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).
		 * get(0).getText(); amount1 = amount1.substring(1); double amount1value =
		 * Double.parseDouble(amount1); System.out.println(amount1); Thread.sleep(8000);
		 * 
		 * String amount2 =
		 * driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).
		 * get(1).getText(); amount2 = amount2.substring(1); double amount2value =
		 * Double.parseDouble(amount2); System.out.println(amount2); Thread.sleep(8000);
		 * 
		 * //Sum double TotalAmount = amount1value + amount2value; String finalamount =
		 * driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
		 * .getText(); finalamount = finalamount.substring(1); double FinalTotal =
		 * Double.parseDouble(finalamount);
		 * 
		 * Assert.assertEquals(FinalTotal, TotalAmount);
		 */  
    
 // Tap
    Thread.sleep(8000);
    AndroidElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
    TouchAction t = new TouchAction(driver);
    t.tap(tapOptions().withElement(element(checkbox))).perform();    
    Thread.sleep(5000);
    AndroidElement terms =driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
    t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();
    Thread.sleep(5000);
    System.out.println(driver.findElement(By.id("android:id/message")).getText());
    driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    Thread.sleep(5000);
    
    Set<String> contextNames = driver.getContextHandles();
    for (String contextName : contextNames) {
        System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
    }
    Thread.sleep(5000);
    driver.context("WEBVIEW_com.androidsample.generalstore");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
    driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.RETURN);
    Thread.sleep(5000);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
    Thread.sleep(5000);
    driver.context("NATIVE_APP");
    service.stop();
    
	}
	
}
