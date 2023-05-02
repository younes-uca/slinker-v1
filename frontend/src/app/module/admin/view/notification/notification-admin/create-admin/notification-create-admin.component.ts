import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {NotificationService} from 'src/app/controller/service/Notification.service';
import {NotificationDto} from 'src/app/controller/model/Notification.model';
import {NotificationCriteria} from 'src/app/controller/criteria/NotificationCriteria.model';
import {NotificationDetailDto} from 'src/app/controller/model/NotificationDetail.model';
import {NotificationDetailService} from 'src/app/controller/service/NotificationDetail.service';
import {StatutNotificationDto} from 'src/app/controller/model/StatutNotification.model';
import {StatutNotificationService} from 'src/app/controller/service/StatutNotification.service';
@Component({
  selector: 'app-notification-create-admin',
  templateUrl: './notification-create-admin.component.html'
})
export class NotificationCreateAdminComponent extends AbstractCreateController<NotificationDto, NotificationCriteria, NotificationService>  implements OnInit {



    private _validStatutNotificationCode = true;
    private _validStatutNotificationLibelle = true;

    constructor( private notificationService: NotificationService , private notificationDetailService: NotificationDetailService, private statutNotificationService: StatutNotificationService) {
        super(notificationService);
    }

    ngOnInit(): void {
    this.statutNotification = new StatutNotificationDto();
    this.statutNotificationService.findAll().subscribe((data) => this.statutNotifications = data);
    this.notificationDetail = new NotificationDetailDto();
    this.notificationDetailService.findAll().subscribe((data) => this.notificationDetails = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateStatutNotification(statutNotification: string) {
    const isPermistted = await this.roleService.isPermitted('StatutNotification', 'add');
    if(isPermistted) {
         this.statutNotification = new StatutNotificationDto();
         this.createStatutNotificationDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get notificationDetail(): NotificationDetailDto {
        return this.notificationDetailService.item;
    }
    set notificationDetail(value: NotificationDetailDto) {
        this.notificationDetailService.item = value;
    }
    get notificationDetails(): Array<NotificationDetailDto> {
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
    get statutNotifications(): Array<StatutNotificationDto> {
        return this.statutNotificationService.items;
    }
    set statutNotifications(value: Array<StatutNotificationDto>) {
        this.statutNotificationService.items = value;
    }
    get createStatutNotificationDialog(): boolean {
       return this.statutNotificationService.createDialog;
    }
    set createStatutNotificationDialog(value: boolean) {
        this.statutNotificationService.createDialog= value;
    }




    get validStatutNotificationCode(): boolean {
        return this._validStatutNotificationCode;
    }
    set validStatutNotificationCode(value: boolean) {
        this._validStatutNotificationCode = value;
    }
    get validStatutNotificationLibelle(): boolean {
        return this._validStatutNotificationLibelle;
    }
    set validStatutNotificationLibelle(value: boolean) {
        this._validStatutNotificationLibelle = value;
    }


}
