import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {NotificationService} from 'src/app/controller/service/Notification.service';
import {NotificationDto} from 'src/app/controller/model/Notification.model';
import {NotificationCriteria} from 'src/app/controller/criteria/NotificationCriteria.model';

import {NotificationDetailDto} from 'src/app/controller/model/NotificationDetail.model';
import {NotificationDetailService} from 'src/app/controller/service/NotificationDetail.service';
import {StatutNotificationDto} from 'src/app/controller/model/StatutNotification.model';
import {StatutNotificationService} from 'src/app/controller/service/StatutNotification.service';
@Component({
  selector: 'app-notification-view-admin',
  templateUrl: './notification-view-admin.component.html'
})
export class NotificationViewAdminComponent extends AbstractViewController<NotificationDto, NotificationCriteria, NotificationService> implements OnInit {


    constructor(private notificationService: NotificationService, private notificationDetailService: NotificationDetailService, private statutNotificationService: StatutNotificationService){
        super(notificationService);
    }

    ngOnInit(): void {
        this.statutNotification = new StatutNotificationDto();
        this.statutNotificationService.findAll().subscribe((data) => this.statutNotifications = data);
        this.notificationDetail = new NotificationDetailDto();
        this.notificationDetailService.findAll().subscribe((data) => this.notificationDetails = data);
    }


    get notificationDetail(): NotificationDetailDto {
       return this.notificationDetailService.item;
    }
    set notificationDetail(value: NotificationDetailDto) {
        this.notificationDetailService.item = value;
    }
    get notificationDetails():Array<NotificationDetailDto> {
       return this.notificationDetailService.items;
    }
    set notificationDetails(value: Array<NotificationDetailDto>) {
        this.notificationDetailService.items = value;
    }
    get statutNotification(): StatutNotificationDto {
       return this.statutNotificationService.item;
    }
    set statutNotification(value: StatutNotificationDto) {
        this.statutNotificationService.item = value;
    }
    get statutNotifications():Array<StatutNotificationDto> {
       return this.statutNotificationService.items;
    }
    set statutNotifications(value: Array<StatutNotificationDto>) {
        this.statutNotificationService.items = value;
    }


}
