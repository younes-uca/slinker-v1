import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StatutNotificationService} from 'src/app/controller/service/StatutNotification.service';
import {StatutNotificationDto} from 'src/app/controller/model/StatutNotification.model';
import {StatutNotificationCriteria} from 'src/app/controller/criteria/StatutNotificationCriteria.model';



@Component({
  selector: 'app-statut-notification-edit-admin',
  templateUrl: './statut-notification-edit-admin.component.html'
})
export class StatutNotificationEditAdminComponent extends AbstractEditController<StatutNotificationDto, StatutNotificationCriteria, StatutNotificationService>   implements OnInit {


    private _validStatutNotificationCode = true;
    private _validStatutNotificationLibelle = true;




    constructor( private statutNotificationService: StatutNotificationService ) {
        super(statutNotificationService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validStatutNotificationCode = value;
        this.validStatutNotificationLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStatutNotificationCode();
        this.validateStatutNotificationLibelle();
    }
    public validateStatutNotificationCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validStatutNotificationCode = false;
        } else {
            this.validStatutNotificationCode = true;
        }
    }
    public validateStatutNotificationLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validStatutNotificationLibelle = false;
        } else {
            this.validStatutNotificationLibelle = true;
        }
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
