import {Component, OnInit} from '@angular/core';
import {StatutClientService} from 'src/app/controller/service/StatutClient.service';
import {StatutClientDto} from 'src/app/controller/model/StatutClient.model';
import {StatutClientCriteria} from 'src/app/controller/criteria/StatutClientCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-statut-client-list-admin',
  templateUrl: './statut-client-list-admin.component.html'
})
export class StatutClientListAdminComponent extends AbstractListController<StatutClientDto, StatutClientCriteria, StatutClientService>  implements OnInit {

    fileName = 'StatutClient';

  
    constructor(statutClientService: StatutClientService) {
        super(statutClientService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadStatutClients(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('StatutClient', 'list');
        isPermistted ? this.service.findAll().subscribe(statutClients => this.items = statutClients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: StatutClientDto) {
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
