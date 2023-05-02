package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionEtatCriteria;
import ma.zsmart.slinker.bean.core.SubscriptionEtat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionEtatSpecification extends  AbstractSpecification<SubscriptionEtatCriteria, SubscriptionEtat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public SubscriptionEtatSpecification(SubscriptionEtatCriteria criteria) {
        super(criteria);
    }

    public SubscriptionEtatSpecification(SubscriptionEtatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
