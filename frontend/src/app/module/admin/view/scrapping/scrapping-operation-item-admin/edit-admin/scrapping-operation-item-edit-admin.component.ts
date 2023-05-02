import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-scrapping-operation-item-edit-admin',
  templateUrl: './scrapping-operation-item-edit-admin.component.html'
})
export class ScrappingOperationItemEditAdminComponent extends AbstractEditController<ScrappingOperationItemDto, ScrappingOperationItemCriteria, ScrappingOperationItemService>   implements OnInit {



    private _validScrappingLinkCode = true;
    private _validScrappingLinkLibelle = true;
    private _validTypeProduitCode = true;
    private _validTypeProduitLibelle = true;
    private _validScrappingOperationDateDebutScrappingOperation = true;



    constructor( private scrappingOperationItemService: ScrappingOperationItemService , private typeProduitService: TypeProduitService, private scrappingLinkService: ScrappingLinkService, private scrappingOperationService: ScrappingOperationService) {
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


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateScrappingOperation(scrappingOperation: string) {
        const isPermistted = await this.roleService.isPermitted('ScrappingOperation', 'edit');
        if(isPermistted) {
             this.scrappingOperation = new ScrappingOperationDto();
             this.createScrappingOperationDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateTypeProduit(typeProduit: string) {
        const isPermistted = await this.roleService.isPermitted('TypeProduit', 'edit');
        if(isPermistted) {
             this.typeProduit = new TypeProduitDto();
             this.createTypeProduitDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get scrappingOperation(): ScrappingOperationDto {
       return this.scrappingOperationService.item;
   }
  set scrappingOperation(value: ScrappingOperationDto) {
        this.scrappingOperationService.item = value;
   }
   get scrappingOperations(): Array<ScrappingOperationDto> {
        return this.scrappingOperationService.items;
   }
   set scrappingOperations(value: Array<ScrappingOperationDto>) {
        this.scrappingOperationService.items = value;
   }
   get createScrappingOperationDialog(): boolean {
       return this.scrappingOperationService.createDialog;
   }
  set createScrappingOperationDialog(value: boolean) {
       this.scrappingOperationService.createDialog= value;
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
    get validTypeProduitCode(): boolean {
        return this._validTypeProduitCode;
    }
    set validTypeProduitCode(value: boolean) {
        this._validTypeProduitCode = value;
    }
    get validTypeProduitLibelle(): boolean {
        return this._validTypeProduitLibelle;
    }
    set validTypeProduitLibelle(value: boolean) {
        this._validTypeProduitLibelle = value;
    }
    get validScrappingOperationDateDebutScrappingOperation(): boolean {
        return this._validScrappingOperationDateDebutScrappingOperation;
    }
    set validScrappingOperationDateDebutScrappingOperation(value: boolean) {
        this._validScrappingOperationDateDebutScrappingOperation = value;
    }
}
