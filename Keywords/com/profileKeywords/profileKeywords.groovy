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

public class profileKeywords {

	def checkButton = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez cocher la case pour continuer'
	def numValide = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez saisir un numero valide'
	def numTelephone = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez saisir votre numero de telephone'

	// function to click in profile details
	def static void clickProfile() {
		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.view.ViewGroup-Profile'), 0)
	}

	//Function sets the new number in the corresponding field
	def static void setNewNumber(String NvNumero ) {

		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText - 212'), 0)

		Mobile.sendKeys(findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText - 212'),NvNumero )
	}
	//Function that  click modify button to display the new number form
	def static void openPhoneForm() {
		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.view.ViewGroup-Num bouton modifier'), 0)
	}
	// function that display modify  email profile form
	def static void openEmailForm() {
		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.view.ViewGroup-email modifier bouton'), 0)
	}
	//	Clear Email Page Field
	def static void resetEmailPage() {
		def nvEmailField = findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText-Nv email')
		def confirmEmailField = findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText-confirmer email')
		Mobile.tap(nvEmailField, 0)
		Mobile.clearText(nvEmailField,3)
		Mobile.tap(confirmEmailField, 0)
		Mobile.clearText(confirmEmailField,3)
		Mobile.hideKeyboard()
	}
	//function that sets the email form data
	def static void setNewEmail(String nvEmail,String comfirmEmail ) {

		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText-Nv email'), 0)

		Mobile.sendKeys(findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText-Nv email'), nvEmail)

		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText-confirmer email'), 0)

		Mobile.sendKeys(findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText-confirmer email'), comfirmEmail)
	}
	//	Clear Phone Page Field
	def static void resetPhonePage() {
		def phoneNumberField = findTestObject('Object Repository/Opération sur le profile connecté/android.widget.EditText - 212')

		Mobile.tap(phoneNumberField, 0)
		Mobile.clearText(phoneNumberField,3)
	}

	//The function that checks the button to accept the use of data in accordance with the CNSS policy.
	def static void checkTheBox() {
		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.widget.CheckBox'), 0)
	}
	// button the close the modify number form
	def static void closeForm() {
		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.view.ViewGroup-Bouton X'), 0)
	}
	// function to click on enregister button
	def static void enregistrer() {
		Mobile.tap(findTestObject('Object Repository/Opération sur le profile connecté/android.view.View-bouton Enregistrer Numero'), 0)
	}
}
