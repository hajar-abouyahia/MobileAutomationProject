import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.communKeywords.verificationKeywords as verificationKeywords
import com.profileKeywords.changementDeMdpKeywords as changementDeMdpKeywords
import com.communKeywords.authentificationKeywords as AuthentificationKeyword
import com.communKeywords.apkKeywords as apkKeywords

def verificationKeyword = new verificationKeywords()
def editPasswordKeyword = new changementDeMdpKeywords()
def authkeyword = new AuthentificationKeyword()
def apkkeyword = new apkKeywords()

//Start application
apkkeyword.startApplication()

//Set Language to french
apkkeyword.setLanguage()
Mobile.delay(1)

//Set login credentials and connect
authkeyword.setAuthData(immatriculation,Mdp)
authkeyword.login()
authkeyword.CancelAuthorization()
// function to accesses the page to change the password
editPasswordKeyword.editPassword()
//String confirmerMdp = "Pca@2024"
// function that sets the new password data
editPasswordKeyword.setMdpData(mdpActuel, nvMdp, confirmerMdp)

//	Clear password Page Field
editPasswordKeyword.resetPwdPage()

// function that sets the new password data
editPasswordKeyword.setMdpData(mdpActuel, nvMdp, confirmerMdp)

//function to validate the edit password
editPasswordKeyword.validate()

//Alert wrong pwd should display
String alertPath = verificationKeyword.mdpActuelIncorrect
authkeyword.verifyalertPresent(alertPath, "Mot de passe d'identification du validateur incorrect")

// Click "ok" te return to edit password page 
editPasswordKeyword.PressOk()

Mobile.closeApplication()