package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "scrapping_operation_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="scrapping_operation_item_seq",sequenceName="scrapping_operation_item_seq",allocationSize=1, initialValue = 1)
public class ScrappingOperationItemHistory extends HistBusinessObject  {


    public ScrappingOperationItemHistory() {
    super();
    }

    public ScrappingOperationItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="scrapping_operation_item_seq")
    public Long getId() {
    return id;
    }
}

