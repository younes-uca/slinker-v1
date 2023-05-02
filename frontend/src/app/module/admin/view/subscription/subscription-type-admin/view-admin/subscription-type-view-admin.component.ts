import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SubscriptionTypeService} from 'src/app/controller/service/SubscriptionType.service';
import {SubscriptionTypeDto} from 'src/app/controller/model/SubscriptionType.model';
import {SubscriptionTypeCriteria} from 'src/app/controller/criteria/SubscriptionTypeCriteria.model';

@Component({
  selector: 'app-subscription-type-view-admin',
  templateUrl: './subscription-type-view-admin.component.html'
})
export class SubscriptionTypeViewAdminComponent extends AbstractViewController<SubscriptionTypeDto, SubscriptionTypeCriteria, SubscriptionTypeService> implements OnInit {


    constructor(private subscriptionTypeService: SubscriptionTypeService){
        super(subscriptionTypeService);
    }

    ngOnInit(): void {
    }




}
