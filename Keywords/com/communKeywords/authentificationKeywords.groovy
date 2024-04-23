package com.communKeywords

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

public class authentificationKeywords {
	def identifiantMdpInvalid = 'Object Repository/Authentification/android.widget.TextView - Identifiant ou mot de passe invalide'
	def bienvenue = 'Object Repository/Authentification/android.widget.TextView - Bienvenue,'
	def authPage = 'Object Repository/Authentification/android.widget.TextView - Me connecter'

	//Set login credentials function
	def static void setAuthData(String n_immatriculation, String MDP) {
		def immatriculation = findTestObject('Object Repository/Authentification/android.widget.EditText - N Immatriculation')
		def MotDePasse = findTestObject('Object Repository/Authentification/android.widget.EditText - Mot de passe')
		Mobile.tap(immatriculation, 0)
		Mobile.sendKeys(immatriculation,n_immatriculation)
		Mobile.tap(MotDePasse, 0)
		Mobile.sendKeys(MotDePasse,MDP)



		Mobile.hideKeyboard()
		Mobile.delay(1)
	}
	//Connect function
	def static void login() {
		Mobile.tap(findTestObject('Object Repository/Authentification/android.view.View-Me connecte'), 0)
	}
	//	Clear LoginPage Field
	def resetLoginPage() {
		def immatriculation = findTestObject('Object Repository/Authentification/android.widget.EditText - N Immatriculation')
		def MotDePasse = findTestObject('Object Repository/Authentification/android.widget.EditText - Mot de passe')
		Mobile.tap(immatriculation, 0)
		Mobile.clearText(immatriculation,3)
		Mobile.tap(MotDePasse, 0)
		Mobile.clearText(MotDePasse,3)
		Mobile.hideKeyboard()
	}
	//function that allows to return to the Authentication page after trying to connect with the wrong data
	def static void ReturnToAuthPage() {
		Mobile.tap(findTestObject('Object Repository/Authentification/android.view.View-ok'), 0)
	}

	// verify alert Present Function that ensure that the exact message "alert" is displayed
	def static void verifyalertPresent(String objectPath , String  alert) {
		Mobile.verifyElementText(findTestObject(objectPath),alert,FailureHandling.STOP_ON_FAILURE)
	}
	//The function to revoke authorization for the use of biometric data.
	def static void CancelAuthorization() {
		Mobile.tap(findTestObject('Object Repository/Authentification/android.widget.Button - ANNULER'), 0)
	}
	//function for login out
	def static void seDeconnecter() {
		Mobile.tap(findTestObject('Object Repository/Authentification/android.widget.ImageView (1)'), 0)
		Mobile.tap(findTestObject('Object Repository/Authentification/android.widget.TextView - Se dconnecter'), 0)
		Mobile.tap(findTestObject('Object Repository/Authentification/android.widget.Button - OUI'), 0)
	}
}