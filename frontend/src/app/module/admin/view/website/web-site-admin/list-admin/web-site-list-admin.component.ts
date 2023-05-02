import {Component, OnInit} from '@angular/core';
import {WebSiteService} from 'src/app/controller/service/WebSite.service';
import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {WebSiteCriteria} from 'src/app/controller/criteria/WebSiteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StatutWebSiteService } from 'src/app/controller/service/StatutWebSite.service';
import { ClientService } from 'src/app/controller/service/Client.service';

import {StatutWebSiteDto} from 'src/app/controller/model/StatutWebSite.model';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-web-site-list-admin',
  templateUrl: './web-site-list-admin.component.html'
})
export class WebSiteListAdminComponent extends AbstractListController<WebSiteDto, WebSiteCriteria, WebSiteService>  implements OnInit {

    fileName = 'WebSite';

    statutWebSites :Array<StatutWebSiteDto>;
    clients :Array<ClientDto>;
  
    constructor(webSiteService: WebSiteService, private statutWebSiteService: StatutWebSiteService, private clientService: ClientService) {
        super(webSiteService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStatutWebSite();
      this.loadClient();
    }

    public async loadWebSites(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('WebSite', 'list');
        isPermistted ? this.service.findAll().subscribe(webSites => this.items = webSites,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'url', header: 'Url'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'jsonSummary', header: 'Json summary'},
            {field: 'statutWebSite?.libelle', header: 'Statut web site'},
            {field: 'client?.id', header: 'Client'},
        ];
    }


    public async loadStatutWebSite(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('WebSite', 'list');
        isPermistted ? this.statutWebSiteService.findAllOptimized().subscribe(statutWebSites => this.statutWebSites = statutWebSites,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('WebSite', 'list');
        isPermistted ? this.clientService.findAll().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: WebSiteDto) {
        if (res.scrappingLinks != null) {
             res.scrappingLinks.forEach(d => { d.webSite = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Url': e.url ,
                 'Libelle': e.libelle ,
                 'Json summary': e.jsonSummary ,
                'Statut web site': e.statutWebSite?.libelle ,
                'Client': e.client?.id ,
            }
        });

        this.criteriaData = [{
            'Url': this.criteria.url ? this.criteria.url : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Json summary': this.criteria.jsonSummary ? this.criteria.jsonSummary : environment.emptyForExport ,
        //'Statut web site': this.criteria.statutWebSite?.libelle ? this.criteria.statutWebSite?.libelle : environment.emptyForExport ,
        //'Client': this.criteria.client?.id ? this.criteria.client?.id : environment.emptyForExport ,
        }];
      }
}
