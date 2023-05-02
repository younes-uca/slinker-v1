import {Component, OnInit} from '@angular/core';
import {ScrappingOperationService} from 'src/app/controller/service/ScrappingOperation.service';
import {ScrappingOperationDto} from 'src/app/controller/model/ScrappingOperation.model';
import {ScrappingOperationCriteria} from 'src/app/controller/criteria/ScrappingOperationCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { AffliateService } from 'src/app/controller/service/Affliate.service';
import { WebSiteService } from 'src/app/controller/service/WebSite.service';

import {ScrappingOperationItemDto} from 'src/app/controller/model/ScrappingOperationItem.model';
import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {AffliateDto} from 'src/app/controller/model/Affliate.model';


@Component({
  selector: 'app-scrapping-operation-list-admin',
  templateUrl: './scrapping-operation-list-admin.component.html'
})
export class ScrappingOperationListAdminComponent extends AbstractListController<ScrappingOperationDto, ScrappingOperationCriteria, ScrappingOperationService>  implements OnInit {

    fileName = 'ScrappingOperation';

    affliates :Array<AffliateDto>;
    webSites :Array<WebSiteDto>;
  
    constructor(scrappingOperationService: ScrappingOperationService, private affliateService: AffliateService, private webSiteService: WebSiteService) {
        super(scrappingOperationService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadAffliate();
      this.loadWebSite();
    }

    public async loadScrappingOperations(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingOperation', 'list');
        isPermistted ? this.service.findAll().subscribe(scrappingOperations => this.items = scrappingOperations,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'dateDebutScrappingOperation', header: 'Date debut scrapping operation'},
            {field: 'dateFinScrappingOperation', header: 'Date fin scrapping operation'},
            {field: 'affliate?.libelle', header: 'Affliate'},
            {field: 'webSite?.url', header: 'Web site'},
            {field: 'url', header: 'Url'},
        ];
    }


    public async loadAffliate(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingOperation', 'list');
        isPermistted ? this.affliateService.findAllOptimized().subscribe(affliates => this.affliates = affliates,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadWebSite(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingOperation', 'list');
        isPermistted ? this.webSiteService.findAllOptimized().subscribe(webSites => this.webSites = webSites,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ScrappingOperationDto) {
        if (res.scrappingOperationItems != null) {
             res.scrappingOperationItems.forEach(d => { d.scrappingOperation = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Date debut scrapping operation': this.datePipe.transform(e.dateDebutScrappingOperation , 'dd/MM/yyyy hh:mm'),
                'Date fin scrapping operation': this.datePipe.transform(e.dateFinScrappingOperation , 'dd/MM/yyyy hh:mm'),
                'Affliate': e.affliate?.libelle ,
                'Web site': e.webSite?.url ,
                 'Url': e.url ,
            }
        });

        this.criteriaData = [{
            'Date debut scrapping operation Min': this.criteria.dateDebutScrappingOperationFrom ? this.datePipe.transform(this.criteria.dateDebutScrappingOperationFrom , this.dateFormat) : environment.emptyForExport ,
            'Date debut scrapping operation Max': this.criteria.dateDebutScrappingOperationTo ? this.datePipe.transform(this.criteria.dateDebutScrappingOperationTo , this.dateFormat) : environment.emptyForExport ,
            'Date fin scrapping operation Min': this.criteria.dateFinScrappingOperationFrom ? this.datePipe.transform(this.criteria.dateFinScrappingOperationFrom , this.dateFormat) : environment.emptyForExport ,
            'Date fin scrapping operation Max': this.criteria.dateFinScrappingOperationTo ? this.datePipe.transform(this.criteria.dateFinScrappingOperationTo , this.dateFormat) : environment.emptyForExport ,
        //'Affliate': this.criteria.affliate?.libelle ? this.criteria.affliate?.libelle : environment.emptyForExport ,
        //'Web site': this.criteria.webSite?.url ? this.criteria.webSite?.url : environment.emptyForExport ,
            'Url': this.criteria.url ? this.criteria.url : environment.emptyForExport ,
        }];
      }
}
