package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.Affliate;
import ma.zsmart.slinker.bean.history.AffliateHistory;
import ma.zsmart.slinker.dao.criteria.core.AffliateCriteria;
import ma.zsmart.slinker.dao.criteria.history.AffliateHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.AffliateDao;
import ma.zsmart.slinker.dao.facade.history.AffliateHistoryDao;
import ma.zsmart.slinker.dao.specification.core.AffliateSpecification;
import ma.zsmart.slinker.service.facade.admin.AffliateAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zsmart.slinker.service.facade.admin.ClientAdminService ;


import java.util.List;
@Service
public class AffliateAdminServiceImpl extends AbstractServiceImpl<Affliate,AffliateHistory, AffliateCriteria, AffliateHistoryCriteria, AffliateDao,
AffliateHistoryDao> implements AffliateAdminService {


    public Affliate findByReferenceEntity(Affliate t){
        return  dao.findByCode(t.getCode());
    }

    public List<Affliate> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }

    public void configure() {
        super.configure(Affliate.class,AffliateHistory.class, AffliateHistoryCriteria.class, AffliateSpecification.class);
    }

    @Autowired
    private ClientAdminService clientService ;
    public AffliateAdminServiceImpl(AffliateDao dao, AffliateHistoryDao historyDao) {
        super(dao, historyDao);
    }

}