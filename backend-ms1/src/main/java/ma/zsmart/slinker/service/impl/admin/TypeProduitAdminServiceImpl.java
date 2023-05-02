package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.TypeProduit;
import ma.zsmart.slinker.bean.history.TypeProduitHistory;
import ma.zsmart.slinker.dao.criteria.core.TypeProduitCriteria;
import ma.zsmart.slinker.dao.criteria.history.TypeProduitHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.TypeProduitDao;
import ma.zsmart.slinker.dao.facade.history.TypeProduitHistoryDao;
import ma.zsmart.slinker.dao.specification.core.TypeProduitSpecification;
import ma.zsmart.slinker.service.facade.admin.TypeProduitAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class TypeProduitAdminServiceImpl extends AbstractServiceImpl<TypeProduit,TypeProduitHistory, TypeProduitCriteria, TypeProduitHistoryCriteria, TypeProduitDao,
TypeProduitHistoryDao> implements TypeProduitAdminService {


    public TypeProduit findByReferenceEntity(TypeProduit t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(TypeProduit.class,TypeProduitHistory.class, TypeProduitHistoryCriteria.class, TypeProduitSpecification.class);
    }

    public TypeProduitAdminServiceImpl(TypeProduitDao dao, TypeProduitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}