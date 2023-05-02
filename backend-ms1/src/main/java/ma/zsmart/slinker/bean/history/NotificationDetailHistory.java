package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "notification_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="notification_detail_seq",sequenceName="notification_detail_seq",allocationSize=1, initialValue = 1)
public class NotificationDetailHistory extends HistBusinessObject  {


    public NotificationDetailHistory() {
    super();
    }

    public NotificationDetailHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="notification_detail_seq")
    public Long getId() {
    return id;
    }
}

