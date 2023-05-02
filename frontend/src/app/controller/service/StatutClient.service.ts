import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {StatutClientDto} from '../model/StatutClient.model';
import {StatutClientCriteria} from '../criteria/StatutClientCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class StatutClientService extends AbstractService<StatutClientDto, StatutClientCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/statutClient/');
    }

    public constrcutDto(): StatutClientDto {
        return new StatutClientDto();
    }

    public constrcutCriteria(): StatutClientCriteria {
        return new StatutClientCriteria();
    }
}
