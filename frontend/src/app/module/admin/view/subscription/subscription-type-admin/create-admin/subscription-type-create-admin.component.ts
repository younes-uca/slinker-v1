import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SubscriptionTypeService} from 'src/app/controller/service/SubscriptionType.service';
import {SubscriptionTypeDto} from 'src/app/controller/model/SubscriptionType.model';
import {SubscriptionTypeCriteria} from 'src/app/controller/criteria/SubscriptionTypeCriteria.model';
@Component({
  selector: 'app-subscription-type-create-admin',
  templateUrl: './subscription-type-create-admin.component.html'
})
export class SubscriptionTypeCreateAdminComponent extends AbstractCreateController<SubscriptionTypeDto, SubscriptionTypeCriteria, SubscriptionTypeService>  implements OnInit {



   private _validSubscriptionTypeCode = true;
   private _validSubscriptionTypeLibelle = true;

    constructor( private subscriptionTypeService: SubscriptionTypeService ) {
        super(subscriptionTypeService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validSubscriptionTypeCode = value;
        this.validSubscriptionTypeLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSubscriptionTypeCode();
        this.validateSubscriptionTypeLibelle();
    }

    public validateSubscriptionTypeCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validSubscriptionTypeCode = false;
        } else {
            this.validSubscriptionTypeCode = true;
        }
    }
    public validateSubscriptionTypeLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validSubscriptionTypeLibelle = false;
        } else {
            this.validSubscriptionTypeLibelle = true;
        }
    }






    get validSubscriptionTypeCode(): boolean {
        return this._validSubscriptionTypeCode;
    }

    set validSubscriptionTypeCode(value: boolean) {
         this._validSubscriptionTypeCode = value;
    }
    get validSubscriptionTypeLibelle(): boolean {
        return this._validSubscriptionTypeLibelle;
    }

    set validSubscriptionTypeLibelle(value: boolean) {
         this._validSubscriptionTypeLibelle = value;
    }



}
