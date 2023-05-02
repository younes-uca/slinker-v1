package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.ScrappingOperationItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrappingOperationItemHistoryDao extends AbstractHistoryRepository<ScrappingOperationItemHistory,Long> {

}
