package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationItemHistoryCriteria;
import ma.zsmart.slinker.bean.history.ScrappingOperationItemHistory;


public class ScrappingOperationItemHistorySpecification extends AbstractHistorySpecification<ScrappingOperationItemHistoryCriteria, ScrappingOperationItemHistory> {

    public ScrappingOperationItemHistorySpecification(ScrappingOperationItemHistoryCriteria criteria) {
        super(criteria);
    }

    public ScrappingOperationItemHistorySpecification(ScrappingOperationItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
