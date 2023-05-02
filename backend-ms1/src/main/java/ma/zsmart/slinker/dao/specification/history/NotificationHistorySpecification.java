package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.NotificationHistoryCriteria;
import ma.zsmart.slinker.bean.history.NotificationHistory;


public class NotificationHistorySpecification extends AbstractHistorySpecification<NotificationHistoryCriteria, NotificationHistory> {

    public NotificationHistorySpecification(NotificationHistoryCriteria criteria) {
        super(criteria);
    }

    public NotificationHistorySpecification(NotificationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
