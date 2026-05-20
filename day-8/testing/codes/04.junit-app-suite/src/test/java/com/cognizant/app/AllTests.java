package com.cognizant.app;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import com.cognizant.app.services.*;
import com.cognizant.app.utils.EvenOddUtilityTest;


@Suite
@SuiteDisplayName(value = "ALL TESTS of APP PROJECT")
//@SelectClasses(value = {PalindromeTest.class, EvenOddUtilityTest.class, EvenOddUtilityTest1.class})
@SelectPackages(value = {"com.cognizant.app.services", "com.cognizant.app.utils"})
public class AllTests {

}
