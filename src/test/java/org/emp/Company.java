package org.emp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Company {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple 15 pro max", Keys.ENTER);
		List<WebElement> mobile = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		List<WebElement> amount = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	
		for(int i=0; i<mobile.size(); i++) {
			
			WebElement text = mobile.get(i);
			String text2 = text.getText();
			System.out.println(text2);

			WebElement text1 = amount.get(i);
			String text3 = text1.getText();
			System.out.println(text3);
		}
	}

}
