package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.NotificationDetail;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface NotificationDetailDao extends AbstractRepository<NotificationDetail,Long>  {

    List<NotificationDetail> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<NotificationDetail> findByNotificationId(Long id);
    int deleteByNotificationId(Long id);

}
