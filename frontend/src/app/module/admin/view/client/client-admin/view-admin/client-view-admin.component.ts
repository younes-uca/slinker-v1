import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-client-view-admin',
  templateUrl: './client-view-admin.component.html'
})
export class ClientViewAdminComponent extends AbstractViewController<ClientDto, ClientCriteria, ClientService> implements OnInit {

    affliates = new AffliateDto();
    affliatess: Array<AffliateDto> = [];
    webSites = new WebSiteDto();
    webSitess: Array<WebSiteDto> = [];
    notificationDetails = new NotificationDetailDto();
    notificationDetailss: Array<NotificationDetailDto> = [];
    subscriptions = new SubscriptionDto();
    subscriptionss: Array<SubscriptionDto> = [];

    constructor(private clientService: ClientService, private subscriptionTypeService: SubscriptionTypeService, private notificationService: NotificationService, private subscriptionPackService: SubscriptionPackService, private affliateService: AffliateService, private notificationDetailService: NotificationDetailService, private typePaiementService: TypePaiementService, private subscriptionService: SubscriptionService, private statutClientService: StatutClientService, private webSiteService: WebSiteService, private statutWebSiteService: StatutWebSiteService, private subscriptionEtatService: SubscriptionEtatService){
        super(clientService);
    }

    ngOnInit(): void {
        this.webSites.statutWebSite = new StatutWebSiteDto();
        this.statutWebSiteService.findAll().subscribe((data) => this.statutWebSites = data);
        this.notificationDetails.notification = new NotificationDto();
        this.notificationService.findAll().subscribe((data) => this.notifications = data);
        this.subscriptions.subscriptionType = new SubscriptionTypeDto();
        this.subscriptionTypeService.findAll().subscribe((data) => this.subscriptionTypes = data);
        this.subscriptions.subscriptionPack = new SubscriptionPackDto();
        this.subscriptionPackService.findAll().subscribe((data) => this.subscriptionPacks = data);
        this.subscriptions.subscriptionEtat = new SubscriptionEtatDto();
        this.subscriptionEtatService.findAll().subscribe((data) => this.subscriptionEtats = data);
        this.subscriptions.typePaiement = new TypePaiementDto();
        this.typePaiementService.findAll().subscribe((data) => this.typePaiements = data);
        this.statutClient = new StatutClientDto();
        this.statutClientService.findAll().subscribe((data) => this.statutClients = data);
    }


    get statutClient(): StatutClientDto {
       return this.statutClientService.item;
    }
    set statutClient(value: StatutClientDto) {
        this.statutClientService.item = value;
    }
    get statutClients():Array<StatutClientDto> {
       return this.statutClientService.items;
    }
    set statutClients(value: Array<StatutClientDto>) {
        this.statutClientService.items = value;
    }
    get subscriptionType(): SubscriptionTypeDto {
       return this.subscriptionTypeService.item;
    }
    set subscriptionType(value: SubscriptionTypeDto) {
        this.subscriptionTypeService.item = value;
    }
    get subscriptionTypes():Array<SubscriptionTypeDto> {
       return this.subscriptionTypeService.items;
    }
    set subscriptionTypes(value: Array<SubscriptionTypeDto>) {
        this.subscriptionTypeService.items = value;
    }
    get typePaiement(): TypePaiementDto {
       return this.typePaiementService.item;
    }
    set typePaiement(value: TypePaiementDto) {
        this.typePaiementService.item = value;
    }
    get typePaiements():Array<TypePaiementDto> {
       return this.typePaiementService.items;
    }
    set typePaiements(value: Array<TypePaiementDto>) {
        this.typePaiementService.items = value;
    }
    get subscriptionEtat(): SubscriptionEtatDto {
       return this.subscriptionEtatService.item;
    }
    set subscriptionEtat(value: SubscriptionEtatDto) {
        this.subscriptionEtatService.item = value;
    }
    get subscriptionEtats():Array<SubscriptionEtatDto> {
       return this.subscriptionEtatService.items;
    }
    set subscriptionEtats(value: Array<SubscriptionEtatDto>) {
        this.subscriptionEtatService.items = value;
    }
    get statutWebSite(): StatutWebSiteDto {
       return this.statutWebSiteService.item;
    }
    set statutWebSite(value: StatutWebSiteDto) {
        this.statutWebSiteService.item = value;
    }
    get statutWebSites():Array<StatutWebSiteDto> {
       return this.statutWebSiteService.items;
    }
    set statutWebSites(value: Array<StatutWebSiteDto>) {
        this.statutWebSiteService.items = value;
    }
    get notification(): NotificationDto {
       return this.notificationService.item;
    }
    set notification(value: NotificationDto) {
        this.notificationService.item = value;
    }
    get notifications():Array<NotificationDto> {
       return this.notificationService.items;
    }
    set notifications(value: Array<NotificationDto>) {
        this.notificationService.items = value;
    }
    get subscriptionPack(): SubscriptionPackDto {
       return this.subscriptionPackService.item;
    }
    set subscriptionPack(value: SubscriptionPackDto) {
        this.subscriptionPackService.item = value;
    }
    get subscriptionPacks():Array<SubscriptionPackDto> {
       return this.subscriptionPackService.items;
    }
    set subscriptionPacks(value: Array<SubscriptionPackDto>) {
        this.subscriptionPackService.items = value;
    }


}
