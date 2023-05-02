package ma.zsmart.slinker.service.impl.admin;

import ma.zsmart.slinker.bean.core.Client;
import ma.zsmart.slinker.bean.history.ClientHistory;
import ma.zsmart.slinker.dao.criteria.core.ClientCriteria;
import ma.zsmart.slinker.dao.criteria.history.ClientHistoryCriteria;
import ma.zsmart.slinker.dao.facade.core.ClientDao;
import ma.zsmart.slinker.dao.facade.history.ClientHistoryDao;
import ma.zsmart.slinker.dao.specification.core.ClientSpecification;
import ma.zsmart.slinker.service.facade.admin.ClientAdminService;
import ma.zsmart.slinker.zynerator.service.AbstractServiceImpl;
import ma.zsmart.slinker.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.slinker.bean.core.Affliate;
import ma.zsmart.slinker.bean.core.WebSite;
import ma.zsmart.slinker.bean.core.NotificationDetail;
import ma.zsmart.slinker.bean.core.Subscription;

import ma.zsmart.slinker.service.facade.admin.AffliateAdminService ;
import ma.zsmart.slinker.service.facade.admin.NotificationDetailAdminService ;
import ma.zsmart.slinker.service.facade.admin.SubscriptionAdminService ;
import ma.zsmart.slinker.service.facade.admin.StatutClientAdminService ;
import ma.zsmart.slinker.service.facade.admin.WebSiteAdminService ;


import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Client create(Client t) {
        super.create(t);
        if (t.getAffliates() != null) {
                t.getAffliates().forEach(element-> {
                    element.setClient(t);
                    affliateService.create(element);
            });
        }
        if (t.getWebSites() != null) {
                t.getWebSites().forEach(element-> {
                    element.setClient(t);
                    webSiteService.create(element);
            });
        }
        if (t.getNotificationDetails() != null) {
                t.getNotificationDetails().forEach(element-> {
                    element.setClient(t);
                    notificationDetailService.create(element);
            });
        }
        if (t.getSubscriptions() != null) {
                t.getSubscriptions().forEach(element-> {
                    element.setClient(t);
                    subscriptionService.create(element);
            });
        }
        return t;
    }

    public Client findWithAssociatedLists(Long id){
        Client result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setAffliates(affliateService.findByClientId(id));
            result.setWebSites(webSiteService.findByClientId(id));
            result.setNotificationDetails(notificationDetailService.findByClientId(id));
            result.setSubscriptions(subscriptionService.findByClientId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        affliateService.deleteByClientId(id);
        webSiteService.deleteByClientId(id);
        notificationDetailService.deleteByClientId(id);
        subscriptionService.deleteByClientId(id);
    }


    public void updateWithAssociatedLists(Client client){
    if(client !=null && client.getId() != null){
            List<List<Affliate>> resultAffliates= affliateService.getToBeSavedAndToBeDeleted(affliateService.findByClientId(client.getId()),client.getAffliates());
            affliateService.delete(resultAffliates.get(1));
            ListUtil.emptyIfNull(resultAffliates.get(0)).forEach(e -> e.setClient(client));
            affliateService.update(resultAffliates.get(0),true);
            List<List<WebSite>> resultWebSites= webSiteService.getToBeSavedAndToBeDeleted(webSiteService.findByClientId(client.getId()),client.getWebSites());
            webSiteService.delete(resultWebSites.get(1));
            ListUtil.emptyIfNull(resultWebSites.get(0)).forEach(e -> e.setClient(client));
            webSiteService.update(resultWebSites.get(0),true);
            List<List<NotificationDetail>> resultNotificationDetails= notificationDetailService.getToBeSavedAndToBeDeleted(notificationDetailService.findByClientId(client.getId()),client.getNotificationDetails());
            notificationDetailService.delete(resultNotificationDetails.get(1));
            ListUtil.emptyIfNull(resultNotificationDetails.get(0)).forEach(e -> e.setClient(client));
            notificationDetailService.update(resultNotificationDetails.get(0),true);
            List<List<Subscription>> resultSubscriptions= subscriptionService.getToBeSavedAndToBeDeleted(subscriptionService.findByClientId(client.getId()),client.getSubscriptions());
            subscriptionService.delete(resultSubscriptions.get(1));
            ListUtil.emptyIfNull(resultSubscriptions.get(0)).forEach(e -> e.setClient(client));
            subscriptionService.update(resultSubscriptions.get(0),true);
    }
    }


    public List<Client> findByStatutClientId(Long id){
        return dao.findByStatutClientId(id);
    }
    public int deleteByStatutClientId(Long id){
        return dao.deleteByStatutClientId(id);
    }

    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }

    @Autowired
    private AffliateAdminService affliateService ;
    @Autowired
    private NotificationDetailAdminService notificationDetailService ;
    @Autowired
    private SubscriptionAdminService subscriptionService ;
    @Autowired
    private StatutClientAdminService statutClientService ;
    @Autowired
    private WebSiteAdminService webSiteService ;
    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}