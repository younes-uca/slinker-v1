
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { SubscriptionPackListAdminComponent } from './subscription-pack-admin/list-admin/subscription-pack-list-admin.component';
import { SubscriptionTypeListAdminComponent } from './subscription-type-admin/list-admin/subscription-type-list-admin.component';
import { SubscriptionEtatListAdminComponent } from './subscription-etat-admin/list-admin/subscription-etat-list-admin.component';
import { TypePaiementListAdminComponent } from './type-paiement-admin/list-admin/type-paiement-list-admin.component';
import { SubscriptionListAdminComponent } from './subscription-admin/list-admin/subscription-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'subscription-pack',
                            children: [
                                {
                                    path: 'list',
                                    component: SubscriptionPackListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'subscription-type',
                            children: [
                                {
                                    path: 'list',
                                    component: SubscriptionTypeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'subscription-etat',
                            children: [
                                {
                                    path: 'list',
                                    component: SubscriptionEtatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-paiement',
                            children: [
                                {
                                    path: 'list',
                                    component: TypePaiementListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'subscription',
                            children: [
                                {
                                    path: 'list',
                                    component: SubscriptionListAdminComponent ,
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
export class SubscriptionAdminRoutingModule { }
