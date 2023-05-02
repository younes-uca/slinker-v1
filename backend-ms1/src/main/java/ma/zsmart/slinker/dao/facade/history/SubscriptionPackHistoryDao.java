package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.SubscriptionPackHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPackHistoryDao extends AbstractHistoryRepository<SubscriptionPackHistory,Long> {

}
