package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.Article;
import ma.zsmart.slinker.dao.criteria.core.ArticleCriteria;
import ma.zsmart.slinker.dao.criteria.history.ArticleHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface ArticleAdminService extends  IService<Article,ArticleCriteria, ArticleHistoryCriteria>  {




}
