package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.NotificationDetail;
import ma.zsmart.slinker.bean.history.NotificationDetailHistory;
import ma.zsmart.slinker.dao.criteria.core.NotificationDetailCriteria;
import ma.zsmart.slinker.dao.criteria.history.NotificationDetailHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.NotificationDetailDao;
import ma.zsmart.slinker.dao.facade.history.NotificationDetailHistoryDao;
import ma.zsmart.slinker.dao.specification.core.NotificationDetailSpecification;
import ma.zsmart.slinker.service.facade.admin.NotificationDetailAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zsmart.slinker.service.facade.admin.NotificationAdminService ;
import ma.zsmart.slinker.service.facade.admin.ClientAdminService ;


import java.util.List;
@Service
public class NotificationDetailAdminServiceImpl extends AbstractServiceImpl<NotificationDetail,NotificationDetailHistory, NotificationDetailCriteria, NotificationDetailHistoryCriteria, NotificationDetailDao,
NotificationDetailHistoryDao> implements NotificationDetailAdminService {



    public List<NotificationDetail> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<NotificationDetail> findByNotificationId(Long id){
        return dao.findByNotificationId(id);
    }
    public int deleteByNotificationId(Long id){
        return dao.deleteByNotificationId(id);
    }

    public void configure() {
        super.configure(NotificationDetail.class,NotificationDetailHistory.class, NotificationDetailHistoryCriteria.class, NotificationDetailSpecification.class);
    }

    @Autowired
    private NotificationAdminService notificationService ;
    @Autowired
    private ClientAdminService clientService ;
    public NotificationDetailAdminServiceImpl(NotificationDetailDao dao, NotificationDetailHistoryDao historyDao) {
        super(dao, historyDao);
    }

}