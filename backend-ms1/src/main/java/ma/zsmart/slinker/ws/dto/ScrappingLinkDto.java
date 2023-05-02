package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScrappingLinkDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;

    private WebSiteDto webSite ;



    public ScrappingLinkDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }


    public WebSiteDto getWebSite(){
        return this.webSite;
    }

    public void setWebSite(WebSiteDto webSite){
        this.webSite = webSite;
    }




}
