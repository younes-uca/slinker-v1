package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.Affliate;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.Affliate;
import java.util.List;


@Repository
public interface AffliateDao extends AbstractRepository<Affliate,Long>  {
    Affliate findByCode(String code);
    int deleteByCode(String code);

    List<Affliate> findByClientId(Long id);
    int deleteByClientId(Long id);

    @Query("SELECT NEW Affliate(item.id,item.libelle) FROM Affliate item")
    List<Affliate> findAllOptimized();
}
