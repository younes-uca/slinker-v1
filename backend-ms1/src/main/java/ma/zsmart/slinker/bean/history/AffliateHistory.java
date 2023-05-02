package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "affliate")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="affliate_seq",sequenceName="affliate_seq",allocationSize=1, initialValue = 1)
public class AffliateHistory extends HistBusinessObject  {


    public AffliateHistory() {
    super();
    }

    public AffliateHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="affliate_seq")
    public Long getId() {
    return id;
    }
}

