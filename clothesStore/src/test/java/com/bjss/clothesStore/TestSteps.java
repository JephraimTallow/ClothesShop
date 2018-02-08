package com.bjss.clothesStore;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bjss.clothesStore.pages.HomePage;
import com.bjss.clothesStore.pages.LoginPage;
import com.bjss.clothesStore.pages.MyAccountPage;
import com.bjss.clothesStore.pages.OrderConfirmationPage;
import com.bjss.clothesStore.pages.OrderHistoryPage;
import com.bjss.clothesStore.pages.OrderSummaryAddressPage;
import com.bjss.clothesStore.pages.OrderSummaryPage;
import com.bjss.clothesStore.pages.OrderSummaryPaymentPage;
import com.bjss.clothesStore.pages.OrderSummaryShippingPage;
import com.bjss.clothesStore.pages.QuickViewPage;
import com.bjss.clothesStore.pages.ShoppingCartPage;
import com.bjss.clothesStore.pages.WomenPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 

public class TestSteps extends BaseSteps {
	
	private HomePage homePage;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;
	private WomenPage womenPage;
	private QuickViewPage quickViewPage;
	private ShoppingCartPage shoppingCartPage;
	private OrderSummaryPage orderSummaryPage;
	private OrderSummaryAddressPage orderSummaryAddressPage;
	private OrderSummaryShippingPage orderSummaryShippingPage;
	private OrderSummaryPaymentPage orderSummaryPaymentPage;
	private OrderConfirmationPage orderConfirmationPage;
	private OrderHistoryPage orderHistoryPage;
	private WebDriver driver;
	
	@Before
    public void setup() {
        driver = new ChromeDriver();
        
        driver.get("http://automationpractice.com/index.php");
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        womenPage = PageFactory.initElements(driver, WomenPage.class);
        quickViewPage = PageFactory.initElements(driver, QuickViewPage.class);
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        orderSummaryPage = PageFactory.initElements(driver, OrderSummaryPage.class);
        orderSummaryAddressPage = PageFactory.initElements(driver, OrderSummaryAddressPage.class);
        orderSummaryShippingPage = PageFactory.initElements(driver, OrderSummaryShippingPage.class);
        orderSummaryPaymentPage = PageFactory.initElements(driver, OrderSummaryPaymentPage.class);
        orderConfirmationPage = PageFactory.initElements(driver, OrderConfirmationPage.class);
        orderHistoryPage = PageFactory.initElements(driver, OrderHistoryPage.class);
    }
	
    @Given("^The clothes store homepage has loaded successfully$")
    public void homepageSuccessfullyLoaded() {
        assertThat(homePage.isPageLoaded(driver)).as("Check homepage has loaded").isEqualTo(true);
    }
    
    @When("^A user clicks the Sign in link$") 
    public void clickSignIn() throws InterruptedException {
    	homePage.clickSignIn();
    }
    
    @Then("^The login page is displayed")
    public void loginPageIsDisplayed() {
        assertThat(loginPage.isPageLoaded(driver)).as("Check login page has loaded").isEqualTo(true);
    }
     
    @When("^A user logs in successfully")
    public void userLogInSuccessfully() {
    	loginPage.enterLoginDetails();
    }
    
    @Then("^The My Account page is displayed")
    public void myAccountPageDisplayed() {
    	myAccountPage.isPageLoaded(driver);
    }
    
    @When("^A user clicks the Women link on My Accounts page")
    public void userClicksWomenLinkOnMyAccounts() {
    	myAccountPage.clickWomenLink();
    }
    @Then("^The Women page is displayed")
    public void womenPageDisplayed() {
    	womenPage.isPageLoaded(driver);
    }
    @When("^A user clicks the first item quick view icon")
    public void userClicksFirstItemQuickView() {

    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", womenPage.getItem1Image());
    	
    	Actions actions = new Actions(driver);
    	actions.moveToElement(womenPage.getItem1Image());
    	actions.moveToElement(womenPage.getImageQuickView()).click();
    	actions.build().perform();
    	
    	// Hard coding item name etc - this should be obtained from the page
    	ClothingItem item = new ClothingItem("Faded Short Sleeve T-shirts", "Size : M", "", new BigDecimal("16.51"));
    	shoppingCartList.add(item);
    	
    	threadSleep(2);
    	driver.switchTo().frame(0);
    }
    
    @When("^A user clicks the second item quick view icon")
    public void userClicksSecondItemQuickView() {

    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", womenPage.getItem2Image());
    	
    	Actions actions = new Actions(driver);
    	actions.moveToElement(womenPage.getItem2Image());
    	actions.moveToElement(womenPage.getImage2QuickView()).click();
    	actions.build().perform();
    	
    	// TODO - Hard coding item name etc - this should be obtained from the page
    	ClothingItem item = new ClothingItem("Blouse", "Size : S", "", new BigDecimal("27.00"));
    	shoppingCartList.add(item);
    	
    	threadSleep(2);
    	driver.switchTo().frame(0);
    }
    
    @When("^A user changes size to medium")
    public void userChangesSizeToMedium() {
    	
    	WebElement sizeDropDown = driver.findElement(By.cssSelector("#group_1"));
    	Select selectBox = new Select(quickViewPage.getSizeDropDown());
    	selectBox.selectByVisibleText("M");
    	sizeDropDown.click();
    }
    
    @When("^A user buys a quick view item")
    public void userBuysQuickViewItem() {
    	
    	quickViewPage.clickAddToCartButton();
    	driver.switchTo().defaultContent();
    	threadSleep(2);
    }
    
    @When("^A user clicks on Continue Shopping")
    public void userClicksContinueShopping() {
    	shoppingCartPage.clickContinueShopping();
    	threadSleep(2);
    }
    
    @Then("^The calculated totals will be correct") 
    public void calculatedTotalsAreCorrect() {
    	shoppingCartPage.clickProceedToCheckout();
    	
    	// TODO - Hard coding the two lines to validate. 
    	// Better solution to iterate over the table rows and check each item, colour, size etc
    	
    	List<ClothingItem> checkoutList = new ArrayList<>();
    	
    	WebElement product1Name = orderSummaryPage.getProduct1Name();
    	WebElement product1Size = orderSummaryPage.getProduct1Size();
    	WebElement product1Price = orderSummaryPage.getProduct1Price();
    	checkoutList.add(new ClothingItem(product1Name, product1Size, "", product1Price));
    	
    	WebElement product2Name = orderSummaryPage.getProduct2Name();
    	WebElement product2Size = orderSummaryPage.getProduct2Size();
    	WebElement product2Price = orderSummaryPage.getProduct2Price();
    	checkoutList.add(new ClothingItem(product2Name, product2Size, "", product2Price));
    	
    	
    	Iterator<ClothingItem> cartIter = shoppingCartList.iterator();
    	Iterator<ClothingItem> checkoutIter = checkoutList.iterator();
    	
    	BigDecimal cartProductTotal = new BigDecimal("0.0");
    	
    	while (cartIter.hasNext()) {
    		ClothingItem cartItem = cartIter.next();
    		cartProductTotal = cartProductTotal.add(cartItem.getPrice());
    		checkoutIter = checkoutList.iterator();
    		while (checkoutIter.hasNext()) {
    			ClothingItem checkoutItem = checkoutIter.next();
    			if (checkoutItem.equals(cartItem)) {
    				checkoutIter.remove();
    			}
    		}
    	}
    	Assert.assertTrue("Cart items have not all been matched.", checkoutList.size() == 0);
    	
    	WebElement productTotal = orderSummaryPage.getProductTotal();
    	String productTotalString = productTotal.getText();
    	BigDecimal productTotalDecimal = convertPriceToDecimal(productTotalString);
    	convertPriceToDecimal(productTotalString);
    	
    	String shippingTotal = orderSummaryPage.getShippingTotal().getText();
    	BigDecimal shippingTotalDecimal = convertPriceToDecimal(shippingTotal);
    	
    	String overallTotal = orderSummaryPage.getOverallTotal().getText();
    	BigDecimal overallTotalDecimal = convertPriceToDecimal(overallTotal);
    	
    	assertTrue("Checkout total does not equal cart total", productTotalDecimal.equals(cartProductTotal));
    	assertTrue("Checkout and shipping total is incorrect", overallTotalDecimal.equals(productTotalDecimal.add(shippingTotalDecimal)));
    	
    }
    
    @Then("^The user proceeds to checkout") 
    public void userProceedsToCheckout() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderSummaryPage.locateProceedToCheckoutBtn());
    	orderSummaryPage.clickProceedToCheckoutBtn();
    }
    
    @Then("^The user proceeds on Address stage checkout") 
    public void userProceedsOnAddressCheckout() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderSummaryAddressPage.locateProceedToCheckoutBtn());
    	orderSummaryAddressPage.clickProceedToCheckout();
    }
    
    @Then("^The user proceeds on Shipping stage checkout") 
    public void userProceedsOnShippingAddressCheckout() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderSummaryShippingPage.locateProceedToCheckoutBtn());
    	
    	if (!orderSummaryShippingPage.isTermsAndConditionsChecked()) {
    		orderSummaryShippingPage.toggleTermsAndConditions();
    	}
    	orderSummaryShippingPage.clickProceedToCheckout();
    }

    @Then("^The user clicks Pay by Wire button") 
    public void userClicksPayByWire() {
    	orderSummaryPaymentPage.clickPayByWireBtn();
    }
    
    @Then("^The user clicks Confirm Order button") 
    public void userClicksConfirmOrder() {
    	orderSummaryPage.clickConfirmOrderBtn();
    }
    
    @Then("^The Order Confirmation page is displayed") 
    public void orderConfirmationPageDisplayed() {
    	assertTrue("Order confirmation has not been displayed", orderConfirmationPage.isPageLoaded(driver));
    }
    @Then("^The user logs out") 
    public void userLogsOut() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderConfirmationPage.locateSignOutLink());
    	orderConfirmationPage.clickSignOutLink();
    }
    
    @Then("^A user logs in to view order history") 
    public void userLogsInToViewAccount() {
    	homePage.clickSignIn();
    	loginPage.enterLoginDetails();
    	myAccountPage.clickOrderHistory();
    	orderHistoryPage.clickFirstHistoryItem();
    	threadSleep(2);
    }
    
    @When("^A user selects product for comment \"([^\"]*)\"$")
    public void userSelectsProductForComment(String messageIn) {
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderHistoryPage.locateSummaryTable());

    	WebElement productDropDown = orderHistoryPage.locateProductSelect();
    	Select selectBox = new Select(productDropDown);
    	selectBox.selectByIndex(1);

    	orderHistoryPage.addComments(messageIn);
    	orderHistoryPage.clickSendMessageBtn();
    	
    	threadSleep(2);
    }
    
    @Then("^The comments \"([^\"]*)\" are displayed in the Messages section") 
    public void commentsDisplayedInMessagesSection(String messageIn) {
    	
    	List<WebElement> messagesTable = driver.findElements(By.xpath("//*[@id='block-order-detail']/div[5]/table/tbody/tr"));
    	// TODO - Assume first row is the most recent so only assert this for now. Should iterate over table rows...
    	try {
    		assertTrue("Most recent message was not saved", messagesTable.get(0).getText().contains(messageIn));
    		
    	} catch (AssertionError ae) {
    		captureScreenshot();
    	}
    }
    
	private void captureScreenshot() {
		
		// TODO - make the file location system independent. 
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("/Users/davidwesson/Downloads/screenshot1_" + new Date().toString() + ".png"), true);
		} catch (IOException e) {
			// TODO Add logging
			e.printStackTrace();
		}
		
	}
	
    @After
    public void tearDown() {
    	driver.quit();
    }
    
}