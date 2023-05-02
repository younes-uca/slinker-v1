package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.StatutWebSite;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.StatutWebSite;
import java.util.List;


@Repository
public interface StatutWebSiteDao extends AbstractRepository<StatutWebSite,Long>  {
    StatutWebSite findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW StatutWebSite(item.id,item.libelle) FROM StatutWebSite item")
    List<StatutWebSite> findAllOptimized();
}
