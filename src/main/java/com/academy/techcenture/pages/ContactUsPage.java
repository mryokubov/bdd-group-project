package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactUsPage extends HomePage{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id_contact")
    private WebElement subjectHeadingDropDown;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "id_order")
    private WebElement orderRefInput; //for guests

    @FindBy(name = "id_order")
    private WebElement orderRefDropDown; //for valid users

    @FindBy(id = "message")
    private WebElement messageArea;

    @FindBy(id = "submitMessage")
    private WebElement sendBtn;

    @FindBy(xpath = "//p[contains(@class,'alert-success')]")
    private WebElement successAlertMessage;

    @FindBy(xpath = "//span[contains(.,'Home')]")
    private WebElement homeBtn;

    @FindBy(id = "fileUpload")
    private WebElement attachFileInput;

    @FindBy(xpath = "//h1[contains(.,'Customer service - Contact us')]")
    private WebElement contactUsHeader;


    public void verifyUserIsOnLoginPage(){
        String contactUsTitle = driver.getTitle();
        assertEquals("Titles are not matching","Contact us - My Store", contactUsTitle);
        assertTrue("Contact Us Header was not displayed", contactUsHeader.isDisplayed() );
    }

    public void selectsHeading(String heading){
            Select select = new Select(subjectHeadingDropDown);
            select.selectByVisibleText(heading);
    }

    public void verifyEmailAutoPopulated(String email){
        assertEquals( "Emails do not match", email, emailInput.getAttribute("value"));

    }

    public void pickOrderReference(String reference){
        Select select = new Select(orderRefDropDown);
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().startsWith(reference)){
                options.get(i).click();
                break;
            }
        }
    }

    public void attachPicturePath(String picture){
        File f = new File(picture);
        String absolute = f.getAbsolutePath();
        attachFileInput.sendKeys(absolute);


    }


    public void enterMessageInput(String message){
        assertTrue("is not displayed", messageArea.isDisplayed());
        messageArea.sendKeys(message);

    }

    public void clickSendBtn(){
        assertTrue("button is not enabled", sendBtn.isEnabled());
        actions.click(sendBtn).perform();
    }

    public void seeSuccessMsg(String alert){
        assertEquals("alert message is not displayed", alert, successAlertMessage.isDisplayed());

    }



    public void enterUnRegisteredEmail(String email){
        assertTrue("input email is not displayed", emailInput.isDisplayed());
        emailInput.sendKeys(email);
    }

    public void enterUnRegisteredReference(String reference){
        assertTrue("input reference is not displayed", orderRefDropDown.isDisplayed());
        orderRefDropDown.sendKeys(reference);
    }
}









