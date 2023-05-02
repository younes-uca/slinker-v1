package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ScrappingOperationCriteria extends  BaseCriteria  {

    private LocalDateTime dateDebutScrappingOperation;
    private LocalDateTime dateDebutScrappingOperationFrom;
    private LocalDateTime dateDebutScrappingOperationTo;
    private LocalDateTime dateFinScrappingOperation;
    private LocalDateTime dateFinScrappingOperationFrom;
    private LocalDateTime dateFinScrappingOperationTo;
    private String url;
    private String urlLike;

    private AffliateCriteria affliate ;
    private List<AffliateCriteria> affliates ;
    private WebSiteCriteria webSite ;
    private List<WebSiteCriteria> webSites ;


    public ScrappingOperationCriteria(){}

    public LocalDateTime getDateDebutScrappingOperation(){
        return this.dateDebutScrappingOperation;
    }
    public void setDateDebutScrappingOperation(LocalDateTime dateDebutScrappingOperation){
        this.dateDebutScrappingOperation = dateDebutScrappingOperation;
    }
    public LocalDateTime getDateDebutScrappingOperationFrom(){
        return this.dateDebutScrappingOperationFrom;
    }
    public void setDateDebutScrappingOperationFrom(LocalDateTime dateDebutScrappingOperationFrom){
        this.dateDebutScrappingOperationFrom = dateDebutScrappingOperationFrom;
    }
    public LocalDateTime getDateDebutScrappingOperationTo(){
        return this.dateDebutScrappingOperationTo;
    }
    public void setDateDebutScrappingOperationTo(LocalDateTime dateDebutScrappingOperationTo){
        this.dateDebutScrappingOperationTo = dateDebutScrappingOperationTo;
    }
    public LocalDateTime getDateFinScrappingOperation(){
        return this.dateFinScrappingOperation;
    }
    public void setDateFinScrappingOperation(LocalDateTime dateFinScrappingOperation){
        this.dateFinScrappingOperation = dateFinScrappingOperation;
    }
    public LocalDateTime getDateFinScrappingOperationFrom(){
        return this.dateFinScrappingOperationFrom;
    }
    public void setDateFinScrappingOperationFrom(LocalDateTime dateFinScrappingOperationFrom){
        this.dateFinScrappingOperationFrom = dateFinScrappingOperationFrom;
    }
    public LocalDateTime getDateFinScrappingOperationTo(){
        return this.dateFinScrappingOperationTo;
    }
    public void setDateFinScrappingOperationTo(LocalDateTime dateFinScrappingOperationTo){
        this.dateFinScrappingOperationTo = dateFinScrappingOperationTo;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrlLike(){
        return this.urlLike;
    }
    public void setUrlLike(String urlLike){
        this.urlLike = urlLike;
    }


    public AffliateCriteria getAffliate(){
        return this.affliate;
    }

    public void setAffliate(AffliateCriteria affliate){
        this.affliate = affliate;
    }
    public List<AffliateCriteria> getAffliates(){
        return this.affliates;
    }

    public void setAffliates(List<AffliateCriteria> affliates){
        this.affliates = affliates;
    }
    public WebSiteCriteria getWebSite(){
        return this.webSite;
    }

    public void setWebSite(WebSiteCriteria webSite){
        this.webSite = webSite;
    }
    public List<WebSiteCriteria> getWebSites(){
        return this.webSites;
    }

    public void setWebSites(List<WebSiteCriteria> webSites){
        this.webSites = webSites;
    }
}
