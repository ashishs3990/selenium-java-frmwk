package com.swiggy;

import com.swiggy.core.annotations.TestInfo;
import com.swiggy.core.base.BaseFrontEndTest;
import com.swiggy.core.model.TestPriority;
import com.swiggy.core.model.TestSeverity;
import com.swiggy.core.model.TestcaseInventory;
import com.swiggy.pages.GuestHomePage;
import com.swiggy.pages.GuestWelcomePage;
import com.swiggy.test.data.providers.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuestUserLocationTest extends BaseFrontEndTest {
    private GuestWelcomePage homePage;
    private GuestHomePage guestHomePage;

    @Test(groups = {"sanity", "regression"}, dataProvider = "data-provider", dataProviderClass = TestDataProvider.class)
    @TestInfo(
            testcaseInvType = TestcaseInventory.JIRA,
            testSuiteId = "GuestUserSuite",
            testId = "1",
            priority = TestPriority.P4,
            severity = TestSeverity.S4,
            testArea = "GuestUserJourney",
            testOwner = "Ashish Sharma<ashishs3990@gmail.com>",
            testLocation = ""
    )
    public void validateRestaurantsCount(String locationText, String tabIndex) {
        homePage = new GuestWelcomePage(getDriver());
        guestHomePage = homePage.selectLocation(locationText, tabIndex);
        int restaurantCount = guestHomePage.getRestaurantsCount();
        if (restaurantCount <= 1000) Assert.fail("Restaurant Count is <= 1000 | Actual Count: " + restaurantCount);
    }
}
