package Urban_StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class UrbanLadderSteps {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Given("user is on Urban Ladder homepage")
    public void openHomePage() {
        driver.get("https://www.urbanladder.com/");
    }

    // ----------- SIGN UP Scenario ------------

    @When("user opens the Sign Up form")
    public void openSignUpForm() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement profileIcon = driver.findElement(By.cssSelector("span.header-icon-link.user-profile-icon"));
        actions.moveToElement(profileIcon).perform();
        driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
        Thread.sleep(2000);
    }

    @When("enters valid email and password")
    public void enterSignUpDetails() {
        driver.findElement(By.id("spree_user_email")).sendKeys("testemail@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test@1234");
    }

    @Then("user clicks on the Sign Up button")
    public void clickSignUpButton() {
        driver.findElement(By.xpath("//input[@value='Sign Up']")).click();
    }

    // ----------- LOGIN Scenario ------------

    @When("user opens the Log In form")
    public void openLoginForm() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement profileIcon = driver.findElement(By.cssSelector("span.header-icon-link.user-profile-icon"));
        actions.moveToElement(profileIcon).perform();
        driver.findElement(By.xpath("//a[text()='Log In']")).click();
        Thread.sleep(2000);
    }

    @When("enters correct login credentials")
    public void enterLoginDetails() {
    	//enter emailId
        WebElement emailId = driver.findElement(By.xpath("//div[@id='password-credentials']//input[@id='spree_user_email']"));
        emailId.sendKeys("testemail@example.com");

        //enter Password
        WebElement password = driver.findElement(By.xpath("(//input[@type=\"password\"])[2]"));
        password.sendKeys("test@1234");
    }

    @Then("user clicks on the Log In button")
    public void clickLoginButton() {
        driver.findElement(By.id("ul_site_login")).click();
        //Alert Handling
        Alert myalert = driver.switchTo().alert();
        System.out.println("Simple Alert Message: " + myalert.getText());
        myalert.dismiss();
        
    }

    // ----------- ADD TO CART & CHECKOUT Scenario ------------

    @When("user searches for {string}")
    public void searchProduct(String product) {
    	
        driver.findElement(By.id("search")).sendKeys(product);
        driver.findElement(By.cssSelector("span.search-icon.icofont-search")).click();
    }

    @When("selects a product and adds to cart")
    public void selectProductAndAddToCart() throws InterruptedException {
//    	 openLoginForm();
//    	 enterLoginDetails();
//    	 clickLoginButton();
        driver.findElement(By.xpath("//img[contains(@title,'Faria Wooden Sofa')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.id("checkout-link")).click();
    }

    @Then("user proceeds to checkout and fills the shipping details")
    public void fillShippingDetails() {
    	driver.findElement(By.xpath("//input[@id='order_email']")).sendKeys("tesst@example.com");
        driver.findElement(By.id("order_ship_address_attributes_zipcode")).sendKeys("560068");
        driver.findElement(By.id("order_ship_address_attributes_address1")).sendKeys("HSR Layout, Bangalore");
        driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("Abhishek");
        driver.findElement(By.id("order_ship_address_attributes_lastname")).sendKeys("Maurya");
        driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("1234567890");
        driver.findElement(By.id("address-form-submit")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
