package ma.zsmart.slinker.zynerator.service;

import ma.zsmart.slinker.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import ma.zsmart.slinker.zynerator.history.HistBusinessObject;
import ma.zsmart.slinker.zynerator.history.HistCriteria;
import ma.zsmart.slinker.zynerator.repository.AbstractHistoryRepository;
import ma.zsmart.slinker.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}