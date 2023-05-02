package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.Notification;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface NotificationDao extends AbstractRepository<Notification,Long>  {

    List<Notification> findByStatutNotificationId(Long id);
    int deleteByStatutNotificationId(Long id);
    List<Notification> findByNotificationDetailId(Long id);
    int deleteByNotificationDetailId(Long id);

}
