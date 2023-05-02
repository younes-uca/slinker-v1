import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ScrappingLinkService} from 'src/app/controller/service/ScrappingLink.service';
import {ScrappingLinkDto} from 'src/app/controller/model/ScrappingLink.model';
import {ScrappingLinkCriteria} from 'src/app/controller/criteria/ScrappingLinkCriteria.model';


import {WebSiteDto} from 'src/app/controller/model/WebSite.model';
import {WebSiteService} from 'src/app/controller/service/WebSite.service';

@Component({
  selector: 'app-scrapping-link-edit-admin',
  templateUrl: './scrapping-link-edit-admin.component.html'
})
export class ScrappingLinkEditAdminComponent extends AbstractEditController<ScrappingLinkDto, ScrappingLinkCriteria, ScrappingLinkService>   implements OnInit {


    private _validScrappingLinkCode = true;
    private _validScrappingLinkLibelle = true;

    private _validWebSiteUrl = true;



    constructor( private scrappingLinkService: ScrappingLinkService , private webSiteService: WebSiteService) {
        super(scrappingLinkService);
    }

    ngOnInit(): void {
    this.webSite = new WebSiteDto();
    this.webSiteService.findAll().subscribe((data) => this.webSites = data);
}


    public setValidation(value : boolean){
        this.validScrappingLinkCode = value;
        this.validScrappingLinkLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateScrappingLinkCode();
        this.validateScrappingLinkLibelle();
    }
    public validateScrappingLinkCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validScrappingLinkCode = false;
        } else {
            this.validScrappingLinkCode = true;
        }
    }
    public validateScrappingLinkLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validScrappingLinkLibelle = false;
        } else {
            this.validScrappingLinkLibelle = true;
        }
    }




   get webSite(): WebSiteDto {
       return this.webSiteService.item;
   }
  set webSite(value: WebSiteDto) {
        this.webSiteService.item = value;
   }
   get webSites(): Array<WebSiteDto> {
        return this.webSiteService.items;
   }
   set webSites(value: Array<WebSiteDto>) {
        this.webSiteService.items = value;
   }
   get createWebSiteDialog(): boolean {
       return this.webSiteService.createDialog;
   }
  set createWebSiteDialog(value: boolean) {
       this.webSiteService.createDialog= value;
   }


    get validScrappingLinkCode(): boolean {
        return this._validScrappingLinkCode;
    }
    set validScrappingLinkCode(value: boolean) {
        this._validScrappingLinkCode = value;
    }
    get validScrappingLinkLibelle(): boolean {
        return this._validScrappingLinkLibelle;
    }
    set validScrappingLinkLibelle(value: boolean) {
        this._validScrappingLinkLibelle = value;
    }

    get validWebSiteUrl(): boolean {
        return this._validWebSiteUrl;
    }
    set validWebSiteUrl(value: boolean) {
        this._validWebSiteUrl = value;
    }
}
