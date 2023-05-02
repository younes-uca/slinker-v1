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

import { SubscriptionPackCreateAdminComponent } from './subscription-pack-admin/create-admin/subscription-pack-create-admin.component';
import { SubscriptionPackEditAdminComponent } from './subscription-pack-admin/edit-admin/subscription-pack-edit-admin.component';
import { SubscriptionPackViewAdminComponent } from './subscription-pack-admin/view-admin/subscription-pack-view-admin.component';
import { SubscriptionPackListAdminComponent } from './subscription-pack-admin/list-admin/subscription-pack-list-admin.component';
import { SubscriptionTypeCreateAdminComponent } from './subscription-type-admin/create-admin/subscription-type-create-admin.component';
import { SubscriptionTypeEditAdminComponent } from './subscription-type-admin/edit-admin/subscription-type-edit-admin.component';
import { SubscriptionTypeViewAdminComponent } from './subscription-type-admin/view-admin/subscription-type-view-admin.component';
import { SubscriptionTypeListAdminComponent } from './subscription-type-admin/list-admin/subscription-type-list-admin.component';
import { SubscriptionEtatCreateAdminComponent } from './subscription-etat-admin/create-admin/subscription-etat-create-admin.component';
import { SubscriptionEtatEditAdminComponent } from './subscription-etat-admin/edit-admin/subscription-etat-edit-admin.component';
import { SubscriptionEtatViewAdminComponent } from './subscription-etat-admin/view-admin/subscription-etat-view-admin.component';
import { SubscriptionEtatListAdminComponent } from './subscription-etat-admin/list-admin/subscription-etat-list-admin.component';
import { TypePaiementCreateAdminComponent } from './type-paiement-admin/create-admin/type-paiement-create-admin.component';
import { TypePaiementEditAdminComponent } from './type-paiement-admin/edit-admin/type-paiement-edit-admin.component';
import { TypePaiementViewAdminComponent } from './type-paiement-admin/view-admin/type-paiement-view-admin.component';
import { TypePaiementListAdminComponent } from './type-paiement-admin/list-admin/type-paiement-list-admin.component';
import { SubscriptionCreateAdminComponent } from './subscription-admin/create-admin/subscription-create-admin.component';
import { SubscriptionEditAdminComponent } from './subscription-admin/edit-admin/subscription-edit-admin.component';
import { SubscriptionViewAdminComponent } from './subscription-admin/view-admin/subscription-view-admin.component';
import { SubscriptionListAdminComponent } from './subscription-admin/list-admin/subscription-list-admin.component';

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

    SubscriptionPackCreateAdminComponent,
    SubscriptionPackListAdminComponent,
    SubscriptionPackViewAdminComponent,
    SubscriptionPackEditAdminComponent,
    SubscriptionTypeCreateAdminComponent,
    SubscriptionTypeListAdminComponent,
    SubscriptionTypeViewAdminComponent,
    SubscriptionTypeEditAdminComponent,
    SubscriptionEtatCreateAdminComponent,
    SubscriptionEtatListAdminComponent,
    SubscriptionEtatViewAdminComponent,
    SubscriptionEtatEditAdminComponent,
    TypePaiementCreateAdminComponent,
    TypePaiementListAdminComponent,
    TypePaiementViewAdminComponent,
    TypePaiementEditAdminComponent,
    SubscriptionCreateAdminComponent,
    SubscriptionListAdminComponent,
    SubscriptionViewAdminComponent,
    SubscriptionEditAdminComponent,
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
  SubscriptionPackCreateAdminComponent,
  SubscriptionPackListAdminComponent,
  SubscriptionPackViewAdminComponent,
  SubscriptionPackEditAdminComponent,
  SubscriptionTypeCreateAdminComponent,
  SubscriptionTypeListAdminComponent,
  SubscriptionTypeViewAdminComponent,
  SubscriptionTypeEditAdminComponent,
  SubscriptionEtatCreateAdminComponent,
  SubscriptionEtatListAdminComponent,
  SubscriptionEtatViewAdminComponent,
  SubscriptionEtatEditAdminComponent,
  TypePaiementCreateAdminComponent,
  TypePaiementListAdminComponent,
  TypePaiementViewAdminComponent,
  TypePaiementEditAdminComponent,
  SubscriptionCreateAdminComponent,
  SubscriptionListAdminComponent,
  SubscriptionViewAdminComponent,
  SubscriptionEditAdminComponent,
  ],
  entryComponents: [],
})
export class SubscriptionAdminModule { }