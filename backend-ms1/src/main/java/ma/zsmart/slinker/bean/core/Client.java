package ma.zsmart.slinker.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "client")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="client_seq",sequenceName="client_seq",allocationSize=1, initialValue = 1)
public class Client   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;
    @Column(length = 500)
    private String prenom;
    @Column(length = 500)
    private String password;
    @Column(length = 500)
    private String email;

    private StatutClient statutClient ;
    

    private List<Affliate> affliates ;
    private List<WebSite> webSites ;
    private List<NotificationDetail> notificationDetails ;
    private List<Subscription> subscriptions ;

    public Client(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="client_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public StatutClient getStatutClient(){
        return this.statutClient;
    }
    public void setStatutClient(StatutClient statutClient){
        this.statutClient = statutClient;
    }
    @OneToMany(mappedBy = "client")
    public List<Affliate> getAffliates(){
        return this.affliates;
    }
    public void setAffliates(List<Affliate> affliates){
        this.affliates = affliates;
    }
    @OneToMany(mappedBy = "client")
    public List<WebSite> getWebSites(){
        return this.webSites;
    }
    public void setWebSites(List<WebSite> webSites){
        this.webSites = webSites;
    }
    @OneToMany(mappedBy = "client")
    public List<NotificationDetail> getNotificationDetails(){
        return this.notificationDetails;
    }
    public void setNotificationDetails(List<NotificationDetail> notificationDetails){
        this.notificationDetails = notificationDetails;
    }
    @OneToMany(mappedBy = "client")
    public List<Subscription> getSubscriptions(){
        return this.subscriptions;
    }
    public void setSubscriptions(List<Subscription> subscriptions){
        this.subscriptions = subscriptions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

