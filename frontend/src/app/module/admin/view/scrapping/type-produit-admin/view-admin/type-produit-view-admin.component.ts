import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypeProduitService} from 'src/app/controller/service/TypeProduit.service';
import {TypeProduitDto} from 'src/app/controller/model/TypeProduit.model';
import {TypeProduitCriteria} from 'src/app/controller/criteria/TypeProduitCriteria.model';

@Component({
  selector: 'app-type-produit-view-admin',
  templateUrl: './type-produit-view-admin.component.html'
})
export class TypeProduitViewAdminComponent extends AbstractViewController<TypeProduitDto, TypeProduitCriteria, TypeProduitService> implements OnInit {


    constructor(private typeProduitService: TypeProduitService){
        super(typeProduitService);
    }

    ngOnInit(): void {
    }




}
