import {Component, OnInit} from '@angular/core';
import {SubscriptionService} from 'src/app/controller/service/Subscription.service';
import {SubscriptionDto} from 'src/app/controller/model/Subscription.model';
import {SubscriptionCriteria} from 'src/app/controller/criteria/SubscriptionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SubscriptionTypeService } from 'src/app/controller/service/SubscriptionType.service';
import { SubscriptionPackService } from 'src/app/controller/service/SubscriptionPack.service';
import { SubscriptionEtatService } from 'src/app/controller/service/SubscriptionEtat.service';
import { ClientService } from 'src/app/controller/service/Client.service';
import { TypePaiementService } from 'src/app/controller/service/TypePaiement.service';

import {SubscriptionTypeDto} from 'src/app/controller/model/SubscriptionType.model';
import {SubscriptionPackDto} from 'src/app/controller/model/SubscriptionPack.model';
import {SubscriptionEtatDto} from 'src/app/controller/model/SubscriptionEtat.model';
import {TypePaiementDto} from 'src/app/controller/model/TypePaiement.model';
import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-subscription-list-admin',
  templateUrl: './subscription-list-admin.component.html'
})
export class SubscriptionListAdminComponent extends AbstractListController<SubscriptionDto, SubscriptionCriteria, SubscriptionService>  implements OnInit {

    fileName = 'Subscription';

    subscriptionTypes :Array<SubscriptionTypeDto>;
    subscriptionPacks :Array<SubscriptionPackDto>;
    subscriptionEtats :Array<SubscriptionEtatDto>;
    clients :Array<ClientDto>;
    typePaiements :Array<TypePaiementDto>;
  
    constructor(subscriptionService: SubscriptionService, private subscriptionTypeService: SubscriptionTypeService, private subscriptionPackService: SubscriptionPackService, private subscriptionEtatService: SubscriptionEtatService, private clientService: ClientService, private typePaiementService: TypePaiementService) {
        super(subscriptionService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSubscriptionType();
      this.loadSubscriptionPack();
      this.loadSubscriptionEtat();
      this.loadClient();
      this.loadTypePaiement();
    }

    public async loadSubscriptions(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Subscription', 'list');
        isPermistted ? this.service.findAll().subscribe(subscriptions => this.items = subscriptions,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'dateDebut', header: 'Date debut'},
            {field: 'dateFin', header: 'Date fin'},
            {field: 'delai', header: 'Delai'},
            {field: 'subscriptionType?.libelle', header: 'Subscription type'},
            {field: 'subscriptionPack?.libelle', header: 'Subscription pack'},
            {field: 'subscriptionEtat?.libelle', header: 'Subscription etat'},
            {field: 'client?.id', header: 'Client'},
            {field: 'nombrePage', header: 'Nombre page'},
            {field: 'typePaiement?.libelle', header: 'Type paiement'},
            {field: 'montantPaye', header: 'Montant paye'},
            {field: 'datePaiement', header: 'Date paiement'},
        ];
    }


    public async loadSubscriptionType(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Subscription', 'list');
        isPermistted ? this.subscriptionTypeService.findAllOptimized().subscribe(subscriptionTypes => this.subscriptionTypes = subscriptionTypes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSubscriptionPack(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Subscription', 'list');
        isPermistted ? this.subscriptionPackService.findAllOptimized().subscribe(subscriptionPacks => this.subscriptionPacks = subscriptionPacks,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSubscriptionEtat(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Subscription', 'list');
        isPermistted ? this.subscriptionEtatService.findAllOptimized().subscribe(subscriptionEtats => this.subscriptionEtats = subscriptionEtats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Subscription', 'list');
        isPermistted ? this.clientService.findAll().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadTypePaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Subscription', 'list');
        isPermistted ? this.typePaiementService.findAllOptimized().subscribe(typePaiements => this.typePaiements = typePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SubscriptionDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Date debut': this.datePipe.transform(e.dateDebut , 'dd/MM/yyyy hh:mm'),
                'Date fin': this.datePipe.transform(e.dateFin , 'dd/MM/yyyy hh:mm'),
                 'Delai': e.delai ,
                'Subscription type': e.subscriptionType?.libelle ,
                'Subscription pack': e.subscriptionPack?.libelle ,
                'Subscription etat': e.subscriptionEtat?.libelle ,
                'Client': e.client?.id ,
                 'Nombre page': e.nombrePage ,
                'Type paiement': e.typePaiement?.libelle ,
                 'Montant paye': e.montantPaye ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
            }
        });

        this.criteriaData = [{
            'Date debut Min': this.criteria.dateDebutFrom ? this.datePipe.transform(this.criteria.dateDebutFrom , this.dateFormat) : environment.emptyForExport ,
            'Date debut Max': this.criteria.dateDebutTo ? this.datePipe.transform(this.criteria.dateDebutTo , this.dateFormat) : environment.emptyForExport ,
            'Date fin Min': this.criteria.dateFinFrom ? this.datePipe.transform(this.criteria.dateFinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date fin Max': this.criteria.dateFinTo ? this.datePipe.transform(this.criteria.dateFinTo , this.dateFormat) : environment.emptyForExport ,
            'Delai Min': this.criteria.delaiMin ? this.criteria.delaiMin : environment.emptyForExport ,
            'Delai Max': this.criteria.delaiMax ? this.criteria.delaiMax : environment.emptyForExport ,
        //'Subscription type': this.criteria.subscriptionType?.libelle ? this.criteria.subscriptionType?.libelle : environment.emptyForExport ,
        //'Subscription pack': this.criteria.subscriptionPack?.libelle ? this.criteria.subscriptionPack?.libelle : environment.emptyForExport ,
        //'Subscription etat': this.criteria.subscriptionEtat?.libelle ? this.criteria.subscriptionEtat?.libelle : environment.emptyForExport ,
        //'Client': this.criteria.client?.id ? this.criteria.client?.id : environment.emptyForExport ,
            'Nombre page Min': this.criteria.nombrePageMin ? this.criteria.nombrePageMin : environment.emptyForExport ,
            'Nombre page Max': this.criteria.nombrePageMax ? this.criteria.nombrePageMax : environment.emptyForExport ,
        //'Type paiement': this.criteria.typePaiement?.libelle ? this.criteria.typePaiement?.libelle : environment.emptyForExport ,
            'Montant paye Min': this.criteria.montantPayeMin ? this.criteria.montantPayeMin : environment.emptyForExport ,
            'Montant paye Max': this.criteria.montantPayeMax ? this.criteria.montantPayeMax : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
        }];
      }
}
