package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.ArticleCriteria;
import ma.zsmart.slinker.bean.core.Article;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ArticleSpecification extends  AbstractSpecification<ArticleCriteria, Article>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("titre", criteria.getTitre(),criteria.getTitreLike());
        addPredicate("image", criteria.getImage(),criteria.getImageLike());
    }

    public ArticleSpecification(ArticleCriteria criteria) {
        super(criteria);
    }

    public ArticleSpecification(ArticleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
