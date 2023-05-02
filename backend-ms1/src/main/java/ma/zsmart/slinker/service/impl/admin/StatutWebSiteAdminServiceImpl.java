package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.StatutWebSite;
import ma.zsmart.slinker.bean.history.StatutWebSiteHistory;
import ma.zsmart.slinker.dao.criteria.core.StatutWebSiteCriteria;
import ma.zsmart.slinker.dao.criteria.history.StatutWebSiteHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.StatutWebSiteDao;
import ma.zsmart.slinker.dao.facade.history.StatutWebSiteHistoryDao;
import ma.zsmart.slinker.dao.specification.core.StatutWebSiteSpecification;
import ma.zsmart.slinker.service.facade.admin.StatutWebSiteAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class StatutWebSiteAdminServiceImpl extends AbstractServiceImpl<StatutWebSite,StatutWebSiteHistory, StatutWebSiteCriteria, StatutWebSiteHistoryCriteria, StatutWebSiteDao,
StatutWebSiteHistoryDao> implements StatutWebSiteAdminService {


    public StatutWebSite findByReferenceEntity(StatutWebSite t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(StatutWebSite.class,StatutWebSiteHistory.class, StatutWebSiteHistoryCriteria.class, StatutWebSiteSpecification.class);
    }

    public StatutWebSiteAdminServiceImpl(StatutWebSiteDao dao, StatutWebSiteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}