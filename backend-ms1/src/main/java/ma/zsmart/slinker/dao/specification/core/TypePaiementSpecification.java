package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.TypePaiementCriteria;
import ma.zsmart.slinker.bean.core.TypePaiement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TypePaiementSpecification extends  AbstractSpecification<TypePaiementCriteria, TypePaiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypePaiementSpecification(TypePaiementCriteria criteria) {
        super(criteria);
    }

    public TypePaiementSpecification(TypePaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
