package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.StatutClientHistoryCriteria;
import ma.zsmart.slinker.bean.history.StatutClientHistory;


public class StatutClientHistorySpecification extends AbstractHistorySpecification<StatutClientHistoryCriteria, StatutClientHistory> {

    public StatutClientHistorySpecification(StatutClientHistoryCriteria criteria) {
        super(criteria);
    }

    public StatutClientHistorySpecification(StatutClientHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
