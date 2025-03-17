package com.exemplo.pages;

import com.exemplo.maps.BlogSelectors;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends BasePage {

    @FindBy(css = BlogSelectors.SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(id = BlogSelectors.SEARCH_FIELD)
    private WebElement searchField;

    @FindBy(xpath = BlogSelectors.SEARCH_SUBMIT)
    private WebElement searchSubmit;

    @FindBy(css = BlogSelectors.POST_TITLE)
    private WebElement postTitle;

    @FindBy(id = BlogSelectors.POST_1)
    private WebElement post1;

    @FindBy(css = BlogSelectors.ERROR_MESSAGE)
    private WebElement postErrorMessage;

    public BlogPage(WebDriver driver) {
        super(driver);
    }


    public void navigateTo() {
        driver.get(BlogSelectors.BASE_URL);
    }


    public void clickSearchButton() {
        searchButton.click();
    }


    public void enterSearchText(String text) {
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
    }

    public String getPageTitle() {
        return getTitle();
    }


    public boolean isPagePostSucess() {
        String title = postTitle.getText();
        return title.contains(BlogSelectors.SEARCH_RESULTS_PREFIX);
    }


    public boolean isPostPresent() {
        try {
            return post1.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isPageErrorMessageDisplayed() {
        try {
            String errorMessage = postErrorMessage.getText();
            return errorMessage.contains(BlogSelectors.ERROR_MESSAGE_TEXT);
        } catch (Exception e) {
            return false;
        }
    }


    public String getExpectedTitle() {
        return BlogSelectors.EXPECTED_TITLE;
    }
}