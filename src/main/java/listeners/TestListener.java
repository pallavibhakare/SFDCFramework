package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class TestListener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult name) {
		//to create a report for a particular test and pass test name
		BaseTest.test = BaseTest.extent.createTest(name.getName());
		BaseTest.threadExtentText.set(BaseTest.test);
		BaseTest.test.log(Status.INFO, "Test Started for: " +name.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		BaseTest.threadExtentText.get().pass("Test Case for: '"+result.getName()+"' Pass successfully.");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		//captures screenshot if test fails
		BaseTest.threadExtentText.get().addScreenCaptureFromPath(CommonUtils.captureScreenShots(BaseTest.getDriver()));
		BaseTest.threadExtentText.get().fail(MarkupHelper.createLabel("FAILED "+result.getName(), ExtentColor.RED) );
	}
	
}
