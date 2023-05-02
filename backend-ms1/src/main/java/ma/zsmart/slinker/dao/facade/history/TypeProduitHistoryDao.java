package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.TypeProduitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProduitHistoryDao extends AbstractHistoryRepository<TypeProduitHistory,Long> {

}
