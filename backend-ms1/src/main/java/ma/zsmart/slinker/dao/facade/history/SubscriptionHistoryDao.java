package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.SubscriptionHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionHistoryDao extends AbstractHistoryRepository<SubscriptionHistory,Long> {

}
