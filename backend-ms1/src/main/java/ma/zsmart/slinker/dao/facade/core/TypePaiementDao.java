package ma.zsmart.slinker.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;
import ma.zsmart.slinker.bean.core.TypePaiement;
import org.springframework.stereotype.Repository;
import ma.zsmart.slinker.bean.core.TypePaiement;
import java.util.List;


@Repository
public interface TypePaiementDao extends AbstractRepository<TypePaiement,Long>  {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypePaiement(item.id,item.libelle) FROM TypePaiement item")
    List<TypePaiement> findAllOptimized();
}
