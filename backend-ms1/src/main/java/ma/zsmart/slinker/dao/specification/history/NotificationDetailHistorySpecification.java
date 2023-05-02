package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.NotificationDetailHistoryCriteria;
import ma.zsmart.slinker.bean.history.NotificationDetailHistory;


public class NotificationDetailHistorySpecification extends AbstractHistorySpecification<NotificationDetailHistoryCriteria, NotificationDetailHistory> {

    public NotificationDetailHistorySpecification(NotificationDetailHistoryCriteria criteria) {
        super(criteria);
    }

    public NotificationDetailHistorySpecification(NotificationDetailHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
