/*
package executionEngine;
import java.lang.reflect.Method;
import config.ActionKeywords;
import utility.ExcelUtils;
public class DriverScript {

    public static void main(String[] args) throws Exception {
        // Declaring the path of the Excel file with the name of the Excel file
        String sPath = "C:\\Users\\Administrator\\Downloads\\KDT.xlsx";

        ExcelUtils.setExcelFile(sPath, "KDTSheet");

        for (int iRow=1;iRow<=10;iRow++){
            String sActionKeyword = ExcelUtils.getCellData(iRow, 2);

            if(sActionKeyword.equals("open_Browser")){
                ActionKeywords.open_Browser();}
            else if(sActionKeyword.equals("navigate_RegisPage")){
                ActionKeywords.navigate_RegisPage();}
            else if(sActionKeyword.equals("enter_Email")){
                ActionKeywords.enter_Email();}
            else if(sActionKeyword.equals("click_Submit")){
                ActionKeywords.click_Submit();}
            else if(sActionKeyword.equals("catch_Username")){
                ActionKeywords.catch_Username();}
            else if(sActionKeyword.equals("catch_Password")){
                ActionKeywords.catch_Password();}
            else if(sActionKeyword.equals("navigate_LoginPage")){
                ActionKeywords.navigate_LoginPage();}
            else if(sActionKeyword.equals("enter_Username")){
                ActionKeywords.enter_Username();}
            else if(sActionKeyword.equals("enter_Password")){
                ActionKeywords.enter_Password();}
            else if(sActionKeyword.equals("click_SignIn")){
                ActionKeywords.click_SignIn();}
        }
    }
}*/

/*package executionEngine;

import java.lang.reflect.Method;
import config.ActionKeywords;
import utility.ExcelUtils;

public class DriverScript {
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static Method method[];

    public DriverScript() throws NoSuchMethodException, SecurityException{
        actionKeywords = new ActionKeywords();
        method = actionKeywords.getClass().getMethods();
    }

    public static void main(String[] args) throws Exception {
        DriverScript driverScript = new DriverScript();
        String sPath = "C:\\Users\\Administrator\\Downloads\\KDT.xlsx";
        ExcelUtils.setExcelFile(sPath, "KDTSheet");

        for (int iRow = 1;iRow <= 10;iRow++){
            sActionKeyword = ExcelUtils.getCellData(iRow, 2);
            execute_Actions();
        }
    }

    private static void execute_Actions() throws Exception {
        for(int i = 0;i < method.length;i++){
            if(method[i].getName().equals(sActionKeyword)){
                method[i].invoke(actionKeywords);
                break;
            }
        }
    }
}*/
/*package executionEngine;
import java.lang.reflect.Method;
import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;
public class DriverScript {
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static Method method[];

    public DriverScript() throws NoSuchMethodException, SecurityException{
        actionKeywords = new ActionKeywords();
        method = actionKeywords.getClass().getMethods();
    }

    public static void main(String[] args) throws Exception {
        DriverScript driverScript = new DriverScript();
        String sPath = Constants.Path_TestData;
        ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestSteps);
        for (int iRow=1;iRow<=10;iRow++){
            sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
            execute_Actions();
        }
    }

    private static void execute_Actions() throws Exception {
        for(int i=0;i<method.length;i++){
            if(method[i].getName().equals(sActionKeyword)){
                method[i].invoke(actionKeywords);
                break;
            }
        }
    }
}*/
/*package executionEngine;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;
public class DriverScript {
    public static Properties OR;
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static String sPageObject;
    public static Method method[];
    public DriverScript() throws NoSuchMethodException, SecurityException{
        actionKeywords = new ActionKeywords();
        method = actionKeywords.getClass().getMethods();
    }
    public static void main(String[] args) throws Exception {
        DriverScript driverScript = new DriverScript();
        String Path_DataEngine = Constants.Path_TestData;
        ExcelUtils.setExcelFile(Path_DataEngine, Constants.Sheet_TestSteps);

        //Declaring String variable for storing Object Repository path
        String Path_OR = Constants.Path_OR;
        //Creating file system object for Object Repository text/property file
        FileInputStream fs = new FileInputStream(Path_OR);
        //Creating an Object of properties
        OR= new Properties(System.getProperties());
        //Loading all the properties from Object Repository property file in to OR object
        OR.load(fs);
        for (int iRow=1;iRow<=10;iRow++){
            sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
            sPageObject = ExcelUtils.getCellData(iRow, Constants.Col_PageObject);
            execute_Actions();
        }
    }
    private static void execute_Actions() throws Exception {
        for(int i=0;i<method.length;i++){
            if(method[i].getName().equals(sActionKeyword)){
                method[i].invoke(actionKeywords,sPageObject);
                break;
            }
        }
    }
}*/
package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;
import utility.Log;

public class DriverScript {

    public static boolean bResult;
    public static Properties OR;
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static String sPageObject;
    public static Method method[];

    public static int iTestStep;
    public static int iTestLastStep;
    public static String sTestCaseID;
    public static String sRunMode;

    public DriverScript() throws NoSuchMethodException, SecurityException{
        actionKeywords = new ActionKeywords();
        method = actionKeywords.getClass().getMethods();
    }

    public static void main(String[] args) throws Exception {
        ExcelUtils.setExcelFile(Constants.Path_TestData);

        //This is to start the Log4j logging in the test case
        DOMConfigurator.configure("log4j.xml");

        String Path_OR = Constants.Path_OR;
        FileInputStream fs = new FileInputStream(Path_OR);
        OR= new Properties(System.getProperties());
        OR.load(fs);

        DriverScript startEngine = new DriverScript();
        startEngine.execute_TestCase();
    }

    private void execute_TestCase() throws Exception {
        int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
        for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++) {
            bResult = true;
            sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
            sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode, Constants.Sheet_TestCases);
            if (sRunMode.equals("Yes")) {
                iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
                iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
                Log.startTestCase(sTestCaseID);
                bResult = true;
                for (; iTestStep < iTestLastStep; iTestStep++) {
                    sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword, Constants.Sheet_TestSteps);
                    sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
                    execute_Actions();
                    if (bResult == false) {
                        ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestcase, Constants.Col_Result, Constants.Sheet_TestCases);
                        Log.endTestCase(sTestCaseID);
                        break;
                    }
                }
                if (bResult == true) {
                    //Storing the result as Pass in the excel sheet
                    ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestcase, Constants.Col_Result, Constants.Sheet_TestCases);
                    Log.endTestCase(sTestCaseID);
                }
            }
        }
    }

    private static void execute_Actions() throws Exception {

        for(int i=0;i<method.length;i++){
            if(method[i].getName().equals(sActionKeyword)){
                method[i].invoke(actionKeywords,sPageObject);
                if(bResult==true){
                    ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
                    break;
                }else{
                    ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
                    ActionKeywords.closeBrowser("");
                    break;
                }
            }
        }
    }
}