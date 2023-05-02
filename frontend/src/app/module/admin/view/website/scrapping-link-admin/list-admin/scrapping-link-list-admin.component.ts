import {Component, OnInit} from '@angular/core';
import {ScrappingLinkService} from 'src/app/controller/service/ScrappingLink.service';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ScrappingLinkCriteria} from 'src/app/controller/criteria/ScrappingLinkCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { WebSiteService } from 'src/app/controller/service/WebSite.service';

import {WebSiteDto} from 'src/app/controller/model/WebSite.model';


@Component({
  selector: 'app-scrapping-link-list-admin',
  templateUrl: './scrapping-link-list-admin.component.html'
})
export class ScrappingLinkListAdminComponent extends AbstractListController<ScrappingLinkDto, ScrappingLinkCriteria, ScrappingLinkService>  implements OnInit {

    fileName = 'ScrappingLink';

    webSites :Array<WebSiteDto>;
  
    constructor(scrappingLinkService: ScrappingLinkService, private webSiteService: WebSiteService) {
        super(scrappingLinkService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadWebSite();
    }

    public async loadScrappingLinks(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingLink', 'list');
        isPermistted ? this.service.findAll().subscribe(scrappingLinks => this.items = scrappingLinks,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'webSite?.url', header: 'Web site'},
        ];
    }


    public async loadWebSite(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingLink', 'list');
        isPermistted ? this.webSiteService.findAllOptimized().subscribe(webSites => this.webSites = webSites,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ScrappingLinkDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                'Web site': e.webSite?.url ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Web site': this.criteria.webSite?.url ? this.criteria.webSite?.url : environment.emptyForExport ,
        }];
      }
}
