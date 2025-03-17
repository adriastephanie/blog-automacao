package com.exemplo.maps;

public class BlogSelectors {
    // Constantes para URLs e textos
    public static final String BASE_URL = "https://blog.agibank.com.br/";
    public static final String EXPECTED_TITLE = "Agi Blog | Tudo sobre empréstimo e educação financeira";
    public static final String SEARCH_RESULTS_PREFIX = "Resultados encontrados para: ";
    public static final String ERROR_MESSAGE_TEXT = "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.";
    // Seletores para elementos blog
    public static final String SEARCH_BUTTON = ".ast-search-menu-icon";
    public static final String SEARCH_FIELD = "search-field";
    public static final String SEARCH_SUBMIT = "//button[@class='search-submit ast-search-submit' and @aria-label='Enviar pesquisa']";
    public static final String POST_TITLE = ".page-title.ast-archive-title";
    public static final String POST_1 = "post-15604";
    public static final String ERROR_MESSAGE = ".no-results .page-content p";
}
