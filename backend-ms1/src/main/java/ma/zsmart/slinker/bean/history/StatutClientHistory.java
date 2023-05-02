package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "statut_client")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="statut_client_seq",sequenceName="statut_client_seq",allocationSize=1, initialValue = 1)
public class StatutClientHistory extends HistBusinessObject  {


    public StatutClientHistory() {
    super();
    }

    public StatutClientHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="statut_client_seq")
    public Long getId() {
    return id;
    }
}

