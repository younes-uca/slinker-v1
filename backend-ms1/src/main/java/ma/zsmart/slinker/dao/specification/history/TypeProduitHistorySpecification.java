package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.TypeProduitHistoryCriteria;
import ma.zsmart.slinker.bean.history.TypeProduitHistory;


public class TypeProduitHistorySpecification extends AbstractHistorySpecification<TypeProduitHistoryCriteria, TypeProduitHistory> {

    public TypeProduitHistorySpecification(TypeProduitHistoryCriteria criteria) {
        super(criteria);
    }

    public TypeProduitHistorySpecification(TypeProduitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
