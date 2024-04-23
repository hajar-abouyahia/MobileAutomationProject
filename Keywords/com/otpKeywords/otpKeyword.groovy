package com.otpKeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
/**
 * @author CHIRAG
 *
 */
public class OtpVerification {

	AndroidDriver<MobileElement> driver;
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "sdk_gphone64_x86_64");
		cap.setCapability("app", "C:\\Users\\DELL\\Downloads\\Bulls_Rent-master\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void insertOTPValue() {
		String otpValue = getOTP();
		System.out.println("OTP VALUE : "+otpValue);
	}


	public String getOTP() {
		//messaging application
		driver.startActivity("com.android.messaging", "com.android.messaging.ui.conversationlist.ConversationListActivity");
		String getOTPValue = driver.findElementById("com.android.messaging:id/conversation_snippet").getText().split(":")[1].trim();

		//
		String message = driver.findElementById("com.android.messaging:id/conversation_snippet").getText();
		// Extract the OTP code from the message
		String getOTPValu = message.split(":")[1].split("\\.")[0].trim();


		return getOTPValue;
	}

	public void tearDown() {
		driver.quit();
	}
	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		OtpVerification obj = new OtpVerification();
		obj.setup();
		obj.insertOTPValue();
		obj.tearDown();
	}
}
