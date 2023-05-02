package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.StatutNotification;
import ma.zsmart.slinker.bean.history.StatutNotificationHistory;
import ma.zsmart.slinker.dao.criteria.core.StatutNotificationCriteria;
import ma.zsmart.slinker.dao.criteria.history.StatutNotificationHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.StatutNotificationDao;
import ma.zsmart.slinker.dao.facade.history.StatutNotificationHistoryDao;
import ma.zsmart.slinker.dao.specification.core.StatutNotificationSpecification;
import ma.zsmart.slinker.service.facade.admin.StatutNotificationAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class StatutNotificationAdminServiceImpl extends AbstractServiceImpl<StatutNotification,StatutNotificationHistory, StatutNotificationCriteria, StatutNotificationHistoryCriteria, StatutNotificationDao,
StatutNotificationHistoryDao> implements StatutNotificationAdminService {


    public StatutNotification findByReferenceEntity(StatutNotification t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(StatutNotification.class,StatutNotificationHistory.class, StatutNotificationHistoryCriteria.class, StatutNotificationSpecification.class);
    }

    public StatutNotificationAdminServiceImpl(StatutNotificationDao dao, StatutNotificationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}