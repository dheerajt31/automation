package com.example.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.automation.tests.BaseClass;

public class CheckOutPage extends BaseClass {

	private WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Correct locator for search box
	@FindBy(xpath = "//*[text()=' Cart']")
	private WebElement cart;
	
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement ProceedToCheckout;
	
	@FindBy(xpath = "//a[text()='Place Order']")
	private WebElement placeOrder;
	
	
	public void clickCart() {
		scrolllintoView(cart);

		cart.click();
	}
	
	public void clickOnproceedToCheckout() {
		scrolllintoView(ProceedToCheckout);
		ProceedToCheckout.click();
	}
	
	public void clickOnplaceOrder() {
		scrolllintoView(placeOrder);
		placeOrder.click();
	}

}
