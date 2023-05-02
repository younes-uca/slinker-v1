package ma.zsmart.slinker.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "scrapping_operation")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="scrapping_operation_seq",sequenceName="scrapping_operation_seq",allocationSize=1, initialValue = 1)
public class ScrappingOperationHistory extends HistBusinessObject  {


    public ScrappingOperationHistory() {
    super();
    }

    public ScrappingOperationHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="scrapping_operation_seq")
    public Long getId() {
    return id;
    }
}

