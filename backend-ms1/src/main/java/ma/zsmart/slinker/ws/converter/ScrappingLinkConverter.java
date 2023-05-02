package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.slinker.bean.core.WebSite;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.ScrappingLinkHistory;
import ma.zsmart.slinker.bean.core.ScrappingLink;
import ma.zsmart.slinker.ws.dto.ScrappingLinkDto;

@Component
public class ScrappingLinkConverter extends AbstractConverter<ScrappingLink, ScrappingLinkDto, ScrappingLinkHistory> {

    @Autowired
    private WebSiteConverter webSiteConverter ;
    private boolean webSite;

    public  ScrappingLinkConverter(){
        super(ScrappingLink.class, ScrappingLinkDto.class, ScrappingLinkHistory.class);
    }

    @Override
    public ScrappingLink toItem(ScrappingLinkDto dto) {
        if (dto == null) {
            return null;
        } else {
        ScrappingLink item = new ScrappingLink();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(dto.getWebSite() != null && dto.getWebSite().getId() != null){
                item.setWebSite(new WebSite());
                item.getWebSite().setId(dto.getWebSite().getId());
            }



        return item;
        }
    }

    @Override
    public ScrappingLinkDto toDto(ScrappingLink item) {
        if (item == null) {
            return null;
        } else {
            ScrappingLinkDto dto = new ScrappingLinkDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.webSite && item.getWebSite()!=null) {
            dto.setWebSite(webSiteConverter.toDto(item.getWebSite())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.webSite = value;
    }


    public WebSiteConverter getWebSiteConverter(){
        return this.webSiteConverter;
    }
    public void setWebSiteConverter(WebSiteConverter webSiteConverter ){
        this.webSiteConverter = webSiteConverter;
    }
    public boolean  isWebSite(){
        return this.webSite;
    }
    public void  setWebSite(boolean webSite){
        this.webSite = webSite;
    }
}
