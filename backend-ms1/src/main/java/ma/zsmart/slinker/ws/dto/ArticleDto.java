package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDto  extends AuditBaseDto {

    private String titre  ;
    private String contenu  ;
    private String image  ;


    private List<CommentaireDto> commentaires ;


    public ArticleDto(){
        super();
    }



    @Log
    public String getTitre(){
        return this.titre;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }

    @Log
    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }

    @Log
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }





    public List<CommentaireDto> getCommentaires(){
        return this.commentaires;
    }

    public void setCommentaires(List<CommentaireDto> commentaires){
        this.commentaires = commentaires;
    }

}
