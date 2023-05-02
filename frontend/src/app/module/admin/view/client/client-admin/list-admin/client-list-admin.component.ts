import {Component, OnInit} from '@angular/core';
import {ClientService} from 'src/app/controller/service/Client.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/ClientCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StatutClientService } from 'src/app/controller/service/StatutClient.service';

import {NotificationDetailDto} from 'src/app/controller/model/NotificationDetail.model';
import {StatutClientDto} from 'src/app/controller/model/StatutClient.model';
import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {AffliateDto} from 'src/app/controller/model/Affliate.model';
import {SubscriptionDto} from 'src/app/controller/model/Subscription.model';


@Component({
  selector: 'app-client-list-admin',
  templateUrl: './client-list-admin.component.html'
})
export class ClientListAdminComponent extends AbstractListController<ClientDto, ClientCriteria, ClientService>  implements OnInit {

    fileName = 'Client';

    statutClients :Array<StatutClientDto>;
  
    constructor(clientService: ClientService, private statutClientService: StatutClientService) {
        super(clientService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStatutClient();
    }

    public async loadClients(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Client', 'list');
        isPermistted ? this.service.findAll().subscribe(clients => this.items = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'nom', header: 'Nom'},
            {field: 'prenom', header: 'Prenom'},
            {field: 'password', header: 'Password'},
            {field: 'email', header: 'Email'},
            {field: 'statutClient?.libelle', header: 'Statut client'},
        ];
    }


    public async loadStatutClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Client', 'list');
        isPermistted ? this.statutClientService.findAllOptimized().subscribe(statutClients => this.statutClients = statutClients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ClientDto) {
        if (res.affliates != null) {
             res.affliates.forEach(d => { d.client = null; d.id = null; });
        }
        if (res.webSites != null) {
             res.webSites.forEach(d => { d.client = null; d.id = null; });
        }
        if (res.notificationDetails != null) {
             res.notificationDetails.forEach(d => { d.client = null; d.id = null; });
        }
        if (res.subscriptions != null) {
             res.subscriptions.forEach(d => { d.client = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Nom': e.nom ,
                 'Prenom': e.prenom ,
                 'Password': e.password ,
                 'Email': e.email ,
                'Statut client': e.statutClient?.libelle ,
            }
        });

        this.criteriaData = [{
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Prenom': this.criteria.prenom ? this.criteria.prenom : environment.emptyForExport ,
            'Password': this.criteria.password ? this.criteria.password : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
        //'Statut client': this.criteria.statutClient?.libelle ? this.criteria.statutClient?.libelle : environment.emptyForExport ,
        }];
      }
}
