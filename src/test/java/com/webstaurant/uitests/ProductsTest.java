package com.webstaurant.uitests;

import com.webstaurant.testcommon.TestCore;
import org.testng.annotations.Test;

public class ProductsTest extends TestCore {

    @Test(dataProvider = "dataProvider", description = "test coverage for Webstaurant store search functionality")
    public void performProductSearch(String searchText, String verifyText) {
        homepage.fillOutSearchField(searchText)
                .clickSearchButton()
                .verifyExpectedTextAgainstCategoriesBox(verifyText)
                .verifyExpectedTextAgainstSearchResultsProductListing(verifyText);
    }

}
