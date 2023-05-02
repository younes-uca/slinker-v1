package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.NotificationDetailCriteria;
import ma.zsmart.slinker.bean.core.NotificationDetail;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class NotificationDetailSpecification extends  AbstractSpecification<NotificationDetailCriteria, NotificationDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("notification","id", criteria.getNotification()==null?null:criteria.getNotification().getId());
        addPredicateFk("notification","id", criteria.getNotifications());
    }

    public NotificationDetailSpecification(NotificationDetailCriteria criteria) {
        super(criteria);
    }

    public NotificationDetailSpecification(NotificationDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
