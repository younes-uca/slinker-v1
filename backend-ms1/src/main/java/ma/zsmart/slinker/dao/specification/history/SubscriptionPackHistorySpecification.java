package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionPackHistoryCriteria;
import ma.zsmart.slinker.bean.history.SubscriptionPackHistory;


public class SubscriptionPackHistorySpecification extends AbstractHistorySpecification<SubscriptionPackHistoryCriteria, SubscriptionPackHistory> {

    public SubscriptionPackHistorySpecification(SubscriptionPackHistoryCriteria criteria) {
        super(criteria);
    }

    public SubscriptionPackHistorySpecification(SubscriptionPackHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
