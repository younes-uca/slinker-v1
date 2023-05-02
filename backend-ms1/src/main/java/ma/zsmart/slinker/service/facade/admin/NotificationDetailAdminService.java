package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.NotificationDetail;
import ma.zsmart.slinker.dao.criteria.core.NotificationDetailCriteria;
import ma.zsmart.slinker.dao.criteria.history.NotificationDetailHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface NotificationDetailAdminService extends  IService<NotificationDetail,NotificationDetailCriteria, NotificationDetailHistoryCriteria>  {

    List<NotificationDetail> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<NotificationDetail> findByNotificationId(Long id);
    int deleteByNotificationId(Long id);



}
