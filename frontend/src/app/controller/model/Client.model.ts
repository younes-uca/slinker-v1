import {NotificationDetailDto} from './NotificationDetail.model';
import {StatutClientDto} from './StatutClient.model';
import {WebSiteDto} from './WebSite.model';
import {AffliateDto} from './Affliate.model';
import {SubscriptionDto} from './Subscription.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ClientDto  extends BaseDto{

    public id: number;
    public nom: string;
    public prenom: string;
    public password: string;
    public email: string;
    public statutClient: StatutClientDto ;
     public affliates: Array<AffliateDto>;
     public webSites: Array<WebSiteDto>;
     public notificationDetails: Array<NotificationDetailDto>;
     public subscriptions: Array<SubscriptionDto>;

}
