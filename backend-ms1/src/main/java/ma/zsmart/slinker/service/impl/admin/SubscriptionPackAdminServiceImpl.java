package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.SubscriptionPack;
import ma.zsmart.slinker.bean.history.SubscriptionPackHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionPackCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionPackHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.SubscriptionPackDao;
import ma.zsmart.slinker.dao.facade.history.SubscriptionPackHistoryDao;
import ma.zsmart.slinker.dao.specification.core.SubscriptionPackSpecification;
import ma.zsmart.slinker.service.facade.admin.SubscriptionPackAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class SubscriptionPackAdminServiceImpl extends AbstractServiceImpl<SubscriptionPack,SubscriptionPackHistory, SubscriptionPackCriteria, SubscriptionPackHistoryCriteria, SubscriptionPackDao,
SubscriptionPackHistoryDao> implements SubscriptionPackAdminService {


    public SubscriptionPack findByReferenceEntity(SubscriptionPack t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(SubscriptionPack.class,SubscriptionPackHistory.class, SubscriptionPackHistoryCriteria.class, SubscriptionPackSpecification.class);
    }

    public SubscriptionPackAdminServiceImpl(SubscriptionPackDao dao, SubscriptionPackHistoryDao historyDao) {
        super(dao, historyDao);
    }

}