
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ClientListAdminComponent } from './client-admin/list-admin/client-list-admin.component';
import { AffliateListAdminComponent } from './affliate-admin/list-admin/affliate-list-admin.component';
import { StatutClientListAdminComponent } from './statut-client-admin/list-admin/statut-client-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'client',
                            children: [
                                {
                                    path: 'list',
                                    component: ClientListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'affliate',
                            children: [
                                {
                                    path: 'list',
                                    component: AffliateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'statut-client',
                            children: [
                                {
                                    path: 'list',
                                    component: StatutClientListAdminComponent ,
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
export class ClientAdminRoutingModule { }
