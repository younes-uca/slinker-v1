package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.Affliate;
import ma.zsmart.slinker.dao.criteria.core.AffliateCriteria;
import ma.zsmart.slinker.dao.criteria.history.AffliateHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface AffliateAdminService extends  IService<Affliate,AffliateCriteria, AffliateHistoryCriteria>  {

    List<Affliate> findByClientId(Long id);
    int deleteByClientId(Long id);



}
