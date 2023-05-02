import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SubscriptionEtatDto} from '../model/SubscriptionEtat.model';
import {SubscriptionEtatCriteria} from '../criteria/SubscriptionEtatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SubscriptionEtatService extends AbstractService<SubscriptionEtatDto, SubscriptionEtatCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/subscriptionEtat/');
    }

    public constrcutDto(): SubscriptionEtatDto {
        return new SubscriptionEtatDto();
    }

    public constrcutCriteria(): SubscriptionEtatCriteria {
        return new SubscriptionEtatCriteria();
    }
}
