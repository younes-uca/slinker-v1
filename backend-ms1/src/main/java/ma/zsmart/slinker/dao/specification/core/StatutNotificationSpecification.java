package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.StatutNotificationCriteria;
import ma.zsmart.slinker.bean.core.StatutNotification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StatutNotificationSpecification extends  AbstractSpecification<StatutNotificationCriteria, StatutNotification>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public StatutNotificationSpecification(StatutNotificationCriteria criteria) {
        super(criteria);
    }

    public StatutNotificationSpecification(StatutNotificationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
