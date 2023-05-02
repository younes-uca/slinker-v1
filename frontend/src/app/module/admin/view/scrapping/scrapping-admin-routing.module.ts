
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ScrappingOperationItemListAdminComponent } from './scrapping-operation-item-admin/list-admin/scrapping-operation-item-list-admin.component';
import { ScrappingOperationListAdminComponent } from './scrapping-operation-admin/list-admin/scrapping-operation-list-admin.component';
import { TypeProduitListAdminComponent } from './type-produit-admin/list-admin/type-produit-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'scrapping-operation-item',
                            children: [
                                {
                                    path: 'list',
                                    component: ScrappingOperationItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'scrapping-operation',
                            children: [
                                {
                                    path: 'list',
                                    component: ScrappingOperationListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-produit',
                            children: [
                                {
                                    path: 'list',
                                    component: TypeProduitListAdminComponent ,
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
export class ScrappingAdminRoutingModule { }
