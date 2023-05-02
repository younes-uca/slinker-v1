package ma.zsmart.slinker.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "subscription_etat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscription_etat_seq",sequenceName="subscription_etat_seq",allocationSize=1, initialValue = 1)
public class SubscriptionEtat   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public SubscriptionEtat(){
        super();
    }

    public SubscriptionEtat(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscription_etat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionEtat subscriptionEtat = (SubscriptionEtat) o;
        return id != null && id.equals(subscriptionEtat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

