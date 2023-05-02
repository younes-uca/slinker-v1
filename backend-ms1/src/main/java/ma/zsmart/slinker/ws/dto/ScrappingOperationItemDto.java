package  ma.zsmart.slinker.ws.dto;

import ma.zsmart.slinker.zynerator.audit.Log;
import ma.zsmart.slinker.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScrappingOperationItemDto  extends AuditBaseDto {

    private BigDecimal prix  ;
    private String stock  ;
    private String image  ;
    private String description  ;
    private String review  ;

    private ScrappingLinkDto scrappingLink ;
    private TypeProduitDto typeProduit ;
    private ScrappingOperationDto scrappingOperation ;



    public ScrappingOperationItemDto(){
        super();
    }



    @Log
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }

    @Log
    public String getStock(){
        return this.stock;
    }
    public void setStock(String stock){
        this.stock = stock;
    }

    @Log
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public String getReview(){
        return this.review;
    }
    public void setReview(String review){
        this.review = review;
    }


    public ScrappingLinkDto getScrappingLink(){
        return this.scrappingLink;
    }

    public void setScrappingLink(ScrappingLinkDto scrappingLink){
        this.scrappingLink = scrappingLink;
    }
    public TypeProduitDto getTypeProduit(){
        return this.typeProduit;
    }

    public void setTypeProduit(TypeProduitDto typeProduit){
        this.typeProduit = typeProduit;
    }
    public ScrappingOperationDto getScrappingOperation(){
        return this.scrappingOperation;
    }

    public void setScrappingOperation(ScrappingOperationDto scrappingOperation){
        this.scrappingOperation = scrappingOperation;
    }




}
