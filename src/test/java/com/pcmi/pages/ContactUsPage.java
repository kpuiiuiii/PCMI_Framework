package com.pcmi.pages;

import com.pcmi.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends MainPage{


    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement fNameField;
    @FindBy(xpath = "//*[@id=\"lastname-19c2f669-20fa-4e63-9993-309b89f1e8b2\"]")
    public WebElement lNameField;
    @FindBy(xpath = "//*[@id=\"email-19c2f669-20fa-4e63-9993-309b89f1e8b2\"]")
    public WebElement emailField;
    @FindBy(xpath = "//*[@id=\"phone-19c2f669-20fa-4e63-9993-309b89f1e8b2\"]")
    public WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"hsForm_19c2f669-20fa-4e63-9993-309b89f1e8b2\"]/div/div[2]/input")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"hsForm_19c2f669-20fa-4e63-9993-309b89f1e8b2\"]/div[1]/ul/li/label")
    public WebElement messageAlert;








}
