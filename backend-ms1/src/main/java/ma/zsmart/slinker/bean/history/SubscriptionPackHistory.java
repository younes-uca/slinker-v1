package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "subscription_pack")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscription_pack_seq",sequenceName="subscription_pack_seq",allocationSize=1, initialValue = 1)
public class SubscriptionPackHistory extends HistBusinessObject  {


    public SubscriptionPackHistory() {
    super();
    }

    public SubscriptionPackHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscription_pack_seq")
    public Long getId() {
    return id;
    }
}

