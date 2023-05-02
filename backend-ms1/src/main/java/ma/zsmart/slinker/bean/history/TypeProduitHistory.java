package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "type_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_produit_seq",sequenceName="type_produit_seq",allocationSize=1, initialValue = 1)
public class TypeProduitHistory extends HistBusinessObject  {


    public TypeProduitHistory() {
    super();
    }

    public TypeProduitHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_produit_seq")
    public Long getId() {
    return id;
    }
}

