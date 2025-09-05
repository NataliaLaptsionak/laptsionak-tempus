package by.tempus.ui;

import by.tempus.HomePage;
import by.tempus.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    @BeforeEach
    public void openHomePage() {
        new HomePage().openSite();
    }

    @Test
    @DisplayName("Проверка поиска по полному названию существующего товара")
    public void validFullSearchTest() {
        SearchPage searchPage = new SearchPage();
        String searchQuery = "Наручные часы Emporio Armani Sports AR2460";
        searchPage.searchFor(searchQuery);

        String expectedResult = "Emporio Armani Sports AR2460";
        Assertions.assertEquals(expectedResult, searchPage.getSpecificSearchResultText());
    }

    @Test
    @DisplayName("Проверка, что результаты поиска по частичному названию релевантны")
    public void validPartialSearchTest() {
        SearchPage searchPage = new SearchPage();
        String searchQuery = "armani";
        searchPage.searchFor(searchQuery);

        String firstResultText = searchPage.getFirstSearchResultText();
        Assertions.assertTrue(firstResultText.toLowerCase().contains(searchQuery));
    }

    @Test
    @DisplayName("Проверка сообщения при поиске по несуществующему запросу")
    public void invalidSearchTest() {
        SearchPage searchPage = new SearchPage();
        searchPage.searchFor("someinvalidquerry12345");

        String expectedMessage = "Сожалеем, но ничего не найдено.";
        String pageText = searchPage.getNoResultsMessageText();

        Assertions.assertTrue(pageText.contains(expectedMessage),
                "Сообщение 'ничего не найдено' отсутствует на странице результатов поиска.");
    }
}