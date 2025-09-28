✅ README.md
# Hybrid End-to-End Automation Framework

## 📌 Scenario
This project automates an **end-to-end hybrid test** that combines **UI automation** with **API validation** on [Automation Exercise](https://automationexercise.com/).

### Flow:
1. **UI Automation (Selenium + TestNG)**
   - Open browser and login with a dummy user (credentials from `config.properties`)
   - Search for a product and add it to cart
   - Proceed to checkout and select payment method
   - Place the order

2. **API Validation (RestAssured)**
   - Validate order status using order ID or user email  
     (mocked response if real API unavailable)
   - Send a dummy **POST** request to simulate coupon application  
     (mocked with Postman/RestAssured)

3. **Bonus (Optional)**
   - Validate cart data using a local DB or mocked JSON file
   - Generate execution reports with **ExtentReports**

---

## 🛠️ Framework Features
- **Page Object Model (POM)**
- **TestNG** for test execution and assertions
- **Data-driven testing** via `config.properties`
- **Explicit waits** for stable UI automation
- **Screenshot capture** on test failure
- **Extent Reports** for HTML reports
- **API Testing** with RestAssured
- **CI/CD ready** with GitHub Actions or Jenkins

---

## 📂 Project Structure


automation/
├── reports/ # HTML execution reports
├── screenshots/ # Failure screenshots
├── src/test/java/ # Test classes & POM page classes
├── test-output/ # TestNG default output
├── pom.xml # Maven dependencies
├── testng.xml # Test suite configuration
└── README.md # Project documentation


---

## ⚡ How to Run

### 1. Clone the repo
```bash
git clone https://github.com/dheerajt31/automation.git
cd automation

2. Update test data

Modify src/test/resources/config.properties:

baseURL=https://automationexercise.com
browser=chrome
email=testuser@gmail.com
pass=Test@123
cardname=Test User
cardnum=4111111111111111
cvc=123
expiry_month=09
expiry_year=2025

3. Run tests with Maven
mvn clean test

4. Run specific suite with TestNG
mvn clean test -DsuiteXmlFile=testng.xml

📚 Dependencies

Key libraries used (managed via pom.xml):

Selenium WebDriver – UI automation

TestNG – Test framework

RestAssured – API testing

ExtentReports – Reporting

Apache POI – Data-driven Excel (optional)

Maven Surefire Plugin – Test execution

✅ Assumptions

Real APIs are not available for order/coupon, so mocked responses are used.

Product search term (tshirt) is hardcoded, but can be parameterized.

Local DB validation is optional and mocked with JSON if needed.

Tests are designed to run on Chrome (can be extended for other browsers).

📊 Reports

Extent Report: Available in /reports/Test-Report-<timestamp>.html

Screenshots for failed cases stored in /screenshots/

👤 Author

Developed by Dheeraj T
Hybrid UI + API automation framework using Selenium, TestNG, RestAssured, and ExtentReports.


---

Would you like me to also add a **badges section** (like build status, license, Maven version) at the top of the README so it looks professional on GitHub?
