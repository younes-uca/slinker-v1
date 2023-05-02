package ma.zsmart.slinker.dao.facade.history;

import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.bean.history.ArticleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleHistoryDao extends AbstractHistoryRepository<ArticleHistory,Long> {

}
