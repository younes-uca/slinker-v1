package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.TypeProduit;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.TypeProduit;
import java.util.List;


@Repository
public interface TypeProduitDao extends AbstractRepository<TypeProduit,Long>  {
    TypeProduit findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeProduit(item.id,item.libelle) FROM TypeProduit item")
    List<TypeProduit> findAllOptimized();
}
