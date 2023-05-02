package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.ScrappingOperationItem;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationItemCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationItemHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface ScrappingOperationItemAdminService extends  IService<ScrappingOperationItem,ScrappingOperationItemCriteria, ScrappingOperationItemHistoryCriteria>  {

    List<ScrappingOperationItem> findByScrappingLinkId(Long id);
    int deleteByScrappingLinkId(Long id);
    List<ScrappingOperationItem> findByTypeProduitId(Long id);
    int deleteByTypeProduitId(Long id);
    List<ScrappingOperationItem> findByScrappingOperationId(Long id);
    int deleteByScrappingOperationId(Long id);



}
