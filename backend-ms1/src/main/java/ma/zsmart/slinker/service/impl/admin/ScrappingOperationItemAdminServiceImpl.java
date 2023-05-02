package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.ScrappingOperationItem;
import ma.zsmart.slinker.bean.history.ScrappingOperationItemHistory;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationItemCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationItemHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.ScrappingOperationItemDao;
import ma.zsmart.slinker.dao.facade.history.ScrappingOperationItemHistoryDao;
import ma.zsmart.slinker.dao.specification.core.ScrappingOperationItemSpecification;
import ma.zsmart.slinker.service.facade.admin.ScrappingOperationItemAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zsmart.slinker.service.facade.admin.TypeProduitAdminService ;
import ma.zsmart.slinker.service.facade.admin.ScrappingLinkAdminService ;
import ma.zsmart.slinker.service.facade.admin.ScrappingOperationAdminService ;


import java.util.List;
@Service
public class ScrappingOperationItemAdminServiceImpl extends AbstractServiceImpl<ScrappingOperationItem,ScrappingOperationItemHistory, ScrappingOperationItemCriteria, ScrappingOperationItemHistoryCriteria, ScrappingOperationItemDao,
ScrappingOperationItemHistoryDao> implements ScrappingOperationItemAdminService {



    public List<ScrappingOperationItem> findByScrappingLinkId(Long id){
        return dao.findByScrappingLinkId(id);
    }
    public int deleteByScrappingLinkId(Long id){
        return dao.deleteByScrappingLinkId(id);
    }
    public List<ScrappingOperationItem> findByTypeProduitId(Long id){
        return dao.findByTypeProduitId(id);
    }
    public int deleteByTypeProduitId(Long id){
        return dao.deleteByTypeProduitId(id);
    }
    public List<ScrappingOperationItem> findByScrappingOperationId(Long id){
        return dao.findByScrappingOperationId(id);
    }
    public int deleteByScrappingOperationId(Long id){
        return dao.deleteByScrappingOperationId(id);
    }

    public void configure() {
        super.configure(ScrappingOperationItem.class,ScrappingOperationItemHistory.class, ScrappingOperationItemHistoryCriteria.class, ScrappingOperationItemSpecification.class);
    }

    @Autowired
    private TypeProduitAdminService typeProduitService ;
    @Autowired
    private ScrappingLinkAdminService scrappingLinkService ;
    @Autowired
    private ScrappingOperationAdminService scrappingOperationService ;
    public ScrappingOperationItemAdminServiceImpl(ScrappingOperationItemDao dao, ScrappingOperationItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}