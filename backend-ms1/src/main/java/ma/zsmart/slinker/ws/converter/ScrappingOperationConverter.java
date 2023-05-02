package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zsmart.slinker.zynerator.util.ListUtil;

import ma.zsmart.slinker.bean.core.WebSite;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.ScrappingOperationHistory;
import ma.zsmart.slinker.bean.core.ScrappingOperation;
import ma.zsmart.slinker.ws.dto.ScrappingOperationDto;

@Component
public class ScrappingOperationConverter extends AbstractConverter<ScrappingOperation, ScrappingOperationDto, ScrappingOperationHistory> {

    @Autowired
    private TypeProduitConverter typeProduitConverter ;
    @Autowired
    private AffliateConverter affliateConverter ;
    @Autowired
    private WebSiteConverter webSiteConverter ;
    @Autowired
    private ScrappingOperationItemConverter scrappingOperationItemConverter ;
    @Autowired
    private ScrappingLinkConverter scrappingLinkConverter ;
    private boolean affliate;
    private boolean webSite;
    private boolean scrappingOperationItems;

    public  ScrappingOperationConverter(){
        super(ScrappingOperation.class, ScrappingOperationDto.class, ScrappingOperationHistory.class);
        init(true);
    }

    @Override
    public ScrappingOperation toItem(ScrappingOperationDto dto) {
        if (dto == null) {
            return null;
        } else {
        ScrappingOperation item = new ScrappingOperation();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDebutScrappingOperation()))
                item.setDateDebutScrappingOperation(DateUtil.stringEnToDate(dto.getDateDebutScrappingOperation()));
            if(StringUtil.isNotEmpty(dto.getDateFinScrappingOperation()))
                item.setDateFinScrappingOperation(DateUtil.stringEnToDate(dto.getDateFinScrappingOperation()));
            if(StringUtil.isNotEmpty(dto.getUrl()))
                item.setUrl(dto.getUrl());
            if(this.affliate && dto.getAffliate()!=null)
                item.setAffliate(affliateConverter.toItem(dto.getAffliate())) ;

            if(dto.getWebSite() != null && dto.getWebSite().getId() != null){
                item.setWebSite(new WebSite());
                item.getWebSite().setId(dto.getWebSite().getId());
            }


            if(this.scrappingOperationItems && ListUtil.isNotEmpty(dto.getScrappingOperationItems()))
                item.setScrappingOperationItems(scrappingOperationItemConverter.toItem(dto.getScrappingOperationItems()));

        return item;
        }
    }

    @Override
    public ScrappingOperationDto toDto(ScrappingOperation item) {
        if (item == null) {
            return null;
        } else {
            ScrappingOperationDto dto = new ScrappingOperationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDebutScrappingOperation()!=null)
                dto.setDateDebutScrappingOperation(DateUtil.dateTimeToString(item.getDateDebutScrappingOperation()));
            if(item.getDateFinScrappingOperation()!=null)
                dto.setDateFinScrappingOperation(DateUtil.dateTimeToString(item.getDateFinScrappingOperation()));
            if(StringUtil.isNotEmpty(item.getUrl()))
                dto.setUrl(item.getUrl());
        if(this.affliate && item.getAffliate()!=null) {
            dto.setAffliate(affliateConverter.toDto(item.getAffliate())) ;
        }
        if(this.webSite && item.getWebSite()!=null) {
            dto.setWebSite(webSiteConverter.toDto(item.getWebSite())) ;
        }
        if(this.scrappingOperationItems && ListUtil.isNotEmpty(item.getScrappingOperationItems())){
            scrappingOperationItemConverter.init(true);
            scrappingOperationItemConverter.setScrappingOperation(false);
            dto.setScrappingOperationItems(scrappingOperationItemConverter.toDto(item.getScrappingOperationItems()));
            scrappingOperationItemConverter.setScrappingOperation(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.scrappingOperationItems = value;
    }

    public void initObject(boolean value) {
        this.affliate = value;
        this.webSite = value;
    }


    public TypeProduitConverter getTypeProduitConverter(){
        return this.typeProduitConverter;
    }
    public void setTypeProduitConverter(TypeProduitConverter typeProduitConverter ){
        this.typeProduitConverter = typeProduitConverter;
    }
    public AffliateConverter getAffliateConverter(){
        return this.affliateConverter;
    }
    public void setAffliateConverter(AffliateConverter affliateConverter ){
        this.affliateConverter = affliateConverter;
    }
    public WebSiteConverter getWebSiteConverter(){
        return this.webSiteConverter;
    }
    public void setWebSiteConverter(WebSiteConverter webSiteConverter ){
        this.webSiteConverter = webSiteConverter;
    }
    public ScrappingOperationItemConverter getScrappingOperationItemConverter(){
        return this.scrappingOperationItemConverter;
    }
    public void setScrappingOperationItemConverter(ScrappingOperationItemConverter scrappingOperationItemConverter ){
        this.scrappingOperationItemConverter = scrappingOperationItemConverter;
    }
    public ScrappingLinkConverter getScrappingLinkConverter(){
        return this.scrappingLinkConverter;
    }
    public void setScrappingLinkConverter(ScrappingLinkConverter scrappingLinkConverter ){
        this.scrappingLinkConverter = scrappingLinkConverter;
    }
    public boolean  isAffliate(){
        return this.affliate;
    }
    public void  setAffliate(boolean affliate){
        this.affliate = affliate;
    }
    public boolean  isWebSite(){
        return this.webSite;
    }
    public void  setWebSite(boolean webSite){
        this.webSite = webSite;
    }
    public boolean  isScrappingOperationItems(){
        return this.scrappingOperationItems ;
    }
    public void  setScrappingOperationItems(boolean scrappingOperationItems ){
        this.scrappingOperationItems  = scrappingOperationItems ;
    }
}
