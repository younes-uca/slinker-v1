import {ClientDto} from './Client.model';
import {NotificationDto} from './Notification.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class NotificationDetailDto  extends BaseDto{

    public id: number;
    public client: ClientDto ;
    public notification: NotificationDto ;

}
