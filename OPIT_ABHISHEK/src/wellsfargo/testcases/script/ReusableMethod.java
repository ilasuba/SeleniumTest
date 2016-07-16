package wellsfargo.testcases.script;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethod{
	//	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	@Test
	public void test() throws Exception {

		startReport("Decending order sort","C:/Users/Ila Suba/Desktop/Abhishk_Homework/Report/");

		Update_Report( "Pass", "Decending order sort",  "Decending order sort executing is complete.");
		
		bw.close();


	}
	/* Name of the Method: startReport
	 * Brief description: Start creating a report 
	 * Arguments: scriptName --> String , ReportsPath --> String 
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */

	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
	/* Name of the Method: enterText
	 * Brief description: Enter text value to text boxes 
	 * Arguments: obj --> webelement Object, textVal --> text to be entered, objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{


		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			Update_Report("Pass", "enterText", textVal+ "  is entered in " + objName + " field");
		}else{
			Update_Report("Fail", "enterText", objName + " field is not displayed please check your application ");
		}

	}

	/* Name of the Method: clickButton
	 * Brief description: Click on Web Button 
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void clickButton(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "clickButton", objName + " is clicked");
		}
		else{
			Update_Report("Fail", "clickButton",  objName + " Button is not displayed please check your application");

		}
	}
	/* Name of the Method: validateTextMessage
	 * Brief description: validating Text message
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: June 29 2016
	 * Last Modified: June 29 2016
	 * */
	public static void validateTextMessage(WebElement obj, String expectedMsg, String objname) throws IOException{


		if(obj.isDisplayed()){
			String actualMsg = obj.getText().trim();
			if(expectedMsg.equals(actualMsg)){

				Update_Report("Pass","validateTextMessage", "Actual Message " + actualMsg+" is matched with expectedErrMsg "+expectedMsg);

			}
			else{

				Update_Report("Fail","validateTextMessage", "Actual Message " + actualMsg+" is not matched with expectedErrMsg "+expectedMsg);

			}
		}
		else{
			Update_Report("Fail", "validateTextMessage",  objname + " Button is not displayed please check your application");

		}



	}

	/* Name of the Method: chkBoxSelect
	 * Brief description: Select Check box
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	public static void chkBoxSelect(WebElement obj, String objName ) throws IOException{
		if(obj.isDisplayed()){
			if(obj.isSelected()){
				Update_Report("Pass", "chkBoxSelect", objName + " is already selected");
			}
			else{
				obj.click();
				Update_Report("Pass", "chkBoxSelect", objName + " is selected");
			}
		}
		else{
			Update_Report("Fail", "chkBoxSelect", objName + " is not displayed Please check your application");
		}
	}

	/* Name of the Method: chkBoxDeSelect
	 * Brief description: De-Select Check box
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	public static void chkBoxDeSelect(WebElement obj, String objName ) throws IOException{
		if(obj.isDisplayed()){
			if(obj.isSelected()){
				obj.click();
				Update_Report("Pass", "chkBoxDeSelect", objName + " is De-selected");
			}
			else{
				Update_Report("Pass", "chkBoxDeSelect", objName + " is already de-selected");
			}
		}
		else{
			Update_Report("Fail", "chkBoxDeSelect", objName + " is not displayed Please check your application");
		}
	}
	
	
	/* Name of the Method: validateTextInDropdn
	 * Brief description: validate drop down menu text //div -tag
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	public static void validateTextInDropdn(WebElement obj, String[] expMenuItemes, String objname) throws IOException{
		String[] actualStr = obj.getText().split("[\\r\\n]+");
		if(obj.isDisplayed()){
			for(int i = 0; i < expMenuItemes.length; i++){

				if(actualStr[i].equals(expMenuItemes[i])){
					Update_Report("Pass", "validateTextInDropdn",  "Expected menu item is: "  +expMenuItemes[i]+ " is matched to actual item: "+actualStr[i]);

				}
				else{
					Update_Report("Fail", "validateTextInDropdn",  "Expected menu item is: "  +expMenuItemes[i]+ " is not matched to actual item: "+actualStr[i]);

				}

			}

		}
		else{
			Update_Report("Fail", "validateTextInDropdn",  objname + " DropDown menu is not displayed please check your application");

		}
	}

	/* Name of the Method: validateSelectDropDown
	 * Brief description: validate drop down menu with select tag
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	public static void validateSelectDropDown(WebElement obj, String[] expectedItems, String objname) throws Exception{
		if(obj.isDisplayed()){
			Select options = new Select(obj);
			
			java.util.List<WebElement> elementOptions = options.getOptions();
			
			int iSize = elementOptions.size();
			
			for(int i =0; i<iSize; i++){
				if(elementOptions.get(i).getText().equals(expectedItems[i])){
					Update_Report("Pass", "validateTextInDropdn",  "Expected menu item is: "  +expectedItems[i]+ " is matched to actual item: "+elementOptions.get(i).getText());
				}
				else{
					Update_Report("Fail", "validateTextInDropdn",  "Expected menu item is: "  +expectedItems[i]+ " is Not matched to actual item: "+elementOptions.get(i).getText());
				}
			}
			
		}
		else{
			Update_Report("Fail", "validateTextInDropdn",  objname + " DropDown menu is not displayed please check your application");
		}
		
	}
	
	/* Name of the Method: validateSelectMenuOneItem
	 * Brief description: validate drop down menu Only one item with select tag
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	public static void validateSelectMenuOneItem(WebElement obj, String expectedItems, String objname) throws Exception{
		if(obj.isDisplayed()){
			Select options = new Select(obj);
			
			java.util.List<WebElement> elementOptions = options.getOptions();
			
			int iSize = elementOptions.size();
			
			for(int i =0; i<iSize; i++){
				if(elementOptions.get(i).getText().equals(expectedItems)){
					Update_Report("Pass", "validateTextInDropdn",  "Expected menu item is: "  +expectedItems+ " is matched to actual item: "+elementOptions.get(i).getText());
				}
			}
			
		}
		else{
			Update_Report("Fail", "validateTextInDropdn",  objname + " DropDown menu is not displayed please check your application");
		}
		
	}
	
	/* Name of the Method: selectFromDropDown
	 * Brief description: select from drop down menu Only one item with select tag
	 * Arguments: obj --> webelement Object,objName --> Object Name
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	public static void selectFromDropDown(WebElement obj, String selectItem, String objname) throws Exception{
		if(obj.isDisplayed()){
			Select options = new Select(obj);
			options.selectByVisibleText(selectItem);
			Update_Report("Pass", "selectFromDropDown",  "Menu item is: "  +selectItem+ " is Selected");
			
		}
		else{
			Update_Report("Fail", "selectFromDropDown",  objname + " DropDown menu is not displayed please check your application");
		}
		
	}
	/* Name of the Method:verifyElement 
	 * Brief description: Verify Element
	 * Arguments: obj --> webelement Object
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	public static void verifyElement(WebElement obj)throws Exception{
		
	    if(obj.isEnabled()){
	    	
	    	Update_Report("Pass", "Verifying Element", obj + "is Present");
	    	
	    }else{
	    	Update_Report("Fail", "Verifying element", obj +" is not Present, please check your application.");
	    }
	}
	/* Name of the Method:verifyLink 
	 * Brief description: Verify Link of the WebPAge
	 * Arguments: obj --> String actURL , String exPURL
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	
	
	public static void verifyLink(String actURL,String expURL)throws Exception{
		
		
		if(actURL.equals(expURL)){
			
			Update_Report("Pass", "Verifying URL", "Displaying Same URL");
		}else{
	    	Update_Report("Fail", "Verifying URL", expURL+ "is not match with "+ actURL+" please check your application.");
	    }
		
		
	}
	/* Name of the Method:verify_Values_In_Dropdown 
	 * Brief description: Veryfing Drop down
	 * Arguments: List<WebElement> listOfElements, String[] strValues
	 * Created By: TechPirates 
	 * Creation Date: July 16 2016
	 * Last Modified: July 16 2016
	 * */
	

public static boolean verify_Values_In_Dropdown(List<WebElement> listOfElements, String[] strValues) throws IOException {
	boolean bValue=false;
	List<String> list = new ArrayList<String>();
	for (String strValue : strValues) {
		boolean bflag = false;
		for (WebElement element : listOfElements) {
			String elementValue = element.getText();
			if (strValue.equals(elementValue)) {
				bflag= true;
			}
		}
		if (!bflag)
			list.add(strValue);
	}
	if (list.size() > 0) {
		for(String strList : list) {
			Update_Report("Fail", "Verifying Your Accunt Drop down",  strValues + "is not Present, please check your application.");
		}
		//Assign false if any of the value not found in dropdown
		bValue = false;
	} else {
		//Assign true if all values found in dropdown
		Update_Report("Pass", "Verifying Element", strValues + "is Present");
		bValue=true;
	}
	return bValue;
}
/* Name of the Method:ElementDisplayed 
 * Brief description: select from drop down menu Only one item with select tag
 * Arguments: 
 * Created By: TechPirates 
 * Creation Date: July 16 2016
 * Last Modified: July 16 2016
 * */
public static void ElementDisplayed(WebElement obj, String objname) throws Exception{
	if(obj.isDisplayed()){
		Update_Report("Pass", objname, objname+"  option is available");
	}else{
		Update_Report("Fail", objname, objname+"  option is not available.Please check your application");
	}
	}
/* Name of the Method:readExcel 
 * Brief description: 
 * Arguments: 
 * Created By: TechPirates 
 * Creation Date: July 16 2016
 * Last Modified: July 16 2016
 * */
public static String[][] readExcel(String dtTablePath, String sheetName ) throws IOException{

	/*Step 1: Get the XL Path*/
	File xlFile = new File(dtTablePath);

	/*step2: Access the Xl File*/
	FileInputStream xlDoc = new FileInputStream(xlFile);

	/*Step3: Access the work book (POI jar file) */
	HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

	/*Step4: Access the Sheet */
	HSSFSheet sheet = wb.getSheet(sheetName);

	int iRowCount = sheet.getLastRowNum()+1;
	int iColCount = sheet.getRow(0).getLastCellNum();


	String[][] xlData = new String[iRowCount][iColCount];

	for(int i =0; i<iRowCount; i++){
		for(int j = 0; j <iColCount; j++){
			xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

		}

	}
	return xlData;
}


/*Name of the method: ValidateDeselect
 * Brief Description: validate check Box
 * Arguments:obj--->webElement object
 * created By:  Techpirates
 * Creation date:June 29 2016
 * Last Modification:June 29 2016
 */
public static void ValidateDeselect(WebElement obj) throws IOException{
	if(obj.isDisplayed()){
		boolean click;
		click=obj.isSelected();
		
		if(click==true){
			obj.click();
		}else
			System.out.println("Already deselected");
	}else{
		Update_Report("Fail", "ValidateDeselect", obj + " Checkbox field is not displayed please check your application ");
	}
			
		
}
}

