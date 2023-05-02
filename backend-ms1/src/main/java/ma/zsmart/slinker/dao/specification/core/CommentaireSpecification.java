package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.CommentaireCriteria;
import ma.zsmart.slinker.bean.core.Commentaire;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CommentaireSpecification extends  AbstractSpecification<CommentaireCriteria, Commentaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateCommentaire", criteria.getDateCommentaire(), criteria.getDateCommentaireFrom(), criteria.getDateCommentaireTo());
        addPredicateFk("article","id", criteria.getArticle()==null?null:criteria.getArticle().getId());
        addPredicateFk("article","id", criteria.getArticles());
    }

    public CommentaireSpecification(CommentaireCriteria criteria) {
        super(criteria);
    }

    public CommentaireSpecification(CommentaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
