package com.payslipsselenium.mounicaview;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

public class View {

	private static WebDriver driver;
	private static final String PAYSLIPS_URL = "http://localhost:8080/employee-payslips/#!/login#employee";

	static Map<String, Object[]> testresultdata;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chrome-driver\\chromedriver.exe");
	
	}

	@Test(priority = 1)
	public void viewemployeedetails() {
		try {
			driver = new ChromeDriver();
			driver.get(PAYSLIPS_URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[1]/input"));
			username.sendKeys("admin");
			username.submit();
			WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[2]/input"));
			password.sendKeys("admin");
			password.submit();
			WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[4]/button"));
			loginbutton.click();
			WebElement Employee = driver.findElement(By.xpath("//*[@id=\"MainMenu\"]/div[1]/a[1]"));
			Employee.click();
			Thread.sleep(5000);
			WebElement view = driver.findElement(By.xpath("//*[@id=\"employee\"]/a[2]"));
			view.click();
			Thread.sleep(3000);
			// driver.quit();
			List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='dataTables-example']/tbody/tr"));
			int listOfEmpRecords = tableRows.size();
			System.out.println("EmplId | Name | Ph | Email | DOJ");
			if (tableRows.size() > 0) {
				for (int rowInit = 1; rowInit < listOfEmpRecords; rowInit++) {
					for (int colInit = 1; colInit < 6; colInit++) {
						List<WebElement> empIdInFirstRow = driver.findElements(By
								.xpath("//*[@id='dataTables-example']/tbody/tr[" + rowInit + "]/td[" + colInit + "]"));
						for (WebElement webElement : empIdInFirstRow) {
							System.out.print(webElement.getText() + " |");
						}
					}
					System.out.println();
				}
			} else {
				throw new Exception("NO DATA FOUND");
				
			}

		} catch (Exception ex) {
			System.out.println("Exception occured******************");
		}

		driver.close();
	}

	@Test(priority = 2)
	public void viewemployeebankdetails() {
		try {
			driver = new ChromeDriver();
			driver.get(PAYSLIPS_URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[1]/input"));
			username.sendKeys("admin");
			username.submit();
			WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[2]/input"));
			password.sendKeys("admin");
			password.submit();
			WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[4]/button"));
			loginbutton.click();
			WebElement EmployeeBank = driver.findElement(By.xpath("//*[@id=\"MainMenu\"]/div[1]/a[2]"));
			EmployeeBank.click();
			Thread.sleep(5000);
			WebElement view = driver.findElement(By.xpath("//*[@id=\"employeebank\"]/a[2]"));
			view.click();
			Thread.sleep(3000);
			// driver.quit();
			List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='dataTables-example']/tbody/tr"));
			int listOfEmpRecords = tableRows.size();
			System.out.println("Bank name | Employee Name | Account Number | ESI Account Number");
			if (tableRows.size() > 0) {
				for (int rowInit = 1; rowInit < listOfEmpRecords; rowInit++) {
					for (int colInit = 1; colInit < 6; colInit++) {
						List<WebElement> empIdInFirstRow = driver.findElements(By
								.xpath("//*[@id='dataTables-example']/tbody/tr[" + rowInit + "]/td[" + colInit + "]"));
						for (WebElement webElement : empIdInFirstRow) {

							System.out.print(webElement.getText() + " |");
						}
					}
					System.out.println();
				}
			} else {
				System.out.println("NO DATA FOUND");
			}

		} catch (Exception ex) {
			System.out.println("Exception occured******************");
		}
		driver.close();
	}

	@Test(priority = 3)
	public void viewleavesdeatils() {
		try {
			driver = new ChromeDriver();
			driver.get(PAYSLIPS_URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[1]/input"));
			username.sendKeys("admin");
			username.submit();
			WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[2]/input"));
			password.sendKeys("admin");
			password.submit();
			WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[4]/button"));
			loginbutton.click();
			WebElement Leaves = driver.findElement(By.xpath("//*[@id=\"MainMenu\"]/div[1]/a[4]"));
			Leaves.click();
			Thread.sleep(5000);
			WebElement view = driver.findElement(By.xpath("//*[@id=\"leaves\"]/a[2]"));
			view.click();
			Thread.sleep(3000);
			// driver.quit();
			List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='dataTables-example']/tbody/tr"));
			int listOfEmpRecords = tableRows.size();
			System.out.println("Employee Name | Month | Year | No of Leaves");
			if (tableRows.size() > 0) {
				for (int rowInit = 1; rowInit < listOfEmpRecords; rowInit++) {
					for (int colInit = 1; colInit < 6; colInit++) {
						List<WebElement> empIdInFirstRow = driver.findElements(By
								.xpath("//*[@id='dataTables-example']/tbody/tr[" + rowInit + "]/td[" + colInit + "]"));
						for (WebElement webElement : empIdInFirstRow) {
							System.out.print(webElement.getText() + " |");
						}
					}
					System.out.println();
				}
			} else {
				System.out.println("NO DATA FOUND");
			}

		} catch (Exception ex) {
			System.out.println("Exception occured******************");
		}
		driver.close();
	}

	@Test(priority = 4)
	public void viewsalarydetails() {
		try {
			driver = new ChromeDriver();
			driver.get(PAYSLIPS_URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[1]/input"));
			username.sendKeys("admin");
			username.submit();
			WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[2]/input"));
			password.sendKeys("admin");
			password.submit();
			WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[4]/button"));
			loginbutton.click();
			WebElement Salary = driver.findElement(By.xpath("//*[@id=\"MainMenu\"]/div[1]/a[3]"));
			Salary.click();
			Thread.sleep(5000);
			WebElement view = driver.findElement(By.xpath("//*[@id=\"salary\"]/a[2]"));
			view.click();
			Thread.sleep(3000);
			// driver.quit();
			List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='dataTables-example']/tbody/tr"));
			int listOfEmpRecords = tableRows.size();
			System.out.println("Empid | Name | Year | Gross Salary | Bank Name");
			if (tableRows.size() > 0) {
				for (int rowInit = 1; rowInit < listOfEmpRecords; rowInit++) {
					for (int colInit = 1; colInit < 6; colInit++) {
						List<WebElement> empIdInFirstRow = driver.findElements(By
								.xpath("//*[@id='dataTables-example']/tbody/tr[" + rowInit + "]/td[" + colInit + "]"));
						for (WebElement webElement : empIdInFirstRow) {
							System.out.print(webElement.getText() + " |");
						}
					}
					System.out.println();
				}
			} else {
				System.out.println("NO DATA FOUND");
			}

		} catch (Exception ex) {
			System.out.println("Exception occured******************");
		}
		driver.close();
	}
}
