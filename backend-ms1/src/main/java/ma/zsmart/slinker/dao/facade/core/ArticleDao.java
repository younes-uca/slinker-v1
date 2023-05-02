package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.Article;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ArticleDao extends AbstractRepository<Article,Long>  {


}
