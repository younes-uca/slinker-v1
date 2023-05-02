package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.StatutNotificationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutNotificationHistoryDao extends AbstractHistoryRepository<StatutNotificationHistory,Long> {

}
