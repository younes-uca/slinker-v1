package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDetailDto  extends AuditBaseDto {


    private ClientDto client ;
    private NotificationDto notification ;



    public NotificationDetailDto(){
        super();
    }




    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public NotificationDto getNotification(){
        return this.notification;
    }

    public void setNotification(NotificationDto notification){
        this.notification = notification;
    }




}
