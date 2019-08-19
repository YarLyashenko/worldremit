package com.lyashenko.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.lyashenko.pages.CareersPage;
import com.lyashenko.pages.JobListingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CareersStepDefinitions {
    private CareersPage careersPage = new CareersPage();
    private JobListingPage jobListingPage = new JobListingPage();

    @Given("I enter {string}")
    public void iEnter(String address) {
        open(address);
        assertEquals("Page url is invalid", address, url());
    }

    @When("I go to open position form")
    public void iGoToOpenPositionForm() {
        careersPage.scrollToJobsSection();
    }

    @When("I select a department {string}")
    public void iSelectADepartment(String departmentName) {
        careersPage.selectDepartment(departmentName);
    }

    @When("I select an office as {string}")
    public void iSelectAnOffice(String officeLocation) {
        careersPage.selectOfficeLocation(officeLocation);
    }

    @When("I find a position for {string}")
    public void iFindAPosition(String positionName) {
        careersPage.getJobItems(positionName).shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @When("I open {string} position")
    public void iOpenPosition(String positionName) {
        careersPage.clickOnJobItem(positionName);
        String currentPage = url();
        assertTrue("Page " + currentPage + "was opened instead of job listing",
                currentPage.contains("https://www.worldremit.com/en/careers/job-listing?jobid="));
    }

    @When("I fill in an application form without a resume")
    public void iFillInAnApplicationFormWithoutAResume() {
        jobListingPage.fillFirstName("Dart");
        jobListingPage.fillLastName("Vader");
        jobListingPage.fillEmailName("admin@deathstar.com");
    }

    @When("I click on apply now")
    public void iClickOnApplyNow() {
        jobListingPage.clickSubmitButton();
    }

    @Then("Validation error {string} is displayed")
    public void validationErrorIsDisplayed(String errorText) {
        jobListingPage.getResumeErrorMessage()
                .shouldBe(Condition.visible)
                .shouldBe(Condition.attribute(JobListingPage.ERROR_TEXT_ATTRIBUTE_NAME, errorText));
    }

}
