
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';

@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {
                            path: 'login',
                            children: [
                                {
                                    path: '',
                                    component: LoginAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'register',
                            children: [
                                {
                                    path: '',
                                    component: RegisterAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {

                            path: 'notification',
                            loadChildren: () => import('./view/notification/notification-admin-routing.module').then(x=>x.NotificationAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'webSite',
                            loadChildren: () => import('./view/webSite/webSite-admin-routing.module').then(x=>x.WebSiteAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'website',
                            loadChildren: () => import('./view/website/website-admin-routing.module').then(x=>x.WebsiteAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'client',
                            loadChildren: () => import('./view/client/client-admin-routing.module').then(x=>x.ClientAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'subscription',
                            loadChildren: () => import('./view/subscription/subscription-admin-routing.module').then(x=>x.SubscriptionAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'article',
                            loadChildren: () => import('./view/article/article-admin-routing.module').then(x=>x.ArticleAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'scrapping',
                            loadChildren: () => import('./view/scrapping/scrapping-admin-routing.module').then(x=>x.ScrappingAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AdminRoutingModule { }
