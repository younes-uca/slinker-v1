import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SubscriptionPackService} from 'src/app/controller/service/SubscriptionPack.service';
import {SubscriptionPackDto} from 'src/app/controller/model/SubscriptionPack.model';
import {SubscriptionPackCriteria} from 'src/app/controller/criteria/SubscriptionPackCriteria.model';

@Component({
  selector: 'app-subscription-pack-view-admin',
  templateUrl: './subscription-pack-view-admin.component.html'
})
export class SubscriptionPackViewAdminComponent extends AbstractViewController<SubscriptionPackDto, SubscriptionPackCriteria, SubscriptionPackService> implements OnInit {


    constructor(private subscriptionPackService: SubscriptionPackService){
        super(subscriptionPackService);
    }

    ngOnInit(): void {
    }




}
