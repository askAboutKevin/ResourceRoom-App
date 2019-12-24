package com.theresourceroom.api.dal.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.theresourceroom.api.models.Article;

public interface ArticleDAO {

	List<Article> getArticles();
	
	Article getArticleById(int id);
	
	List<Article> getArticlesInTheme();
	
	int updateArticleWithId(int id);
	
	int deleteArticleById(int id);
}
