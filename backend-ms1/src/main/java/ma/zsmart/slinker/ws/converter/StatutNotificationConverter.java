package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.StatutNotificationHistory;
import ma.zsmart.slinker.bean.core.StatutNotification;
import ma.zsmart.slinker.ws.dto.StatutNotificationDto;

@Component
public class StatutNotificationConverter extends AbstractConverter<StatutNotification, StatutNotificationDto, StatutNotificationHistory> {


    public  StatutNotificationConverter(){
        super(StatutNotification.class, StatutNotificationDto.class, StatutNotificationHistory.class);
    }

    @Override
    public StatutNotification toItem(StatutNotificationDto dto) {
        if (dto == null) {
            return null;
        } else {
        StatutNotification item = new StatutNotification();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public StatutNotificationDto toDto(StatutNotification item) {
        if (item == null) {
            return null;
        } else {
            StatutNotificationDto dto = new StatutNotificationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
