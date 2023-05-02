import {NotificationDetailCriteria} from './NotificationDetailCriteria.model';
import {StatutNotificationCriteria} from './StatutNotificationCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class NotificationCriteria  extends   BaseCriteria  {

    public id: number;
    public description: string;
    public descriptionLike: string;
  public statutNotification: StatutNotificationCriteria ;
  public statutNotifications: Array<StatutNotificationCriteria> ;
  public notificationDetail: NotificationDetailCriteria ;
  public notificationDetails: Array<NotificationDetailCriteria> ;

}
