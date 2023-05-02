package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionEtatHistoryCriteria;
import ma.zsmart.slinker.bean.history.SubscriptionEtatHistory;


public class SubscriptionEtatHistorySpecification extends AbstractHistorySpecification<SubscriptionEtatHistoryCriteria, SubscriptionEtatHistory> {

    public SubscriptionEtatHistorySpecification(SubscriptionEtatHistoryCriteria criteria) {
        super(criteria);
    }

    public SubscriptionEtatHistorySpecification(SubscriptionEtatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
