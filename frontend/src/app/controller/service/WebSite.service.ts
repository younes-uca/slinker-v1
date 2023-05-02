import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {WebSiteDto} from '../model/WebSite.model';
import {WebSiteCriteria} from '../criteria/WebSiteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {StatutWebSiteDto} from '../model/StatutWebSite.model';
import {ScrappingLinkDto} from '../model/ScrappingLink.model';
import {ClientDto} from '../model/Client.model';

@Injectable({
  providedIn: 'root'
})
export class WebSiteService extends AbstractService<WebSiteDto, WebSiteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/webSite/');
    }

    public constrcutDto(): WebSiteDto {
        return new WebSiteDto();
    }

    public constrcutCriteria(): WebSiteCriteria {
        return new WebSiteCriteria();
    }
}
