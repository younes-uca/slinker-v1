package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.StatutClient;
import ma.zsmart.slinker.bean.history.StatutClientHistory;
import ma.zsmart.slinker.dao.criteria.core.StatutClientCriteria;
import ma.zsmart.slinker.dao.criteria.history.StatutClientHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.StatutClientDao;
import ma.zsmart.slinker.dao.facade.history.StatutClientHistoryDao;
import ma.zsmart.slinker.dao.specification.core.StatutClientSpecification;
import ma.zsmart.slinker.service.facade.admin.StatutClientAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class StatutClientAdminServiceImpl extends AbstractServiceImpl<StatutClient,StatutClientHistory, StatutClientCriteria, StatutClientHistoryCriteria, StatutClientDao,
StatutClientHistoryDao> implements StatutClientAdminService {


    public StatutClient findByReferenceEntity(StatutClient t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(StatutClient.class,StatutClientHistory.class, StatutClientHistoryCriteria.class, StatutClientSpecification.class);
    }

    public StatutClientAdminServiceImpl(StatutClientDao dao, StatutClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}