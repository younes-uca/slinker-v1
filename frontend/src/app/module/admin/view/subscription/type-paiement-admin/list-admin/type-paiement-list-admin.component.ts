import {Component, OnInit} from '@angular/core';
import {TypePaiementService} from 'src/app/controller/service/TypePaiement.service';
import {TypePaiementDto} from 'src/app/controller/model/TypePaiement.model';
import {TypePaiementCriteria} from 'src/app/controller/criteria/TypePaiementCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-type-paiement-list-admin',
  templateUrl: './type-paiement-list-admin.component.html'
})
export class TypePaiementListAdminComponent extends AbstractListController<TypePaiementDto, TypePaiementCriteria, TypePaiementService>  implements OnInit {

    fileName = 'TypePaiement';

  
    constructor(typePaiementService: TypePaiementService) {
        super(typePaiementService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadTypePaiements(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('TypePaiement', 'list');
        isPermistted ? this.service.findAll().subscribe(typePaiements => this.items = typePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: TypePaiementDto) {
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
