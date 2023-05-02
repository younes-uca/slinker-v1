package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.ScrappingOperation;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ScrappingOperationDao extends AbstractRepository<ScrappingOperation,Long>  {

    List<ScrappingOperation> findByAffliateId(Long id);
    int deleteByAffliateId(Long id);
    List<ScrappingOperation> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);

}
