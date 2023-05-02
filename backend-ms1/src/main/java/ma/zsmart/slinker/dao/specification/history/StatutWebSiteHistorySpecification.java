package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.StatutWebSiteHistoryCriteria;
import ma.zsmart.slinker.bean.history.StatutWebSiteHistory;


public class StatutWebSiteHistorySpecification extends AbstractHistorySpecification<StatutWebSiteHistoryCriteria, StatutWebSiteHistory> {

    public StatutWebSiteHistorySpecification(StatutWebSiteHistoryCriteria criteria) {
        super(criteria);
    }

    public StatutWebSiteHistorySpecification(StatutWebSiteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
