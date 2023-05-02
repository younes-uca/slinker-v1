package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "subscription_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscription_type_seq",sequenceName="subscription_type_seq",allocationSize=1, initialValue = 1)
public class SubscriptionTypeHistory extends HistBusinessObject  {


    public SubscriptionTypeHistory() {
    super();
    }

    public SubscriptionTypeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscription_type_seq")
    public Long getId() {
    return id;
    }
}

