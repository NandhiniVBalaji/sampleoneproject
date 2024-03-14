package org.page;
import org.global.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageClass extends BaseClass {

	public CartPageClass() {
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
    private WebElement remove1;

	public WebElement getRemove1() {
		return remove1;
	}
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']")
	private WebElement remove2;

	public WebElement getRemove2() {
		return remove2;
	}
    @FindBy(xpath="//button[@id='checkout']")
	private WebElement checkOut;

	public WebElement getCheckOut() {
		return checkOut;
	}
	
}
