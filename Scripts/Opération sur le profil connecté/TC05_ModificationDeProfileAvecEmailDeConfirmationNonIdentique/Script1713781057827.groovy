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
import com.profileKeywords.profileKeywords as profileKeywords
import com.communKeywords.verificationKeywords as verificationKeywords

def apkkeyword = new apkKeywords()
def authkeyword = new AuthentificationKeyword()
def profileKeyword = new profileKeywords()
def verificationKeyword = new verificationKeywords()

//Start application
apkkeyword.startApplication()

//Set Language to french
apkkeyword.setLanguage()
Mobile.delay(1)

//Set login credentials and connect
authkeyword.setAuthData(immatriculation,Mdp)
authkeyword.login()
authkeyword.CancelAuthorization()

// click profile to inter and see details
profileKeyword.clickProfile()

// function that display modify  email profile form
profileKeyword.openEmailForm()

// function to set email form data
profileKeyword.setNewEmail(nvEmail, confirmEmail)

//The function that checks the button to accept the use of data in accordance with the CNSS policy.
profileKeyword.checkTheBox()

//function to enregister
profileKeyword.enregistrer()

//Alert wrong pwd should display
String alertPath = verificationKeyword.confirmEmailAlert
authkeyword.verifyalertPresent(alertPath, 'Veuillez saisir une adresse email valide')

// button the close the new modify email form
profileKeyword.closeForm()

Mobile.closeApplication()


