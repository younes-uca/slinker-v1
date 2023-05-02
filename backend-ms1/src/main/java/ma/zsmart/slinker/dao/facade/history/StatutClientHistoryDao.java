package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.StatutClientHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutClientHistoryDao extends AbstractHistoryRepository<StatutClientHistory,Long> {

}
