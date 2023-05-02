package  ma.zsmart.slinker.dao.specification.core;

import ma.zsmart.slinker.zynerator.specification.AbstractSpecification;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionCriteria;
import ma.zsmart.slinker.bean.core.Subscription;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionSpecification extends  AbstractSpecification<SubscriptionCriteria, Subscription>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateBigDecimal("delai", criteria.getDelai(), criteria.getDelaiMin(), criteria.getDelaiMax());
        addPredicateInt("nombrePage", criteria.getNombrePage(), criteria.getNombrePageMin(), criteria.getNombrePageMax());
        addPredicateBigDecimal("montantPaye", criteria.getMontantPaye(), criteria.getMontantPayeMin(), criteria.getMontantPayeMax());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateFk("subscriptionType","id", criteria.getSubscriptionType()==null?null:criteria.getSubscriptionType().getId());
        addPredicateFk("subscriptionType","id", criteria.getSubscriptionTypes());
        addPredicateFk("subscriptionType","code", criteria.getSubscriptionType()==null?null:criteria.getSubscriptionType().getCode());
        addPredicateFk("subscriptionPack","id", criteria.getSubscriptionPack()==null?null:criteria.getSubscriptionPack().getId());
        addPredicateFk("subscriptionPack","id", criteria.getSubscriptionPacks());
        addPredicateFk("subscriptionPack","code", criteria.getSubscriptionPack()==null?null:criteria.getSubscriptionPack().getCode());
        addPredicateFk("subscriptionEtat","id", criteria.getSubscriptionEtat()==null?null:criteria.getSubscriptionEtat().getId());
        addPredicateFk("subscriptionEtat","id", criteria.getSubscriptionEtats());
        addPredicateFk("subscriptionEtat","code", criteria.getSubscriptionEtat()==null?null:criteria.getSubscriptionEtat().getCode());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("typePaiement","id", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getId());
        addPredicateFk("typePaiement","id", criteria.getTypePaiements());
        addPredicateFk("typePaiement","code", criteria.getTypePaiement()==null?null:criteria.getTypePaiement().getCode());
    }

    public SubscriptionSpecification(SubscriptionCriteria criteria) {
        super(criteria);
    }

    public SubscriptionSpecification(SubscriptionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
