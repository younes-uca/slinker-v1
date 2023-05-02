package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.WebSite;
import ma.zsmart.slinker.dao.criteria.core.WebSiteCriteria;
import ma.zsmart.slinker.dao.criteria.history.WebSiteHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface WebSiteAdminService extends  IService<WebSite,WebSiteCriteria, WebSiteHistoryCriteria>  {

    List<WebSite> findByStatutWebSiteId(Long id);
    int deleteByStatutWebSiteId(Long id);
    List<WebSite> findByClientId(Long id);
    int deleteByClientId(Long id);



}
