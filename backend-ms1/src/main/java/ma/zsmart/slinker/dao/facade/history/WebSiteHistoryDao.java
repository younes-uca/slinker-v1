package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.WebSiteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteHistoryDao extends AbstractHistoryRepository<WebSiteHistory,Long> {

}
