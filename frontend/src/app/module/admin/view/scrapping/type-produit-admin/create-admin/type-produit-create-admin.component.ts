import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TypeProduitService} from 'src/app/controller/service/TypeProduit.service';
import {TypeProduitDto} from 'src/app/controller/model/TypeProduit.model';
import {TypeProduitCriteria} from 'src/app/controller/criteria/TypeProduitCriteria.model';
@Component({
  selector: 'app-type-produit-create-admin',
  templateUrl: './type-produit-create-admin.component.html'
})
export class TypeProduitCreateAdminComponent extends AbstractCreateController<TypeProduitDto, TypeProduitCriteria, TypeProduitService>  implements OnInit {



   private _validTypeProduitCode = true;
   private _validTypeProduitLibelle = true;

    constructor( private typeProduitService: TypeProduitService ) {
        super(typeProduitService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validTypeProduitCode = value;
        this.validTypeProduitLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeProduitCode();
        this.validateTypeProduitLibelle();
    }

    public validateTypeProduitCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTypeProduitCode = false;
        } else {
            this.validTypeProduitCode = true;
        }
    }
    public validateTypeProduitLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTypeProduitLibelle = false;
        } else {
            this.validTypeProduitLibelle = true;
        }
    }






    get validTypeProduitCode(): boolean {
        return this._validTypeProduitCode;
    }

    set validTypeProduitCode(value: boolean) {
         this._validTypeProduitCode = value;
    }
    get validTypeProduitLibelle(): boolean {
        return this._validTypeProduitLibelle;
    }

    set validTypeProduitLibelle(value: boolean) {
         this._validTypeProduitLibelle = value;
    }



}
