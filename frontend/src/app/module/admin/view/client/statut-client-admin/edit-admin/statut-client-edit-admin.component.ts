import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StatutClientService} from 'src/app/controller/service/StatutClient.service';
import {StatutClientDto} from 'src/app/controller/model/StatutClient.model';
import {StatutClientCriteria} from 'src/app/controller/criteria/StatutClientCriteria.model';



@Component({
  selector: 'app-statut-client-edit-admin',
  templateUrl: './statut-client-edit-admin.component.html'
})
export class StatutClientEditAdminComponent extends AbstractEditController<StatutClientDto, StatutClientCriteria, StatutClientService>   implements OnInit {


    private _validStatutClientCode = true;
    private _validStatutClientLibelle = true;




    constructor( private statutClientService: StatutClientService ) {
        super(statutClientService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validStatutClientCode = value;
        this.validStatutClientLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStatutClientCode();
        this.validateStatutClientLibelle();
    }
    public validateStatutClientCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validStatutClientCode = false;
        } else {
            this.validStatutClientCode = true;
        }
    }
    public validateStatutClientLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validStatutClientLibelle = false;
        } else {
            this.validStatutClientLibelle = true;
        }
    }






    get validStatutClientCode(): boolean {
        return this._validStatutClientCode;
    }
    set validStatutClientCode(value: boolean) {
        this._validStatutClientCode = value;
    }
    get validStatutClientLibelle(): boolean {
        return this._validStatutClientLibelle;
    }
    set validStatutClientLibelle(value: boolean) {
        this._validStatutClientLibelle = value;
    }

}
