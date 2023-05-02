package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.Commentaire;
import ma.zsmart.slinker.bean.history.CommentaireHistory;
import ma.zsmart.slinker.dao.criteria.core.CommentaireCriteria;
import ma.zsmart.slinker.dao.criteria.history.CommentaireHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.CommentaireDao;
import ma.zsmart.slinker.dao.facade.history.CommentaireHistoryDao;
import ma.zsmart.slinker.dao.specification.core.CommentaireSpecification;
import ma.zsmart.slinker.service.facade.admin.CommentaireAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zsmart.slinker.service.facade.admin.ArticleAdminService ;


import java.util.List;
@Service
public class CommentaireAdminServiceImpl extends AbstractServiceImpl<Commentaire,CommentaireHistory, CommentaireCriteria, CommentaireHistoryCriteria, CommentaireDao,
CommentaireHistoryDao> implements CommentaireAdminService {



    public List<Commentaire> findByArticleId(Long id){
        return dao.findByArticleId(id);
    }
    public int deleteByArticleId(Long id){
        return dao.deleteByArticleId(id);
    }

    public void configure() {
        super.configure(Commentaire.class,CommentaireHistory.class, CommentaireHistoryCriteria.class, CommentaireSpecification.class);
    }

    @Autowired
    private ArticleAdminService articleService ;
    public CommentaireAdminServiceImpl(CommentaireDao dao, CommentaireHistoryDao historyDao) {
        super(dao, historyDao);
    }

}