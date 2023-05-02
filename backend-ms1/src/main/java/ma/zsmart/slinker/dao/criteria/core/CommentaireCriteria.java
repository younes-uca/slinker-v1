package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CommentaireCriteria extends  BaseCriteria  {

    private String contenu;
    private String contenuLike;
    private LocalDateTime dateCommentaire;
    private LocalDateTime dateCommentaireFrom;
    private LocalDateTime dateCommentaireTo;

    private ArticleCriteria article ;
    private List<ArticleCriteria> articles ;


    public CommentaireCriteria(){}

    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    public String getContenuLike(){
        return this.contenuLike;
    }
    public void setContenuLike(String contenuLike){
        this.contenuLike = contenuLike;
    }

    public LocalDateTime getDateCommentaire(){
        return this.dateCommentaire;
    }
    public void setDateCommentaire(LocalDateTime dateCommentaire){
        this.dateCommentaire = dateCommentaire;
    }
    public LocalDateTime getDateCommentaireFrom(){
        return this.dateCommentaireFrom;
    }
    public void setDateCommentaireFrom(LocalDateTime dateCommentaireFrom){
        this.dateCommentaireFrom = dateCommentaireFrom;
    }
    public LocalDateTime getDateCommentaireTo(){
        return this.dateCommentaireTo;
    }
    public void setDateCommentaireTo(LocalDateTime dateCommentaireTo){
        this.dateCommentaireTo = dateCommentaireTo;
    }

    public ArticleCriteria getArticle(){
        return this.article;
    }

    public void setArticle(ArticleCriteria article){
        this.article = article;
    }
    public List<ArticleCriteria> getArticles(){
        return this.articles;
    }

    public void setArticles(List<ArticleCriteria> articles){
        this.articles = articles;
    }
}
