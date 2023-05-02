package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.SubscriptionTypeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionTypeHistoryDao extends AbstractHistoryRepository<SubscriptionTypeHistory,Long> {

}
