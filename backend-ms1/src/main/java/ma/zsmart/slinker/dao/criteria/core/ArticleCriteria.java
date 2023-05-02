package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ArticleCriteria extends  BaseCriteria  {

    private String titre;
    private String titreLike;
    private String contenu;
    private String contenuLike;
    private String image;
    private String imageLike;



    public ArticleCriteria(){}

    public String getTitre(){
        return this.titre;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    public String getTitreLike(){
        return this.titreLike;
    }
    public void setTitreLike(String titreLike){
        this.titreLike = titreLike;
    }

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

    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImageLike(){
        return this.imageLike;
    }
    public void setImageLike(String imageLike){
        this.imageLike = imageLike;
    }


}
