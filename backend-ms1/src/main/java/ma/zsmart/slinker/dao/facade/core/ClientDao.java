package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.Client;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {

    List<Client> findByStatutClientId(Long id);
    int deleteByStatutClientId(Long id);

}
