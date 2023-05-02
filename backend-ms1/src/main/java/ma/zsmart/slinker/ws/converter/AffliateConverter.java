package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.slinker.bean.core.Client;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.AffliateHistory;
import ma.zsmart.slinker.bean.core.Affliate;
import ma.zsmart.slinker.ws.dto.AffliateDto;

@Component
public class AffliateConverter extends AbstractConverter<Affliate, AffliateDto, AffliateHistory> {

    @Autowired
    private ClientConverter clientConverter ;
    private boolean client;

    public  AffliateConverter(){
        super(Affliate.class, AffliateDto.class, AffliateHistory.class);
    }

    @Override
    public Affliate toItem(AffliateDto dto) {
        if (dto == null) {
            return null;
        } else {
        Affliate item = new Affliate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(dto.getClient() != null && dto.getClient().getId() != null){
                item.setClient(new Client());
                item.getClient().setId(dto.getClient().getId());
            }



        return item;
        }
    }

    @Override
    public AffliateDto toDto(Affliate item) {
        if (item == null) {
            return null;
        } else {
            AffliateDto dto = new AffliateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.client = value;
    }


    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
}
