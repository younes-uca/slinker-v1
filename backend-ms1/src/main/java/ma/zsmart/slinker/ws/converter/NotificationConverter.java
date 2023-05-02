package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.NotificationHistory;
import ma.zsmart.slinker.bean.core.Notification;
import ma.zsmart.slinker.ws.dto.NotificationDto;

@Component
public class NotificationConverter extends AbstractConverter<Notification, NotificationDto, NotificationHistory> {

    @Autowired
    private NotificationDetailConverter notificationDetailConverter ;
    @Autowired
    private StatutNotificationConverter statutNotificationConverter ;
    private boolean statutNotification;
    private boolean notificationDetail;

    public  NotificationConverter(){
        super(Notification.class, NotificationDto.class, NotificationHistory.class);
    }

    @Override
    public Notification toItem(NotificationDto dto) {
        if (dto == null) {
            return null;
        } else {
        Notification item = new Notification();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.statutNotification && dto.getStatutNotification()!=null)
                item.setStatutNotification(statutNotificationConverter.toItem(dto.getStatutNotification())) ;

            if(this.notificationDetail && dto.getNotificationDetail()!=null)
                item.setNotificationDetail(notificationDetailConverter.toItem(dto.getNotificationDetail())) ;



        return item;
        }
    }

    @Override
    public NotificationDto toDto(Notification item) {
        if (item == null) {
            return null;
        } else {
            NotificationDto dto = new NotificationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.statutNotification && item.getStatutNotification()!=null) {
            dto.setStatutNotification(statutNotificationConverter.toDto(item.getStatutNotification())) ;
        }
        if(this.notificationDetail && item.getNotificationDetail()!=null) {
            notificationDetailConverter.setNotification(false);
            dto.setNotificationDetail(notificationDetailConverter.toDto(item.getNotificationDetail())) ;
            notificationDetailConverter.setNotification(true);
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.statutNotification = value;
        this.notificationDetail = value;
    }


    public NotificationDetailConverter getNotificationDetailConverter(){
        return this.notificationDetailConverter;
    }
    public void setNotificationDetailConverter(NotificationDetailConverter notificationDetailConverter ){
        this.notificationDetailConverter = notificationDetailConverter;
    }
    public StatutNotificationConverter getStatutNotificationConverter(){
        return this.statutNotificationConverter;
    }
    public void setStatutNotificationConverter(StatutNotificationConverter statutNotificationConverter ){
        this.statutNotificationConverter = statutNotificationConverter;
    }
    public boolean  isStatutNotification(){
        return this.statutNotification;
    }
    public void  setStatutNotification(boolean statutNotification){
        this.statutNotification = statutNotification;
    }
    public boolean  isNotificationDetail(){
        return this.notificationDetail;
    }
    public void  setNotificationDetail(boolean notificationDetail){
        this.notificationDetail = notificationDetail;
    }
}
