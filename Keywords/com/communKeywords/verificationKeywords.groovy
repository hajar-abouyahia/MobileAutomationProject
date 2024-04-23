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

public class verificationKeywords {
	//Element for "Operation sur le profile connecte" object repository
	def checkButton = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez cocher la case pour continuer'
	def numValide = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez saisir un numero valide'
	def phoneNumber = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez saisir votre numero de telephone'
	def validEmail = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez saisir une adresse email valide'
	def confirmEmailAlert = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez saisir une adresse email de confirmation valide'
	def emailValide = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez saisir votre Adresse e-mail'
	def confirmEmail = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez confirmer votre adresse e-mail'
	def checkButtonEmail = 'Object Repository/Opération sur le profile connecté/android.widget.TextView - Veuillez cocher la case pour continuer-Email'
	//Element for "Changement de mot de passe" object repository
	def weakPwd = 'Object Repository/Changement de mot de passe/android.widget.TextView - Veuillez entrer un mot de passe qui rpond aux normes de scurit requises ci-dessous'
	def mdpActuelIncorrect ='Object Repository/Changement de mot de passe/android.widget.TextView - Mot de passe didentification du validateur incorrect'

	// verify alert Present Function that ensure that the exact message "alert" is displayed
	def static void verifyalertPresent(String objectPath , String  alert) {
		Mobile.verifyElementText(findTestObject(objectPath),alert,FailureHandling.STOP_ON_FAILURE)
	}
}
