package com.example.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage2 {

    protected WebDriver driver;
    private WebDriverWait wait;

    public ProductPage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    // Search box
    @FindBy(id="search_product")
    private WebElement searchBox;

    // Search button
    @FindBy(id="submit_search")
    private WebElement searchButton;

    // Product names from search results
    @FindBy(xpath="//div[@class='productinfo text-center']/p")
    private List<WebElement> productNames;

    // "Add to Cart" buttons mapped to products
    @FindBy(xpath="//div[@class='productinfo text-center']/a[contains(text(),'Add to cart')]")
    private List<WebElement> addToCartButtons;

    // Continue shopping button in modal
    @FindBy(xpath="//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;

   

    /** Search product by name */
    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(productNames));
    }

    /** Add first product from results */
    public void addFirstProductToCart() {
        if (!addToCartButtons.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(0))).click();
        } else {
            throw new RuntimeException("No products found!");
        }
    }

    /** Add specific product by name */
    public void addProductToCartByName(String productName) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(i))).click();
                return;
            }
        }
        throw new RuntimeException("Product '" + productName + "' not found in search results!");
    }

    /** Handle 'Continue Shopping' popup */
    public void clickOnContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }
}
