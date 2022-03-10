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

'Handle access demoQA Page'
CustomKeywords.'testing.start.access'()

'Fill in value in firstName field'
WebUI.setText(findTestObject('demoQA/input', [('text_label') : 'Name', ('text_id') : 'firstName']), firstName)

'Fill in value in lastName field'
WebUI.setText(findTestObject('demoQA/input', [('text_label') : 'Name', ('text_id') : 'lastName']), lastName)

'Fill in value in Email field'
WebUI.setText(findTestObject('demoQA/input', [('text_label') : 'Email', ('text_id') : 'userEmail']), email)

'Choose Gender value'
WebUI.check(findTestObject('demoQA/label', [('text_label') : 'Gender', ('text_value') : gender]))

'Fill in value in Mobile field'
WebUI.setText(findTestObject('demoQA/input', [('text_label') : 'Mobile', ('text_id') : 'userNumber']), mobile)

'Handle DOB field'
WebUI.click(findTestObject('demoQA/input', [('text_label') : 'Date of Birth', ('text_id') : 'dateOfBirthInput']))

'Choose value for Year\r\n'
WebUI.selectOptionByValue(findTestObject('demoQA/select_DOB_year'), year_DOB, true)

'Choose value for Month'
WebUI.selectOptionByValue(findTestObject('demoQA/select_DOB_month'), month_DOB, true)

'Choose value for Day'
WebUI.click(findTestObject('demoQA/select_DOB_day'))

'Fill in value in Subjects field'
WebUI.setText(findTestObject('demoQA/input', [('text_label') : 'Subjects', ('text_id') : 'subjectsInput']), subject)

'Select Subjects value visible'
WebUI.click(findTestObject('demoQA/select_Subjects_value'))

'Choose Hobbies value'
WebUI.check(findTestObject('demoQA/label', [('text_label') : 'Hobbies', ('text_value') : hobbies]))

'Upload Picture'
WebUI.uploadFile(findTestObject('demoQA/input', [('text_label') : 'Picture', ('text_id') : 'uploadPicture']), upload)

'Fill in value in Address field'
WebUI.setText(findTestObject('demoQA/textArea_Address', [('text_label') : 'Current Address', ('text_id') : 'currentAddress']),
address)

'Fill in value in State field'
WebUI.setText(findTestObject('demoQA/input', [('text_label') : 'State and City', ('text_id') : 'react-select-3-input']),
'NCR')

'Using TAB key to choose State value\r\n'
WebUI.sendKeys(findTestObject('demoQA/input', [('text_label') : 'State and City', ('text_id') : 'react-select-3-input']),
Keys.chord(Keys.TAB))

'Fill in value in State field'
WebUI.setText(findTestObject('demoQA/input', [('text_label') : 'State and City', ('text_id') : 'react-select-4-input']),
'Delhi')

'Using TAB, ENTER key to choose value and submit form'
WebUI.sendKeys(findTestObject('demoQA/input', [('text_label') : 'State and City', ('text_id') : 'react-select-4-input']),
Keys.chord(Keys.TAB, Keys.ENTER))

'Get text from Modal Label\r\n'
act_result = WebUI.getText(findTestObject('demoQA/div_Modal_label'))

'Compare Actual result and Expected result\r\n'
WebUI.verifyEqual(act_result, 'Thanks for submitting the form')

'Close Testing\r\n'
CustomKeywords.'testing.end.closure'()

