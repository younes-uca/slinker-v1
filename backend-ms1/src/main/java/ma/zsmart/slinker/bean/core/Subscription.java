package ma.zsmart.slinker.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "subscription")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscription_seq",sequenceName="subscription_seq",allocationSize=1, initialValue = 1)
public class Subscription   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFin ;
    private BigDecimal delai = BigDecimal.ZERO;
    private Integer nombrePage = 0;
    private BigDecimal montantPaye = BigDecimal.ZERO;
    private LocalDateTime datePaiement ;

    private SubscriptionType subscriptionType ;
    
    private SubscriptionPack subscriptionPack ;
    
    private SubscriptionEtat subscriptionEtat ;
    
    private Client client ;
    
    private TypePaiement typePaiement ;
    


    public Subscription(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscription_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public BigDecimal getDelai(){
        return this.delai;
    }
    public void setDelai(BigDecimal delai){
        this.delai = delai;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public SubscriptionType getSubscriptionType(){
        return this.subscriptionType;
    }
    public void setSubscriptionType(SubscriptionType subscriptionType){
        this.subscriptionType = subscriptionType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public SubscriptionPack getSubscriptionPack(){
        return this.subscriptionPack;
    }
    public void setSubscriptionPack(SubscriptionPack subscriptionPack){
        this.subscriptionPack = subscriptionPack;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public SubscriptionEtat getSubscriptionEtat(){
        return this.subscriptionEtat;
    }
    public void setSubscriptionEtat(SubscriptionEtat subscriptionEtat){
        this.subscriptionEtat = subscriptionEtat;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public Integer getNombrePage(){
        return this.nombrePage;
    }
    public void setNombrePage(Integer nombrePage){
        this.nombrePage = nombrePage;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypePaiement getTypePaiement(){
        return this.typePaiement;
    }
    public void setTypePaiement(TypePaiement typePaiement){
        this.typePaiement = typePaiement;
    }
    public BigDecimal getMontantPaye(){
        return this.montantPaye;
    }
    public void setMontantPaye(BigDecimal montantPaye){
        this.montantPaye = montantPaye;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription subscription = (Subscription) o;
        return id != null && id.equals(subscription.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

