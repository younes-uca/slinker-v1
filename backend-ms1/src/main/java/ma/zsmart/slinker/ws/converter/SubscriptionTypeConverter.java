package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.SubscriptionTypeHistory;
import ma.zsmart.slinker.bean.core.SubscriptionType;
import ma.zsmart.slinker.ws.dto.SubscriptionTypeDto;

@Component
public class SubscriptionTypeConverter extends AbstractConverter<SubscriptionType, SubscriptionTypeDto, SubscriptionTypeHistory> {


    public  SubscriptionTypeConverter(){
        super(SubscriptionType.class, SubscriptionTypeDto.class, SubscriptionTypeHistory.class);
    }

    @Override
    public SubscriptionType toItem(SubscriptionTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        SubscriptionType item = new SubscriptionType();
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
    public SubscriptionTypeDto toDto(SubscriptionType item) {
        if (item == null) {
            return null;
        } else {
            SubscriptionTypeDto dto = new SubscriptionTypeDto();
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
