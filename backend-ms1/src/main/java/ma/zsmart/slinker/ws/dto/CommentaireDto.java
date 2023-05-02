package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentaireDto  extends AuditBaseDto {

    private String contenu  ;
    private String dateCommentaire ;

    private ArticleDto article ;



    public CommentaireDto(){
        super();
    }



    @Log
    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateCommentaire(){
        return this.dateCommentaire;
    }
    public void setDateCommentaire(String dateCommentaire){
        this.dateCommentaire = dateCommentaire;
    }


    public ArticleDto getArticle(){
        return this.article;
    }

    public void setArticle(ArticleDto article){
        this.article = article;
    }




}
