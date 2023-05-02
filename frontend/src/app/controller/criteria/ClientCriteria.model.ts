import {NotificationDetailCriteria} from './NotificationDetailCriteria.model';
import {StatutClientCriteria} from './StatutClientCriteria.model';
import {WebSiteCriteria} from './WebSiteCriteria.model';
import {AffliateCriteria} from './AffliateCriteria.model';
import {SubscriptionCriteria} from './SubscriptionCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ClientCriteria  extends   BaseCriteria  {

    public id: number;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
    public password: string;
    public passwordLike: string;
    public email: string;
    public emailLike: string;
  public statutClient: StatutClientCriteria ;
  public statutClients: Array<StatutClientCriteria> ;
      public affliates: Array<AffliateCriteria>;
      public webSites: Array<WebSiteCriteria>;
      public notificationDetails: Array<NotificationDetailCriteria>;
      public subscriptions: Array<SubscriptionCriteria>;

}
