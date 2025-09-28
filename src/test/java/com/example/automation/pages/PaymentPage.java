package com.example.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.automation.tests.BaseClass;

public class PaymentPage extends BaseClass {

	private WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Correct locator for search box
	@FindBy(xpath = "//input[@name=\"name_on_card\"]")
	private WebElement NameonCard;

	@FindBy(xpath = "//input[@name=\"card_number\"]")
	private WebElement CardNumber;

	@FindBy(xpath = "//input[@class='form-control card-cvc' and @data-qa=\"cvc\"]")
	private WebElement CVC;

	@FindBy(xpath = "//input[@class=\"form-control card-expiry-month\" and @name=\"expiry_month\"]")
	private WebElement expiry_month;

	@FindBy(xpath = "//input[@class=\"form-control card-expiry-year\"and @name=\"expiry_year\"]")
	private WebElement expiry_year;

	@FindBy(xpath="//button[@id=\"submit\"]")
	private WebElement submit;

	@FindBy(id = "success_message")
	private WebElement success_message;

	// payment confirmation
	@FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
	private WebElement confirmationstatus;

	public void sendNameOnCard(String OwnerCardName) {
		scrolllintoView(NameonCard);

		NameonCard.sendKeys(OwnerCardName);
	}

	public void sendCardNumber(String OwnerCardNumber) {
		scrolllintoView(CardNumber);

		CardNumber.sendKeys(OwnerCardNumber);
	}

	public void sendCVC(String OwnerCVC) {
		scrolllintoView(CVC);

		CVC.sendKeys(OwnerCVC);
	}

	public void sendexpiry_month(String Ownerexpiry_month) {
		scrolllintoView(expiry_month);

		expiry_month.sendKeys(Ownerexpiry_month);
	}

	public void sendexpiry_year(String Ownerexpiry_year) {
		scrolllintoView(expiry_year);

		expiry_year.sendKeys(Ownerexpiry_year);
	}

	public void clicksubmit()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		scrolllintoView(submit);

		submit.click();

	}

	public boolean statussuccess_message() {
		scrolllintoView(success_message);

		return success_message.isDisplayed();
	}

	public boolean statusConfirmationstatus() {
		scrolllintoView(confirmationstatus);

		return confirmationstatus.isDisplayed();
	}

}
