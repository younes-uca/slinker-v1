import {Component, OnInit} from '@angular/core';
import {SubscriptionTypeService} from 'src/app/controller/service/SubscriptionType.service';
import {SubscriptionTypeDto} from 'src/app/controller/model/SubscriptionType.model';
import {SubscriptionTypeCriteria} from 'src/app/controller/criteria/SubscriptionTypeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-subscription-type-list-admin',
  templateUrl: './subscription-type-list-admin.component.html'
})
export class SubscriptionTypeListAdminComponent extends AbstractListController<SubscriptionTypeDto, SubscriptionTypeCriteria, SubscriptionTypeService>  implements OnInit {

    fileName = 'SubscriptionType';

  
    constructor(subscriptionTypeService: SubscriptionTypeService) {
        super(subscriptionTypeService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadSubscriptionTypes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SubscriptionType', 'list');
        isPermistted ? this.service.findAll().subscribe(subscriptionTypes => this.items = subscriptionTypes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: SubscriptionTypeDto) {
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
