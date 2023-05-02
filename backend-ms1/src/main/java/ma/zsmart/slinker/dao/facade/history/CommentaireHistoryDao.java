package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.CommentaireHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireHistoryDao extends AbstractHistoryRepository<CommentaireHistory,Long> {

}
