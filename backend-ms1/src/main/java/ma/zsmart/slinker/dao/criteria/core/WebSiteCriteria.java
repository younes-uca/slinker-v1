package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;

public class WebSiteCriteria extends  BaseCriteria  {

    private String url;
    private String urlLike;
    private String libelle;
    private String libelleLike;
    private String jsonSummary;
    private String jsonSummaryLike;

    private StatutWebSiteCriteria statutWebSite ;
    private List<StatutWebSiteCriteria> statutWebSites ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;


    public WebSiteCriteria(){}

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

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getJsonSummary(){
        return this.jsonSummary;
    }
    public void setJsonSummary(String jsonSummary){
        this.jsonSummary = jsonSummary;
    }
    public String getJsonSummaryLike(){
        return this.jsonSummaryLike;
    }
    public void setJsonSummaryLike(String jsonSummaryLike){
        this.jsonSummaryLike = jsonSummaryLike;
    }


    public StatutWebSiteCriteria getStatutWebSite(){
        return this.statutWebSite;
    }

    public void setStatutWebSite(StatutWebSiteCriteria statutWebSite){
        this.statutWebSite = statutWebSite;
    }
    public List<StatutWebSiteCriteria> getStatutWebSites(){
        return this.statutWebSites;
    }

    public void setStatutWebSites(List<StatutWebSiteCriteria> statutWebSites){
        this.statutWebSites = statutWebSites;
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
}
