package com.exemplo.tests;
import com.exemplo.pages.BlogPage;
import com.exemplo.utils.Base;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlogPageTest extends Base {
    private BlogPage blogPage;

    @BeforeEach
    public void setUpPage() {
        blogPage = new BlogPage(driver);
    }

    @AfterEach
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Tag("funcional")
    public void testHomePage() {
        blogPage.navigateTo();
        String title = blogPage.getPageTitle();
        assertEquals(blogPage.getExpectedTitle(), title);
    }
    @Test
    @Tag("funcional")
    public void testSearchSucess() {
        blogPage.navigateTo();
        blogPage.clickSearchButton();
        blogPage.enterSearchText("limbo");
        assertTrue(blogPage.isPagePostSucess(), "O Resultados não foi encontrado");
        assertTrue(blogPage.isPostPresent(), "A mensagem de erro esperada não foi encontrada.");
    }

    @Test
    @Tag("negativo")
    public void testSearchFailed() {
        blogPage.navigateTo();
        blogPage.clickSearchButton();
        blogPage.enterSearchText("tetete");
        assertTrue(blogPage.isPagePostSucess(), "O Resultados não foi encontrado");
        assertTrue(blogPage.isPageErrorMessageDisplayed(), "A mensagem de erro esperada não foi encontrada.");
    }
}