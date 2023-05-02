package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.Article;
import ma.zsmart.slinker.bean.history.ArticleHistory;
import ma.zsmart.slinker.dao.criteria.core.ArticleCriteria;
import ma.zsmart.slinker.dao.criteria.history.ArticleHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.ArticleDao;
import ma.zsmart.slinker.dao.facade.history.ArticleHistoryDao;
import ma.zsmart.slinker.dao.specification.core.ArticleSpecification;
import ma.zsmart.slinker.service.facade.admin.ArticleAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.slinker.bean.core.Commentaire;

import ma.zsmart.slinker.service.facade.admin.CommentaireAdminService ;


import java.util.List;
@Service
public class ArticleAdminServiceImpl extends AbstractServiceImpl<Article,ArticleHistory, ArticleCriteria, ArticleHistoryCriteria, ArticleDao,
ArticleHistoryDao> implements ArticleAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Article create(Article t) {
        super.create(t);
        if (t.getCommentaires() != null) {
                t.getCommentaires().forEach(element-> {
                    element.setArticle(t);
                    commentaireService.create(element);
            });
        }
        return t;
    }

    public Article findWithAssociatedLists(Long id){
        Article result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCommentaires(commentaireService.findByArticleId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        commentaireService.deleteByArticleId(id);
    }


    public void updateWithAssociatedLists(Article article){
    if(article !=null && article.getId() != null){
            List<List<Commentaire>> resultCommentaires= commentaireService.getToBeSavedAndToBeDeleted(commentaireService.findByArticleId(article.getId()),article.getCommentaires());
            commentaireService.delete(resultCommentaires.get(1));
            ListUtil.emptyIfNull(resultCommentaires.get(0)).forEach(e -> e.setArticle(article));
            commentaireService.update(resultCommentaires.get(0),true);
    }
    }



    public void configure() {
        super.configure(Article.class,ArticleHistory.class, ArticleHistoryCriteria.class, ArticleSpecification.class);
    }

    @Autowired
    private CommentaireAdminService commentaireService ;
    public ArticleAdminServiceImpl(ArticleDao dao, ArticleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}