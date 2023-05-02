package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionDto  extends AuditBaseDto {

    private String dateDebut ;
    private String dateFin ;
    private BigDecimal delai  ;
    private Integer nombrePage  = 0 ;
    private BigDecimal montantPaye  ;
    private String datePaiement ;

    private SubscriptionTypeDto subscriptionType ;
    private SubscriptionPackDto subscriptionPack ;
    private SubscriptionEtatDto subscriptionEtat ;
    private ClientDto client ;
    private TypePaiementDto typePaiement ;



    public SubscriptionDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }

    @Log
    public BigDecimal getDelai(){
        return this.delai;
    }
    public void setDelai(BigDecimal delai){
        this.delai = delai;
    }

    @Log
    public Integer getNombrePage(){
        return this.nombrePage;
    }
    public void setNombrePage(Integer nombrePage){
        this.nombrePage = nombrePage;
    }

    @Log
    public BigDecimal getMontantPaye(){
        return this.montantPaye;
    }
    public void setMontantPaye(BigDecimal montantPaye){
        this.montantPaye = montantPaye;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
    }


    public SubscriptionTypeDto getSubscriptionType(){
        return this.subscriptionType;
    }

    public void setSubscriptionType(SubscriptionTypeDto subscriptionType){
        this.subscriptionType = subscriptionType;
    }
    public SubscriptionPackDto getSubscriptionPack(){
        return this.subscriptionPack;
    }

    public void setSubscriptionPack(SubscriptionPackDto subscriptionPack){
        this.subscriptionPack = subscriptionPack;
    }
    public SubscriptionEtatDto getSubscriptionEtat(){
        return this.subscriptionEtat;
    }

    public void setSubscriptionEtat(SubscriptionEtatDto subscriptionEtat){
        this.subscriptionEtat = subscriptionEtat;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public TypePaiementDto getTypePaiement(){
        return this.typePaiement;
    }

    public void setTypePaiement(TypePaiementDto typePaiement){
        this.typePaiement = typePaiement;
    }




}
