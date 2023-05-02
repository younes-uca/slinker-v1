package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.WebSiteHistoryCriteria;
import ma.zsmart.slinker.bean.history.WebSiteHistory;


public class WebSiteHistorySpecification extends AbstractHistorySpecification<WebSiteHistoryCriteria, WebSiteHistory> {

    public WebSiteHistorySpecification(WebSiteHistoryCriteria criteria) {
        super(criteria);
    }

    public WebSiteHistorySpecification(WebSiteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
