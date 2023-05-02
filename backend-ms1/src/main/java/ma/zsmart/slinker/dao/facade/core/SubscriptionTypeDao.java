package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.SubscriptionType;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.SubscriptionType;
import java.util.List;


@Repository
public interface SubscriptionTypeDao extends AbstractRepository<SubscriptionType,Long>  {
    SubscriptionType findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW SubscriptionType(item.id,item.libelle) FROM SubscriptionType item")
    List<SubscriptionType> findAllOptimized();
}
