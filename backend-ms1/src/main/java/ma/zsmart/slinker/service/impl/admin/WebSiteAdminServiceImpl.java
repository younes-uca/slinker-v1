package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.WebSite;
import ma.zsmart.slinker.bean.history.WebSiteHistory;
import ma.zsmart.slinker.dao.criteria.core.WebSiteCriteria;
import ma.zsmart.slinker.dao.criteria.history.WebSiteHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.WebSiteDao;
import ma.zsmart.slinker.dao.facade.history.WebSiteHistoryDao;
import ma.zsmart.slinker.dao.specification.core.WebSiteSpecification;
import ma.zsmart.slinker.service.facade.admin.WebSiteAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.slinker.bean.core.ScrappingLink;

import ma.zsmart.slinker.service.facade.admin.ClientAdminService ;
import ma.zsmart.slinker.service.facade.admin.StatutWebSiteAdminService ;
import ma.zsmart.slinker.service.facade.admin.ScrappingLinkAdminService ;


import java.util.List;
@Service
public class WebSiteAdminServiceImpl extends AbstractServiceImpl<WebSite,WebSiteHistory, WebSiteCriteria, WebSiteHistoryCriteria, WebSiteDao,
WebSiteHistoryDao> implements WebSiteAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public WebSite create(WebSite t) {
        super.create(t);
        if (t.getScrappingLinks() != null) {
                t.getScrappingLinks().forEach(element-> {
                    element.setWebSite(t);
                    scrappingLinkService.create(element);
            });
        }
        return t;
    }

    public WebSite findWithAssociatedLists(Long id){
        WebSite result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setScrappingLinks(scrappingLinkService.findByWebSiteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        scrappingLinkService.deleteByWebSiteId(id);
    }


    public void updateWithAssociatedLists(WebSite webSite){
    if(webSite !=null && webSite.getId() != null){
            List<List<ScrappingLink>> resultScrappingLinks= scrappingLinkService.getToBeSavedAndToBeDeleted(scrappingLinkService.findByWebSiteId(webSite.getId()),webSite.getScrappingLinks());
            scrappingLinkService.delete(resultScrappingLinks.get(1));
            ListUtil.emptyIfNull(resultScrappingLinks.get(0)).forEach(e -> e.setWebSite(webSite));
            scrappingLinkService.update(resultScrappingLinks.get(0),true);
    }
    }


    public List<WebSite> findByStatutWebSiteId(Long id){
        return dao.findByStatutWebSiteId(id);
    }
    public int deleteByStatutWebSiteId(Long id){
        return dao.deleteByStatutWebSiteId(id);
    }
    public List<WebSite> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }

    public void configure() {
        super.configure(WebSite.class,WebSiteHistory.class, WebSiteHistoryCriteria.class, WebSiteSpecification.class);
    }

    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private StatutWebSiteAdminService statutWebSiteService ;
    @Autowired
    private ScrappingLinkAdminService scrappingLinkService ;
    public WebSiteAdminServiceImpl(WebSiteDao dao, WebSiteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}