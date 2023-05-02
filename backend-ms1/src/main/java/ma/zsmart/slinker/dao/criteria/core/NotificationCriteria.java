package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;

public class NotificationCriteria extends  BaseCriteria  {

    private String description;
    private String descriptionLike;

    private StatutNotificationCriteria statutNotification ;
    private List<StatutNotificationCriteria> statutNotifications ;
    private NotificationDetailCriteria notificationDetail ;
    private List<NotificationDetailCriteria> notificationDetails ;


    public NotificationCriteria(){}

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public StatutNotificationCriteria getStatutNotification(){
        return this.statutNotification;
    }

    public void setStatutNotification(StatutNotificationCriteria statutNotification){
        this.statutNotification = statutNotification;
    }
    public List<StatutNotificationCriteria> getStatutNotifications(){
        return this.statutNotifications;
    }

    public void setStatutNotifications(List<StatutNotificationCriteria> statutNotifications){
        this.statutNotifications = statutNotifications;
    }
    public NotificationDetailCriteria getNotificationDetail(){
        return this.notificationDetail;
    }

    public void setNotificationDetail(NotificationDetailCriteria notificationDetail){
        this.notificationDetail = notificationDetail;
    }
    public List<NotificationDetailCriteria> getNotificationDetails(){
        return this.notificationDetails;
    }

    public void setNotificationDetails(List<NotificationDetailCriteria> notificationDetails){
        this.notificationDetails = notificationDetails;
    }
}
