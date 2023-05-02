import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AffliateService} from 'src/app/controller/service/Affliate.service';
import {AffliateDto} from 'src/app/controller/model/Affliate.model';
import {AffliateCriteria} from 'src/app/controller/criteria/AffliateCriteria.model';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
@Component({
  selector: 'app-affliate-create-admin',
  templateUrl: './affliate-create-admin.component.html'
})
export class AffliateCreateAdminComponent extends AbstractCreateController<AffliateDto, AffliateCriteria, AffliateService>  implements OnInit {



   private _validAffliateCode = true;
   private _validAffliateLibelle = true;
    private _validClientNom = true;
    private _validClientPrenom = true;
    private _validClientPassword = true;
    private _validClientEmail = true;

    constructor( private affliateService: AffliateService , private clientService: ClientService) {
        super(affliateService);
    }

    ngOnInit(): void {
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
}





    public setValidation(value: boolean){
        this.validAffliateCode = value;
        this.validAffliateLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAffliateCode();
        this.validateAffliateLibelle();
    }

    public validateAffliateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validAffliateCode = false;
        } else {
            this.validAffliateCode = true;
        }
    }
    public validateAffliateLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validAffliateLibelle = false;
        } else {
            this.validAffliateLibelle = true;
        }
    }


    public async openCreateClient(client: string) {
    const isPermistted = await this.roleService.isPermitted('Client', 'add');
    if(isPermistted) {
         this.client = new ClientDto();
         this.createClientDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get client(): ClientDto {
        return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients(): Array<ClientDto> {
        return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get createClientDialog(): boolean {
       return this.clientService.createDialog;
    }
    set createClientDialog(value: boolean) {
        this.clientService.createDialog= value;
    }



    get validAffliateCode(): boolean {
        return this._validAffliateCode;
    }

    set validAffliateCode(value: boolean) {
         this._validAffliateCode = value;
    }
    get validAffliateLibelle(): boolean {
        return this._validAffliateLibelle;
    }

    set validAffliateLibelle(value: boolean) {
         this._validAffliateLibelle = value;
    }

    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }
    get validClientPrenom(): boolean {
        return this._validClientPrenom;
    }
    set validClientPrenom(value: boolean) {
        this._validClientPrenom = value;
    }
    get validClientPassword(): boolean {
        return this._validClientPassword;
    }
    set validClientPassword(value: boolean) {
        this._validClientPassword = value;
    }
    get validClientEmail(): boolean {
        return this._validClientEmail;
    }
    set validClientEmail(value: boolean) {
        this._validClientEmail = value;
    }


}
