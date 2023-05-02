import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SubscriptionPackService} from 'src/app/controller/service/SubscriptionPack.service';
import {SubscriptionPackDto} from 'src/app/controller/model/SubscriptionPack.model';
import {SubscriptionPackCriteria} from 'src/app/controller/criteria/SubscriptionPackCriteria.model';
@Component({
  selector: 'app-subscription-pack-create-admin',
  templateUrl: './subscription-pack-create-admin.component.html'
})
export class SubscriptionPackCreateAdminComponent extends AbstractCreateController<SubscriptionPackDto, SubscriptionPackCriteria, SubscriptionPackService>  implements OnInit {



   private _validSubscriptionPackCode = true;
   private _validSubscriptionPackLibelle = true;

    constructor( private subscriptionPackService: SubscriptionPackService ) {
        super(subscriptionPackService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validSubscriptionPackCode = value;
        this.validSubscriptionPackLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSubscriptionPackCode();
        this.validateSubscriptionPackLibelle();
    }

    public validateSubscriptionPackCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validSubscriptionPackCode = false;
        } else {
            this.validSubscriptionPackCode = true;
        }
    }
    public validateSubscriptionPackLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validSubscriptionPackLibelle = false;
        } else {
            this.validSubscriptionPackLibelle = true;
        }
    }






    get validSubscriptionPackCode(): boolean {
        return this._validSubscriptionPackCode;
    }

    set validSubscriptionPackCode(value: boolean) {
         this._validSubscriptionPackCode = value;
    }
    get validSubscriptionPackLibelle(): boolean {
        return this._validSubscriptionPackLibelle;
    }

    set validSubscriptionPackLibelle(value: boolean) {
         this._validSubscriptionPackLibelle = value;
    }



}
