import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AffliateDto} from '../model/Affliate.model';
import {AffliateCriteria} from '../criteria/AffliateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ClientDto} from '../model/Client.model';

@Injectable({
  providedIn: 'root'
})
export class AffliateService extends AbstractService<AffliateDto, AffliateCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/affliate/');
    }

    public constrcutDto(): AffliateDto {
        return new AffliateDto();
    }

    public constrcutCriteria(): AffliateCriteria {
        return new AffliateCriteria();
    }
}
