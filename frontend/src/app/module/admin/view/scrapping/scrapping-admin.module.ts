import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';

import { ScrappingOperationItemCreateAdminComponent } from './scrapping-operation-item-admin/create-admin/scrapping-operation-item-create-admin.component';
import { ScrappingOperationItemEditAdminComponent } from './scrapping-operation-item-admin/edit-admin/scrapping-operation-item-edit-admin.component';
import { ScrappingOperationItemViewAdminComponent } from './scrapping-operation-item-admin/view-admin/scrapping-operation-item-view-admin.component';
import { ScrappingOperationItemListAdminComponent } from './scrapping-operation-item-admin/list-admin/scrapping-operation-item-list-admin.component';
import { ScrappingOperationCreateAdminComponent } from './scrapping-operation-admin/create-admin/scrapping-operation-create-admin.component';
import { ScrappingOperationEditAdminComponent } from './scrapping-operation-admin/edit-admin/scrapping-operation-edit-admin.component';
import { ScrappingOperationViewAdminComponent } from './scrapping-operation-admin/view-admin/scrapping-operation-view-admin.component';
import { ScrappingOperationListAdminComponent } from './scrapping-operation-admin/list-admin/scrapping-operation-list-admin.component';
import { TypeProduitCreateAdminComponent } from './type-produit-admin/create-admin/type-produit-create-admin.component';
import { TypeProduitEditAdminComponent } from './type-produit-admin/edit-admin/type-produit-edit-admin.component';
import { TypeProduitViewAdminComponent } from './type-produit-admin/view-admin/type-produit-view-admin.component';
import { TypeProduitListAdminComponent } from './type-produit-admin/list-admin/type-produit-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    ScrappingOperationItemCreateAdminComponent,
    ScrappingOperationItemListAdminComponent,
    ScrappingOperationItemViewAdminComponent,
    ScrappingOperationItemEditAdminComponent,
    ScrappingOperationCreateAdminComponent,
    ScrappingOperationListAdminComponent,
    ScrappingOperationViewAdminComponent,
    ScrappingOperationEditAdminComponent,
    TypeProduitCreateAdminComponent,
    TypeProduitListAdminComponent,
    TypeProduitViewAdminComponent,
    TypeProduitEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
  ],
  exports: [
  ScrappingOperationItemCreateAdminComponent,
  ScrappingOperationItemListAdminComponent,
  ScrappingOperationItemViewAdminComponent,
  ScrappingOperationItemEditAdminComponent,
  ScrappingOperationCreateAdminComponent,
  ScrappingOperationListAdminComponent,
  ScrappingOperationViewAdminComponent,
  ScrappingOperationEditAdminComponent,
  TypeProduitCreateAdminComponent,
  TypeProduitListAdminComponent,
  TypeProduitViewAdminComponent,
  TypeProduitEditAdminComponent,
  ],
  entryComponents: [],
})
export class ScrappingAdminModule { }