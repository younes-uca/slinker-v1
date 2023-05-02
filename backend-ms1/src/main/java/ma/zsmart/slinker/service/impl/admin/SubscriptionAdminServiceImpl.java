package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.Subscription;
import ma.zsmart.slinker.bean.history.SubscriptionHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.SubscriptionDao;
import ma.zsmart.slinker.dao.facade.history.SubscriptionHistoryDao;
import ma.zsmart.slinker.dao.specification.core.SubscriptionSpecification;
import ma.zsmart.slinker.service.facade.admin.SubscriptionAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zsmart.slinker.service.facade.admin.SubscriptionTypeAdminService ;
import ma.zsmart.slinker.service.facade.admin.SubscriptionPackAdminService ;
import ma.zsmart.slinker.service.facade.admin.ClientAdminService ;
import ma.zsmart.slinker.service.facade.admin.SubscriptionEtatAdminService ;


import java.util.List;
@Service
public class SubscriptionAdminServiceImpl extends AbstractServiceImpl<Subscription,SubscriptionHistory, SubscriptionCriteria, SubscriptionHistoryCriteria, SubscriptionDao,
SubscriptionHistoryDao> implements SubscriptionAdminService {



    public List<Subscription> findBySubscriptionTypeId(Long id){
        return dao.findBySubscriptionTypeId(id);
    }
    public int deleteBySubscriptionTypeId(Long id){
        return dao.deleteBySubscriptionTypeId(id);
    }
    public List<Subscription> findBySubscriptionPackId(Long id){
        return dao.findBySubscriptionPackId(id);
    }
    public int deleteBySubscriptionPackId(Long id){
        return dao.deleteBySubscriptionPackId(id);
    }
    public List<Subscription> findBySubscriptionEtatId(Long id){
        return dao.findBySubscriptionEtatId(id);
    }
    public int deleteBySubscriptionEtatId(Long id){
        return dao.deleteBySubscriptionEtatId(id);
    }
    public List<Subscription> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Subscription> findByTypePaiementId(Long id){
        return dao.findByTypePaiementId(id);
    }
    public int deleteByTypePaiementId(Long id){
        return dao.deleteByTypePaiementId(id);
    }

    public void configure() {
        super.configure(Subscription.class,SubscriptionHistory.class, SubscriptionHistoryCriteria.class, SubscriptionSpecification.class);
    }

    @Autowired
    private SubscriptionTypeAdminService subscriptionTypeService ;
    @Autowired
    private SubscriptionPackAdminService subscriptionPackService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private SubscriptionEtatAdminService subscriptionEtatService ;
    public SubscriptionAdminServiceImpl(SubscriptionDao dao, SubscriptionHistoryDao historyDao) {
        super(dao, historyDao);
    }

}