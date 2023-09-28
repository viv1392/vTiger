package baseComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int count =0;
	@Override
	public boolean retry(ITestResult result) {
		int maxtry=1;
		if(count<maxtry) {
			count++;
			return true;
		}
		return false;
	}
	

}
