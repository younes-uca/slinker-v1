package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.ScrappingLink;
import ma.zsmart.slinker.bean.history.ScrappingLinkHistory;
import ma.zsmart.slinker.dao.criteria.core.ScrappingLinkCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingLinkHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.ScrappingLinkDao;
import ma.zsmart.slinker.dao.facade.history.ScrappingLinkHistoryDao;
import ma.zsmart.slinker.dao.specification.core.ScrappingLinkSpecification;
import ma.zsmart.slinker.service.facade.admin.ScrappingLinkAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zsmart.slinker.service.facade.admin.WebSiteAdminService ;


import java.util.List;
@Service
public class ScrappingLinkAdminServiceImpl extends AbstractServiceImpl<ScrappingLink,ScrappingLinkHistory, ScrappingLinkCriteria, ScrappingLinkHistoryCriteria, ScrappingLinkDao,
ScrappingLinkHistoryDao> implements ScrappingLinkAdminService {


    public ScrappingLink findByReferenceEntity(ScrappingLink t){
        return  dao.findByCode(t.getCode());
    }

    public List<ScrappingLink> findByWebSiteId(Long id){
        return dao.findByWebSiteId(id);
    }
    public int deleteByWebSiteId(Long id){
        return dao.deleteByWebSiteId(id);
    }

    public void configure() {
        super.configure(ScrappingLink.class,ScrappingLinkHistory.class, ScrappingLinkHistoryCriteria.class, ScrappingLinkSpecification.class);
    }

    @Autowired
    private WebSiteAdminService webSiteService ;
    public ScrappingLinkAdminServiceImpl(ScrappingLinkDao dao, ScrappingLinkHistoryDao historyDao) {
        super(dao, historyDao);
    }

}