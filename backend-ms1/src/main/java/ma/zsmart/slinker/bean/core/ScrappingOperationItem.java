package ma.zsmart.slinker.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "scrapping_operation_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="scrapping_operation_item_seq",sequenceName="scrapping_operation_item_seq",allocationSize=1, initialValue = 1)
public class ScrappingOperationItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal prix = BigDecimal.ZERO;
    @Column(length = 500)
    private String stock;
    @Column(length = 500)
    private String image;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String review;

    private ScrappingLink scrappingLink ;
    
    private TypeProduit typeProduit ;
    
    private ScrappingOperation scrappingOperation ;
    


    public ScrappingOperationItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="scrapping_operation_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ScrappingLink getScrappingLink(){
        return this.scrappingLink;
    }
    public void setScrappingLink(ScrappingLink scrappingLink){
        this.scrappingLink = scrappingLink;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeProduit getTypeProduit(){
        return this.typeProduit;
    }
    public void setTypeProduit(TypeProduit typeProduit){
        this.typeProduit = typeProduit;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }
    public String getStock(){
        return this.stock;
    }
    public void setStock(String stock){
        this.stock = stock;
    }
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getReview(){
        return this.review;
    }
    public void setReview(String review){
        this.review = review;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ScrappingOperation getScrappingOperation(){
        return this.scrappingOperation;
    }
    public void setScrappingOperation(ScrappingOperation scrappingOperation){
        this.scrappingOperation = scrappingOperation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrappingOperationItem scrappingOperationItem = (ScrappingOperationItem) o;
        return id != null && id.equals(scrappingOperationItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

