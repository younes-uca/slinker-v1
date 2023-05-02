package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionHistoryCriteria;
import ma.zsmart.slinker.bean.history.SubscriptionHistory;


public class SubscriptionHistorySpecification extends AbstractHistorySpecification<SubscriptionHistoryCriteria, SubscriptionHistory> {

    public SubscriptionHistorySpecification(SubscriptionHistoryCriteria criteria) {
        super(criteria);
    }

    public SubscriptionHistorySpecification(SubscriptionHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
