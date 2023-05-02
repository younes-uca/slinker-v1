package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.ScrappingLinkCriteria;
import ma.zsmart.slinker.bean.core.ScrappingLink;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ScrappingLinkSpecification extends  AbstractSpecification<ScrappingLinkCriteria, ScrappingLink>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("webSite","id", criteria.getWebSite()==null?null:criteria.getWebSite().getId());
        addPredicateFk("webSite","id", criteria.getWebSites());
    }

    public ScrappingLinkSpecification(ScrappingLinkCriteria criteria) {
        super(criteria);
    }

    public ScrappingLinkSpecification(ScrappingLinkCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
