import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SubscriptionService} from 'src/app/controller/service/Subscription.service';
import {SubscriptionDto} from 'src/app/controller/model/Subscription.model';
import {SubscriptionCriteria} from 'src/app/controller/criteria/SubscriptionCriteria.model';


import {SubscriptionTypeDto} from 'src/app/controller/model/SubscriptionType.model';
import {SubscriptionTypeService} from 'src/app/controller/service/SubscriptionType.service';
import {SubscriptionPackDto} from 'src/app/controller/model/SubscriptionPack.model';
import {SubscriptionPackService} from 'src/app/controller/service/SubscriptionPack.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {TypePaiementDto} from 'src/app/controller/model/TypePaiement.model';
import {TypePaiementService} from 'src/app/controller/service/TypePaiement.service';
import {SubscriptionEtatDto} from 'src/app/controller/model/SubscriptionEtat.model';
import {SubscriptionEtatService} from 'src/app/controller/service/SubscriptionEtat.service';

@Component({
  selector: 'app-subscription-edit-admin',
  templateUrl: './subscription-edit-admin.component.html'
})
export class SubscriptionEditAdminComponent extends AbstractEditController<SubscriptionDto, SubscriptionCriteria, SubscriptionService>   implements OnInit {



    private _validSubscriptionTypeCode = true;
    private _validSubscriptionTypeLibelle = true;
    private _validSubscriptionPackCode = true;
    private _validSubscriptionPackLibelle = true;
    private _validSubscriptionEtatCode = true;
    private _validSubscriptionEtatLibelle = true;
    private _validClientNom = true;
    private _validClientPrenom = true;
    private _validClientPassword = true;
    private _validClientEmail = true;
    private _validTypePaiementCode = true;
    private _validTypePaiementLibelle = true;



    constructor( private subscriptionService: SubscriptionService , private subscriptionTypeService: SubscriptionTypeService, private subscriptionPackService: SubscriptionPackService, private clientService: ClientService, private typePaiementService: TypePaiementService, private subscriptionEtatService: SubscriptionEtatService) {
        super(subscriptionService);
    }

    ngOnInit(): void {
    this.subscriptionType = new SubscriptionTypeDto();
    this.subscriptionTypeService.findAll().subscribe((data) => this.subscriptionTypes = data);
    this.subscriptionPack = new SubscriptionPackDto();
    this.subscriptionPackService.findAll().subscribe((data) => this.subscriptionPacks = data);
    this.subscriptionEtat = new SubscriptionEtatDto();
    this.subscriptionEtatService.findAll().subscribe((data) => this.subscriptionEtats = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
    this.typePaiement = new TypePaiementDto();
    this.typePaiementService.findAll().subscribe((data) => this.typePaiements = data);
}
    public prepareEdit() {
        this.item.dateDebut = this.subscriptionService.format(this.item.dateDebut);
        this.item.dateFin = this.subscriptionService.format(this.item.dateFin);
        this.item.datePaiement = this.subscriptionService.format(this.item.datePaiement);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateSubscriptionType(subscriptionType: string) {
        const isPermistted = await this.roleService.isPermitted('SubscriptionType', 'edit');
        if(isPermistted) {
             this.subscriptionType = new SubscriptionTypeDto();
             this.createSubscriptionTypeDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateTypePaiement(typePaiement: string) {
        const isPermistted = await this.roleService.isPermitted('TypePaiement', 'edit');
        if(isPermistted) {
             this.typePaiement = new TypePaiementDto();
             this.createTypePaiementDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateSubscriptionEtat(subscriptionEtat: string) {
        const isPermistted = await this.roleService.isPermitted('SubscriptionEtat', 'edit');
        if(isPermistted) {
             this.subscriptionEtat = new SubscriptionEtatDto();
             this.createSubscriptionEtatDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateSubscriptionPack(subscriptionPack: string) {
        const isPermistted = await this.roleService.isPermitted('SubscriptionPack', 'edit');
        if(isPermistted) {
             this.subscriptionPack = new SubscriptionPackDto();
             this.createSubscriptionPackDialog = true;
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
   get subscriptionType(): SubscriptionTypeDto {
       return this.subscriptionTypeService.item;
   }
  set subscriptionType(value: SubscriptionTypeDto) {
        this.subscriptionTypeService.item = value;
   }
   get subscriptionTypes(): Array<SubscriptionTypeDto> {
        return this.subscriptionTypeService.items;
   }
   set subscriptionTypes(value: Array<SubscriptionTypeDto>) {
        this.subscriptionTypeService.items = value;
   }
   get createSubscriptionTypeDialog(): boolean {
       return this.subscriptionTypeService.createDialog;
   }
  set createSubscriptionTypeDialog(value: boolean) {
       this.subscriptionTypeService.createDialog= value;
   }
   get typePaiement(): TypePaiementDto {
       return this.typePaiementService.item;
   }
  set typePaiement(value: TypePaiementDto) {
        this.typePaiementService.item = value;
   }
   get typePaiements(): Array<TypePaiementDto> {
        return this.typePaiementService.items;
   }
   set typePaiements(value: Array<TypePaiementDto>) {
        this.typePaiementService.items = value;
   }
   get createTypePaiementDialog(): boolean {
       return this.typePaiementService.createDialog;
   }
  set createTypePaiementDialog(value: boolean) {
       this.typePaiementService.createDialog= value;
   }
   get subscriptionEtat(): SubscriptionEtatDto {
       return this.subscriptionEtatService.item;
   }
  set subscriptionEtat(value: SubscriptionEtatDto) {
        this.subscriptionEtatService.item = value;
   }
   get subscriptionEtats(): Array<SubscriptionEtatDto> {
        return this.subscriptionEtatService.items;
   }
   set subscriptionEtats(value: Array<SubscriptionEtatDto>) {
        this.subscriptionEtatService.items = value;
   }
   get createSubscriptionEtatDialog(): boolean {
       return this.subscriptionEtatService.createDialog;
   }
  set createSubscriptionEtatDialog(value: boolean) {
       this.subscriptionEtatService.createDialog= value;
   }
   get subscriptionPack(): SubscriptionPackDto {
       return this.subscriptionPackService.item;
   }
  set subscriptionPack(value: SubscriptionPackDto) {
        this.subscriptionPackService.item = value;
   }
   get subscriptionPacks(): Array<SubscriptionPackDto> {
        return this.subscriptionPackService.items;
   }
   set subscriptionPacks(value: Array<SubscriptionPackDto>) {
        this.subscriptionPackService.items = value;
   }
   get createSubscriptionPackDialog(): boolean {
       return this.subscriptionPackService.createDialog;
   }
  set createSubscriptionPackDialog(value: boolean) {
       this.subscriptionPackService.createDialog= value;
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
