package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.SubscriptionEtat;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.SubscriptionEtat;
import java.util.List;


@Repository
public interface SubscriptionEtatDao extends AbstractRepository<SubscriptionEtat,Long>  {
    SubscriptionEtat findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW SubscriptionEtat(item.id,item.libelle) FROM SubscriptionEtat item")
    List<SubscriptionEtat> findAllOptimized();
}
