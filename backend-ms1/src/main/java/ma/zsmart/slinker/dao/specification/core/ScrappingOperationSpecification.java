package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationCriteria;
import ma.zsmart.slinker.bean.core.ScrappingOperation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ScrappingOperationSpecification extends  AbstractSpecification<ScrappingOperationCriteria, ScrappingOperation>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDebutScrappingOperation", criteria.getDateDebutScrappingOperation(), criteria.getDateDebutScrappingOperationFrom(), criteria.getDateDebutScrappingOperationTo());
        addPredicate("dateFinScrappingOperation", criteria.getDateFinScrappingOperation(), criteria.getDateFinScrappingOperationFrom(), criteria.getDateFinScrappingOperationTo());
        addPredicate("url", criteria.getUrl(),criteria.getUrlLike());
        addPredicateFk("affliate","id", criteria.getAffliate()==null?null:criteria.getAffliate().getId());
        addPredicateFk("affliate","id", criteria.getAffliates());
        addPredicateFk("affliate","code", criteria.getAffliate()==null?null:criteria.getAffliate().getCode());
        addPredicateFk("webSite","id", criteria.getWebSite()==null?null:criteria.getWebSite().getId());
        addPredicateFk("webSite","id", criteria.getWebSites());
    }

    public ScrappingOperationSpecification(ScrappingOperationCriteria criteria) {
        super(criteria);
    }

    public ScrappingOperationSpecification(ScrappingOperationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
