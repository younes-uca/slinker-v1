package ma.zsmart.slinker.dao.facade.core;

import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.ScrappingOperationItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ScrappingOperationItemDao extends AbstractRepository<ScrappingOperationItem,Long>  {

    List<ScrappingOperationItem> findByScrappingLinkId(Long id);
    int deleteByScrappingLinkId(Long id);
    List<ScrappingOperationItem> findByTypeProduitId(Long id);
    int deleteByTypeProduitId(Long id);
    List<ScrappingOperationItem> findByScrappingOperationId(Long id);
    int deleteByScrappingOperationId(Long id);

}
