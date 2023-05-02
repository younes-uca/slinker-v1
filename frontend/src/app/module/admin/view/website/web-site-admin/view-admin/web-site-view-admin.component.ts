import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {WebSiteService} from 'src/app/controller/service/WebSite.service';
import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {WebSiteCriteria} from 'src/app/controller/criteria/WebSiteCriteria.model';

import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {StatutWebSiteDto} from 'src/app/controller/model/StatutWebSite.model';
import {StatutWebSiteService} from 'src/app/controller/service/StatutWebSite.service';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ScrappingLinkService} from 'src/app/controller/service/ScrappingLink.service';
@Component({
  selector: 'app-web-site-view-admin',
  templateUrl: './web-site-view-admin.component.html'
})
export class WebSiteViewAdminComponent extends AbstractViewController<WebSiteDto, WebSiteCriteria, WebSiteService> implements OnInit {

    scrappingLinks = new ScrappingLinkDto();
    scrappingLinkss: Array<ScrappingLinkDto> = [];

    constructor(private webSiteService: WebSiteService, private clientService: ClientService, private statutWebSiteService: StatutWebSiteService, private scrappingLinkService: ScrappingLinkService){
        super(webSiteService);
    }

    ngOnInit(): void {
        this.statutWebSite = new StatutWebSiteDto();
        this.statutWebSiteService.findAll().subscribe((data) => this.statutWebSites = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }


    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get statutWebSite(): StatutWebSiteDto {
       return this.statutWebSiteService.item;
    }
    set statutWebSite(value: StatutWebSiteDto) {
        this.statutWebSiteService.item = value;
    }
    get statutWebSites():Array<StatutWebSiteDto> {
       return this.statutWebSiteService.items;
    }
    set statutWebSites(value: Array<StatutWebSiteDto>) {
        this.statutWebSiteService.items = value;
    }


}
