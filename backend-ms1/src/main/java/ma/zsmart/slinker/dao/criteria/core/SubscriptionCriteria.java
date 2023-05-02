package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SubscriptionCriteria extends  BaseCriteria  {

    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private String delai;
    private String delaiMin;
    private String delaiMax;
    private String nombrePage;
    private String nombrePageMin;
    private String nombrePageMax;
    private String montantPaye;
    private String montantPayeMin;
    private String montantPayeMax;
    private LocalDateTime datePaiement;
    private LocalDateTime datePaiementFrom;
    private LocalDateTime datePaiementTo;

    private SubscriptionTypeCriteria subscriptionType ;
    private List<SubscriptionTypeCriteria> subscriptionTypes ;
    private SubscriptionPackCriteria subscriptionPack ;
    private List<SubscriptionPackCriteria> subscriptionPacks ;
    private SubscriptionEtatCriteria subscriptionEtat ;
    private List<SubscriptionEtatCriteria> subscriptionEtats ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private TypePaiementCriteria typePaiement ;
    private List<TypePaiementCriteria> typePaiements ;


    public SubscriptionCriteria(){}

    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }
    public String getDelai(){
        return this.delai;
    }
    public void setDelai(String delai){
        this.delai = delai;
    }   
    public String getDelaiMin(){
        return this.delaiMin;
    }
    public void setDelaiMin(String delaiMin){
        this.delaiMin = delaiMin;
    }
    public String getDelaiMax(){
        return this.delaiMax;
    }
    public void setDelaiMax(String delaiMax){
        this.delaiMax = delaiMax;
    }
      
    public String getNombrePage(){
        return this.nombrePage;
    }
    public void setNombrePage(String nombrePage){
        this.nombrePage = nombrePage;
    }   
    public String getNombrePageMin(){
        return this.nombrePageMin;
    }
    public void setNombrePageMin(String nombrePageMin){
        this.nombrePageMin = nombrePageMin;
    }
    public String getNombrePageMax(){
        return this.nombrePageMax;
    }
    public void setNombrePageMax(String nombrePageMax){
        this.nombrePageMax = nombrePageMax;
    }
      
    public String getMontantPaye(){
        return this.montantPaye;
    }
    public void setMontantPaye(String montantPaye){
        this.montantPaye = montantPaye;
    }   
    public String getMontantPayeMin(){
        return this.montantPayeMin;
    }
    public void setMontantPayeMin(String montantPayeMin){
        this.montantPayeMin = montantPayeMin;
    }
    public String getMontantPayeMax(){
        return this.montantPayeMax;
    }
    public void setMontantPayeMax(String montantPayeMax){
        this.montantPayeMax = montantPayeMax;
    }
      
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public LocalDateTime getDatePaiementFrom(){
        return this.datePaiementFrom;
    }
    public void setDatePaiementFrom(LocalDateTime datePaiementFrom){
        this.datePaiementFrom = datePaiementFrom;
    }
    public LocalDateTime getDatePaiementTo(){
        return this.datePaiementTo;
    }
    public void setDatePaiementTo(LocalDateTime datePaiementTo){
        this.datePaiementTo = datePaiementTo;
    }

    public SubscriptionTypeCriteria getSubscriptionType(){
        return this.subscriptionType;
    }

    public void setSubscriptionType(SubscriptionTypeCriteria subscriptionType){
        this.subscriptionType = subscriptionType;
    }
    public List<SubscriptionTypeCriteria> getSubscriptionTypes(){
        return this.subscriptionTypes;
    }

    public void setSubscriptionTypes(List<SubscriptionTypeCriteria> subscriptionTypes){
        this.subscriptionTypes = subscriptionTypes;
    }
    public SubscriptionPackCriteria getSubscriptionPack(){
        return this.subscriptionPack;
    }

    public void setSubscriptionPack(SubscriptionPackCriteria subscriptionPack){
        this.subscriptionPack = subscriptionPack;
    }
    public List<SubscriptionPackCriteria> getSubscriptionPacks(){
        return this.subscriptionPacks;
    }

    public void setSubscriptionPacks(List<SubscriptionPackCriteria> subscriptionPacks){
        this.subscriptionPacks = subscriptionPacks;
    }
    public SubscriptionEtatCriteria getSubscriptionEtat(){
        return this.subscriptionEtat;
    }

    public void setSubscriptionEtat(SubscriptionEtatCriteria subscriptionEtat){
        this.subscriptionEtat = subscriptionEtat;
    }
    public List<SubscriptionEtatCriteria> getSubscriptionEtats(){
        return this.subscriptionEtats;
    }

    public void setSubscriptionEtats(List<SubscriptionEtatCriteria> subscriptionEtats){
        this.subscriptionEtats = subscriptionEtats;
    }
    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
    public TypePaiementCriteria getTypePaiement(){
        return this.typePaiement;
    }

    public void setTypePaiement(TypePaiementCriteria typePaiement){
        this.typePaiement = typePaiement;
    }
    public List<TypePaiementCriteria> getTypePaiements(){
        return this.typePaiements;
    }

    public void setTypePaiements(List<TypePaiementCriteria> typePaiements){
        this.typePaiements = typePaiements;
    }
}
