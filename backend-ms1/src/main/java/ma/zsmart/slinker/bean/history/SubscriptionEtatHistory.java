package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "subscription_etat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscription_etat_seq",sequenceName="subscription_etat_seq",allocationSize=1, initialValue = 1)
public class SubscriptionEtatHistory extends HistBusinessObject  {


    public SubscriptionEtatHistory() {
    super();
    }

    public SubscriptionEtatHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscription_etat_seq")
    public Long getId() {
    return id;
    }
}

