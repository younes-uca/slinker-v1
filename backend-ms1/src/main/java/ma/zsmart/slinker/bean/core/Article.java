package ma.zsmart.slinker.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "article")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="article_seq",sequenceName="article_seq",allocationSize=1, initialValue = 1)
public class Article   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String titre;
    @Column(length = 500)
    private String contenu;
    @Column(length = 500)
    private String image;


    private List<Commentaire> commentaires ;

    public Article(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="article_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getTitre(){
        return this.titre;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    @OneToMany(mappedBy = "article")
    public List<Commentaire> getCommentaires(){
        return this.commentaires;
    }
    public void setCommentaires(List<Commentaire> commentaires){
        this.commentaires = commentaires;
    }
    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

