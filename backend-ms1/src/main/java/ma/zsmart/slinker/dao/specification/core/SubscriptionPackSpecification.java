package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionPackCriteria;
import ma.zsmart.slinker.bean.core.SubscriptionPack;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionPackSpecification extends  AbstractSpecification<SubscriptionPackCriteria, SubscriptionPack>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
    }

    public SubscriptionPackSpecification(SubscriptionPackCriteria criteria) {
        super(criteria);
    }

    public SubscriptionPackSpecification(SubscriptionPackCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
