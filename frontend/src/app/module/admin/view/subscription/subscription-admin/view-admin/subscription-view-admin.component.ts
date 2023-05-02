import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-subscription-view-admin',
  templateUrl: './subscription-view-admin.component.html'
})
export class SubscriptionViewAdminComponent extends AbstractViewController<SubscriptionDto, SubscriptionCriteria, SubscriptionService> implements OnInit {


    constructor(private subscriptionService: SubscriptionService, private subscriptionTypeService: SubscriptionTypeService, private subscriptionPackService: SubscriptionPackService, private clientService: ClientService, private typePaiementService: TypePaiementService, private subscriptionEtatService: SubscriptionEtatService){
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


    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
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
