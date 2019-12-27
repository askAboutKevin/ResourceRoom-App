package com.theresourceroom.api.dal.dao;

import com.theresourceroom.api.dal.mapper.ArticleMapper;
import com.theresourceroom.api.models.Article;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ArticleDAO {

	@SqlQuery("SELECT id, name, link_story, link_image FROM Article")
	@RegisterRowMapper(ArticleMapper.class)
	List<Article> getArticles();

	@SqlQuery("SELECT id, name, link_story, link_image FROM Article WHERE id = ?")
	@RegisterRowMapper(ArticleMapper.class)
	Article getArticleById(int id);

	@SqlQuery("SELECT id, name, link_story, link_image FROM Article WHERE id IN (SELECT article_id FROM Article_topic WHERE topic_id = ?)")
	@RegisterRowMapper(ArticleMapper.class)
	List<Article> getArticlesInTheme(int topic);

	@SqlUpdate("INSERT INTO Article (name, link_story, link_image) VALUES (?, ?, ?)")
	int addArticle(String name, String link_story, String link_image);

	@SqlUpdate("UPDATE Article SET name = ?, link_story ?, link_image = ? WHERE id = ?")
	int updateArticleWithId(String name, String link_story, String link_image, int id);

	@SqlUpdate("DELETE FROM Article WHERE id = ?")
	int deleteArticleById(int id);


}
