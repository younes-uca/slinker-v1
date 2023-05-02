import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {StatutNotificationService} from 'src/app/controller/service/StatutNotification.service';
import {StatutNotificationDto} from 'src/app/controller/model/StatutNotification.model';
import {StatutNotificationCriteria} from 'src/app/controller/criteria/StatutNotificationCriteria.model';

@Component({
  selector: 'app-statut-notification-view-admin',
  templateUrl: './statut-notification-view-admin.component.html'
})
export class StatutNotificationViewAdminComponent extends AbstractViewController<StatutNotificationDto, StatutNotificationCriteria, StatutNotificationService> implements OnInit {


    constructor(private statutNotificationService: StatutNotificationService){
        super(statutNotificationService);
    }

    ngOnInit(): void {
    }




}
