package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.Commentaire;
import ma.zsmart.slinker.dao.criteria.core.CommentaireCriteria;
import ma.zsmart.slinker.dao.criteria.history.CommentaireHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface CommentaireAdminService extends  IService<Commentaire,CommentaireCriteria, CommentaireHistoryCriteria>  {

    List<Commentaire> findByArticleId(Long id);
    int deleteByArticleId(Long id);



}
