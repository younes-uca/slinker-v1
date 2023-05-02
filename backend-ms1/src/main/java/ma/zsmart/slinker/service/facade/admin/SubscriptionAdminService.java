package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.Subscription;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface SubscriptionAdminService extends  IService<Subscription,SubscriptionCriteria, SubscriptionHistoryCriteria>  {

    List<Subscription> findBySubscriptionTypeId(Long id);
    int deleteBySubscriptionTypeId(Long id);
    List<Subscription> findBySubscriptionPackId(Long id);
    int deleteBySubscriptionPackId(Long id);
    List<Subscription> findBySubscriptionEtatId(Long id);
    int deleteBySubscriptionEtatId(Long id);
    List<Subscription> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Subscription> findByTypePaiementId(Long id);
    int deleteByTypePaiementId(Long id);



}
