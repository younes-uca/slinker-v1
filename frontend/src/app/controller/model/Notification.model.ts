import {NotificationDetailDto} from './NotificationDetail.model';
import {StatutNotificationDto} from './StatutNotification.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class NotificationDto  extends BaseDto{

    public id: number;
    public description: string;
    public statutNotification: StatutNotificationDto ;
    public notificationDetail: NotificationDetailDto ;

}
