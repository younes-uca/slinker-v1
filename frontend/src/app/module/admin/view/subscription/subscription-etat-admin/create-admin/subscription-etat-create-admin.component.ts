import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SubscriptionEtatService} from 'src/app/controller/service/SubscriptionEtat.service';
import {SubscriptionEtatDto} from 'src/app/controller/model/SubscriptionEtat.model';
import {SubscriptionEtatCriteria} from 'src/app/controller/criteria/SubscriptionEtatCriteria.model';
@Component({
  selector: 'app-subscription-etat-create-admin',
  templateUrl: './subscription-etat-create-admin.component.html'
})
export class SubscriptionEtatCreateAdminComponent extends AbstractCreateController<SubscriptionEtatDto, SubscriptionEtatCriteria, SubscriptionEtatService>  implements OnInit {



   private _validSubscriptionEtatCode = true;
   private _validSubscriptionEtatLibelle = true;

    constructor( private subscriptionEtatService: SubscriptionEtatService ) {
        super(subscriptionEtatService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validSubscriptionEtatCode = value;
        this.validSubscriptionEtatLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSubscriptionEtatCode();
        this.validateSubscriptionEtatLibelle();
    }

    public validateSubscriptionEtatCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validSubscriptionEtatCode = false;
        } else {
            this.validSubscriptionEtatCode = true;
        }
    }
    public validateSubscriptionEtatLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validSubscriptionEtatLibelle = false;
        } else {
            this.validSubscriptionEtatLibelle = true;
        }
    }






    get validSubscriptionEtatCode(): boolean {
        return this._validSubscriptionEtatCode;
    }

    set validSubscriptionEtatCode(value: boolean) {
         this._validSubscriptionEtatCode = value;
    }
    get validSubscriptionEtatLibelle(): boolean {
        return this._validSubscriptionEtatLibelle;
    }

    set validSubscriptionEtatLibelle(value: boolean) {
         this._validSubscriptionEtatLibelle = value;
    }



}
