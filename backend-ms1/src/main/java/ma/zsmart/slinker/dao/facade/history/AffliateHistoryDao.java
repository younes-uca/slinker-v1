package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.AffliateHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AffliateHistoryDao extends AbstractHistoryRepository<AffliateHistory,Long> {

}
