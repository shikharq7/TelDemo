package telstrademo;

import org.openqa.selenium.By;

public class TestUtils {
	public static By getLocatorBy(String sLocatorString) {
		
		try {
			String [] aLocator;
			
			sLocatorString = sLocatorString.trim();
			if(sLocatorString.isEmpty() || ! sLocatorString.contains(":=")) {
				throw new Exception("Invalid Locator String");
			}
			
			aLocator = sLocatorString.split(":=");
			
			if(aLocator[0].equalsIgnoreCase("id")) {
				return By.id(aLocator[1]);
				
			}
			
			throw new Exception("Invalid Locator String");
		} catch (Throwable t) {
			System.err.println(t.getMessage());
			return null;
		}
	}

}
