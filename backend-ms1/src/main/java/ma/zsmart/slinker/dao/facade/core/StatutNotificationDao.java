package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.StatutNotification;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.StatutNotification;
import java.util.List;


@Repository
public interface StatutNotificationDao extends AbstractRepository<StatutNotification,Long>  {
    StatutNotification findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW StatutNotification(item.id,item.libelle) FROM StatutNotification item")
    List<StatutNotification> findAllOptimized();
}
