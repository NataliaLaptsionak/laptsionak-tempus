package by.tempus.ui;

import by.tempus.ui.pages.homePage.HomePage;
import by.tempus.ui.pages.searchPage.SearchExpectedMessages;
import by.tempus.ui.pages.searchPage.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {
    private SearchPage searchPage;
    private HomePage homePage;
    @BeforeEach
    public void openHomePage() {
        homePage = new HomePage();
        homePage.openSite();
        searchPage = new SearchPage();
    }

    @Test
    @DisplayName("Checking that search results are partially relevant to the partial name.")
    public void validFullSearchTest() {
        String searchQuery = "Emporio Armani Sports AR2460";
        searchPage.searchFor(searchQuery);
        Assertions.assertTrue(searchPage.getSpecificSearchResultText(SearchExpectedMessages.FULL_SEARCH_RESULT)
                .contains(SearchExpectedMessages.FULL_SEARCH_RESULT), "Full search result not found.");
    }

    @Test
    @DisplayName("Checking that search results are partially relevant to the partial name.")
    public void validPartialSearchTest() {
        String partialSearchQuery = "Emporio";
        searchPage.searchFor(partialSearchQuery);
        Assertions.assertTrue(searchPage.getFirstSearchResultText().contains(partialSearchQuery),
                "Expected partial search result to contain: " + partialSearchQuery);
    }

    @Test
    @DisplayName("Checking message when searching for a non-existent query. Проверка сообщения при поиске по несуществующему запросу")
    public void invalidSearchTest() {
        String incorrectSearchQuery = "someinvalidquerry12345";
        searchPage.searchFor(incorrectSearchQuery);
        Assertions.assertTrue(searchPage.getNoResultsMessageText()
                .contains(SearchExpectedMessages.NO_RESULTS_MESSAGE), "Invalid search message not displayed.");
    }
}