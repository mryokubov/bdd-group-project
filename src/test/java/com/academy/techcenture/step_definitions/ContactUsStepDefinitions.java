package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.Driver;
import com.academy.techcenture.pages.ContactUsPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ContactUsStepDefinitions {

    private WebDriver driver;
    private HomePage homepage;
    private LoginPage loginPage;
    private ContactUsPage contactUsPage;

    @AfterStep
    public void takeScreenshots(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"img/png", scenario.getName());
        }
//        if (driver != null){
//            driver.quit();
//        }
    }

    @Given("user is on the home page")
    public void user_is_on_the_home_page() throws InterruptedException {
        driver = Driver.getDriver();
        homepage = new HomePage(driver);
        homepage.navigateToHomePage();

    }

    @When("user clicks on the sign in link")
    public void user_clicks_on_the_sign_in_link() throws InterruptedException {
        homepage.clickSingInLink();
        Thread.sleep(5000);
    }

    @Then("user should be navigated to Login Page")
    public void user_should_be_navigated_to_Login_Page()  {
        loginPage = new LoginPage(driver);
        loginPage.verifyUserIsOnLoginPage();
    }

    @Then("user logins with {string} and {string}")
    public void user_logins_with_and(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginBtn();
    }

    @Then("user clicks on Contact Us link")
    public void user_clicks_on_Contact_Us_link()  {
        homepage.clickContactUsLink();
    }

    @Then("user should be navigated to Contact Us Page")
    public void user_should_be_navigated_to_Contact_Us_Page()  {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.verifyUserIsOnLoginPage();
    }

    @Then("user selects {string} as a subject heading")
    public void user_selects_as_a_subject_heading(String heading) {
        contactUsPage.selectsHeading(heading);
    }

    @Then("user email {string} should be auto-populated")
    public void user_email_should_be_auto_populated(String email)  {
        contactUsPage.verifyEmailAutoPopulated(email);
    }

    @Then("user should pick {string} from the reference dropdown")
    public void user_should_pick_from_the_reference_dropdown(String reference) {
        contactUsPage.pickOrderReference(reference);

    }

    @Then("user should attach a picture from path {string}")
    public void user_should_attach_a_picture_from_path(String picture ) {
        contactUsPage.attachPicturePath(picture);

    }

    @Then("user should enter {string} in the message input")
    public void user_should_enter_in_the_message_input(String message)  {
        contactUsPage.enterMessageInput(message);
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button(){
        contactUsPage.clickSendBtn();

    }

    @Then("user should see success message {string}")
    public void user_should_see_success_message(String alert){
        contactUsPage.seeSuccessMsg(alert);
    }



    @And("user enters {string} in the email input")
    public void userEntersInTheEmailInput(String email){
        contactUsPage.enterUnRegisteredEmail(email);

    }

    @And("user enters {string} in the reference input")
    public void userEntersInTheReferenceInput(String reference) {
        contactUsPage.enterUnRegisteredReference(reference);

    }



//    @After(order = 0)
//    public void tearDown() {
//        if(driver != null){
//            driver.quit();
//        }
//    }

}

