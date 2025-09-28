package com.example.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.automation.tests.BaseClass;

public class ProductPage extends BaseClass {

	private WebDriver driver;

	// Correct locator for search box
	@FindBy(id = "search_product")
	private WebElement searchBox;

	// Correct locator for search button
	@FindBy(id = "submit_search")
	private WebElement searchButton;

	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[1]")
	private WebElement clickonaddtshirt;

	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[1]")
	private WebElement clickonviewProduct;

	// Correct locator for Add to Cart button
	@FindBy(xpath = "//button[@type='button' and @class='btn btn-default cart']")
	private WebElement addToCartBtn;

	// locate all add to cart webelemet
	@FindBy(xpath = "//a[text()='Add to cart']")
	private List<WebElement> AddToCart;

	// continue shopping
	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement ContinueShopping;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** Search for a product and add first result to cart */
	public void searchAndAddProduct(String productName) {
		scrolllintoView(searchBox);
		searchBox.clear();
		searchBox.sendKeys(productName);
		scrolllintoView(searchButton);
		searchButton.click();
		// addToCartBtn.click();
	}

	public void clickOnAddToCart() {

		for (WebElement singleAddtoCart : AddToCart) {

			// JavascriptExecutor j=(JavascriptExecutor) driver;
			// j.executeScript("arguments[0].scrollIntoView(true)",singleAddtoCart);
			scrolllintoView(singleAddtoCart);
			singleAddtoCart.click();
			System.out.println("click done successfully");
			ContinueShopping.click();
			break;

		}
		// addToCartBtn.click();
	}
}
