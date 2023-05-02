import {Component, OnInit} from '@angular/core';
import {NotificationService} from 'src/app/controller/service/Notification.service';
import {NotificationDto} from 'src/app/controller/model/Notification.model';
import {NotificationCriteria} from 'src/app/controller/criteria/NotificationCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StatutNotificationService } from 'src/app/controller/service/StatutNotification.service';
import { NotificationDetailService } from 'src/app/controller/service/NotificationDetail.service';

import {NotificationDetailDto} from 'src/app/controller/model/NotificationDetail.model';
import {StatutNotificationDto} from 'src/app/controller/model/StatutNotification.model';


@Component({
  selector: 'app-notification-list-admin',
  templateUrl: './notification-list-admin.component.html'
})
export class NotificationListAdminComponent extends AbstractListController<NotificationDto, NotificationCriteria, NotificationService>  implements OnInit {

    fileName = 'Notification';

    statutNotifications :Array<StatutNotificationDto>;
    notificationDetails :Array<NotificationDetailDto>;
  
    constructor(notificationService: NotificationService, private statutNotificationService: StatutNotificationService, private notificationDetailService: NotificationDetailService) {
        super(notificationService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStatutNotification();
      this.loadNotificationDetail();
    }

    public async loadNotifications(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Notification', 'list');
        isPermistted ? this.service.findAll().subscribe(notifications => this.items = notifications,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'statutNotification?.libelle', header: 'Statut notification'},
            {field: 'notificationDetail?.id', header: 'Notification detail'},
        ];
    }


    public async loadStatutNotification(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Notification', 'list');
        isPermistted ? this.statutNotificationService.findAllOptimized().subscribe(statutNotifications => this.statutNotifications = statutNotifications,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadNotificationDetail(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Notification', 'list');
        isPermistted ? this.notificationDetailService.findAll().subscribe(notificationDetails => this.notificationDetails = notificationDetails,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: NotificationDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Description': e.description ,
                'Statut notification': e.statutNotification?.libelle ,
                'Notification detail': e.notificationDetail?.id ,
            }
        });

        this.criteriaData = [{
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Statut notification': this.criteria.statutNotification?.libelle ? this.criteria.statutNotification?.libelle : environment.emptyForExport ,
        //'Notification detail': this.criteria.notificationDetail?.id ? this.criteria.notificationDetail?.id : environment.emptyForExport ,
        }];
      }
}
