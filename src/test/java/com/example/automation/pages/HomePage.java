package com.example.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.automation.tests.BaseClass;

public class HomePage extends BaseClass {

    public WebDriver driver;
    
    // Constructor
    public HomePage(WebDriver driver) {
       // super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Locators using @FindBy ---
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsLink;
    
    
  

   

    // --- Page Actions ---

 // --- Page Actions ---

    public void clickOnSignUporLogin() {
    	signupLoginLink.click();
    }
    
    public void clickOnproductsLink() {
    	productsLink.click();
    }
    
}
