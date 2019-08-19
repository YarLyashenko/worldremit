package com.lyashenko.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CareersPage {

    private SelenideElement jobSection = $("section#jobs-section");
    private SelenideElement departmentSelect = $("select#department-select");
    private SelenideElement officeSelect = $("select#office-select");
    private ElementsCollection jobItems = $$("a.job-item");

    public void scrollToJobsSection() {
        jobSection.scrollTo();
    }

    public void selectDepartment(String departmentName) {
        departmentSelect.selectOption(departmentName);
        departmentSelect.shouldHave(Condition.text(departmentName));
    }

    public void selectOfficeLocation(String officeLocation) {
        officeSelect.selectOption(officeLocation);
        officeSelect.shouldHave(Condition.text(officeLocation));
    }

    public ElementsCollection getJobItems(String jobName) {
        //wait for loading
        jobItems.shouldBe(CollectionCondition.sizeGreaterThan(0));

        return jobItems.filterBy(Condition.have(Condition.matchesText(jobName)));
    }

    public void clickOnJobItem(String jobName) {
        getJobItems(jobName).first().find(".job-item-link").click();
    }
}
