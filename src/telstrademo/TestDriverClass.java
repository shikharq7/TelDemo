package telstrademo;



import org.openqa.selenium.By;

public class TestDriverClass {
	TestKeywords keywords;
	TestExcelDriver driver;
	
	public void readTestCase() {
		
		String sKey, sLocator, sArgument;
		String returnValue;
		By oBy;
		driver = new TestExcelDriver();
		keywords = new TestKeywords();
		driver.openWorkbook("C:\\Users\\NINDIYA PC\\Desktop\\Test.xlsx");
		int rowCount = 	driver.getRowCountOfSheet("TC1");
		for (int row= 2; row<=rowCount; row++) {
			sKey="";
			sLocator="";
			sArgument="";
			oBy=null;
			sKey=driver.getCellData("TC1", row, 2);
			sLocator=driver.getCellData("TC1", row, 3);
			sArgument=driver.getCellData("TC1", row, 4);
			
			if(sLocator != "" && !sLocator.equals("")) {
				oBy= TestUtils.getLocatorBy(sLocator);
			}
			
			returnValue= keywords.performAction(sKey, oBy, sArgument);
			System.out.println(returnValue);
	
		}
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		TestDriverClass myClass = new TestDriverClass();
		myClass.readTestCase();
		

	}

}
