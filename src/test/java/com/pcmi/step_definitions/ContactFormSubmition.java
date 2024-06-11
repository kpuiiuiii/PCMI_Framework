package com.pcmi.step_definitions;

import com.github.javafaker.Faker;
import com.pcmi.pages.ContactUsPage;
import com.pcmi.pages.MainPage;
import com.pcmi.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactFormSubmition {
    Faker faker;
    ContactUsPage cp = new ContactUsPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String string) {
        Driver.getDriver().get("https://www.pcmicorp.com/contact/");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Talk to Us | PCMI Corporation");

    }
    @When("the user enters random test data for the form")
    public void the_user_enters_random_test_data_for_the_form(){

        wait.until(ExpectedConditions.elementToBeClickable(cp.cookieButton));
        Assert.assertTrue(cp.cookieButton.isDisplayed());
        cp.cookieButton.click();


        faker = new Faker();

        wait.until(ExpectedConditions.elementToBeClickable(cp.fNameField));
        cp.fNameField.sendKeys(faker.name().firstName());

        wait.until(ExpectedConditions.elementToBeClickable(cp.lNameField));
        cp.lNameField.sendKeys(faker.name().lastName());

        wait.until(ExpectedConditions.elementToBeClickable(cp.emailField));
        cp.emailField.sendKeys(faker.internet().emailAddress());

        wait.until(ExpectedConditions.elementToBeClickable(cp.phoneField));
        cp.phoneField.sendKeys(faker.phoneNumber().cellPhone());


    }
    @When("the user presses the {string} button")
    public void the_user_presses_the_button(String submit) {
        wait.until(ExpectedConditions.elementToBeClickable(cp.submitButton));
        cp.submitButton.click();

    }


    @Then("the user should see a message")
    public void theUserShouldSeeAMessage() throws InterruptedException {
        String message = cp.messageAlert.getText();
        Assert.assertEquals("Please complete all required fields.", message);
        Thread.sleep(4000);
        Driver.getDriver().quit();
    }
}
