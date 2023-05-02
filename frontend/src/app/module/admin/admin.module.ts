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
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import { NotificationAdminModule } from './view/notification/notification-admin.module';
import { NotificationAdminRoutingModule } from './view/notification/notification-admin-routing.module';
import { WebSiteAdminModule } from './view/webSite/webSite-admin.module';
import { WebSiteAdminRoutingModule } from './view/webSite/webSite-admin-routing.module';
import { WebsiteAdminModule } from './view/website/website-admin.module';
import { WebsiteAdminRoutingModule } from './view/website/website-admin-routing.module';
import { ClientAdminModule } from './view/client/client-admin.module';
import { ClientAdminRoutingModule } from './view/client/client-admin-routing.module';
import { SubscriptionAdminModule } from './view/subscription/subscription-admin.module';
import { SubscriptionAdminRoutingModule } from './view/subscription/subscription-admin-routing.module';
import { ArticleAdminModule } from './view/article/article-admin.module';
import { ArticleAdminRoutingModule } from './view/article/article-admin-routing.module';
import { ScrappingAdminModule } from './view/scrapping/scrapping-admin.module';
import { ScrappingAdminRoutingModule } from './view/scrapping/scrapping-admin-routing.module';


import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';


@NgModule({
  declarations: [
   LoginAdminComponent,
   RegisterAdminComponent
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
  NotificationAdminModule,
  NotificationAdminRoutingModule,
  WebSiteAdminModule,
  WebSiteAdminRoutingModule,
  WebsiteAdminModule,
  WebsiteAdminRoutingModule,
  ClientAdminModule,
  ClientAdminRoutingModule,
  SubscriptionAdminModule,
  SubscriptionAdminRoutingModule,
  ArticleAdminModule,
  ArticleAdminRoutingModule,
  ScrappingAdminModule,
  ScrappingAdminRoutingModule,
  ],
  exports: [
  LoginAdminComponent,
  RegisterAdminComponent,

    NotificationAdminModule,
    WebSiteAdminModule,
    WebsiteAdminModule,
    ClientAdminModule,
    SubscriptionAdminModule,
    ArticleAdminModule,
    ScrappingAdminModule,
  ],
  entryComponents: [],
})
export class AdminModule { }
