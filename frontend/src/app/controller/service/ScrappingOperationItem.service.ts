import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ScrappingOperationItemDto} from '../model/ScrappingOperationItem.model';
import {ScrappingOperationItemCriteria} from '../criteria/ScrappingOperationItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {TypeProduitDto} from '../model/TypeProduit.model';
import {ScrappingOperationDto} from '../model/ScrappingOperation.model';
import {ScrappingLinkDto} from '../model/ScrappingLink.model';

@Injectable({
  providedIn: 'root'
})
export class ScrappingOperationItemService extends AbstractService<ScrappingOperationItemDto, ScrappingOperationItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/scrappingOperationItem/');
    }

    public constrcutDto(): ScrappingOperationItemDto {
        return new ScrappingOperationItemDto();
    }

    public constrcutCriteria(): ScrappingOperationItemCriteria {
        return new ScrappingOperationItemCriteria();
    }
}
