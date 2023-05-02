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

import { ClientCreateAdminComponent } from './client-admin/create-admin/client-create-admin.component';
import { ClientEditAdminComponent } from './client-admin/edit-admin/client-edit-admin.component';
import { ClientViewAdminComponent } from './client-admin/view-admin/client-view-admin.component';
import { ClientListAdminComponent } from './client-admin/list-admin/client-list-admin.component';
import { AffliateCreateAdminComponent } from './affliate-admin/create-admin/affliate-create-admin.component';
import { AffliateEditAdminComponent } from './affliate-admin/edit-admin/affliate-edit-admin.component';
import { AffliateViewAdminComponent } from './affliate-admin/view-admin/affliate-view-admin.component';
import { AffliateListAdminComponent } from './affliate-admin/list-admin/affliate-list-admin.component';
import { StatutClientCreateAdminComponent } from './statut-client-admin/create-admin/statut-client-create-admin.component';
import { StatutClientEditAdminComponent } from './statut-client-admin/edit-admin/statut-client-edit-admin.component';
import { StatutClientViewAdminComponent } from './statut-client-admin/view-admin/statut-client-view-admin.component';
import { StatutClientListAdminComponent } from './statut-client-admin/list-admin/statut-client-list-admin.component';

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

    ClientCreateAdminComponent,
    ClientListAdminComponent,
    ClientViewAdminComponent,
    ClientEditAdminComponent,
    AffliateCreateAdminComponent,
    AffliateListAdminComponent,
    AffliateViewAdminComponent,
    AffliateEditAdminComponent,
    StatutClientCreateAdminComponent,
    StatutClientListAdminComponent,
    StatutClientViewAdminComponent,
    StatutClientEditAdminComponent,
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
  ClientCreateAdminComponent,
  ClientListAdminComponent,
  ClientViewAdminComponent,
  ClientEditAdminComponent,
  AffliateCreateAdminComponent,
  AffliateListAdminComponent,
  AffliateViewAdminComponent,
  AffliateEditAdminComponent,
  StatutClientCreateAdminComponent,
  StatutClientListAdminComponent,
  StatutClientViewAdminComponent,
  StatutClientEditAdminComponent,
  ],
  entryComponents: [],
})
export class ClientAdminModule { }