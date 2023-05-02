import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SubscriptionDto} from '../model/Subscription.model';
import {SubscriptionCriteria} from '../criteria/SubscriptionCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SubscriptionTypeDto} from '../model/SubscriptionType.model';
import {SubscriptionPackDto} from '../model/SubscriptionPack.model';
import {SubscriptionEtatDto} from '../model/SubscriptionEtat.model';
import {TypePaiementDto} from '../model/TypePaiement.model';
import {ClientDto} from '../model/Client.model';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService extends AbstractService<SubscriptionDto, SubscriptionCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/subscription/');
    }

    public constrcutDto(): SubscriptionDto {
        return new SubscriptionDto();
    }

    public constrcutCriteria(): SubscriptionCriteria {
        return new SubscriptionCriteria();
    }
}
