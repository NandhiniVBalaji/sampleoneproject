package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass extends BaseClass {

	public LoginPageClass() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='user-name']")
	
	private WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	
	private WebElement password;

	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	@FindBy(id="login-button")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
}
