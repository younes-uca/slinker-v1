import {Component, OnInit} from '@angular/core';
import {StatutNotificationService} from 'src/app/controller/service/StatutNotification.service';
import {StatutNotificationDto} from 'src/app/controller/model/StatutNotification.model';
import {StatutNotificationCriteria} from 'src/app/controller/criteria/StatutNotificationCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-statut-notification-list-admin',
  templateUrl: './statut-notification-list-admin.component.html'
})
export class StatutNotificationListAdminComponent extends AbstractListController<StatutNotificationDto, StatutNotificationCriteria, StatutNotificationService>  implements OnInit {

    fileName = 'StatutNotification';

  
    constructor(statutNotificationService: StatutNotificationService) {
        super(statutNotificationService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadStatutNotifications(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('StatutNotification', 'list');
        isPermistted ? this.service.findAll().subscribe(statutNotifications => this.items = statutNotifications,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: StatutNotificationDto) {
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
