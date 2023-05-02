package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.slinker.bean.core.ScrappingOperation;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.ScrappingOperationItemHistory;
import ma.zsmart.slinker.bean.core.ScrappingOperationItem;
import ma.zsmart.slinker.ws.dto.ScrappingOperationItemDto;

@Component
public class ScrappingOperationItemConverter extends AbstractConverter<ScrappingOperationItem, ScrappingOperationItemDto, ScrappingOperationItemHistory> {

    @Autowired
    private TypeProduitConverter typeProduitConverter ;
    @Autowired
    private ScrappingLinkConverter scrappingLinkConverter ;
    @Autowired
    private ScrappingOperationConverter scrappingOperationConverter ;
    private boolean scrappingLink;
    private boolean typeProduit;
    private boolean scrappingOperation;

    public  ScrappingOperationItemConverter(){
        super(ScrappingOperationItem.class, ScrappingOperationItemDto.class, ScrappingOperationItemHistory.class);
    }

    @Override
    public ScrappingOperationItem toItem(ScrappingOperationItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        ScrappingOperationItem item = new ScrappingOperationItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(StringUtil.isNotEmpty(dto.getStock()))
                item.setStock(dto.getStock());
            if(StringUtil.isNotEmpty(dto.getImage()))
                item.setImage(dto.getImage());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getReview()))
                item.setReview(dto.getReview());
            if(this.scrappingLink && dto.getScrappingLink()!=null)
                item.setScrappingLink(scrappingLinkConverter.toItem(dto.getScrappingLink())) ;

            if(this.typeProduit && dto.getTypeProduit()!=null)
                item.setTypeProduit(typeProduitConverter.toItem(dto.getTypeProduit())) ;

            if(dto.getScrappingOperation() != null && dto.getScrappingOperation().getId() != null){
                item.setScrappingOperation(new ScrappingOperation());
                item.getScrappingOperation().setId(dto.getScrappingOperation().getId());
            }



        return item;
        }
    }

    @Override
    public ScrappingOperationItemDto toDto(ScrappingOperationItem item) {
        if (item == null) {
            return null;
        } else {
            ScrappingOperationItemDto dto = new ScrappingOperationItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
            if(StringUtil.isNotEmpty(item.getStock()))
                dto.setStock(item.getStock());
            if(StringUtil.isNotEmpty(item.getImage()))
                dto.setImage(item.getImage());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getReview()))
                dto.setReview(item.getReview());
        if(this.scrappingLink && item.getScrappingLink()!=null) {
            dto.setScrappingLink(scrappingLinkConverter.toDto(item.getScrappingLink())) ;
        }
        if(this.typeProduit && item.getTypeProduit()!=null) {
            dto.setTypeProduit(typeProduitConverter.toDto(item.getTypeProduit())) ;
        }
        if(this.scrappingOperation && item.getScrappingOperation()!=null) {
            dto.setScrappingOperation(scrappingOperationConverter.toDto(item.getScrappingOperation())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.scrappingLink = value;
        this.typeProduit = value;
        this.scrappingOperation = value;
    }


    public TypeProduitConverter getTypeProduitConverter(){
        return this.typeProduitConverter;
    }
    public void setTypeProduitConverter(TypeProduitConverter typeProduitConverter ){
        this.typeProduitConverter = typeProduitConverter;
    }
    public ScrappingLinkConverter getScrappingLinkConverter(){
        return this.scrappingLinkConverter;
    }
    public void setScrappingLinkConverter(ScrappingLinkConverter scrappingLinkConverter ){
        this.scrappingLinkConverter = scrappingLinkConverter;
    }
    public ScrappingOperationConverter getScrappingOperationConverter(){
        return this.scrappingOperationConverter;
    }
    public void setScrappingOperationConverter(ScrappingOperationConverter scrappingOperationConverter ){
        this.scrappingOperationConverter = scrappingOperationConverter;
    }
    public boolean  isScrappingLink(){
        return this.scrappingLink;
    }
    public void  setScrappingLink(boolean scrappingLink){
        this.scrappingLink = scrappingLink;
    }
    public boolean  isTypeProduit(){
        return this.typeProduit;
    }
    public void  setTypeProduit(boolean typeProduit){
        this.typeProduit = typeProduit;
    }
    public boolean  isScrappingOperation(){
        return this.scrappingOperation;
    }
    public void  setScrappingOperation(boolean scrappingOperation){
        this.scrappingOperation = scrappingOperation;
    }
}
