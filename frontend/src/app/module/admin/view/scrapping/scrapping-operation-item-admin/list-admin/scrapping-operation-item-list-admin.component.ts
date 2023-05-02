import {Component, OnInit} from '@angular/core';
import {ScrappingOperationItemService} from 'src/app/controller/service/ScrappingOperationItem.service';
import {ScrappingOperationItemDto} from 'src/app/controller/model/ScrappingOperationItem.model';
import {ScrappingOperationItemCriteria} from 'src/app/controller/criteria/ScrappingOperationItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ScrappingLinkService } from 'src/app/controller/service/ScrappingLink.service';
import { TypeProduitService } from 'src/app/controller/service/TypeProduit.service';
import { ScrappingOperationService } from 'src/app/controller/service/ScrappingOperation.service';

import {TypeProduitDto} from 'src/app/controller/model/TypeProduit.model';
import {ScrappingOperationDto} from 'src/app/controller/model/ScrappingOperation.model';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';


@Component({
  selector: 'app-scrapping-operation-item-list-admin',
  templateUrl: './scrapping-operation-item-list-admin.component.html'
})
export class ScrappingOperationItemListAdminComponent extends AbstractListController<ScrappingOperationItemDto, ScrappingOperationItemCriteria, ScrappingOperationItemService>  implements OnInit {

    fileName = 'ScrappingOperationItem';

    scrappingLinks :Array<ScrappingLinkDto>;
    typeProduits :Array<TypeProduitDto>;
    scrappingOperations :Array<ScrappingOperationDto>;
  
    constructor(scrappingOperationItemService: ScrappingOperationItemService, private scrappingLinkService: ScrappingLinkService, private typeProduitService: TypeProduitService, private scrappingOperationService: ScrappingOperationService) {
        super(scrappingOperationItemService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadScrappingLink();
      this.loadTypeProduit();
      this.loadScrappingOperation();
    }

    public async loadScrappingOperationItems(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingOperationItem', 'list');
        isPermistted ? this.service.findAll().subscribe(scrappingOperationItems => this.items = scrappingOperationItems,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'scrappingLink?.libelle', header: 'Scrapping link'},
            {field: 'typeProduit?.libelle', header: 'Type produit'},
            {field: 'prix', header: 'Prix'},
            {field: 'stock', header: 'Stock'},
            {field: 'image', header: 'Image'},
            {field: 'review', header: 'Review'},
            {field: 'scrappingOperation?.id', header: 'Scrapping operation'},
        ];
    }


    public async loadScrappingLink(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingOperationItem', 'list');
        isPermistted ? this.scrappingLinkService.findAllOptimized().subscribe(scrappingLinks => this.scrappingLinks = scrappingLinks,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadTypeProduit(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingOperationItem', 'list');
        isPermistted ? this.typeProduitService.findAllOptimized().subscribe(typeProduits => this.typeProduits = typeProduits,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadScrappingOperation(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ScrappingOperationItem', 'list');
        isPermistted ? this.scrappingOperationService.findAll().subscribe(scrappingOperations => this.scrappingOperations = scrappingOperations,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ScrappingOperationItemDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Scrapping link': e.scrappingLink?.libelle ,
                'Type produit': e.typeProduit?.libelle ,
                 'Prix': e.prix ,
                 'Stock': e.stock ,
                 'Image': e.image ,
                 'Description': e.description ,
                 'Review': e.review ,
                'Scrapping operation': e.scrappingOperation?.id ,
            }
        });

        this.criteriaData = [{
        //'Scrapping link': this.criteria.scrappingLink?.libelle ? this.criteria.scrappingLink?.libelle : environment.emptyForExport ,
        //'Type produit': this.criteria.typeProduit?.libelle ? this.criteria.typeProduit?.libelle : environment.emptyForExport ,
            'Prix Min': this.criteria.prixMin ? this.criteria.prixMin : environment.emptyForExport ,
            'Prix Max': this.criteria.prixMax ? this.criteria.prixMax : environment.emptyForExport ,
            'Stock': this.criteria.stock ? this.criteria.stock : environment.emptyForExport ,
            'Image': this.criteria.image ? this.criteria.image : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Review': this.criteria.review ? this.criteria.review : environment.emptyForExport ,
        //'Scrapping operation': this.criteria.scrappingOperation?.id ? this.criteria.scrappingOperation?.id : environment.emptyForExport ,
        }];
      }
}
