import {Component, OnInit} from '@angular/core';
import {AffliateService} from 'src/app/controller/service/Affliate.service';
import {AffliateDto} from 'src/app/controller/model/Affliate.model';
import {AffliateCriteria} from 'src/app/controller/criteria/AffliateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ClientService } from 'src/app/controller/service/Client.service';

import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-affliate-list-admin',
  templateUrl: './affliate-list-admin.component.html'
})
export class AffliateListAdminComponent extends AbstractListController<AffliateDto, AffliateCriteria, AffliateService>  implements OnInit {

    fileName = 'Affliate';

    clients :Array<ClientDto>;
  
    constructor(affliateService: AffliateService, private clientService: ClientService) {
        super(affliateService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadClient();
    }

    public async loadAffliates(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Affliate', 'list');
        isPermistted ? this.service.findAll().subscribe(affliates => this.items = affliates,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'client?.id', header: 'Client'},
        ];
    }


    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Affliate', 'list');
        isPermistted ? this.clientService.findAll().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: AffliateDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                'Client': e.client?.id ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Client': this.criteria.client?.id ? this.criteria.client?.id : environment.emptyForExport ,
        }];
      }
}
