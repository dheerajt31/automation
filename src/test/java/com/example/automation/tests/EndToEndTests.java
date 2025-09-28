package com.example.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.automation.pages.CheckOutPage;
import com.example.automation.pages.HomePage;
import com.example.automation.pages.LoginPage;
import com.example.automation.pages.PaymentPage;
import com.example.automation.pages.ProductPage;

public class EndToEndTests extends BaseClass {

    @Test
    public void endToEndTest() {
        // Home Page
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSignUporLogin();

        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                p.getProperty("email"),
                p.getProperty("pass")
        );

        // Product Page
        ProductPage productPage = new ProductPage(driver);
        homePage.clickOnproductsLink();
        productPage.searchAndAddProduct("tshirt"); // if needed, we can also move this to config.properties
        productPage.clickOnAddToCart();

        // Checkout Page
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickCart();
        checkOutPage.clickOnproceedToCheckout();
        checkOutPage.clickOnplaceOrder();

        // Payment Page
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.sendNameOnCard(p.getProperty("cardname"));
        paymentPage.sendCardNumber(p.getProperty("cardnum"));
        paymentPage.sendCVC(p.getProperty("cvc"));
        paymentPage.sendexpiry_month(p.getProperty("expiry_month"));
        paymentPage.sendexpiry_year(p.getProperty("expiry_year"));
        paymentPage.clicksubmit();

        // Verification
		/*
		 * boolean status = paymentPage.statusConfirmationstatus();
		 * Assert.assertTrue(status,
		 * "❌ Order placement failed - Payment confirmation not received");
		 */
        Assert.fail();
    }
}
