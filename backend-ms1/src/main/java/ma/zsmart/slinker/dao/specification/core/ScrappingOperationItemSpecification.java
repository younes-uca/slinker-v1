package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationItemCriteria;
import ma.zsmart.slinker.bean.core.ScrappingOperationItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ScrappingOperationItemSpecification extends  AbstractSpecification<ScrappingOperationItemCriteria, ScrappingOperationItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicate("stock", criteria.getStock(),criteria.getStockLike());
        addPredicate("image", criteria.getImage(),criteria.getImageLike());
        addPredicate("review", criteria.getReview(),criteria.getReviewLike());
        addPredicateFk("scrappingLink","id", criteria.getScrappingLink()==null?null:criteria.getScrappingLink().getId());
        addPredicateFk("scrappingLink","id", criteria.getScrappingLinks());
        addPredicateFk("scrappingLink","code", criteria.getScrappingLink()==null?null:criteria.getScrappingLink().getCode());
        addPredicateFk("typeProduit","id", criteria.getTypeProduit()==null?null:criteria.getTypeProduit().getId());
        addPredicateFk("typeProduit","id", criteria.getTypeProduits());
        addPredicateFk("typeProduit","code", criteria.getTypeProduit()==null?null:criteria.getTypeProduit().getCode());
        addPredicateFk("scrappingOperation","id", criteria.getScrappingOperation()==null?null:criteria.getScrappingOperation().getId());
        addPredicateFk("scrappingOperation","id", criteria.getScrappingOperations());
    }

    public ScrappingOperationItemSpecification(ScrappingOperationItemCriteria criteria) {
        super(criteria);
    }

    public ScrappingOperationItemSpecification(ScrappingOperationItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
