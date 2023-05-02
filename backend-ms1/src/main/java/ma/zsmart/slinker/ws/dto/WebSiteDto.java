package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebSiteDto  extends AuditBaseDto {

    private String url  ;
    private String libelle  ;
    private String jsonSummary  ;

    private StatutWebSiteDto statutWebSite ;
    private ClientDto client ;

    private List<ScrappingLinkDto> scrappingLinks ;


    public WebSiteDto(){
        super();
    }



    @Log
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getJsonSummary(){
        return this.jsonSummary;
    }
    public void setJsonSummary(String jsonSummary){
        this.jsonSummary = jsonSummary;
    }


    public StatutWebSiteDto getStatutWebSite(){
        return this.statutWebSite;
    }

    public void setStatutWebSite(StatutWebSiteDto statutWebSite){
        this.statutWebSite = statutWebSite;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }



    public List<ScrappingLinkDto> getScrappingLinks(){
        return this.scrappingLinks;
    }

    public void setScrappingLinks(List<ScrappingLinkDto> scrappingLinks){
        this.scrappingLinks = scrappingLinks;
    }

}
