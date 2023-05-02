import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SubscriptionEtatService} from 'src/app/controller/service/SubscriptionEtat.service';
import {SubscriptionEtatDto} from 'src/app/controller/model/SubscriptionEtat.model';
import {SubscriptionEtatCriteria} from 'src/app/controller/criteria/SubscriptionEtatCriteria.model';

@Component({
  selector: 'app-subscription-etat-view-admin',
  templateUrl: './subscription-etat-view-admin.component.html'
})
export class SubscriptionEtatViewAdminComponent extends AbstractViewController<SubscriptionEtatDto, SubscriptionEtatCriteria, SubscriptionEtatService> implements OnInit {


    constructor(private subscriptionEtatService: SubscriptionEtatService){
        super(subscriptionEtatService);
    }

    ngOnInit(): void {
    }




}
