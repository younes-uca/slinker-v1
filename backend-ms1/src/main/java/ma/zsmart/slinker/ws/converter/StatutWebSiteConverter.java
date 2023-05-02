package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.StatutWebSiteHistory;
import ma.zsmart.slinker.bean.core.StatutWebSite;
import ma.zsmart.slinker.ws.dto.StatutWebSiteDto;

@Component
public class StatutWebSiteConverter extends AbstractConverter<StatutWebSite, StatutWebSiteDto, StatutWebSiteHistory> {


    public  StatutWebSiteConverter(){
        super(StatutWebSite.class, StatutWebSiteDto.class, StatutWebSiteHistory.class);
    }

    @Override
    public StatutWebSite toItem(StatutWebSiteDto dto) {
        if (dto == null) {
            return null;
        } else {
        StatutWebSite item = new StatutWebSite();
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
    public StatutWebSiteDto toDto(StatutWebSite item) {
        if (item == null) {
            return null;
        } else {
            StatutWebSiteDto dto = new StatutWebSiteDto();
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
