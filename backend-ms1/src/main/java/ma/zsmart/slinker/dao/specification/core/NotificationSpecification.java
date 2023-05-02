package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.NotificationCriteria;
import ma.zsmart.slinker.bean.core.Notification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class NotificationSpecification extends  AbstractSpecification<NotificationCriteria, Notification>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("statutNotification","id", criteria.getStatutNotification()==null?null:criteria.getStatutNotification().getId());
        addPredicateFk("statutNotification","id", criteria.getStatutNotifications());
        addPredicateFk("statutNotification","code", criteria.getStatutNotification()==null?null:criteria.getStatutNotification().getCode());
        addPredicateFk("notificationDetail","id", criteria.getNotificationDetail()==null?null:criteria.getNotificationDetail().getId());
        addPredicateFk("notificationDetail","id", criteria.getNotificationDetails());
    }

    public NotificationSpecification(NotificationCriteria criteria) {
        super(criteria);
    }

    public NotificationSpecification(NotificationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
