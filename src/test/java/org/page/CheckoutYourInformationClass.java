package org.page;
import org.global.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationClass extends BaseClass{

	public CheckoutYourInformationClass() {
		PageFactory.initElements(driver, this);
	}
    @FindBy(id="first-name")
	private WebElement firstName;
    
    @FindBy(id="last-name")
	private WebElement lastName;
    
    @FindBy(id="postal-code")
	private WebElement zipCode;
    
    @FindBy(id="continue")
    private WebElement continueButton;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	
	
	
	
}
