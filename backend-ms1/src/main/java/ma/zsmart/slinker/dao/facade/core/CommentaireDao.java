package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.Commentaire;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CommentaireDao extends AbstractRepository<Commentaire,Long>  {

    List<Commentaire> findByArticleId(Long id);
    int deleteByArticleId(Long id);

}
