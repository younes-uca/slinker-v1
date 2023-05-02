import {ClientCriteria} from './ClientCriteria.model';
import {NotificationCriteria} from './NotificationCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class NotificationDetailCriteria  extends   BaseCriteria  {

    public id: number;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public notification: NotificationCriteria ;
  public notifications: Array<NotificationCriteria> ;

}
