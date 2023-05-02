package ma.zsmart.slinker.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "notification_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="notification_detail_seq",sequenceName="notification_detail_seq",allocationSize=1, initialValue = 1)
public class NotificationDetail   extends AuditBusinessObject     {

    private Long id;


    private Client client ;
    
    private Notification notification ;
    


    public NotificationDetail(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="notification_detail_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Notification getNotification(){
        return this.notification;
    }
    public void setNotification(Notification notification){
        this.notification = notification;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationDetail notificationDetail = (NotificationDetail) o;
        return id != null && id.equals(notificationDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

