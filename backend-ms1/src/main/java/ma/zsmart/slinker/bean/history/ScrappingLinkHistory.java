package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "scrapping_link")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="scrapping_link_seq",sequenceName="scrapping_link_seq",allocationSize=1, initialValue = 1)
public class ScrappingLinkHistory extends HistBusinessObject  {


    public ScrappingLinkHistory() {
    super();
    }

    public ScrappingLinkHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="scrapping_link_seq")
    public Long getId() {
    return id;
    }
}

