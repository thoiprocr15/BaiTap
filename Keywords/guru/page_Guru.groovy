package guru

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

public class page_Guru {
	private TestObject userID_inp = findTestObject('demoGuru/userID_inp')//UserID Field
	private TestObject password_inp = findTestObject('demoGuru/password_inp')//Password Field
	private TestObject login_btn = findTestObject('demoGuru/login_btn')
	private TestObject newCustomer_widget = findTestObject('demoGuru/newCustomer')
	private TestObject cusName_inp = findTestObject('demoGuru/inputText', [('label') : 'Customer Name', ('name') : 'name'])
	private TestObject city_inp = findTestObject('demoGuru/inputText', [('label') : 'City', ('name') : 'city'])
	private TestObject state_inp = findTestObject('demoGuru/inputText', [('label') : 'State', ('name') : 'state'])
	private TestObject PIN_inp = findTestObject('demoGuru/inputText', [('label') : 'PIN', ('name') : 'pinno'])
	private TestObject telephone_inp = findTestObject('demoGuru/inputText', [('label') : 'Telephone Number', ('name') : 'telephoneno'])
	private TestObject gender_Male = findTestObject('demoGuru/gender_Male')
	private TestObject gender_Female = findTestObject('demoGuru/gender_Female')
	private TestObject DOB_tp = findTestObject('demoGuru/inputText', [('label') : 'Date of Birth', ('name') : 'dob'])

	@Keyword
	def open_Page() {
		'Open Browser'
		'打开浏览器 '
		WebUI.openBrowser('')//Open browser
		'Maximize Browser Window'
		'最大化浏览器窗户'
		WebUI.maximizeWindow()//Maximize Window Browser
		'Navigate to DemoQA Page'
		WebUI.navigateToUrl(GlobalVariable.URL_Guru)//Navigate to ToolsQA page
	}

	@Keyword
	def login() {
		WebUI.setText(userID_inp, 'mngr391738')
		WebUI.setText(password_inp, 'tAnYjEn')
		WebUI.click(login_btn)
	}

	@Keyword
	def newCustomer(String cusName_value, String gender) {
		WebUI.click(newCustomer_widget)

		'Enter value in Customer Name Field'
		WebUI.setText(cusName_inp, cusName_value)

		'Choose Gender'
		if(gender.equals('Male'))
			WebUI.check(gender_Male)
		else (gender.equals('Female'))
		WebUI.check(gender_Female)

		'Handle DOB'
		WebUI.setText(DOB_tp, '03101999')
	}

}
