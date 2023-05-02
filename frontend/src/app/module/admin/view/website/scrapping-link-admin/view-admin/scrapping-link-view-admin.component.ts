import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ScrappingLinkService} from 'src/app/controller/service/ScrappingLink.service';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ScrappingLinkCriteria} from 'src/app/controller/criteria/ScrappingLinkCriteria.model';

import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {WebSiteService} from 'src/app/controller/service/WebSite.service';
@Component({
  selector: 'app-scrapping-link-view-admin',
  templateUrl: './scrapping-link-view-admin.component.html'
})
export class ScrappingLinkViewAdminComponent extends AbstractViewController<ScrappingLinkDto, ScrappingLinkCriteria, ScrappingLinkService> implements OnInit {


    constructor(private scrappingLinkService: ScrappingLinkService, private webSiteService: WebSiteService){
        super(scrappingLinkService);
    }

    ngOnInit(): void {
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


}
