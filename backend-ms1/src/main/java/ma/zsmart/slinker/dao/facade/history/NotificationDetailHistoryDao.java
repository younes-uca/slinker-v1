package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.NotificationDetailHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDetailHistoryDao extends AbstractHistoryRepository<NotificationDetailHistory,Long> {

}
