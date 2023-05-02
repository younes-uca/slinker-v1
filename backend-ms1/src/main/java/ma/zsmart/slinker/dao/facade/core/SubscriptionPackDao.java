package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.SubscriptionPack;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.SubscriptionPack;
import java.util.List;


@Repository
public interface SubscriptionPackDao extends AbstractRepository<SubscriptionPack,Long>  {
    SubscriptionPack findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW SubscriptionPack(item.id,item.libelle) FROM SubscriptionPack item")
    List<SubscriptionPack> findAllOptimized();
}
