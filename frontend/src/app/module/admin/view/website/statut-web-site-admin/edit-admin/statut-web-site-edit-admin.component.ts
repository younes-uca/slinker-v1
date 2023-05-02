import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StatutWebSiteService} from 'src/app/controller/service/StatutWebSite.service';
import {StatutWebSiteDto} from 'src/app/controller/model/StatutWebSite.model';
import {StatutWebSiteCriteria} from 'src/app/controller/criteria/StatutWebSiteCriteria.model';



@Component({
  selector: 'app-statut-web-site-edit-admin',
  templateUrl: './statut-web-site-edit-admin.component.html'
})
export class StatutWebSiteEditAdminComponent extends AbstractEditController<StatutWebSiteDto, StatutWebSiteCriteria, StatutWebSiteService>   implements OnInit {


    private _validStatutWebSiteCode = true;
    private _validStatutWebSiteLibelle = true;




    constructor( private statutWebSiteService: StatutWebSiteService ) {
        super(statutWebSiteService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validStatutWebSiteCode = value;
        this.validStatutWebSiteLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStatutWebSiteCode();
        this.validateStatutWebSiteLibelle();
    }
    public validateStatutWebSiteCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validStatutWebSiteCode = false;
        } else {
            this.validStatutWebSiteCode = true;
        }
    }
    public validateStatutWebSiteLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validStatutWebSiteLibelle = false;
        } else {
            this.validStatutWebSiteLibelle = true;
        }
    }






    get validStatutWebSiteCode(): boolean {
        return this._validStatutWebSiteCode;
    }
    set validStatutWebSiteCode(value: boolean) {
        this._validStatutWebSiteCode = value;
    }
    get validStatutWebSiteLibelle(): boolean {
        return this._validStatutWebSiteLibelle;
    }
    set validStatutWebSiteLibelle(value: boolean) {
        this._validStatutWebSiteLibelle = value;
    }

}
