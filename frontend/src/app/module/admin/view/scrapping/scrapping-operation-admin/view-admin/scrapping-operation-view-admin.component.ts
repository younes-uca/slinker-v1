import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ScrappingOperationService} from 'src/app/controller/service/ScrappingOperation.service';
import {ScrappingOperationDto} from 'src/app/controller/model/ScrappingOperation.model';
import {ScrappingOperationCriteria} from 'src/app/controller/criteria/ScrappingOperationCriteria.model';

import {TypeProduitDto} from 'src/app/controller/model/TypeProduit.model';
import {TypeProduitService} from 'src/app/controller/service/TypeProduit.service';
import {AffliateDto} from 'src/app/controller/model/Affliate.model';
import {AffliateService} from 'src/app/controller/service/Affliate.service';
import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {WebSiteService} from 'src/app/controller/service/WebSite.service';
import {ScrappingOperationItemDto} from 'src/app/controller/model/ScrappingOperationItem.model';
import {ScrappingOperationItemService} from 'src/app/controller/service/ScrappingOperationItem.service';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ScrappingLinkService} from 'src/app/controller/service/ScrappingLink.service';
@Component({
  selector: 'app-scrapping-operation-view-admin',
  templateUrl: './scrapping-operation-view-admin.component.html'
})
export class ScrappingOperationViewAdminComponent extends AbstractViewController<ScrappingOperationDto, ScrappingOperationCriteria, ScrappingOperationService> implements OnInit {

    scrappingOperationItems = new ScrappingOperationItemDto();
    scrappingOperationItemss: Array<ScrappingOperationItemDto> = [];

    constructor(private scrappingOperationService: ScrappingOperationService, private typeProduitService: TypeProduitService, private affliateService: AffliateService, private webSiteService: WebSiteService, private scrappingOperationItemService: ScrappingOperationItemService, private scrappingLinkService: ScrappingLinkService){
        super(scrappingOperationService);
    }

    ngOnInit(): void {
        this.scrappingOperationItems.scrappingLink = new ScrappingLinkDto();
        this.scrappingLinkService.findAll().subscribe((data) => this.scrappingLinks = data);
        this.scrappingOperationItems.typeProduit = new TypeProduitDto();
        this.typeProduitService.findAll().subscribe((data) => this.typeProduits = data);
        this.affliate = new AffliateDto();
        this.affliateService.findAll().subscribe((data) => this.affliates = data);
        this.webSite = new WebSiteDto();
        this.webSiteService.findAll().subscribe((data) => this.webSites = data);
    }


    get webSite(): WebSiteDto {
       return this.webSiteService.item;
    }
    set webSite(value: WebSiteDto) {
        this.webSiteService.item = value;
    }
    get webSites():Array<WebSiteDto> {
       return this.webSiteService.items;
    }
    set webSites(value: Array<WebSiteDto>) {
        this.webSiteService.items = value;
    }
    get affliate(): AffliateDto {
       return this.affliateService.item;
    }
    set affliate(value: AffliateDto) {
        this.affliateService.item = value;
    }
    get affliates():Array<AffliateDto> {
       return this.affliateService.items;
    }
    set affliates(value: Array<AffliateDto>) {
        this.affliateService.items = value;
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
