package by.tempus.ui;

import by.tempus.webDriver.WebDriver;

public class SearchPage {
    private final String INPUT_SEARCH = "//input[@id='title-search-input']";
    private final String BUTTON_SEARCH = "//input[@id='title-search-input']/following-sibling::button";
    private final String TITLE_FULL_NAME_SEARCH_RESULT = "//a[@class='product-card__name' and contains(text(), 'Emporio Armani Sports AR2460')]";
    private final String TITLE_PARTIAL_NAME_SEARCH_RESULT = "//a[@class='product-card__name']";
    private final String TITLE_NO_RESULTS = "//div[@class='container' and contains(., 'Сожалеем, но ничего не найдено.')]";

    public SearchPage sendKeysSearchInput(String text) {
        WebDriver.sendkeysToElement(INPUT_SEARCH, text);
        return this;
    }

    public SearchPage clickSearchButton() {
        WebDriver.clickElement(BUTTON_SEARCH);
        return this;
    }

    public void searchFor(String text) {
        sendKeysSearchInput(text);
        clickSearchButton();
    }

    public String getSpecificSearchResultText() {
        return WebDriver.getTextFromElement(TITLE_FULL_NAME_SEARCH_RESULT);
    }

    public String getFirstSearchResultText() {
        return WebDriver.getTextFromElement(TITLE_PARTIAL_NAME_SEARCH_RESULT);
    }

    public String getNoResultsMessageText() {
        return WebDriver.getTextFromElement(TITLE_NO_RESULTS);
    }
}
