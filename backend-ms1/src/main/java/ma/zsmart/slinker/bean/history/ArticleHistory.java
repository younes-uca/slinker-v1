package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "article")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="article_seq",sequenceName="article_seq",allocationSize=1, initialValue = 1)
public class ArticleHistory extends HistBusinessObject  {


    public ArticleHistory() {
    super();
    }

    public ArticleHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="article_seq")
    public Long getId() {
    return id;
    }
}

