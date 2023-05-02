import {Component, OnInit} from '@angular/core';
import {TypeProduitService} from 'src/app/controller/service/TypeProduit.service';
import {TypeProduitDto} from 'src/app/controller/model/TypeProduit.model';
import {TypeProduitCriteria} from 'src/app/controller/criteria/TypeProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-type-produit-list-admin',
  templateUrl: './type-produit-list-admin.component.html'
})
export class TypeProduitListAdminComponent extends AbstractListController<TypeProduitDto, TypeProduitCriteria, TypeProduitService>  implements OnInit {

    fileName = 'TypeProduit';

  
    constructor(typeProduitService: TypeProduitService) {
        super(typeProduitService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadTypeProduits(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('TypeProduit', 'list');
        isPermistted ? this.service.findAll().subscribe(typeProduits => this.items = typeProduits,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: TypeProduitDto) {
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
