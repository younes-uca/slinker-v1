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

import { StatutWebSiteCreateAdminComponent } from './statut-web-site-admin/create-admin/statut-web-site-create-admin.component';
import { StatutWebSiteEditAdminComponent } from './statut-web-site-admin/edit-admin/statut-web-site-edit-admin.component';
import { StatutWebSiteViewAdminComponent } from './statut-web-site-admin/view-admin/statut-web-site-view-admin.component';
import { StatutWebSiteListAdminComponent } from './statut-web-site-admin/list-admin/statut-web-site-list-admin.component';
import { WebSiteCreateAdminComponent } from './web-site-admin/create-admin/web-site-create-admin.component';
import { WebSiteEditAdminComponent } from './web-site-admin/edit-admin/web-site-edit-admin.component';
import { WebSiteViewAdminComponent } from './web-site-admin/view-admin/web-site-view-admin.component';
import { WebSiteListAdminComponent } from './web-site-admin/list-admin/web-site-list-admin.component';

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

    StatutWebSiteCreateAdminComponent,
    StatutWebSiteListAdminComponent,
    StatutWebSiteViewAdminComponent,
    StatutWebSiteEditAdminComponent,
    WebSiteCreateAdminComponent,
    WebSiteListAdminComponent,
    WebSiteViewAdminComponent,
    WebSiteEditAdminComponent,
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
  StatutWebSiteCreateAdminComponent,
  StatutWebSiteListAdminComponent,
  StatutWebSiteViewAdminComponent,
  StatutWebSiteEditAdminComponent,
  WebSiteCreateAdminComponent,
  WebSiteListAdminComponent,
  WebSiteViewAdminComponent,
  WebSiteEditAdminComponent,
  ],
  entryComponents: [],
})
export class WebsiteAdminModule { }