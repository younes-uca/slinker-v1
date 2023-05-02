package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.ScrappingOperation;
import ma.zsmart.slinker.bean.history.ScrappingOperationHistory;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.ScrappingOperationDao;
import ma.zsmart.slinker.dao.facade.history.ScrappingOperationHistoryDao;
import ma.zsmart.slinker.dao.specification.core.ScrappingOperationSpecification;
import ma.zsmart.slinker.service.facade.admin.ScrappingOperationAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.slinker.bean.core.ScrappingOperationItem;

import ma.zsmart.slinker.service.facade.admin.AffliateAdminService ;
import ma.zsmart.slinker.service.facade.admin.WebSiteAdminService ;
import ma.zsmart.slinker.service.facade.admin.ScrappingOperationItemAdminService ;


import java.util.List;
@Service
public class ScrappingOperationAdminServiceImpl extends AbstractServiceImpl<ScrappingOperation,ScrappingOperationHistory, ScrappingOperationCriteria, ScrappingOperationHistoryCriteria, ScrappingOperationDao,
ScrappingOperationHistoryDao> implements ScrappingOperationAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public ScrappingOperation create(ScrappingOperation t) {
        super.create(t);
        if (t.getScrappingOperationItems() != null) {
                t.getScrappingOperationItems().forEach(element-> {
                    element.setScrappingOperation(t);
                    scrappingOperationItemService.create(element);
            });
        }
        return t;
    }

    public ScrappingOperation findWithAssociatedLists(Long id){
        ScrappingOperation result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setScrappingOperationItems(scrappingOperationItemService.findByScrappingOperationId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        scrappingOperationItemService.deleteByScrappingOperationId(id);
    }


    public void updateWithAssociatedLists(ScrappingOperation scrappingOperation){
    if(scrappingOperation !=null && scrappingOperation.getId() != null){
            List<List<ScrappingOperationItem>> resultScrappingOperationItems= scrappingOperationItemService.getToBeSavedAndToBeDeleted(scrappingOperationItemService.findByScrappingOperationId(scrappingOperation.getId()),scrappingOperation.getScrappingOperationItems());
            scrappingOperationItemService.delete(resultScrappingOperationItems.get(1));
            ListUtil.emptyIfNull(resultScrappingOperationItems.get(0)).forEach(e -> e.setScrappingOperation(scrappingOperation));
            scrappingOperationItemService.update(resultScrappingOperationItems.get(0),true);
    }
    }


    public List<ScrappingOperation> findByAffliateId(Long id){
        return dao.findByAffliateId(id);
    }
    public int deleteByAffliateId(Long id){
        return dao.deleteByAffliateId(id);
    }
    public List<ScrappingOperation> findByWebSiteId(Long id){
        return dao.findByWebSiteId(id);
    }
    public int deleteByWebSiteId(Long id){
        return dao.deleteByWebSiteId(id);
    }

    public void configure() {
        super.configure(ScrappingOperation.class,ScrappingOperationHistory.class, ScrappingOperationHistoryCriteria.class, ScrappingOperationSpecification.class);
    }

    @Autowired
    private AffliateAdminService affliateService ;
    @Autowired
    private WebSiteAdminService webSiteService ;
    @Autowired
    private ScrappingOperationItemAdminService scrappingOperationItemService ;
    public ScrappingOperationAdminServiceImpl(ScrappingOperationDao dao, ScrappingOperationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}