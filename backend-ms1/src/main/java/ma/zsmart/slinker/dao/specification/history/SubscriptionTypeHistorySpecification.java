package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionTypeHistoryCriteria;
import ma.zsmart.slinker.bean.history.SubscriptionTypeHistory;


public class SubscriptionTypeHistorySpecification extends AbstractHistorySpecification<SubscriptionTypeHistoryCriteria, SubscriptionTypeHistory> {

    public SubscriptionTypeHistorySpecification(SubscriptionTypeHistoryCriteria criteria) {
        super(criteria);
    }

    public SubscriptionTypeHistorySpecification(SubscriptionTypeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
