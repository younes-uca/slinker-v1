package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zsmart.slinker.zynerator.util.ListUtil;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.ClientHistory;
import ma.zsmart.slinker.bean.core.Client;
import ma.zsmart.slinker.ws.dto.ClientDto;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDto, ClientHistory> {

    @Autowired
    private SubscriptionTypeConverter subscriptionTypeConverter ;
    @Autowired
    private NotificationConverter notificationConverter ;
    @Autowired
    private AffliateConverter affliateConverter ;
    @Autowired
    private NotificationDetailConverter notificationDetailConverter ;
    @Autowired
    private StatutClientConverter statutClientConverter ;
    @Autowired
    private TypePaiementConverter typePaiementConverter ;
    @Autowired
    private SubscriptionConverter subscriptionConverter ;
    @Autowired
    private WebSiteConverter webSiteConverter ;
    @Autowired
    private SubscriptionPackConverter subscriptionPackConverter ;
    @Autowired
    private StatutWebSiteConverter statutWebSiteConverter ;
    @Autowired
    private SubscriptionEtatConverter subscriptionEtatConverter ;
    @Autowired
    private ScrappingLinkConverter scrappingLinkConverter ;
    private boolean statutClient;
    private boolean affliates;
    private boolean webSites;
    private boolean notificationDetails;
    private boolean subscriptions;

    public  ClientConverter(){
        super(Client.class, ClientDto.class, ClientHistory.class);
        init(true);
    }

    @Override
    public Client toItem(ClientDto dto) {
        if (dto == null) {
            return null;
        } else {
        Client item = new Client();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(this.statutClient && dto.getStatutClient()!=null)
                item.setStatutClient(statutClientConverter.toItem(dto.getStatutClient())) ;


            if(this.affliates && ListUtil.isNotEmpty(dto.getAffliates()))
                item.setAffliates(affliateConverter.toItem(dto.getAffliates()));
            if(this.webSites && ListUtil.isNotEmpty(dto.getWebSites()))
                item.setWebSites(webSiteConverter.toItem(dto.getWebSites()));
            if(this.notificationDetails && ListUtil.isNotEmpty(dto.getNotificationDetails()))
                item.setNotificationDetails(notificationDetailConverter.toItem(dto.getNotificationDetails()));
            if(this.subscriptions && ListUtil.isNotEmpty(dto.getSubscriptions()))
                item.setSubscriptions(subscriptionConverter.toItem(dto.getSubscriptions()));

        return item;
        }
    }

    @Override
    public ClientDto toDto(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientDto dto = new ClientDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(StringUtil.isNotEmpty(item.getPassword()))
                dto.setPassword(item.getPassword());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
        if(this.statutClient && item.getStatutClient()!=null) {
            dto.setStatutClient(statutClientConverter.toDto(item.getStatutClient())) ;
        }
        if(this.affliates && ListUtil.isNotEmpty(item.getAffliates())){
            affliateConverter.init(true);
            affliateConverter.setClient(false);
            dto.setAffliates(affliateConverter.toDto(item.getAffliates()));
            affliateConverter.setClient(true);

        }
        if(this.webSites && ListUtil.isNotEmpty(item.getWebSites())){
            webSiteConverter.init(true);
            webSiteConverter.setClient(false);
            dto.setWebSites(webSiteConverter.toDto(item.getWebSites()));
            webSiteConverter.setClient(true);

        }
        if(this.notificationDetails && ListUtil.isNotEmpty(item.getNotificationDetails())){
            notificationDetailConverter.init(true);
            notificationDetailConverter.setClient(false);
            dto.setNotificationDetails(notificationDetailConverter.toDto(item.getNotificationDetails()));
            notificationDetailConverter.setClient(true);

        }
        if(this.subscriptions && ListUtil.isNotEmpty(item.getSubscriptions())){
            subscriptionConverter.init(true);
            subscriptionConverter.setClient(false);
            dto.setSubscriptions(subscriptionConverter.toDto(item.getSubscriptions()));
            subscriptionConverter.setClient(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.affliates = value;
        this.webSites = value;
        this.notificationDetails = value;
        this.subscriptions = value;
    }

    public void initObject(boolean value) {
        this.statutClient = value;
    }


    public SubscriptionTypeConverter getSubscriptionTypeConverter(){
        return this.subscriptionTypeConverter;
    }
    public void setSubscriptionTypeConverter(SubscriptionTypeConverter subscriptionTypeConverter ){
        this.subscriptionTypeConverter = subscriptionTypeConverter;
    }
    public NotificationConverter getNotificationConverter(){
        return this.notificationConverter;
    }
    public void setNotificationConverter(NotificationConverter notificationConverter ){
        this.notificationConverter = notificationConverter;
    }
    public AffliateConverter getAffliateConverter(){
        return this.affliateConverter;
    }
    public void setAffliateConverter(AffliateConverter affliateConverter ){
        this.affliateConverter = affliateConverter;
    }
    public NotificationDetailConverter getNotificationDetailConverter(){
        return this.notificationDetailConverter;
    }
    public void setNotificationDetailConverter(NotificationDetailConverter notificationDetailConverter ){
        this.notificationDetailConverter = notificationDetailConverter;
    }
    public StatutClientConverter getStatutClientConverter(){
        return this.statutClientConverter;
    }
    public void setStatutClientConverter(StatutClientConverter statutClientConverter ){
        this.statutClientConverter = statutClientConverter;
    }
    public TypePaiementConverter getTypePaiementConverter(){
        return this.typePaiementConverter;
    }
    public void setTypePaiementConverter(TypePaiementConverter typePaiementConverter ){
        this.typePaiementConverter = typePaiementConverter;
    }
    public SubscriptionConverter getSubscriptionConverter(){
        return this.subscriptionConverter;
    }
    public void setSubscriptionConverter(SubscriptionConverter subscriptionConverter ){
        this.subscriptionConverter = subscriptionConverter;
    }
    public WebSiteConverter getWebSiteConverter(){
        return this.webSiteConverter;
    }
    public void setWebSiteConverter(WebSiteConverter webSiteConverter ){
        this.webSiteConverter = webSiteConverter;
    }
    public SubscriptionPackConverter getSubscriptionPackConverter(){
        return this.subscriptionPackConverter;
    }
    public void setSubscriptionPackConverter(SubscriptionPackConverter subscriptionPackConverter ){
        this.subscriptionPackConverter = subscriptionPackConverter;
    }
    public StatutWebSiteConverter getStatutWebSiteConverter(){
        return this.statutWebSiteConverter;
    }
    public void setStatutWebSiteConverter(StatutWebSiteConverter statutWebSiteConverter ){
        this.statutWebSiteConverter = statutWebSiteConverter;
    }
    public SubscriptionEtatConverter getSubscriptionEtatConverter(){
        return this.subscriptionEtatConverter;
    }
    public void setSubscriptionEtatConverter(SubscriptionEtatConverter subscriptionEtatConverter ){
        this.subscriptionEtatConverter = subscriptionEtatConverter;
    }
    public ScrappingLinkConverter getScrappingLinkConverter(){
        return this.scrappingLinkConverter;
    }
    public void setScrappingLinkConverter(ScrappingLinkConverter scrappingLinkConverter ){
        this.scrappingLinkConverter = scrappingLinkConverter;
    }
    public boolean  isStatutClient(){
        return this.statutClient;
    }
    public void  setStatutClient(boolean statutClient){
        this.statutClient = statutClient;
    }
    public boolean  isAffliates(){
        return this.affliates ;
    }
    public void  setAffliates(boolean affliates ){
        this.affliates  = affliates ;
    }
    public boolean  isWebSites(){
        return this.webSites ;
    }
    public void  setWebSites(boolean webSites ){
        this.webSites  = webSites ;
    }
    public boolean  isNotificationDetails(){
        return this.notificationDetails ;
    }
    public void  setNotificationDetails(boolean notificationDetails ){
        this.notificationDetails  = notificationDetails ;
    }
    public boolean  isSubscriptions(){
        return this.subscriptions ;
    }
    public void  setSubscriptions(boolean subscriptions ){
        this.subscriptions  = subscriptions ;
    }
}
