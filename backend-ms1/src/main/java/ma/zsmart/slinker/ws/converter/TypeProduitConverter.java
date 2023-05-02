package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.TypeProduitHistory;
import ma.zsmart.slinker.bean.core.TypeProduit;
import ma.zsmart.slinker.ws.dto.TypeProduitDto;

@Component
public class TypeProduitConverter extends AbstractConverter<TypeProduit, TypeProduitDto, TypeProduitHistory> {


    public  TypeProduitConverter(){
        super(TypeProduit.class, TypeProduitDto.class, TypeProduitHistory.class);
    }

    @Override
    public TypeProduit toItem(TypeProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeProduit item = new TypeProduit();
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
    public TypeProduitDto toDto(TypeProduit item) {
        if (item == null) {
            return null;
        } else {
            TypeProduitDto dto = new TypeProduitDto();
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
