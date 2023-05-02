package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionTypeCriteria;
import ma.zsmart.slinker.bean.core.SubscriptionType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionTypeSpecification extends  AbstractSpecification<SubscriptionTypeCriteria, SubscriptionType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public SubscriptionTypeSpecification(SubscriptionTypeCriteria criteria) {
        super(criteria);
    }

    public SubscriptionTypeSpecification(SubscriptionTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
