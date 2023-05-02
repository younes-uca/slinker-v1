import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ScrappingOperationItemService} from 'src/app/controller/service/ScrappingOperationItem.service';
import {ScrappingOperationItemDto} from 'src/app/controller/model/ScrappingOperationItem.model';
import {ScrappingOperationItemCriteria} from 'src/app/controller/criteria/ScrappingOperationItemCriteria.model';

import {TypeProduitDto} from 'src/app/controller/model/TypeProduit.model';
import {TypeProduitService} from 'src/app/controller/service/TypeProduit.service';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ScrappingLinkService} from 'src/app/controller/service/ScrappingLink.service';
import {ScrappingOperationDto} from 'src/app/controller/model/ScrappingOperation.model';
import {ScrappingOperationService} from 'src/app/controller/service/ScrappingOperation.service';
@Component({
  selector: 'app-scrapping-operation-item-view-admin',
  templateUrl: './scrapping-operation-item-view-admin.component.html'
})
export class ScrappingOperationItemViewAdminComponent extends AbstractViewController<ScrappingOperationItemDto, ScrappingOperationItemCriteria, ScrappingOperationItemService> implements OnInit {


    constructor(private scrappingOperationItemService: ScrappingOperationItemService, private typeProduitService: TypeProduitService, private scrappingLinkService: ScrappingLinkService, private scrappingOperationService: ScrappingOperationService){
        super(scrappingOperationItemService);
    }

    ngOnInit(): void {
        this.scrappingLink = new ScrappingLinkDto();
        this.scrappingLinkService.findAll().subscribe((data) => this.scrappingLinks = data);
        this.typeProduit = new TypeProduitDto();
        this.typeProduitService.findAll().subscribe((data) => this.typeProduits = data);
        this.scrappingOperation = new ScrappingOperationDto();
        this.scrappingOperationService.findAll().subscribe((data) => this.scrappingOperations = data);
    }


    get scrappingOperation(): ScrappingOperationDto {
       return this.scrappingOperationService.item;
    }
    set scrappingOperation(value: ScrappingOperationDto) {
        this.scrappingOperationService.item = value;
    }
    get scrappingOperations():Array<ScrappingOperationDto> {
       return this.scrappingOperationService.items;
    }
    set scrappingOperations(value: Array<ScrappingOperationDto>) {
        this.scrappingOperationService.items = value;
    }
    get typeProduit(): TypeProduitDto {
       return this.typeProduitService.item;
    }
    set typeProduit(value: TypeProduitDto) {
        this.typeProduitService.item = value;
    }
    get typeProduits():Array<TypeProduitDto> {
       return this.typeProduitService.items;
    }
    set typeProduits(value: Array<TypeProduitDto>) {
        this.typeProduitService.items = value;
    }
    get scrappingLink(): ScrappingLinkDto {
       return this.scrappingLinkService.item;
    }
    set scrappingLink(value: ScrappingLinkDto) {
        this.scrappingLinkService.item = value;
    }
    get scrappingLinks():Array<ScrappingLinkDto> {
       return this.scrappingLinkService.items;
    }
    set scrappingLinks(value: Array<ScrappingLinkDto>) {
        this.scrappingLinkService.items = value;
    }


}
