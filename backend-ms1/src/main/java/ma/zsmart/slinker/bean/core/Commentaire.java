package ma.zsmart.slinker.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "commentaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="commentaire_seq",sequenceName="commentaire_seq",allocationSize=1, initialValue = 1)
public class Commentaire   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String contenu;
    private LocalDateTime dateCommentaire ;

    private Article article ;
    


    public Commentaire(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="commentaire_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    public LocalDateTime getDateCommentaire(){
        return this.dateCommentaire;
    }
    public void setDateCommentaire(LocalDateTime dateCommentaire){
        this.dateCommentaire = dateCommentaire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Article getArticle(){
        return this.article;
    }
    public void setArticle(Article article){
        this.article = article;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentaire commentaire = (Commentaire) o;
        return id != null && id.equals(commentaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

