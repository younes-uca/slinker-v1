import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ScrappingOperationDto} from '../model/ScrappingOperation.model';
import {ScrappingOperationCriteria} from '../criteria/ScrappingOperationCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ScrappingOperationItemDto} from '../model/ScrappingOperationItem.model';
import {WebSiteDto} from '../model/WebSite.model';
import {AffliateDto} from '../model/Affliate.model';

@Injectable({
  providedIn: 'root'
})
export class ScrappingOperationService extends AbstractService<ScrappingOperationDto, ScrappingOperationCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/scrappingOperation/');
    }

    public constrcutDto(): ScrappingOperationDto {
        return new ScrappingOperationDto();
    }

    public constrcutCriteria(): ScrappingOperationCriteria {
        return new ScrappingOperationCriteria();
    }
}
