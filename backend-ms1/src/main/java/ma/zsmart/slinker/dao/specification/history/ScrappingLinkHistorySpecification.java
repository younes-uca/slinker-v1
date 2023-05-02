package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.ScrappingLinkHistoryCriteria;
import ma.zsmart.slinker.bean.history.ScrappingLinkHistory;


public class ScrappingLinkHistorySpecification extends AbstractHistorySpecification<ScrappingLinkHistoryCriteria, ScrappingLinkHistory> {

    public ScrappingLinkHistorySpecification(ScrappingLinkHistoryCriteria criteria) {
        super(criteria);
    }

    public ScrappingLinkHistorySpecification(ScrappingLinkHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
