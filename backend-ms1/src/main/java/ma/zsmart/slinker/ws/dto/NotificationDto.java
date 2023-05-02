package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDto  extends AuditBaseDto {

    private String description  ;

    private StatutNotificationDto statutNotification ;
    private NotificationDetailDto notificationDetail ;



    public NotificationDto(){
        super();
    }



    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public StatutNotificationDto getStatutNotification(){
        return this.statutNotification;
    }

    public void setStatutNotification(StatutNotificationDto statutNotification){
        this.statutNotification = statutNotification;
    }
    public NotificationDetailDto getNotificationDetail(){
        return this.notificationDetail;
    }

    public void setNotificationDetail(NotificationDetailDto notificationDetail){
        this.notificationDetail = notificationDetail;
    }




}
