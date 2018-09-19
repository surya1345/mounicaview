package com.payslipsselenium.mounicaview;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
	public void addEmployee() throws EncryptedDocumentException, InvalidFormatException, IOException {
		driver = new ChromeDriver();
		driver.get(PAYSLIPS_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// LOGIN
		WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[1]/input"));
		username.sendKeys("admin");
		username.submit();
		WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[2]/input"));
		password.sendKeys("admin");
		password.submit();
		WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[4]/button"));
		loginbutton.click();

		// CLICK ON EMPLOYEE DROPDOWN
		WebElement Employee = driver.findElement(By.xpath("//*[@id=\"MainMenu\"]/div[1]/a[1]"));
		Employee.click();

		// SELECT ADD EMPLOYEE
		WebElement addEmployee = driver.findElement(By.xpath("//*[@id=\"employee\"]/a[1]/span"));
		addEmployee.click();

		Workbook workbook = WorkbookFactory.create(new File("E:\\add-employee-data.xls"));

		Sheet sheet = workbook.getSheetAt(0);
		Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {

			WebElement employeeId = driver.findElement(By.xpath("//*[@id=\"empid\"]"));
			WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
			WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
			WebElement usernameForm = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
			WebElement passwordForm = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			WebElement dOB = driver.findElement(By.xpath("//*[@id=\"dob\"]"));
			WebElement address = driver.findElement(By.xpath("//*[@id=\"address\"]"));
			WebElement phNo = driver.findElement(By.xpath("//*[@id=\"phoneNo\"]"));
			WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
			WebElement deptName = driver.findElement(By.xpath("//*[@id=\"departmentName\"]"));
			WebElement designationName = driver.findElement(By.xpath("//*[@id=\"designationName\"]"));
			WebElement panNo = driver.findElement(By.xpath("//*[@id=\"panNo\"]"));
			WebElement uAN = driver.findElement(By.xpath("//*[@id=\"pfNo\"]"));
			WebElement hireDate = driver.findElement(By.xpath("//*[@id=\"hireDate\"]"));
			WebElement skypeId = driver.findElement(By.xpath("//*[@id=\"skypeId\"]"));

			Row row = rowIterator.next();
			if (row.getCell(0) != null)
				employeeId.sendKeys(row.getCell(0).toString());
			if (row.getCell(1) != null)
				firstName.sendKeys(row.getCell(1).toString());
			if (row.getCell(2) != null)
				lastName.sendKeys(row.getCell(2).toString());
			if (row.getCell(3) != null)
				usernameForm.sendKeys(row.getCell(3).toString());
			if (row.getCell(4) != null)
				passwordForm.sendKeys(row.getCell(4).toString());
			if (row.getCell(5) != null)
				dOB.sendKeys(row.getCell(5).toString());
			if (row.getCell(6) != null)
				address.sendKeys(row.getCell(6).toString());
			if (row.getCell(7) != null)
				phNo.sendKeys(row.getCell(7).toString());
			if (row.getCell(8) != null)
				email.sendKeys(row.getCell(8).toString());
			if (row.getCell(9) != null)
				deptName.sendKeys(row.getCell(9).toString());
			if (row.getCell(10) != null)
				designationName.sendKeys(row.getCell(10).toString());
			if (row.getCell(11) != null)
				panNo.sendKeys(row.getCell(11).toString());
			if (row.getCell(12) != null)
				uAN.sendKeys(row.getCell(12).toString());
			if (row.getCell(13) != null)
				hireDate.sendKeys(row.getCell(13).toString());
			if (row.getCell(14) != null)
				skypeId.sendKeys(row.getCell(14).toString());

			WebElement submit = driver.findElement(By.xpath("//*[@id=\"addUserForm\"]/div[16]/div/button"));
			submit.click();

			// #######################################################
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// #######################################################

			WebElement employeeInLoop = driver.findElement(By.xpath("//*[@id=\"MainMenu\"]/div[1]/a[1]"));
			employeeInLoop.click();

			WebElement addEmployeeInLoop = driver.findElement(By.xpath("//*[@id=\"employee\"]/a[1]"));
			addEmployeeInLoop.click();// *[@id="employee"]/a[1]
		}

	}
	// driver.close();

	// @Test(priority = 1)
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

	// @Test(priority = 2)
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

	// @Test(priority = 3)
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

	// @Test(priority = 4)
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