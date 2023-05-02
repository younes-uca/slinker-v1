package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "subscription")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscription_seq",sequenceName="subscription_seq",allocationSize=1, initialValue = 1)
public class SubscriptionHistory extends HistBusinessObject  {


    public SubscriptionHistory() {
    super();
    }

    public SubscriptionHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscription_seq")
    public Long getId() {
    return id;
    }
}

