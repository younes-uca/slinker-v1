package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationHistoryCriteria;
import ma.zsmart.slinker.bean.history.ScrappingOperationHistory;


public class ScrappingOperationHistorySpecification extends AbstractHistorySpecification<ScrappingOperationHistoryCriteria, ScrappingOperationHistory> {

    public ScrappingOperationHistorySpecification(ScrappingOperationHistoryCriteria criteria) {
        super(criteria);
    }

    public ScrappingOperationHistorySpecification(ScrappingOperationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
