package com.profileKeywords

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

public class changementDeMdpKeywords {
	//function to accesses the page to change the password
	def static void editPassword() {
		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.view.ViewGroup-menu'), 0)

		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.view.ViewGroup-Mes parametres'), 0)
	}
	// function that sets the new password data
	def static void setMdpData(String mdpActuel,String nvMdp,String confirmerMdp ) {
		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.view.ViewGroup-modifier Mdp'), 0)
		
		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText-Mdp Actuel'), 0)
		
		Mobile.sendKeys(findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText-Mdp Actuel'), mdpActuel)
		
		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText (1)-Nv Mdp'), 0)
		
		Mobile.sendKeys(findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText (1)-Nv Mdp'), nvMdp)
		
		Mobile.hideKeyboard()
		
		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText (2)-Tap Confirm Mdp'), 0)
		
		Mobile.sendKeys(findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText (3)-Send Confirm Mdp'), confirmerMdp)
		
		Mobile.hideKeyboard()
	}
	// function to click on validate button
	def static void validate() {
		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.view.View-valider'), 0)
	}
	// Click "ok" to return to edit password page
	def static void PressOk() {
		Mobile.tap(findTestObject('Object Repository/Changement de mot de passe/android.view.View-ok'), 0)
	}
	//	Clear password Page Field
	def static void resetPwdPage() {
		def mdpActuel = findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText-Mdp Actuel')
		def nvMdp = findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText (1)-Nv Mdp')
		def confirmationMdp = findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText (2)-Tap Confirm Mdp')
		//def confirmationMdpAfterTap = findTestObject('Object Repository/Changement de mot de passe/android.widget.EditText (1)-send keys confirmation du Nv Mdp')
		Mobile.tap(mdpActuel, 0)
		Mobile.clearText(mdpActuel,3)
		Mobile.tap(nvMdp, 0)
		Mobile.clearText(nvMdp,3)
		Mobile.hideKeyboard()
		Mobile.tap(confirmationMdp, 0)
		Mobile.hideKeyboard()
		Mobile.delay(2)
		Mobile.clearText(confirmationMdp,3)
		Mobile.hideKeyboard()
		
		
	}
}
