package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.Notification;
import ma.zsmart.slinker.dao.criteria.core.NotificationCriteria;
import ma.zsmart.slinker.dao.criteria.history.NotificationHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface NotificationAdminService extends  IService<Notification,NotificationCriteria, NotificationHistoryCriteria>  {

    List<Notification> findByStatutNotificationId(Long id);
    int deleteByStatutNotificationId(Long id);
    List<Notification> findByNotificationDetailId(Long id);
    int deleteByNotificationDetailId(Long id);



}
