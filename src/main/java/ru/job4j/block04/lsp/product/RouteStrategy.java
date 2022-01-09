package ru.job4j.block04.lsp.product;

import ru.job4j.block04.lsp.product.repositories.Repositories;

public class RouteStrategy {
    private Repositories repositories;

    public Repositories getRepositories() {
        return repositories;
    }

    public void route(Repositories repositories) {
        this.repositories = repositories;
    }
}
