package org.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	public void getDriverEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	public void getURL(String url) {
		driver.get(url);

	}

	public void getPageSource() {
		driver.getPageSource();

	}

	public void winMax() {
		driver.manage().window().maximize();
	}

	public void textToSend(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void click(WebElement element) {

		element.click();
	}

	public void submit(WebElement element) {
		element.submit();

	}

	public void navigateTo(String url) throws InterruptedException {
		driver.navigate().to(url);
		Thread.sleep(2000);
	}

	public void navigateBack() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);

	}

	public void navigateForward() throws InterruptedException {
		driver.navigate().forward();
		Thread.sleep(2000);

	}

	public void navigateRefresh() {
		driver.navigate().refresh();

	}

	public void screenshot(String image) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\nandh\\OneDrive\\Desktop\\TakesScreenshot\\" + image + ".jpeg");
		FileUtils.copyFile(screenshotAs, target);
	}

	public void select(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void actions(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click();

	}

	public void text(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}

	public void location(WebElement element) {
		Point location = element.getLocation();
		System.out.println(location);

	}

	public void attribute(WebElement element) {
		String attribute = element.getAttribute(null);
		System.out.println(attribute);

	}

	public String scroll(WebElement element, String values) {
		js = (JavascriptExecutor) driver;
		switch (values) {
		case "Down":
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			break;

		case "Up":
			js.executeScript("arguments[0].scrollIntoView(false)", element);
			break;
		default:
			System.out.println("Invaild");
			break;
		}
return values;
	}

	public String readExcell(int rownum, int cellnum) throws IOException {

		File file = new File("C:\\Users\\nandh\\OneDrive\\Desktop\\Excels\\LoginData.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook book = new XSSFWorkbook(stream);

		Sheet sheet = book.getSheet("Sheet1");

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		CellType cellType = cell.getCellType();

		String value = null;
		switch (cellType) {

		case STRING:
			value = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal big = BigDecimal.valueOf(numericCellValue);
				value = big.toString();
			}
			break;

		default:
			break;

		}

		return value;

	}

	public String  windowsHandling (int index) {
		String parentWindowID = driver.getWindowHandle();
		Set<String> allWindowID = driver.getWindowHandles();
		
		List <String> li = new LinkedList();
		li.addAll(allWindowID);
		
		String childWindowID = li.get(index);
		return childWindowID;

	}
	
	public  void clickJs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
public void quit() {
	driver.quit();

}

public void close() {
	driver.close();
}
	
public void switchTo() {
	driver.switchTo();

}


}
