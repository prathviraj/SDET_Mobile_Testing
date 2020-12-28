package Practice.AppiumFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Capability {

	protected static String appPackage;
	protected static String appActivity;
	protected static String deviceName;
	protected static String chromedriverExecutable;
	public AppiumDriverLocalService service;
	// creating this method to start my appium through nodejs // this is given by appium server
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkifserverisRunning(4723);
		if(!flag)
		{		
		//service = AppiumDriverLocalService.buildDefaultService();
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                  .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                 .withAppiumJS(new File("C:\\Users\\PrathvirajMeenkeri\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723));	
		service.start();
		}
		return service;		
	}
	
	public static boolean checkifserverisRunning(int port)
    {
        boolean isserverRunning = false;
        ServerSocket serverSocket;
        try
        {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }
        catch (Exception e) {
            isserverRunning= true;
        }
        finally {
            serverSocket=null;
        }
        return isserverRunning;
    }
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Emulator.bat");
		   Thread.sleep(8000);
	}
	
	public static AndroidDriver<AndroidElement> Capability(String appPackage, String appActivity,String deviceName,String chromedriverExecutable) throws IOException, InterruptedException {
		FileReader fis = new FileReader(System.getProperty("user.dir")+"//src//main//java//global.properties");
		Properties Pro = new Properties();
		Pro.load(fis);
		appPackage = Pro.getProperty("appPakcage");
		appActivity = Pro.getProperty("appActivity");
		deviceName = Pro.getProperty("deviceName");
		if(deviceName.contains("prathviraj"))
		{
			startEmulator();
		}
		
		chromedriverExecutable = Pro.getProperty("chromedriverExecutable");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android prathviraj");        
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\PrathvirajMeenkeri\\Desktop\\Prathvi\\IBM Training\\SDET\\Appium\\chromedriver_win32\\chromedriver.exe");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");        
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;

	}

}
