import {Component, OnInit} from '@angular/core';
import {SubscriptionPackService} from 'src/app/controller/service/SubscriptionPack.service';
import {SubscriptionPackDto} from 'src/app/controller/model/SubscriptionPack.model';
import {SubscriptionPackCriteria} from 'src/app/controller/criteria/SubscriptionPackCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-subscription-pack-list-admin',
  templateUrl: './subscription-pack-list-admin.component.html'
})
export class SubscriptionPackListAdminComponent extends AbstractListController<SubscriptionPackDto, SubscriptionPackCriteria, SubscriptionPackService>  implements OnInit {

    fileName = 'SubscriptionPack';

  
    constructor(subscriptionPackService: SubscriptionPackService) {
        super(subscriptionPackService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadSubscriptionPacks(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SubscriptionPack', 'list');
        isPermistted ? this.service.findAll().subscribe(subscriptionPacks => this.items = subscriptionPacks,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'prix', header: 'Prix'},
        ];
    }



	public initDuplicate(res: SubscriptionPackDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                 'Prix': e.prix ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Prix Min': this.criteria.prixMin ? this.criteria.prixMin : environment.emptyForExport ,
            'Prix Max': this.criteria.prixMax ? this.criteria.prixMax : environment.emptyForExport ,
        }];
      }
}
