package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;

public class NotificationDetailCriteria extends  BaseCriteria  {


    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private NotificationCriteria notification ;
    private List<NotificationCriteria> notifications ;


    public NotificationDetailCriteria(){}


    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
    public NotificationCriteria getNotification(){
        return this.notification;
    }

    public void setNotification(NotificationCriteria notification){
        this.notification = notification;
    }
    public List<NotificationCriteria> getNotifications(){
        return this.notifications;
    }

    public void setNotifications(List<NotificationCriteria> notifications){
        this.notifications = notifications;
    }
}
