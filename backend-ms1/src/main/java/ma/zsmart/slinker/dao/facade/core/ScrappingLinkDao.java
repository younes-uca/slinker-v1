package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.ScrappingLink;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.ScrappingLink;
import java.util.List;


@Repository
public interface ScrappingLinkDao extends AbstractRepository<ScrappingLink,Long>  {
    ScrappingLink findByCode(String code);
    int deleteByCode(String code);

    List<ScrappingLink> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);

    @Query("SELECT NEW ScrappingLink(item.id,item.libelle) FROM ScrappingLink item")
    List<ScrappingLink> findAllOptimized();
}
