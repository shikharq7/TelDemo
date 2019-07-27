package telstrademo;

import org.openqa.selenium.By;

public class TestKeywords {
	
	TestCommonDriver oDriver;
	
	TestKeywords() {
		oDriver = new TestCommonDriver();
		
	}

	public String performAction(String actionKeyword, By oBy, String argValue) {
		
		if(actionKeyword.equalsIgnoreCase("openBrowser")) {
			oDriver.openBrowser(argValue);
			return "";
		}
		if(actionKeyword.equalsIgnoreCase("navigateToUrl")) {
			oDriver.navigateToUrl(argValue);
			return "";
		}
		if(actionKeyword.equalsIgnoreCase("Signin")) {
			oDriver.signin();
			return "";
		}
		return "Pass";
	}
}
