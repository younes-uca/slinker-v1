
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { StatutWebSiteListAdminComponent } from './statut-web-site-admin/list-admin/statut-web-site-list-admin.component';
import { WebSiteListAdminComponent } from './web-site-admin/list-admin/web-site-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'statut-web-site',
                            children: [
                                {
                                    path: 'list',
                                    component: StatutWebSiteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'web-site',
                            children: [
                                {
                                    path: 'list',
                                    component: WebSiteListAdminComponent ,
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
export class WebsiteAdminRoutingModule { }
