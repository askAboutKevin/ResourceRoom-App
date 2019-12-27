package com.theresourceroom.api.service.article;

import com.theresourceroom.api.models.Article;
import java.util.List;

public interface ArticleService {

    List<Article> getArticles();

    Article getArticleById(int id);

    List<Article> getArticlesInTheme(int topic);

    int addArticle(String name, String link_story, String link_image);

    int updateArticleWithId(String name, String link_story, String link_image, int id);

    int deleteArticleById(int id);
}
