package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Selenium_csv {    // To use "try/catch" uncomment lines:14, 25, 28-30, 35, 65-71. And comment lines: 15, 62, 63
	//public static void main(String[] args) {
	public static void main(String[] args) throws IOException {
		
		String csvFile = "./src/main/resources/Test.csv";
		BufferedReader br = null;
		String line = null;
		String SplitBy = ",";
		String test_case_id = null;
		String url = null;
		String title_expected = null;
		
		//try {
			
			br = new BufferedReader(new FileReader(csvFile));
		 //} catch (FileNotFoundException e) {
		//	e.printStackTrace();
		 //}
		
		WebDriver driver = new FirefoxDriver(); // Version 1.4 :: Firefox
		//WebDriver driver = new HtmlUnitDriver();
		
		//try {
			
			while ((line = br.readLine()) != null) {
				String[] csv = line.split(SplitBy);
				
				test_case_id = csv[0];
				url = csv[1];
				title_expected = csv[2];
				
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				String title_actual = driver.getTitle();
				
				if (title_expected.equals(title_actual)) {
					System.out.println("Test Case ID: \t\t" + test_case_id);
					System.out.println("URL: \t\t\t" + url);
					System.out.println("Title Expected: \t" + title_expected);
					System.out.println("Title Actual: \t\t" + title_actual);
					System.out.println("Test Case Result: \t" + "PASSED");
				} else {
					System.out.println("Test Case ID: \t\t" + test_case_id);
					System.out.println("URL: \t\t\t" + url);
					System.out.println("Title Expected: \t" + title_expected);
					System.out.println("Title Actual: \t\t" + title_actual);
					System.out.println("Test Case Result: \t" + "FAILED");
					}
			}
			driver.quit();
			br.close();
		
			/* br.close();
		  } catch (IOException e) {
			  e.printStackTrace();
		  } finally {
			  driver.quit();
		  }
		 */
	}

}
