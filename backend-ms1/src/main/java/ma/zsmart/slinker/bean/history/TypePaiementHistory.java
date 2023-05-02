package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "type_paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_paiement_seq",sequenceName="type_paiement_seq",allocationSize=1, initialValue = 1)
public class TypePaiementHistory extends HistBusinessObject  {


    public TypePaiementHistory() {
    super();
    }

    public TypePaiementHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_paiement_seq")
    public Long getId() {
    return id;
    }
}

