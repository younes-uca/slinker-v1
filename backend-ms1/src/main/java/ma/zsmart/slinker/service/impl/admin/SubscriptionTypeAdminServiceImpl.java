package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.SubscriptionType;
import ma.zsmart.slinker.bean.history.SubscriptionTypeHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionTypeCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionTypeHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.SubscriptionTypeDao;
import ma.zsmart.slinker.dao.facade.history.SubscriptionTypeHistoryDao;
import ma.zsmart.slinker.dao.specification.core.SubscriptionTypeSpecification;
import ma.zsmart.slinker.service.facade.admin.SubscriptionTypeAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class SubscriptionTypeAdminServiceImpl extends AbstractServiceImpl<SubscriptionType,SubscriptionTypeHistory, SubscriptionTypeCriteria, SubscriptionTypeHistoryCriteria, SubscriptionTypeDao,
SubscriptionTypeHistoryDao> implements SubscriptionTypeAdminService {


    public SubscriptionType findByReferenceEntity(SubscriptionType t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(SubscriptionType.class,SubscriptionTypeHistory.class, SubscriptionTypeHistoryCriteria.class, SubscriptionTypeSpecification.class);
    }

    public SubscriptionTypeAdminServiceImpl(SubscriptionTypeDao dao, SubscriptionTypeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}