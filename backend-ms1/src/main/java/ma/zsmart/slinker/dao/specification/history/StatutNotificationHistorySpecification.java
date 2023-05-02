package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.StatutNotificationHistoryCriteria;
import ma.zsmart.slinker.bean.history.StatutNotificationHistory;


public class StatutNotificationHistorySpecification extends AbstractHistorySpecification<StatutNotificationHistoryCriteria, StatutNotificationHistory> {

    public StatutNotificationHistorySpecification(StatutNotificationHistoryCriteria criteria) {
        super(criteria);
    }

    public StatutNotificationHistorySpecification(StatutNotificationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
