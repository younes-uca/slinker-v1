package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.SubscriptionEtatHistory;
import ma.zsmart.slinker.bean.core.SubscriptionEtat;
import ma.zsmart.slinker.ws.dto.SubscriptionEtatDto;

@Component
public class SubscriptionEtatConverter extends AbstractConverter<SubscriptionEtat, SubscriptionEtatDto, SubscriptionEtatHistory> {


    public  SubscriptionEtatConverter(){
        super(SubscriptionEtat.class, SubscriptionEtatDto.class, SubscriptionEtatHistory.class);
    }

    @Override
    public SubscriptionEtat toItem(SubscriptionEtatDto dto) {
        if (dto == null) {
            return null;
        } else {
        SubscriptionEtat item = new SubscriptionEtat();
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
    public SubscriptionEtatDto toDto(SubscriptionEtat item) {
        if (item == null) {
            return null;
        } else {
            SubscriptionEtatDto dto = new SubscriptionEtatDto();
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
