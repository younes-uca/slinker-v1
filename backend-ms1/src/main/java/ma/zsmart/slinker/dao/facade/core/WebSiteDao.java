package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.WebSite;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface WebSiteDao extends AbstractRepository<WebSite,Long>  {

    List<WebSite> findByStatutWebSiteId(Long id);
    int deleteByStatutWebSiteId(Long id);
    List<WebSite> findByClientId(Long id);
    int deleteByClientId(Long id);

    @Query("SELECT NEW WebSite(item.id,item.url) FROM WebSite item")
    List<WebSite> findAllOptimized();
}
