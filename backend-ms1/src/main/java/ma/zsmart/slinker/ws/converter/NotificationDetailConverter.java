package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.slinker.bean.core.Client;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.NotificationDetailHistory;
import ma.zsmart.slinker.bean.core.NotificationDetail;
import ma.zsmart.slinker.ws.dto.NotificationDetailDto;

@Component
public class NotificationDetailConverter extends AbstractConverter<NotificationDetail, NotificationDetailDto, NotificationDetailHistory> {

    @Autowired
    private NotificationConverter notificationConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    private boolean client;
    private boolean notification;

    public  NotificationDetailConverter(){
        super(NotificationDetail.class, NotificationDetailDto.class, NotificationDetailHistory.class);
    }

    @Override
    public NotificationDetail toItem(NotificationDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        NotificationDetail item = new NotificationDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getClient() != null && dto.getClient().getId() != null){
                item.setClient(new Client());
                item.getClient().setId(dto.getClient().getId());
            }

            if(this.notification && dto.getNotification()!=null)
                item.setNotification(notificationConverter.toItem(dto.getNotification())) ;



        return item;
        }
    }

    @Override
    public NotificationDetailDto toDto(NotificationDetail item) {
        if (item == null) {
            return null;
        } else {
            NotificationDetailDto dto = new NotificationDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.notification && item.getNotification()!=null) {
            notificationConverter.setNotificationDetail(false);
            dto.setNotification(notificationConverter.toDto(item.getNotification())) ;
            notificationConverter.setNotificationDetail(true);
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.client = value;
        this.notification = value;
    }


    public NotificationConverter getNotificationConverter(){
        return this.notificationConverter;
    }
    public void setNotificationConverter(NotificationConverter notificationConverter ){
        this.notificationConverter = notificationConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isNotification(){
        return this.notification;
    }
    public void  setNotification(boolean notification){
        this.notification = notification;
    }
}
