package com.lyashenko;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.TextReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},tags = "not @ignore")
public class RunCucumberTest {

    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/surefire-reports";
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
