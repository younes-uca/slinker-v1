package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.WebSiteCriteria;
import ma.zsmart.slinker.bean.core.WebSite;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class WebSiteSpecification extends  AbstractSpecification<WebSiteCriteria, WebSite>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("url", criteria.getUrl(),criteria.getUrlLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("jsonSummary", criteria.getJsonSummary(),criteria.getJsonSummaryLike());
        addPredicateFk("statutWebSite","id", criteria.getStatutWebSite()==null?null:criteria.getStatutWebSite().getId());
        addPredicateFk("statutWebSite","id", criteria.getStatutWebSites());
        addPredicateFk("statutWebSite","code", criteria.getStatutWebSite()==null?null:criteria.getStatutWebSite().getCode());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
    }

    public WebSiteSpecification(WebSiteCriteria criteria) {
        super(criteria);
    }

    public WebSiteSpecification(WebSiteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
