package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.Subscription;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SubscriptionDao extends AbstractRepository<Subscription,Long>  {

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
