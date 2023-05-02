import {Component, OnInit} from '@angular/core';
import {SubscriptionEtatService} from 'src/app/controller/service/SubscriptionEtat.service';
import {SubscriptionEtatDto} from 'src/app/controller/model/SubscriptionEtat.model';
import {SubscriptionEtatCriteria} from 'src/app/controller/criteria/SubscriptionEtatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-subscription-etat-list-admin',
  templateUrl: './subscription-etat-list-admin.component.html'
})
export class SubscriptionEtatListAdminComponent extends AbstractListController<SubscriptionEtatDto, SubscriptionEtatCriteria, SubscriptionEtatService>  implements OnInit {

    fileName = 'SubscriptionEtat';

  
    constructor(subscriptionEtatService: SubscriptionEtatService) {
        super(subscriptionEtatService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadSubscriptionEtats(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SubscriptionEtat', 'list');
        isPermistted ? this.service.findAll().subscribe(subscriptionEtats => this.items = subscriptionEtats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: SubscriptionEtatDto) {
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
