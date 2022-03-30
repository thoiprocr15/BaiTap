package testing

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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class pratice_Form{

	@Keyword
	def access() {
		'Open Browser\r\n\r\n'
		WebUI.openBrowser('')

		'Maximize Browser Window'
		WebUI.maximizeWindow()

		'Navigate to DemoQA Page'
		WebUI.navigateToUrl(GlobalVariable.URL)
	}

	private TestObject fName_inp = findTestObject('demoQA/input', [('id'):'firstName'])
	private TestObject lName_inp = findTestObject('demoQA/input', [('id'):'lastName'])
	private TestObject email_inp = findTestObject('demoQA/input', [('id') : 'userEmail'])
	private TestObject mobile_inp = findTestObject('demoQA/input', [('id') : 'userNumber'])
	//	private TestObject gender_cb = findTestObject('demoQA/label_gender', [('value') : gender])
	private TestObject DOB_inp = findTestObject('demoQA/input', [('id') : 'dateOfBirthInput'])
	private TestObject year_select = findTestObject('demoQA/select_DOB_year')
	private TestObject month_select = findTestObject('demoQA/select_DOB_month')
	private TestObject day_select = findTestObject('demoQA/select_DOB_day')
	private TestObject subject_inp = findTestObject('demoQA/input', [('id') : 'subjectsInput'])
	private TestObject subject_select = findTestObject('demoQA/select_Subjects_value')
	//	private TestObject hobbies_rd = findTestObject('demoQA/label_hobbies', [('value') : hobbies])
	private TestObject upload_btn = findTestObject('demoQA/input', [('id') : 'uploadPicture'])
	private TestObject address_txt = findTestObject('demoQA/textArea_Address', [('text_label') : 'Current Address', ('text_id') : 'currentAddress'])
	private TestObject state_CB = findTestObject('demoQA/state_city_input', [('id') : 'state'])
	private TestObject city_CB = findTestObject('demoQA/state_city_input', [('id') : 'city'])

	@Keyword
	def click_Form() {
		'Click Form'
		WebUI.click(findTestObject('demoQA/li_Form'))
		'Click Pratice Form'
		WebUI.click(findTestObject('demoQA/li_Pratice_Form'))
	}

	@Keyword
	def enterValue(String fName_value, String lName_value, String email_value, String gender_value, String mobile_value, String year_value,
			String month_value, String subject_value, String hobbies_value,
			String upload_value, String address_value, String state_value, String city_value, String screenshot) {
		'Fill in Name fields'
		WebUI.setText(fName_inp, fName_value)
		WebUI.setText(lName_inp, lName_value)

		'Fill in Email field'
		WebUI.setText(email_inp, email_value)

		'Choose Gender'
		if (gender_value.equals('Male'))
			WebUI.check(findTestObject('demoQA/label_gender', [('value') : 'Male']))
		else if(gender_value.equals('Female'))
			WebUI.check(findTestObject('demoQA/label_gender', [('value') : 'Female']))
		else
			WebUI.check(findTestObject('demoQA/label_gender', [('value') : 'Other']))

		'Fill in Mobile field'
		WebUI.setText(mobile_inp, mobile_value)

		'Handle DOB fields'
		WebUI.click(DOB_inp)
		WebUI.selectOptionByValue(year_select, year_value, true)
		if(month_value.equals('January'))
			WebUI.selectOptionByValue(month_select, '0', true)
		else if(month_value.equals('February'))
			WebUI.selectOptionByValue(month_select, '1', true)
		else if(month_value.equals('March'))
			WebUI.selectOptionByValue(month_select, '2', true)
		else if(month_value.equals('April'))
			WebUI.selectOptionByValue(month_select, '3', true)
		else if(month_value.equals('May'))
			WebUI.selectOptionByValue(month_select, '4', true)
		else if(month_value.equals('June'))
			WebUI.selectOptionByValue(month_select, '5', true)
		else if(month_value.equals('July'))
			WebUI.selectOptionByValue(month_select, '6', true)
		else if(month_value.equals('August'))
			WebUI.selectOptionByValue(month_select, '7', true)
		else if(month_value.equals('September'))
			WebUI.selectOptionByValue(month_select, '8', true)
		else if(month_value.equals('October'))
			WebUI.selectOptionByValue(month_select, '9', true)
		else if(month_value.equals('November'))
			WebUI.selectOptionByValue(month_select, '10', true)
		else if(month_value.equals('December'))
			WebUI.selectOptionByValue(month_select, '11', true)
		WebUI.click(day_select)

		'Fill in Subject field'
		WebUI.setText(subject_inp, subject_value)
		WebUI.click(subject_select)

		'Choose Hobbies'
		if (hobbies_value.equals('Sports'))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '1']))
		else if(hobbies_value.equals('Reading'))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '2']))
		else if(hobbies_value.equals('Music'))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '3']))
		else if(hobbies_value.equals('Sports, Reading'))
		{
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '1']))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '2']))
		}
		else if(hobbies_value.equals('Sports, Music'))
		{
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '1']))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '3']))
		}
		else if(hobbies_value.equals('Reading, Music'))
		{
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '2']))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '3']))
		}
		else if(hobbies_value.equals('All'))
		{
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '1']))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '2']))
			WebUI.check(findTestObject('demoQA/label_hobbies', [('value') : '3']))
		}

		'Upload Picture'
		WebUI.setText(upload_btn, upload_value)

		'Fill in Address field'
		WebUI.setText(address_txt, address_value)

		'Choose State and City'
		WebUI.setText(state_CB, state_value)
		WebUI.sendKeys(state_CB, Keys.chord(Keys.TAB))
		WebUI.setText(city_CB, city_value)
		WebUI.sendKeys(city_CB, Keys.chord(Keys.TAB, Keys.ENTER))

		WebUI.takeFullPageScreenshotAsCheckpoint(screenshot)
	}

	private TestObject modal_lb = findTestObject('demoQA/Modal_label')

	@Keyword
	def end(String expected_result) {
		'Get text from Modal Label\r\n'
		String actual_result = WebUI.getText(modal_lb)

		'Compare Actual result and Expected result\r\n'
		WebUI.verifyEqual(actual_result, expected_result)

		'Close Browser\r\n'
		WebUI.closeBrowser()
	}
}

