package com.theresourceroom.api.resource;

import com.theresourceroom.api.models.Article;
import com.theresourceroom.api.service.article.ArticleService;
import java.util.OptionalInt;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("/article")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArticleResource {

    private ArticleService articleService;

    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GET
    public Response fetchArticles(@QueryParam("topic") OptionalInt topicId) {

        if (!topicId.isEmpty()) {
            List<Article> articles = this.articleService.getArticlesInTheme(topicId.getAsInt());

            if(articles != null) {
                return Response
                        .status(Response.Status.OK)
                        .entity(articles)
                        .build();
            }
            throw new WebApplicationException(Status.NOT_FOUND);
        }

        List<Article> articles = this.articleService.getArticles();

        if(articles != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(articles)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    public Response fetchArticleById(@PathParam("id") int articleId) {

        Article article = this.articleService.getArticleById(articleId);

        if(article != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(article)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @POST
    public Response postArticle(Article article) {

        String link_image = article.getLink_image();
        String link_story = article.getLink_story();
        String name = article.getName();

        int articlesCreated = this.articleService.addArticle(name, link_story, link_image);

        Boolean success = Boolean.FALSE;

        if( articlesCreated == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.CREATED)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @PUT
    @Path("/{id}")
    public Response updateArticleWithId(Article article, @PathParam("id") int articleId) {

        String name = article.getName();
        String link_story = article.getLink_story();
        String link_image = article.getLink_image();

        int articlesUpdated = this.articleService.updateArticleWithId(name, link_story, link_image, articleId);

        Boolean success = Boolean.FALSE;

        if( articlesUpdated == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.OK)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.CONFLICT);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteArticleById(@PathParam("id") int articleId) {

        Boolean success = Boolean.FALSE;

        int countDeleted = this.articleService.deleteArticleById(articleId);

        if( countDeleted == 1 ) {
            success = Boolean.TRUE;
            return Response
                    .status(Status.CREATED)
                    .entity(success)
                    .build();
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }



}
