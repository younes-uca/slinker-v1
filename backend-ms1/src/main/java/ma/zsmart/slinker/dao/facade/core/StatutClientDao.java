package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.StatutClient;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.StatutClient;
import java.util.List;


@Repository
public interface StatutClientDao extends AbstractRepository<StatutClient,Long>  {
    StatutClient findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW StatutClient(item.id,item.libelle) FROM StatutClient item")
    List<StatutClient> findAllOptimized();
}
