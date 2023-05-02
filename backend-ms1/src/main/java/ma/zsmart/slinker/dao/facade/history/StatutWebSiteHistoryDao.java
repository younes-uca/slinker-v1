package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.StatutWebSiteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutWebSiteHistoryDao extends AbstractHistoryRepository<StatutWebSiteHistory,Long> {

}
