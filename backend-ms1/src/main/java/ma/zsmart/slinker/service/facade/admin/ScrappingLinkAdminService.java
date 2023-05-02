package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.ScrappingLink;
import ma.zsmart.slinker.dao.criteria.core.ScrappingLinkCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingLinkHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface ScrappingLinkAdminService extends  IService<ScrappingLink,ScrappingLinkCriteria, ScrappingLinkHistoryCriteria>  {

    List<ScrappingLink> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);



}
