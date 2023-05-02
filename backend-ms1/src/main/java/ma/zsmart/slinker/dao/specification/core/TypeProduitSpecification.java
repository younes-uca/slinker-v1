package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.TypeProduitCriteria;
import ma.zsmart.slinker.bean.core.TypeProduit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TypeProduitSpecification extends  AbstractSpecification<TypeProduitCriteria, TypeProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeProduitSpecification(TypeProduitCriteria criteria) {
        super(criteria);
    }

    public TypeProduitSpecification(TypeProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
