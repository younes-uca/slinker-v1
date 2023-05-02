package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.TypePaiementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaiementHistoryDao extends AbstractHistoryRepository<TypePaiementHistory,Long> {

}
