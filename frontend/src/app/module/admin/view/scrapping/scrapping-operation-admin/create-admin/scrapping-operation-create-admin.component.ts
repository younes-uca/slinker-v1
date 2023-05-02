import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-scrapping-operation-create-admin',
  templateUrl: './scrapping-operation-create-admin.component.html'
})
export class ScrappingOperationCreateAdminComponent extends AbstractCreateController<ScrappingOperationDto, ScrappingOperationCriteria, ScrappingOperationService>  implements OnInit {

    private _scrappingOperationItemsElement = new ScrappingOperationItemDto();


   private _validScrappingOperationDateDebutScrappingOperation = true;
    private _validAffliateCode = true;
    private _validAffliateLibelle = true;
    private _validWebSiteUrl = true;

    constructor( private scrappingOperationService: ScrappingOperationService , private typeProduitService: TypeProduitService, private affliateService: AffliateService, private webSiteService: WebSiteService, private scrappingOperationItemService: ScrappingOperationItemService, private scrappingLinkService: ScrappingLinkService) {
        super(scrappingOperationService);
    }

    ngOnInit(): void {
        this.scrappingOperationItemsElement.scrappingLink = new ScrappingLinkDto();
        this.scrappingLinkService.findAll().subscribe((data) => this.scrappingLinks = data);
        this.scrappingOperationItemsElement.typeProduit = new TypeProduitDto();
        this.typeProduitService.findAll().subscribe((data) => this.typeProduits = data);
    this.affliate = new AffliateDto();
    this.affliateService.findAll().subscribe((data) => this.affliates = data);
    this.webSite = new WebSiteDto();
    this.webSiteService.findAll().subscribe((data) => this.webSites = data);
}



    validateScrappingOperationItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
        this.validScrappingOperationDateDebutScrappingOperation = value;
    }

    public addScrappingOperationItems() {
        if( this.item.scrappingOperationItems == null )
            this.item.scrappingOperationItems = new Array<ScrappingOperationItemDto>();
       this.validateScrappingOperationItems();
       if (this.errorMessages.length === 0) {
              this.item.scrappingOperationItems.push({... this.scrappingOperationItemsElement});
              this.scrappingOperationItemsElement = new ScrappingOperationItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteScrappingOperationItem(p: ScrappingOperationItemDto) {
        this.item.scrappingOperationItems.forEach((element, index) => {
            if (element === p) { this.item.scrappingOperationItems.splice(index, 1); }
        });
    }

    public editScrappingOperationItem(p: ScrappingOperationItemDto) {
        this.scrappingOperationItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateScrappingOperationDateDebutScrappingOperation();
    }

    public validateScrappingOperationDateDebutScrappingOperation(){
        if (this.stringUtilService.isEmpty(this.item.dateDebutScrappingOperation)) {
        this.errorMessages.push('Date debut scrapping operation non valide');
        this.validScrappingOperationDateDebutScrappingOperation = false;
        } else {
            this.validScrappingOperationDateDebutScrappingOperation = true;
        }
    }


    public async openCreateTypeProduit(typeProduit: string) {
    const isPermistted = await this.roleService.isPermitted('TypeProduit', 'add');
    if(isPermistted) {
         this.typeProduit = new TypeProduitDto();
         this.createTypeProduitDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
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
    get affliate(): AffliateDto {
        return this.affliateService.item;
    }
    set affliate(value: AffliateDto) {
        this.affliateService.item = value;
    }
    get affliates(): Array<AffliateDto> {
        return this.affliateService.items;
    }
    set affliates(value: Array<AffliateDto>) {
        this.affliateService.items = value;
    }
    get createAffliateDialog(): boolean {
       return this.affliateService.createDialog;
    }
    set createAffliateDialog(value: boolean) {
        this.affliateService.createDialog= value;
    }
    get typeProduit(): TypeProduitDto {
        return this.typeProduitService.item;
    }
    set typeProduit(value: TypeProduitDto) {
        this.typeProduitService.item = value;
    }
    get typeProduits(): Array<TypeProduitDto> {
        return this.typeProduitService.items;
    }
    set typeProduits(value: Array<TypeProduitDto>) {
        this.typeProduitService.items = value;
    }
    get createTypeProduitDialog(): boolean {
       return this.typeProduitService.createDialog;
    }
    set createTypeProduitDialog(value: boolean) {
        this.typeProduitService.createDialog= value;
    }
    get scrappingLink(): ScrappingLinkDto {
        return this.scrappingLinkService.item;
    }
    set scrappingLink(value: ScrappingLinkDto) {
        this.scrappingLinkService.item = value;
    }
    get scrappingLinks(): Array<ScrappingLinkDto> {
        return this.scrappingLinkService.items;
    }
    set scrappingLinks(value: Array<ScrappingLinkDto>) {
        this.scrappingLinkService.items = value;
    }
    get createScrappingLinkDialog(): boolean {
       return this.scrappingLinkService.createDialog;
    }
    set createScrappingLinkDialog(value: boolean) {
        this.scrappingLinkService.createDialog= value;
    }



    get validScrappingOperationDateDebutScrappingOperation(): boolean {
        return this._validScrappingOperationDateDebutScrappingOperation;
    }

    set validScrappingOperationDateDebutScrappingOperation(value: boolean) {
         this._validScrappingOperationDateDebutScrappingOperation = value;
    }

    get validAffliateCode(): boolean {
        return this._validAffliateCode;
    }
    set validAffliateCode(value: boolean) {
        this._validAffliateCode = value;
    }
    get validAffliateLibelle(): boolean {
        return this._validAffliateLibelle;
    }
    set validAffliateLibelle(value: boolean) {
        this._validAffliateLibelle = value;
    }
    get validWebSiteUrl(): boolean {
        return this._validWebSiteUrl;
    }
    set validWebSiteUrl(value: boolean) {
        this._validWebSiteUrl = value;
    }

    get scrappingOperationItemsElement(): ScrappingOperationItemDto {
        if( this._scrappingOperationItemsElement == null )
            this._scrappingOperationItemsElement = new ScrappingOperationItemDto();
        return this._scrappingOperationItemsElement;
    }

    set scrappingOperationItemsElement(value: ScrappingOperationItemDto) {
        this._scrappingOperationItemsElement = value;
    }

}
