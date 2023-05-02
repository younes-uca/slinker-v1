package ma.zsmart.slinker.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "notification")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="notification_seq",sequenceName="notification_seq",allocationSize=1, initialValue = 1)
public class Notification   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String description;

    private StatutNotification statutNotification ;
    
    private NotificationDetail notificationDetail ;
    


    public Notification(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="notification_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public StatutNotification getStatutNotification(){
        return this.statutNotification;
    }
    public void setStatutNotification(StatutNotification statutNotification){
        this.statutNotification = statutNotification;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public NotificationDetail getNotificationDetail(){
        return this.notificationDetail;
    }
    public void setNotificationDetail(NotificationDetail notificationDetail){
        this.notificationDetail = notificationDetail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification notification = (Notification) o;
        return id != null && id.equals(notification.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

