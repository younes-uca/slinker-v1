package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.TypePaiementHistoryCriteria;
import ma.zsmart.slinker.bean.history.TypePaiementHistory;


public class TypePaiementHistorySpecification extends AbstractHistorySpecification<TypePaiementHistoryCriteria, TypePaiementHistory> {

    public TypePaiementHistorySpecification(TypePaiementHistoryCriteria criteria) {
        super(criteria);
    }

    public TypePaiementHistorySpecification(TypePaiementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
