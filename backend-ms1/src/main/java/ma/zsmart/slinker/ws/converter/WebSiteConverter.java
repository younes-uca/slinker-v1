package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zsmart.slinker.zynerator.util.ListUtil;

import ma.zsmart.slinker.bean.core.Client;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.WebSiteHistory;
import ma.zsmart.slinker.bean.core.WebSite;
import ma.zsmart.slinker.ws.dto.WebSiteDto;

@Component
public class WebSiteConverter extends AbstractConverter<WebSite, WebSiteDto, WebSiteHistory> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private StatutWebSiteConverter statutWebSiteConverter ;
    @Autowired
    private ScrappingLinkConverter scrappingLinkConverter ;
    private boolean statutWebSite;
    private boolean client;
    private boolean scrappingLinks;

    public  WebSiteConverter(){
        super(WebSite.class, WebSiteDto.class, WebSiteHistory.class);
        init(true);
    }

    @Override
    public WebSite toItem(WebSiteDto dto) {
        if (dto == null) {
            return null;
        } else {
        WebSite item = new WebSite();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getUrl()))
                item.setUrl(dto.getUrl());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getJsonSummary()))
                item.setJsonSummary(dto.getJsonSummary());
            if(this.statutWebSite && dto.getStatutWebSite()!=null)
                item.setStatutWebSite(statutWebSiteConverter.toItem(dto.getStatutWebSite())) ;

            if(dto.getClient() != null && dto.getClient().getId() != null){
                item.setClient(new Client());
                item.getClient().setId(dto.getClient().getId());
            }


            if(this.scrappingLinks && ListUtil.isNotEmpty(dto.getScrappingLinks()))
                item.setScrappingLinks(scrappingLinkConverter.toItem(dto.getScrappingLinks()));

        return item;
        }
    }

    @Override
    public WebSiteDto toDto(WebSite item) {
        if (item == null) {
            return null;
        } else {
            WebSiteDto dto = new WebSiteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getUrl()))
                dto.setUrl(item.getUrl());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getJsonSummary()))
                dto.setJsonSummary(item.getJsonSummary());
        if(this.statutWebSite && item.getStatutWebSite()!=null) {
            dto.setStatutWebSite(statutWebSiteConverter.toDto(item.getStatutWebSite())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.scrappingLinks && ListUtil.isNotEmpty(item.getScrappingLinks())){
            scrappingLinkConverter.init(true);
            scrappingLinkConverter.setWebSite(false);
            dto.setScrappingLinks(scrappingLinkConverter.toDto(item.getScrappingLinks()));
            scrappingLinkConverter.setWebSite(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.scrappingLinks = value;
    }

    public void initObject(boolean value) {
        this.statutWebSite = value;
        this.client = value;
    }


    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public StatutWebSiteConverter getStatutWebSiteConverter(){
        return this.statutWebSiteConverter;
    }
    public void setStatutWebSiteConverter(StatutWebSiteConverter statutWebSiteConverter ){
        this.statutWebSiteConverter = statutWebSiteConverter;
    }
    public ScrappingLinkConverter getScrappingLinkConverter(){
        return this.scrappingLinkConverter;
    }
    public void setScrappingLinkConverter(ScrappingLinkConverter scrappingLinkConverter ){
        this.scrappingLinkConverter = scrappingLinkConverter;
    }
    public boolean  isStatutWebSite(){
        return this.statutWebSite;
    }
    public void  setStatutWebSite(boolean statutWebSite){
        this.statutWebSite = statutWebSite;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isScrappingLinks(){
        return this.scrappingLinks ;
    }
    public void  setScrappingLinks(boolean scrappingLinks ){
        this.scrappingLinks  = scrappingLinks ;
    }
}
