package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.SubscriptionEtat;
import ma.zsmart.slinker.bean.history.SubscriptionEtatHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionEtatCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionEtatHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.SubscriptionEtatDao;
import ma.zsmart.slinker.dao.facade.history.SubscriptionEtatHistoryDao;
import ma.zsmart.slinker.dao.specification.core.SubscriptionEtatSpecification;
import ma.zsmart.slinker.service.facade.admin.SubscriptionEtatAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class SubscriptionEtatAdminServiceImpl extends AbstractServiceImpl<SubscriptionEtat,SubscriptionEtatHistory, SubscriptionEtatCriteria, SubscriptionEtatHistoryCriteria, SubscriptionEtatDao,
SubscriptionEtatHistoryDao> implements SubscriptionEtatAdminService {


    public SubscriptionEtat findByReferenceEntity(SubscriptionEtat t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(SubscriptionEtat.class,SubscriptionEtatHistory.class, SubscriptionEtatHistoryCriteria.class, SubscriptionEtatSpecification.class);
    }

    public SubscriptionEtatAdminServiceImpl(SubscriptionEtatDao dao, SubscriptionEtatHistoryDao historyDao) {
        super(dao, historyDao);
    }

}