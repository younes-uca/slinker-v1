package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.Notification;
import ma.zsmart.slinker.bean.history.NotificationHistory;
import ma.zsmart.slinker.dao.criteria.core.NotificationCriteria;
import ma.zsmart.slinker.dao.criteria.history.NotificationHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.NotificationDao;
import ma.zsmart.slinker.dao.facade.history.NotificationHistoryDao;
import ma.zsmart.slinker.dao.specification.core.NotificationSpecification;
import ma.zsmart.slinker.service.facade.admin.NotificationAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zsmart.slinker.service.facade.admin.NotificationDetailAdminService ;
import ma.zsmart.slinker.service.facade.admin.StatutNotificationAdminService ;


import java.util.List;
@Service
public class NotificationAdminServiceImpl extends AbstractServiceImpl<Notification,NotificationHistory, NotificationCriteria, NotificationHistoryCriteria, NotificationDao,
NotificationHistoryDao> implements NotificationAdminService {



    public List<Notification> findByStatutNotificationId(Long id){
        return dao.findByStatutNotificationId(id);
    }
    public int deleteByStatutNotificationId(Long id){
        return dao.deleteByStatutNotificationId(id);
    }
    public List<Notification> findByNotificationDetailId(Long id){
        return dao.findByNotificationDetailId(id);
    }
    public int deleteByNotificationDetailId(Long id){
        return dao.deleteByNotificationDetailId(id);
    }

    public void configure() {
        super.configure(Notification.class,NotificationHistory.class, NotificationHistoryCriteria.class, NotificationSpecification.class);
    }

    @Autowired
    private NotificationDetailAdminService notificationDetailService ;
    @Autowired
    private StatutNotificationAdminService statutNotificationService ;
    public NotificationAdminServiceImpl(NotificationDao dao, NotificationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}