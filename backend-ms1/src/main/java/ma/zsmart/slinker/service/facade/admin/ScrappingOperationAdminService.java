package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.ScrappingOperation;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface ScrappingOperationAdminService extends  IService<ScrappingOperation,ScrappingOperationCriteria, ScrappingOperationHistoryCriteria>  {

    List<ScrappingOperation> findByAffliateId(Long id);
    int deleteByAffliateId(Long id);
    List<ScrappingOperation> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);



}
