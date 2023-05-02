import {Component, OnInit} from '@angular/core';
import {StatutWebSiteService} from 'src/app/controller/service/StatutWebSite.service';
import {StatutWebSiteDto} from 'src/app/controller/model/StatutWebSite.model';
import {StatutWebSiteCriteria} from 'src/app/controller/criteria/StatutWebSiteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-statut-web-site-list-admin',
  templateUrl: './statut-web-site-list-admin.component.html'
})
export class StatutWebSiteListAdminComponent extends AbstractListController<StatutWebSiteDto, StatutWebSiteCriteria, StatutWebSiteService>  implements OnInit {

    fileName = 'StatutWebSite';

  
    constructor(statutWebSiteService: StatutWebSiteService) {
        super(statutWebSiteService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadStatutWebSites(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('StatutWebSite', 'list');
        isPermistted ? this.service.findAll().subscribe(statutWebSites => this.items = statutWebSites,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: StatutWebSiteDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
