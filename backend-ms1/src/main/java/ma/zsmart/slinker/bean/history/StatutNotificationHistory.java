package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "statut_notification")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="statut_notification_seq",sequenceName="statut_notification_seq",allocationSize=1, initialValue = 1)
public class StatutNotificationHistory extends HistBusinessObject  {


    public StatutNotificationHistory() {
    super();
    }

    public StatutNotificationHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="statut_notification_seq")
    public Long getId() {
    return id;
    }
}

