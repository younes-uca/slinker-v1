package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.NotificationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationHistoryDao extends AbstractHistoryRepository<NotificationHistory,Long> {

}
