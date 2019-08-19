package com.lyashenko.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class JobListingPage {
    public static final String ERROR_TEXT_ATTRIBUTE_NAME = "data-message-error";
    private SelenideElement firstNameInput = $("input#First_Name");
    private SelenideElement lastNameInput = $("input#Last_Name");
    private SelenideElement emailInput = $("input#Email");
    private SelenideElement submitButton = $("input[type='submit']");
    private SelenideElement resumeErrorMessage = $("span#message_for_Resume");

    public void fillFirstName(String name) {
        firstNameInput.setValue(name);
    }

    public void fillLastName(String name) {
        lastNameInput.setValue(name);
    }

    public void fillEmailName(String email) {
        emailInput.setValue(email);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public SelenideElement getResumeErrorMessage() {
        return resumeErrorMessage;
    }
}
