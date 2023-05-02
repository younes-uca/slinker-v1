package  ma.zsmart.slinker.dao.specification.history;

import ma.zsmart.slinker.zynerator.specification.AbstractHistorySpecification;
import ma.zsmart.slinker.dao.criteria.history.CommentaireHistoryCriteria;
import ma.zsmart.slinker.bean.history.CommentaireHistory;


public class CommentaireHistorySpecification extends AbstractHistorySpecification<CommentaireHistoryCriteria, CommentaireHistory> {

    public CommentaireHistorySpecification(CommentaireHistoryCriteria criteria) {
        super(criteria);
    }

    public CommentaireHistorySpecification(CommentaireHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
