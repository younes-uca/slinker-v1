package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "web_site")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="web_site_seq",sequenceName="web_site_seq",allocationSize=1, initialValue = 1)
public class WebSiteHistory extends HistBusinessObject  {


    public WebSiteHistory() {
    super();
    }

    public WebSiteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="web_site_seq")
    public Long getId() {
    return id;
    }
}

