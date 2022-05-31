package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions( plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
                                         "json:target/cucumber-reports/cucumber.json" },
features={"src/test/resources/features/SalesfrocePOM.feature"},
glue="com.steps",monochrome=true,dryRun=false)
public class Runner extends AbstractTestNGCucumberTests{

}
