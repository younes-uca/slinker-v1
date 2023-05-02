package ma.zsmart.slinker.service.facade.admin;

import java.util.List;
import ma.zsmart.slinker.bean.core.Client;
import ma.zsmart.slinker.dao.criteria.core.ClientCriteria;
import ma.zsmart.slinker.dao.criteria.history.ClientHistoryCriteria;
import ma.zsmart.slinker.zynerator.service.IService;

public interface ClientAdminService extends  IService<Client,ClientCriteria, ClientHistoryCriteria>  {

    List<Client> findByStatutClientId(Long id);
    int deleteByStatutClientId(Long id);



}
