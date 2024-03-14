package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductPageClass extends BaseClass {

	public ProductPageClass() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Products']")
	private WebElement productPage;

	public WebElement getProductPage() {
		return productPage;
	}
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory ']")
	private WebElement addToCart;

	public WebElement getAddToCart() {
		return addToCart;
	}
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cart;

	public WebElement getCart() {
		return cart;
	}
	@FindBy(xpath="//span[text()='Your Cart']")
	private WebElement yourcart;

	public WebElement getYourcart() {
		return yourcart;
	}
	
	
	
	}
	


