package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.slinker.bean.core.Client;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.SubscriptionHistory;
import ma.zsmart.slinker.bean.core.Subscription;
import ma.zsmart.slinker.ws.dto.SubscriptionDto;

@Component
public class SubscriptionConverter extends AbstractConverter<Subscription, SubscriptionDto, SubscriptionHistory> {

    @Autowired
    private SubscriptionTypeConverter subscriptionTypeConverter ;
    @Autowired
    private SubscriptionPackConverter subscriptionPackConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private TypePaiementConverter typePaiementConverter ;
    @Autowired
    private SubscriptionEtatConverter subscriptionEtatConverter ;
    private boolean subscriptionType;
    private boolean subscriptionPack;
    private boolean subscriptionEtat;
    private boolean client;
    private boolean typePaiement;

    public  SubscriptionConverter(){
        super(Subscription.class, SubscriptionDto.class, SubscriptionHistory.class);
    }

    @Override
    public Subscription toItem(SubscriptionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Subscription item = new Subscription();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(StringUtil.isNotEmpty(dto.getDelai()))
                item.setDelai(dto.getDelai());
            if(StringUtil.isNotEmpty(dto.getNombrePage()))
                item.setNombrePage(dto.getNombrePage());
            if(StringUtil.isNotEmpty(dto.getMontantPaye()))
                item.setMontantPaye(dto.getMontantPaye());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(this.subscriptionType && dto.getSubscriptionType()!=null)
                item.setSubscriptionType(subscriptionTypeConverter.toItem(dto.getSubscriptionType())) ;

            if(this.subscriptionPack && dto.getSubscriptionPack()!=null)
                item.setSubscriptionPack(subscriptionPackConverter.toItem(dto.getSubscriptionPack())) ;

            if(this.subscriptionEtat && dto.getSubscriptionEtat()!=null)
                item.setSubscriptionEtat(subscriptionEtatConverter.toItem(dto.getSubscriptionEtat())) ;

            if(dto.getClient() != null && dto.getClient().getId() != null){
                item.setClient(new Client());
                item.getClient().setId(dto.getClient().getId());
            }

            if(this.typePaiement && dto.getTypePaiement()!=null)
                item.setTypePaiement(typePaiementConverter.toItem(dto.getTypePaiement())) ;



        return item;
        }
    }

    @Override
    public SubscriptionDto toDto(Subscription item) {
        if (item == null) {
            return null;
        } else {
            SubscriptionDto dto = new SubscriptionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(StringUtil.isNotEmpty(item.getDelai()))
                dto.setDelai(item.getDelai());
            if(StringUtil.isNotEmpty(item.getNombrePage()))
                dto.setNombrePage(item.getNombrePage());
            if(StringUtil.isNotEmpty(item.getMontantPaye()))
                dto.setMontantPaye(item.getMontantPaye());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
        if(this.subscriptionType && item.getSubscriptionType()!=null) {
            dto.setSubscriptionType(subscriptionTypeConverter.toDto(item.getSubscriptionType())) ;
        }
        if(this.subscriptionPack && item.getSubscriptionPack()!=null) {
            dto.setSubscriptionPack(subscriptionPackConverter.toDto(item.getSubscriptionPack())) ;
        }
        if(this.subscriptionEtat && item.getSubscriptionEtat()!=null) {
            dto.setSubscriptionEtat(subscriptionEtatConverter.toDto(item.getSubscriptionEtat())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.typePaiement && item.getTypePaiement()!=null) {
            dto.setTypePaiement(typePaiementConverter.toDto(item.getTypePaiement())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.subscriptionType = value;
        this.subscriptionPack = value;
        this.subscriptionEtat = value;
        this.client = value;
        this.typePaiement = value;
    }


    public SubscriptionTypeConverter getSubscriptionTypeConverter(){
        return this.subscriptionTypeConverter;
    }
    public void setSubscriptionTypeConverter(SubscriptionTypeConverter subscriptionTypeConverter ){
        this.subscriptionTypeConverter = subscriptionTypeConverter;
    }
    public SubscriptionPackConverter getSubscriptionPackConverter(){
        return this.subscriptionPackConverter;
    }
    public void setSubscriptionPackConverter(SubscriptionPackConverter subscriptionPackConverter ){
        this.subscriptionPackConverter = subscriptionPackConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public TypePaiementConverter getTypePaiementConverter(){
        return this.typePaiementConverter;
    }
    public void setTypePaiementConverter(TypePaiementConverter typePaiementConverter ){
        this.typePaiementConverter = typePaiementConverter;
    }
    public SubscriptionEtatConverter getSubscriptionEtatConverter(){
        return this.subscriptionEtatConverter;
    }
    public void setSubscriptionEtatConverter(SubscriptionEtatConverter subscriptionEtatConverter ){
        this.subscriptionEtatConverter = subscriptionEtatConverter;
    }
    public boolean  isSubscriptionType(){
        return this.subscriptionType;
    }
    public void  setSubscriptionType(boolean subscriptionType){
        this.subscriptionType = subscriptionType;
    }
    public boolean  isSubscriptionPack(){
        return this.subscriptionPack;
    }
    public void  setSubscriptionPack(boolean subscriptionPack){
        this.subscriptionPack = subscriptionPack;
    }
    public boolean  isSubscriptionEtat(){
        return this.subscriptionEtat;
    }
    public void  setSubscriptionEtat(boolean subscriptionEtat){
        this.subscriptionEtat = subscriptionEtat;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isTypePaiement(){
        return this.typePaiement;
    }
    public void  setTypePaiement(boolean typePaiement){
        this.typePaiement = typePaiement;
    }
}
