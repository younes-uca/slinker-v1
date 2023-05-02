package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "statut_web_site")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="statut_web_site_seq",sequenceName="statut_web_site_seq",allocationSize=1, initialValue = 1)
public class StatutWebSiteHistory extends HistBusinessObject  {


    public StatutWebSiteHistory() {
    super();
    }

    public StatutWebSiteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="statut_web_site_seq")
    public Long getId() {
    return id;
    }
}

