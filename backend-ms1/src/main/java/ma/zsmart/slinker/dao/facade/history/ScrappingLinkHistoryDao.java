package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.ScrappingLinkHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrappingLinkHistoryDao extends AbstractHistoryRepository<ScrappingLinkHistory,Long> {

}
