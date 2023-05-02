import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypePaiementService} from 'src/app/controller/service/TypePaiement.service';
import {TypePaiementDto} from 'src/app/controller/model/TypePaiement.model';
import {TypePaiementCriteria} from 'src/app/controller/criteria/TypePaiementCriteria.model';

@Component({
  selector: 'app-type-paiement-view-admin',
  templateUrl: './type-paiement-view-admin.component.html'
})
export class TypePaiementViewAdminComponent extends AbstractViewController<TypePaiementDto, TypePaiementCriteria, TypePaiementService> implements OnInit {


    constructor(private typePaiementService: TypePaiementService){
        super(typePaiementService);
    }

    ngOnInit(): void {
    }




}
