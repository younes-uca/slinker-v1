package ma.zsmart.slinker.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "scrapping_operation")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="scrapping_operation_seq",sequenceName="scrapping_operation_seq",allocationSize=1, initialValue = 1)
public class ScrappingOperation   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDebutScrappingOperation ;
    private LocalDateTime dateFinScrappingOperation ;
    @Column(length = 500)
    private String url;

    private Affliate affliate ;
    
    private WebSite webSite ;
    

    private List<ScrappingOperationItem> scrappingOperationItems ;

    public ScrappingOperation(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="scrapping_operation_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateDebutScrappingOperation(){
        return this.dateDebutScrappingOperation;
    }
    public void setDateDebutScrappingOperation(LocalDateTime dateDebutScrappingOperation){
        this.dateDebutScrappingOperation = dateDebutScrappingOperation;
    }
    public LocalDateTime getDateFinScrappingOperation(){
        return this.dateFinScrappingOperation;
    }
    public void setDateFinScrappingOperation(LocalDateTime dateFinScrappingOperation){
        this.dateFinScrappingOperation = dateFinScrappingOperation;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Affliate getAffliate(){
        return this.affliate;
    }
    public void setAffliate(Affliate affliate){
        this.affliate = affliate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public WebSite getWebSite(){
        return this.webSite;
    }
    public void setWebSite(WebSite webSite){
        this.webSite = webSite;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    @OneToMany(mappedBy = "scrappingOperation")
    public List<ScrappingOperationItem> getScrappingOperationItems(){
        return this.scrappingOperationItems;
    }
    public void setScrappingOperationItems(List<ScrappingOperationItem> scrappingOperationItems){
        this.scrappingOperationItems = scrappingOperationItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScrappingOperation scrappingOperation = (ScrappingOperation) o;
        return id != null && id.equals(scrappingOperation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

