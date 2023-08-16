package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer,ITestListener {
	
 public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*****Test started:***** " +result);
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*****Test Success:***** " +result);
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*****Test Failed:***** " +result);
		
		TakeScreenShot scr = new TakeScreenShot();
		scr.takeSnap(); 
		
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*****Test Skipped:***** " +result);
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*****Test Failed with percentage***** :onTestFailedButWithinSuccessPercentage(result)");
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("*****Test Failed with timeOut:***** " +result);
	}
	public void onStart(ITestContext context) {
		System.out.println("*****Test started:***** " +context.getName());
	}
	public void onFinish(ITestContext context) {
		System.out.println("*****Test Finish: *****" +context.getFailedTests());

	}
int count =0;
	public boolean retry(ITestResult result) {
		if(count<1) {
			count ++;
			return true;
		}
		return false;
	}

}
