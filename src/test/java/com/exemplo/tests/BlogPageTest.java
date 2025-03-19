package com.exemplo.tests;
import com.exemplo.pages.BasePage;
import com.exemplo.pages.BlogPage;
import com.exemplo.utils.Base;
import org.junit.jupiter.api.*;

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
    @DisplayName("Validar carregamento do blog")
    @Tag("funcional")
    public void testHomePage() {
        blogPage.navigateTo();
        String title = blogPage.getPageTitle();
        assertEquals(blogPage.getExpectedTitle(), title);

    }
    @Test
    @DisplayName("Validar pesquisa do post com palavra valida")
    @Tag("funcional")
    public void testSearchSucess() throws InterruptedException {
        blogPage.navigateTo();
        Thread.sleep(3000);
        blogPage.clickSearchButton();
        Thread.sleep(3000);
        blogPage.enterSearchText("limbo");
        Thread.sleep(5000);
        assertTrue(blogPage.isPagePostSucess(), "O Resultados não foi encontrado");
        assertTrue(blogPage.isPostPresent(), "A mensagem de erro esperada não foi encontrada.");
    }

    @Test
    @DisplayName("Validar pesquisa do post com palavra invalida")
    @Tag("negativo")
    public void testSearchFailed() throws InterruptedException {
        blogPage.navigateTo();
        Thread.sleep(3000);
        blogPage.clickSearchButton();
        Thread.sleep(3000);
        blogPage.enterSearchText("tetete");
        Thread.sleep(5000);
        assertTrue(blogPage.isPagePostSucess(), "O Resultados não foi encontrado");
        assertTrue(blogPage.isPageErrorMessageDisplayed(), "A mensagem de erro esperada não foi encontrada.");
    }
}