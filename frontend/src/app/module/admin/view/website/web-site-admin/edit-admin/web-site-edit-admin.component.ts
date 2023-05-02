import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-web-site-edit-admin',
  templateUrl: './web-site-edit-admin.component.html'
})
export class WebSiteEditAdminComponent extends AbstractEditController<WebSiteDto, WebSiteCriteria, WebSiteService>   implements OnInit {

    private _scrappingLinksElement = new ScrappingLinkDto();

    private _validWebSiteUrl = true;

    private _validStatutWebSiteCode = true;
    private _validStatutWebSiteLibelle = true;
    private _validScrappingLinksCode = true;
    private _validScrappingLinksLibelle = true;
    private _validClientNom = true;
    private _validClientPrenom = true;
    private _validClientPassword = true;
    private _validClientEmail = true;



    constructor( private webSiteService: WebSiteService , private clientService: ClientService, private statutWebSiteService: StatutWebSiteService, private scrappingLinkService: ScrappingLinkService) {
        super(webSiteService);
    }

    ngOnInit(): void {

    this.statutWebSite = new StatutWebSiteDto();
    this.statutWebSiteService.findAll().subscribe((data) => this.statutWebSites = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
}


    public validateScrappingLinks(){
        this.errorMessages = new Array();
        this.validateScrappingLinksCode();
        this.validateScrappingLinksLibelle();
    }
    public setValidation(value : boolean){
        this.validWebSiteUrl = value;
        this.validScrappingLinksCode = value;
        this.validScrappingLinksLibelle = value;
        }
   public addScrappingLinks() {
        if( this.item.scrappingLinks == null )
            this.item.scrappingLinks = new Array<ScrappingLinkDto>();
       this.validateScrappingLinks();
       if (this.errorMessages.length === 0) {
            if(this.scrappingLinksElement.id == null){
                this.item.scrappingLinks.push(this.scrappingLinksElement);
            }else{
                const index = this.item.scrappingLinks.findIndex(e => e.id == this.scrappingLinksElement.id);
                this.item.scrappingLinks[index] = this.scrappingLinksElement;
            }
          this.scrappingLinksElement = new ScrappingLinkDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteScrappingLink(p: ScrappingLinkDto) {
        this.item.scrappingLinks.forEach((element, index) => {
            if (element === p) { this.item.scrappingLinks.splice(index, 1); }
        });
    }

    public editScrappingLink(p: ScrappingLinkDto) {
        this.scrappingLinksElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateWebSiteUrl();
    }
    public validateWebSiteUrl(){
        if (this.stringUtilService.isEmpty(this.item.url)) {
            this.errorMessages.push('Url non valide');
            this.validWebSiteUrl = false;
        } else {
            this.validWebSiteUrl = true;
        }
    }


    private validateScrappingLinksCode(){
        if (this.scrappingLinksElement.code == null) {
        this.errorMessages.push('Code de la scrappingLink est  invalide');
            this.validScrappingLinksCode = false;
        } else {
            this.validScrappingLinksCode = true;
        }
    }
    private validateScrappingLinksLibelle(){
        if (this.scrappingLinksElement.libelle == null) {
        this.errorMessages.push('Libelle de la scrappingLink est  invalide');
            this.validScrappingLinksLibelle = false;
        } else {
            this.validScrappingLinksLibelle = true;
        }
    }

   public async openCreateStatutWebSite(statutWebSite: string) {
        const isPermistted = await this.roleService.isPermitted('StatutWebSite', 'edit');
        if(isPermistted) {
             this.statutWebSite = new StatutWebSiteDto();
             this.createStatutWebSiteDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get client(): ClientDto {
       return this.clientService.item;
   }
  set client(value: ClientDto) {
        this.clientService.item = value;
   }
   get clients(): Array<ClientDto> {
        return this.clientService.items;
   }
   set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
   }
   get createClientDialog(): boolean {
       return this.clientService.createDialog;
   }
  set createClientDialog(value: boolean) {
       this.clientService.createDialog= value;
   }
   get statutWebSite(): StatutWebSiteDto {
       return this.statutWebSiteService.item;
   }
  set statutWebSite(value: StatutWebSiteDto) {
        this.statutWebSiteService.item = value;
   }
   get statutWebSites(): Array<StatutWebSiteDto> {
        return this.statutWebSiteService.items;
   }
   set statutWebSites(value: Array<StatutWebSiteDto>) {
        this.statutWebSiteService.items = value;
   }
   get createStatutWebSiteDialog(): boolean {
       return this.statutWebSiteService.createDialog;
   }
  set createStatutWebSiteDialog(value: boolean) {
       this.statutWebSiteService.createDialog= value;
   }

    get scrappingLinksElement(): ScrappingLinkDto {
        if( this._scrappingLinksElement == null )
            this._scrappingLinksElement = new ScrappingLinkDto();
         return this._scrappingLinksElement;
    }

    set scrappingLinksElement(value: ScrappingLinkDto) {
        this._scrappingLinksElement = value;
    }

    get validWebSiteUrl(): boolean {
        return this._validWebSiteUrl;
    }
    set validWebSiteUrl(value: boolean) {
        this._validWebSiteUrl = value;
    }

    get validStatutWebSiteCode(): boolean {
        return this._validStatutWebSiteCode;
    }
    set validStatutWebSiteCode(value: boolean) {
        this._validStatutWebSiteCode = value;
    }
    get validStatutWebSiteLibelle(): boolean {
        return this._validStatutWebSiteLibelle;
    }
    set validStatutWebSiteLibelle(value: boolean) {
        this._validStatutWebSiteLibelle = value;
    }
    get validScrappingLinksCode(): boolean {
        return this._validScrappingLinksCode;
    }
    set validScrappingLinksCode(value: boolean) {
        this._validScrappingLinksCode = value;
    }
    get validScrappingLinksLibelle(): boolean {
        return this._validScrappingLinksLibelle;
    }
    set validScrappingLinksLibelle(value: boolean) {
        this._validScrappingLinksLibelle = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }
    get validClientPrenom(): boolean {
        return this._validClientPrenom;
    }
    set validClientPrenom(value: boolean) {
        this._validClientPrenom = value;
    }
    get validClientPassword(): boolean {
        return this._validClientPassword;
    }
    set validClientPassword(value: boolean) {
        this._validClientPassword = value;
    }
    get validClientEmail(): boolean {
        return this._validClientEmail;
    }
    set validClientEmail(value: boolean) {
        this._validClientEmail = value;
    }
}
