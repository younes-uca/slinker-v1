package ma.zsmart.slinker.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "web_site")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="web_site_seq",sequenceName="web_site_seq",allocationSize=1, initialValue = 1)
public class WebSite   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String url;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String jsonSummary;

    private StatutWebSite statutWebSite ;
    
    private Client client ;
    

    private List<ScrappingLink> scrappingLinks ;

    public WebSite(){
        super();
    }

    public WebSite(Long id,String url){
        this.id = id;
        this.url = url ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="web_site_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getJsonSummary(){
        return this.jsonSummary;
    }
    public void setJsonSummary(String jsonSummary){
        this.jsonSummary = jsonSummary;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public StatutWebSite getStatutWebSite(){
        return this.statutWebSite;
    }
    public void setStatutWebSite(StatutWebSite statutWebSite){
        this.statutWebSite = statutWebSite;
    }
    @OneToMany(mappedBy = "webSite")
    public List<ScrappingLink> getScrappingLinks(){
        return this.scrappingLinks;
    }
    public void setScrappingLinks(List<ScrappingLink> scrappingLinks){
        this.scrappingLinks = scrappingLinks;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }

    @Transient
    public String getLabel() {
        label = url;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebSite webSite = (WebSite) o;
        return id != null && id.equals(webSite.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

