package com.example.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.automation.tests.BaseClass;

public class LoginPage extends BaseClass {
	public WebDriver driver;

	// ====== Constructor ======
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initializes all @FindBy fields
	}

	// ====== Locators for "Login to your account" ======
	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;

	// ====== Actions ======
	public void login(String email, String password) {
		emailField.clear();
		emailField.sendKeys(email);

		passwordField.clear();
		passwordField.sendKeys(password);

		loginButton.click();
	}

}
