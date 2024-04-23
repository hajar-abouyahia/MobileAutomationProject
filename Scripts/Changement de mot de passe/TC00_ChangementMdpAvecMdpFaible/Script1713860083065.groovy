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
import com.communKeywords.apkKeywords as apkKeywords
import com.communKeywords.authentificationKeywords as AuthentificationKeyword
import com.communKeywords.verificationKeywords as verificationKeywords
import com.profileKeywords.changementDeMdpKeywords as changementDeMdpKeywords

def apkkeyword = new apkKeywords()
def authkeyword = new AuthentificationKeyword()
def verificationKeyword = new verificationKeywords()
def editPasswordKeyword = new changementDeMdpKeywords()
//Start application
apkkeyword.startApplication()

//Set Language to french
apkkeyword.setLanguage()
Mobile.delay(1)

//Set login credentials and connect
authkeyword.setAuthData(immatriculation,Mdp)
authkeyword.login()
authkeyword.CancelAuthorization()
Mobile.delay(2)
// function to accesses the page to change the password
editPasswordKeyword.editPassword()

// function that sets the new password data
editPasswordKeyword.setMdpData(mdpActuel,nvMdp,confirmerMdp)

//function to validate the edit password
editPasswordKeyword.validate()
Mobile.delay(2)

//Alert weak pwd should display
String alertPath = verificationKeyword.weakPwd
authkeyword.verifyalertPresent(alertPath, 'Veuillez entrer un mot de passe qui répond aux normes de sécurité requises ci-dessous')
editPasswordKeyword.resetPwdPage()

Mobile.closeApplication()
