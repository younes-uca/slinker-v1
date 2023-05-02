package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.StatutClientHistory;
import ma.zsmart.slinker.bean.core.StatutClient;
import ma.zsmart.slinker.ws.dto.StatutClientDto;

@Component
public class StatutClientConverter extends AbstractConverter<StatutClient, StatutClientDto, StatutClientHistory> {


    public  StatutClientConverter(){
        super(StatutClient.class, StatutClientDto.class, StatutClientHistory.class);
    }

    @Override
    public StatutClient toItem(StatutClientDto dto) {
        if (dto == null) {
            return null;
        } else {
        StatutClient item = new StatutClient();
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
    public StatutClientDto toDto(StatutClient item) {
        if (item == null) {
            return null;
        } else {
            StatutClientDto dto = new StatutClientDto();
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
