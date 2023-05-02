package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.SubscriptionPackHistory;
import ma.zsmart.slinker.bean.core.SubscriptionPack;
import ma.zsmart.slinker.ws.dto.SubscriptionPackDto;

@Component
public class SubscriptionPackConverter extends AbstractConverter<SubscriptionPack, SubscriptionPackDto, SubscriptionPackHistory> {


    public  SubscriptionPackConverter(){
        super(SubscriptionPack.class, SubscriptionPackDto.class, SubscriptionPackHistory.class);
    }

    @Override
    public SubscriptionPack toItem(SubscriptionPackDto dto) {
        if (dto == null) {
            return null;
        } else {
        SubscriptionPack item = new SubscriptionPack();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());


        return item;
        }
    }

    @Override
    public SubscriptionPackDto toDto(SubscriptionPack item) {
        if (item == null) {
            return null;
        } else {
            SubscriptionPackDto dto = new SubscriptionPackDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
