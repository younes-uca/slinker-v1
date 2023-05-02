package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.AffliateHistoryCriteria;
import ma.zsmart.slinker.bean.history.AffliateHistory;


public class AffliateHistorySpecification extends AbstractHistorySpecification<AffliateHistoryCriteria, AffliateHistory> {

    public AffliateHistorySpecification(AffliateHistoryCriteria criteria) {
        super(criteria);
    }

    public AffliateHistorySpecification(AffliateHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
