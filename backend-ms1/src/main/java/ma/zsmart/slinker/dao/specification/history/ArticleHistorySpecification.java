package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.ArticleHistoryCriteria;
import ma.zsmart.slinker.bean.history.ArticleHistory;


public class ArticleHistorySpecification extends AbstractHistorySpecification<ArticleHistoryCriteria, ArticleHistory> {

    public ArticleHistorySpecification(ArticleHistoryCriteria criteria) {
        super(criteria);
    }

    public ArticleHistorySpecification(ArticleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
