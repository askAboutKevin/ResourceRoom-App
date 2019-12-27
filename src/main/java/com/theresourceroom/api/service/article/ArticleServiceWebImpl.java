package com.theresourceroom.api.service.article;

import com.theresourceroom.api.dal.dao.ArticleDAO;
import com.theresourceroom.api.models.Article;

import java.util.List;

public class ArticleServiceWebImpl implements ArticleService {

    private ArticleDAO articleDAO;

    public ArticleServiceWebImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public List<Article> getArticles() {
        return articleDAO.getArticles();
    }

    @Override
    public Article getArticleById(int id) {
        return articleDAO.getArticleById(id);
    }

    @Override
    public List<Article> getArticlesInTheme(int topic) {
        return articleDAO.getArticlesInTheme(topic);
    }

    @Override
    public int addArticle(String name, String link_story, String link_image) {
        return articleDAO.addArticle(name, link_story, link_image);
    }

    @Override
    public int updateArticleWithId(String name, String link_story, String link_image, int id) {
        return articleDAO.updateArticleWithId(name, link_story, link_image, id);
    }

    @Override
    public int deleteArticleById(int id) {
        return articleDAO.deleteArticleById(id);
    }
}
