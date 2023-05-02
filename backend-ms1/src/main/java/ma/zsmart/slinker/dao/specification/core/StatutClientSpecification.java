package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.StatutClientCriteria;
import ma.zsmart.slinker.bean.core.StatutClient;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StatutClientSpecification extends  AbstractSpecification<StatutClientCriteria, StatutClient>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public StatutClientSpecification(StatutClientCriteria criteria) {
        super(criteria);
    }

    public StatutClientSpecification(StatutClientCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
