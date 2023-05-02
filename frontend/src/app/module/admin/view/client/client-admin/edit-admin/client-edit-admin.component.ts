import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ClientService} from 'src/app/controller/service/Client.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/ClientCriteria.model';


import {SubscriptionTypeDto} from 'src/app/controller/model/SubscriptionType.model';
import {SubscriptionTypeService} from 'src/app/controller/service/SubscriptionType.service';
import {NotificationDto} from 'src/app/controller/model/Notification.model';
import {NotificationService} from 'src/app/controller/service/Notification.service';
import {AffliateDto} from 'src/app/controller/model/Affliate.model';
import {AffliateService} from 'src/app/controller/service/Affliate.service';
import {NotificationDetailDto} from 'src/app/controller/model/NotificationDetail.model';
import {NotificationDetailService} from 'src/app/controller/service/NotificationDetail.service';
import {StatutClientDto} from 'src/app/controller/model/StatutClient.model';
import {StatutClientService} from 'src/app/controller/service/StatutClient.service';
import {TypePaiementDto} from 'src/app/controller/model/TypePaiement.model';
import {TypePaiementService} from 'src/app/controller/service/TypePaiement.service';
import {SubscriptionDto} from 'src/app/controller/model/Subscription.model';
import {SubscriptionService} from 'src/app/controller/service/Subscription.service';
import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {WebSiteService} from 'src/app/controller/service/WebSite.service';
import {SubscriptionPackDto} from 'src/app/controller/model/SubscriptionPack.model';
import {SubscriptionPackService} from 'src/app/controller/service/SubscriptionPack.service';
import {StatutWebSiteDto} from 'src/app/controller/model/StatutWebSite.model';
import {StatutWebSiteService} from 'src/app/controller/service/StatutWebSite.service';
import {SubscriptionEtatDto} from 'src/app/controller/model/SubscriptionEtat.model';
import {SubscriptionEtatService} from 'src/app/controller/service/SubscriptionEtat.service';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ScrappingLinkService} from 'src/app/controller/service/ScrappingLink.service';

@Component({
  selector: 'app-client-edit-admin',
  templateUrl: './client-edit-admin.component.html'
})
export class ClientEditAdminComponent extends AbstractEditController<ClientDto, ClientCriteria, ClientService>   implements OnInit {

    private _affliatesElement = new AffliateDto();
    private _webSitesElement = new WebSiteDto();
    private _notificationDetailsElement = new NotificationDetailDto();
    private _subscriptionsElement = new SubscriptionDto();

    private _validClientNom = true;
    private _validClientPrenom = true;
    private _validClientPassword = true;
    private _validClientEmail = true;

    private _validStatutClientCode = true;
    private _validStatutClientLibelle = true;
    private _validAffliatesCode = true;
    private _validAffliatesLibelle = true;
    private _validWebSitesUrl = true;


    private _notificationDetails: Array<NotificationDetailDto> = [];

    constructor( private clientService: ClientService , private subscriptionTypeService: SubscriptionTypeService, private notificationService: NotificationService, private subscriptionPackService: SubscriptionPackService, private affliateService: AffliateService, private notificationDetailService: NotificationDetailService, private typePaiementService: TypePaiementService, private subscriptionService: SubscriptionService, private statutClientService: StatutClientService, private webSiteService: WebSiteService, private statutWebSiteService: StatutWebSiteService, private subscriptionEtatService: SubscriptionEtatService) {
        super(clientService);
    }

    ngOnInit(): void {

        this.webSitesElement.statutWebSite = new StatutWebSiteDto();
        this.statutWebSiteService.findAll().subscribe((data) => this.statutWebSites = data);

        this.notificationService.findAll().subscribe(data => this.prepareNotificationDetails(data));
        this.notificationDetailsElement.notification = new NotificationDto();
        this.notificationService.findAll().subscribe((data) => this.notifications = data);

        this.subscriptionsElement.subscriptionType = new SubscriptionTypeDto();
        this.subscriptionTypeService.findAll().subscribe((data) => this.subscriptionTypes = data);
        this.subscriptionsElement.subscriptionPack = new SubscriptionPackDto();
        this.subscriptionPackService.findAll().subscribe((data) => this.subscriptionPacks = data);
        this.subscriptionsElement.subscriptionEtat = new SubscriptionEtatDto();
        this.subscriptionEtatService.findAll().subscribe((data) => this.subscriptionEtats = data);
        this.subscriptionsElement.typePaiement = new TypePaiementDto();
        this.typePaiementService.findAll().subscribe((data) => this.typePaiements = data);

    this.statutClient = new StatutClientDto();
    this.statutClientService.findAll().subscribe((data) => this.statutClients = data);
}


    prepareNotificationDetails(notifications: Array<NotificationDto>): void{
        if( notifications != null){
            notifications.forEach(e => {
                const notificationDetail = new NotificationDetailDto();
                notificationDetail.notification = e;
                this.notificationDetails.push(notificationDetail);
            });
        }
    }
    public validateAffliates(){
        this.errorMessages = new Array();
        this.validateAffliatesCode();
        this.validateAffliatesLibelle();
    }
    public validateWebSites(){
        this.errorMessages = new Array();
        this.validateWebSitesUrl();
    }
    public validateSubscriptions(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        this.validClientNom = value;
        this.validClientPrenom = value;
        this.validClientPassword = value;
        this.validClientEmail = value;
        this.validAffliatesCode = value;
        this.validAffliatesLibelle = value;
        this.validWebSitesUrl = value;
        }
   public addAffliates() {
        if( this.item.affliates == null )
            this.item.affliates = new Array<AffliateDto>();
       this.validateAffliates();
       if (this.errorMessages.length === 0) {
            if(this.affliatesElement.id == null){
                this.item.affliates.push(this.affliatesElement);
            }else{
                const index = this.item.affliates.findIndex(e => e.id == this.affliatesElement.id);
                this.item.affliates[index] = this.affliatesElement;
            }
          this.affliatesElement = new AffliateDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAffliate(p: AffliateDto) {
        this.item.affliates.forEach((element, index) => {
            if (element === p) { this.item.affliates.splice(index, 1); }
        });
    }

    public editAffliate(p: AffliateDto) {
        this.affliatesElement = {... p};
        this.activeTab = 0;
    }
   public addWebSites() {
        if( this.item.webSites == null )
            this.item.webSites = new Array<WebSiteDto>();
       this.validateWebSites();
       if (this.errorMessages.length === 0) {
            if(this.webSitesElement.id == null){
                this.item.webSites.push(this.webSitesElement);
            }else{
                const index = this.item.webSites.findIndex(e => e.id == this.webSitesElement.id);
                this.item.webSites[index] = this.webSitesElement;
            }
          this.webSitesElement = new WebSiteDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteWebSite(p: WebSiteDto) {
        this.item.webSites.forEach((element, index) => {
            if (element === p) { this.item.webSites.splice(index, 1); }
        });
    }

    public editWebSite(p: WebSiteDto) {
        this.webSitesElement = {... p};
        this.activeTab = 0;
    }
   public addSubscriptions() {
        if( this.item.subscriptions == null )
            this.item.subscriptions = new Array<SubscriptionDto>();
       this.validateSubscriptions();
       if (this.errorMessages.length === 0) {
            if(this.subscriptionsElement.id == null){
                this.item.subscriptions.push(this.subscriptionsElement);
            }else{
                const index = this.item.subscriptions.findIndex(e => e.id == this.subscriptionsElement.id);
                this.item.subscriptions[index] = this.subscriptionsElement;
            }
          this.subscriptionsElement = new SubscriptionDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteSubscription(p: SubscriptionDto) {
        this.item.subscriptions.forEach((element, index) => {
            if (element === p) { this.item.subscriptions.splice(index, 1); }
        });
    }

    public editSubscription(p: SubscriptionDto) {
        this.subscriptionsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateClientNom();
        this.validateClientPrenom();
        this.validateClientPassword();
        this.validateClientEmail();
    }
    public validateClientNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validClientNom = false;
        } else {
            this.validClientNom = true;
        }
    }
    public validateClientPrenom(){
        if (this.stringUtilService.isEmpty(this.item.prenom)) {
            this.errorMessages.push('Prenom non valide');
            this.validClientPrenom = false;
        } else {
            this.validClientPrenom = true;
        }
    }
    public validateClientPassword(){
        if (this.stringUtilService.isEmpty(this.item.password)) {
            this.errorMessages.push('Password non valide');
            this.validClientPassword = false;
        } else {
            this.validClientPassword = true;
        }
    }
    public validateClientEmail(){
        if (this.stringUtilService.isEmpty(this.item.email)) {
            this.errorMessages.push('Email non valide');
            this.validClientEmail = false;
        } else {
            this.validClientEmail = true;
        }
    }


    private validateAffliatesCode(){
        if (this.affliatesElement.code == null) {
        this.errorMessages.push('Code de la affliate est  invalide');
            this.validAffliatesCode = false;
        } else {
            this.validAffliatesCode = true;
        }
    }
    private validateAffliatesLibelle(){
        if (this.affliatesElement.libelle == null) {
        this.errorMessages.push('Libelle de la affliate est  invalide');
            this.validAffliatesLibelle = false;
        } else {
            this.validAffliatesLibelle = true;
        }
    }
    private validateWebSitesUrl(){
        if (this.webSitesElement.url == null) {
        this.errorMessages.push('Url de la webSite est  invalide');
            this.validWebSitesUrl = false;
        } else {
            this.validWebSitesUrl = true;
        }
    }

   public async openCreateStatutClient(statutClient: string) {
        const isPermistted = await this.roleService.isPermitted('StatutClient', 'edit');
        if(isPermistted) {
             this.statutClient = new StatutClientDto();
             this.createStatutClientDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get statutClient(): StatutClientDto {
       return this.statutClientService.item;
   }
  set statutClient(value: StatutClientDto) {
        this.statutClientService.item = value;
   }
   get statutClients(): Array<StatutClientDto> {
        return this.statutClientService.items;
   }
   set statutClients(value: Array<StatutClientDto>) {
        this.statutClientService.items = value;
   }
   get createStatutClientDialog(): boolean {
       return this.statutClientService.createDialog;
   }
  set createStatutClientDialog(value: boolean) {
       this.statutClientService.createDialog= value;
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
   get statutWebSite(): StatutWebSiteDto {
       return this.statutWebSiteService.item;
   }
  set statutWebSite(value: StatutWebSiteDto) {
        this.statutWebSiteService.item = value;
   }
   get statutWebSites(): Array<StatutWebSiteDto> {
        return this.statutWebSiteService.items;
   }
   set statutWebSites(value: Array<StatutWebSiteDto>) {
        this.statutWebSiteService.items = value;
   }
   get createStatutWebSiteDialog(): boolean {
       return this.statutWebSiteService.createDialog;
   }
  set createStatutWebSiteDialog(value: boolean) {
       this.statutWebSiteService.createDialog= value;
   }
   get notification(): NotificationDto {
       return this.notificationService.item;
   }
  set notification(value: NotificationDto) {
        this.notificationService.item = value;
   }
   get notifications(): Array<NotificationDto> {
        return this.notificationService.items;
   }
   set notifications(value: Array<NotificationDto>) {
        this.notificationService.items = value;
   }
   get createNotificationDialog(): boolean {
       return this.notificationService.createDialog;
   }
  set createNotificationDialog(value: boolean) {
       this.notificationService.createDialog= value;
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

    get notificationDetails(): Array<NotificationDetailDto> {
        if( this._notificationDetails == null )
            this._notificationDetails = new Array();
         return this._notificationDetails;
    }

    set notificationDetails(value: Array<NotificationDetailDto>) {
        this._notificationDetails = value;
    }
    get affliatesElement(): AffliateDto {
        if( this._affliatesElement == null )
            this._affliatesElement = new AffliateDto();
         return this._affliatesElement;
    }

    set affliatesElement(value: AffliateDto) {
        this._affliatesElement = value;
    }
    get webSitesElement(): WebSiteDto {
        if( this._webSitesElement == null )
            this._webSitesElement = new WebSiteDto();
         return this._webSitesElement;
    }

    set webSitesElement(value: WebSiteDto) {
        this._webSitesElement = value;
    }
    get notificationDetailsElement(): NotificationDetailDto {
        if( this._notificationDetailsElement == null )
            this._notificationDetailsElement = new NotificationDetailDto();
         return this._notificationDetailsElement;
    }

    set notificationDetailsElement(value: NotificationDetailDto) {
        this._notificationDetailsElement = value;
    }
    get subscriptionsElement(): SubscriptionDto {
        if( this._subscriptionsElement == null )
            this._subscriptionsElement = new SubscriptionDto();
         return this._subscriptionsElement;
    }

    set subscriptionsElement(value: SubscriptionDto) {
        this._subscriptionsElement = value;
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
    get validAffliatesCode(): boolean {
        return this._validAffliatesCode;
    }
    set validAffliatesCode(value: boolean) {
        this._validAffliatesCode = value;
    }
    get validAffliatesLibelle(): boolean {
        return this._validAffliatesLibelle;
    }
    set validAffliatesLibelle(value: boolean) {
        this._validAffliatesLibelle = value;
    }
    get validWebSitesUrl(): boolean {
        return this._validWebSitesUrl;
    }
    set validWebSitesUrl(value: boolean) {
        this._validWebSitesUrl = value;
    }
}
