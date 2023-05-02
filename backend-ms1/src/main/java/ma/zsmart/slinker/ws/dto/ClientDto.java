package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto  extends AuditBaseDto {

    private String nom  ;
    private String prenom  ;
    private String password  ;
    private String email  ;

    private StatutClientDto statutClient ;

    private List<AffliateDto> affliates ;
    private List<WebSiteDto> webSites ;
    private List<NotificationDetailDto> notificationDetails ;
    private List<SubscriptionDto> subscriptions ;


    public ClientDto(){
        super();
    }



    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public StatutClientDto getStatutClient(){
        return this.statutClient;
    }

    public void setStatutClient(StatutClientDto statutClient){
        this.statutClient = statutClient;
    }



    public List<AffliateDto> getAffliates(){
        return this.affliates;
    }

    public void setAffliates(List<AffliateDto> affliates){
        this.affliates = affliates;
    }
    public List<WebSiteDto> getWebSites(){
        return this.webSites;
    }

    public void setWebSites(List<WebSiteDto> webSites){
        this.webSites = webSites;
    }
    public List<NotificationDetailDto> getNotificationDetails(){
        return this.notificationDetails;
    }

    public void setNotificationDetails(List<NotificationDetailDto> notificationDetails){
        this.notificationDetails = notificationDetails;
    }
    public List<SubscriptionDto> getSubscriptions(){
        return this.subscriptions;
    }

    public void setSubscriptions(List<SubscriptionDto> subscriptions){
        this.subscriptions = subscriptions;
    }

}
