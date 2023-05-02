
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { StatutNotificationListAdminComponent } from './statut-notification-admin/list-admin/statut-notification-list-admin.component';
import { NotificationListAdminComponent } from './notification-admin/list-admin/notification-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'statut-notification',
                            children: [
                                {
                                    path: 'list',
                                    component: StatutNotificationListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'notification',
                            children: [
                                {
                                    path: 'list',
                                    component: NotificationListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class NotificationAdminRoutingModule { }
