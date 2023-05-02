package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "commentaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="commentaire_seq",sequenceName="commentaire_seq",allocationSize=1, initialValue = 1)
public class CommentaireHistory extends HistBusinessObject  {


    public CommentaireHistory() {
    super();
    }

    public CommentaireHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="commentaire_seq")
    public Long getId() {
    return id;
    }
}

