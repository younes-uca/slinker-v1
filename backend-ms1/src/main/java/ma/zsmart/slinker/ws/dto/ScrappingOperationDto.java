package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScrappingOperationDto  extends AuditBaseDto {

    private String dateDebutScrappingOperation ;
    private String dateFinScrappingOperation ;
    private String url  ;

    private AffliateDto affliate ;
    private WebSiteDto webSite ;

    private List<ScrappingOperationItemDto> scrappingOperationItems ;


    public ScrappingOperationDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebutScrappingOperation(){
        return this.dateDebutScrappingOperation;
    }
    public void setDateDebutScrappingOperation(String dateDebutScrappingOperation){
        this.dateDebutScrappingOperation = dateDebutScrappingOperation;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFinScrappingOperation(){
        return this.dateFinScrappingOperation;
    }
    public void setDateFinScrappingOperation(String dateFinScrappingOperation){
        this.dateFinScrappingOperation = dateFinScrappingOperation;
    }

    @Log
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }


    public AffliateDto getAffliate(){
        return this.affliate;
    }

    public void setAffliate(AffliateDto affliate){
        this.affliate = affliate;
    }
    public WebSiteDto getWebSite(){
        return this.webSite;
    }

    public void setWebSite(WebSiteDto webSite){
        this.webSite = webSite;
    }



    public List<ScrappingOperationItemDto> getScrappingOperationItems(){
        return this.scrappingOperationItems;
    }

    public void setScrappingOperationItems(List<ScrappingOperationItemDto> scrappingOperationItems){
        this.scrappingOperationItems = scrappingOperationItems;
    }

}
