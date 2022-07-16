package com.academy.techcenture.step_definitions;

import com.academy.techcenture.config.Driver;
import com.academy.techcenture.pages.ContactUsPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ContactUsStepDefinitions {
    private WebDriver driver;
    private HomePage homepage;
    private LoginPage loginPage;
    private ContactUsPage contactUsPage;

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() throws Throwable {
        driver = Driver.getDriver();
        homepage = new HomePage(driver);
        homepage.navigateToHomePage();
    }

    @When("^user clicks on the sign in link$")
    public void user_clicks_on_the_sign_in_link() throws Throwable {
        homepage.clickSingInLink();
    }

    @Then("^user should be navigated to Login Page$")
    public void user_should_be_navigated_to_Login_Page() throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.verifyUserIsOnLoginPage();
    }

    @Then("^user logins with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_logins_with_and(String username, String password) throws Throwable {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginBtn();
    }

    @Then("^user clicks on Contact Us link$")
    public void user_clicks_on_Contact_Us_link() {
        homepage.clickContactUsLink();
    }

    @Then("^user should be navigated to Contact Us Page$")
    public void user_should_be_navigated_to_Contact_Us_Page() {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.verifyUserIsOnLoginPage();
    }

    @Then("^user selects \"([^\"]*)\" as a subject heading$")
    public void user_selects_as_a_subject_heading(String heading) {
        contactUsPage.selectsHeading(heading);
    }

    @Then("^user email \"([^\"]*)\" should be auto-populated$")
    public void user_email_should_be_auto_populated(String email) {
        contactUsPage.verifyEmailAutoPopulated(email);
    }

    @Then("^user should pick \"([^\"]*)\" from the reference dropdown$")
    public void user_should_pick_from_the_reference_dropdown(String reference) {
        contactUsPage.verifyOrderReference(reference);

    }

    @Then("^user should attach a picture from path \"([^\"]*)\"$")
    public void user_should_attach_a_picture_from_path(String picture) {
        contactUsPage.verifyAttachedPic(picture);
    }

    @Then("^user should enter \"([^\"]*)\" in the message input$")
    public void user_should_enter_in_the_message_input(String message) throws Throwable {
        contactUsPage.enterMessageInput(message);
    }

    @When("^user clicks on send button$")
    public void user_clicks_on_send_button() throws Throwable {
        contactUsPage.clickSendButton();
    }

    @Then("^user should see success message \"([^\"]*)\"$")
    public void user_should_see_success_message(String alertMessage) throws Throwable {

        contactUsPage.verifyAlertMessage(alertMessage);
    }

    @And("^user enters \"([^\"]*)\" in the email input$")
    public void userEntersInTheEmailInput(String email) throws Throwable {
        contactUsPage.enterEmailInput(email);
    }

    @And("^user enters \"([^\"]*)\" in the reference input$")
    public void userEntersInTheReferenceInput(String reference) throws Throwable {
        contactUsPage.enterOrderReferenceInput(reference);
    }

    @Then("^user should see error message \"([^\"]*)\"$")
    public void userShouldSeeErrorMessage(String alertMsg) throws Throwable {
        contactUsPage.verifyUnSuccessAlertMessage(alertMsg);
    }
}
