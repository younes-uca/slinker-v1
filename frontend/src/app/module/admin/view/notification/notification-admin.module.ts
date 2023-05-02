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

import { StatutNotificationCreateAdminComponent } from './statut-notification-admin/create-admin/statut-notification-create-admin.component';
import { StatutNotificationEditAdminComponent } from './statut-notification-admin/edit-admin/statut-notification-edit-admin.component';
import { StatutNotificationViewAdminComponent } from './statut-notification-admin/view-admin/statut-notification-view-admin.component';
import { StatutNotificationListAdminComponent } from './statut-notification-admin/list-admin/statut-notification-list-admin.component';
import { NotificationCreateAdminComponent } from './notification-admin/create-admin/notification-create-admin.component';
import { NotificationEditAdminComponent } from './notification-admin/edit-admin/notification-edit-admin.component';
import { NotificationViewAdminComponent } from './notification-admin/view-admin/notification-view-admin.component';
import { NotificationListAdminComponent } from './notification-admin/list-admin/notification-list-admin.component';

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

    StatutNotificationCreateAdminComponent,
    StatutNotificationListAdminComponent,
    StatutNotificationViewAdminComponent,
    StatutNotificationEditAdminComponent,
    NotificationCreateAdminComponent,
    NotificationListAdminComponent,
    NotificationViewAdminComponent,
    NotificationEditAdminComponent,
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
  StatutNotificationCreateAdminComponent,
  StatutNotificationListAdminComponent,
  StatutNotificationViewAdminComponent,
  StatutNotificationEditAdminComponent,
  NotificationCreateAdminComponent,
  NotificationListAdminComponent,
  NotificationViewAdminComponent,
  NotificationEditAdminComponent,
  ],
  entryComponents: [],
})
export class NotificationAdminModule { }