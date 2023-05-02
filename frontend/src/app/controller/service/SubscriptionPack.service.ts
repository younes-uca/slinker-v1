import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SubscriptionPackDto} from '../model/SubscriptionPack.model';
import {SubscriptionPackCriteria} from '../criteria/SubscriptionPackCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SubscriptionPackService extends AbstractService<SubscriptionPackDto, SubscriptionPackCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/subscriptionPack/');
    }

    public constrcutDto(): SubscriptionPackDto {
        return new SubscriptionPackDto();
    }

    public constrcutCriteria(): SubscriptionPackCriteria {
        return new SubscriptionPackCriteria();
    }
}
