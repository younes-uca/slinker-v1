import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TypePaiementService} from 'src/app/controller/service/TypePaiement.service';
import {TypePaiementDto} from 'src/app/controller/model/TypePaiement.model';
import {TypePaiementCriteria} from 'src/app/controller/criteria/TypePaiementCriteria.model';



@Component({
  selector: 'app-type-paiement-edit-admin',
  templateUrl: './type-paiement-edit-admin.component.html'
})
export class TypePaiementEditAdminComponent extends AbstractEditController<TypePaiementDto, TypePaiementCriteria, TypePaiementService>   implements OnInit {


    private _validTypePaiementCode = true;
    private _validTypePaiementLibelle = true;




    constructor( private typePaiementService: TypePaiementService ) {
        super(typePaiementService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validTypePaiementCode = value;
        this.validTypePaiementLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypePaiementCode();
        this.validateTypePaiementLibelle();
    }
    public validateTypePaiementCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validTypePaiementCode = false;
        } else {
            this.validTypePaiementCode = true;
        }
    }
    public validateTypePaiementLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validTypePaiementLibelle = false;
        } else {
            this.validTypePaiementLibelle = true;
        }
    }






    get validTypePaiementCode(): boolean {
        return this._validTypePaiementCode;
    }
    set validTypePaiementCode(value: boolean) {
        this._validTypePaiementCode = value;
    }
    get validTypePaiementLibelle(): boolean {
        return this._validTypePaiementLibelle;
    }
    set validTypePaiementLibelle(value: boolean) {
        this._validTypePaiementLibelle = value;
    }

}
