package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.SubscriptionEtatHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionEtatHistoryDao extends AbstractHistoryRepository<SubscriptionEtatHistory,Long> {

}
