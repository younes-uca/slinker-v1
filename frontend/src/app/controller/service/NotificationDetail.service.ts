import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {NotificationDetailDto} from '../model/NotificationDetail.model';
import {NotificationDetailCriteria} from '../criteria/NotificationDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ClientDto} from '../model/Client.model';
import {NotificationDto} from '../model/Notification.model';

@Injectable({
  providedIn: 'root'
})
export class NotificationDetailService extends AbstractService<NotificationDetailDto, NotificationDetailCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/notificationDetail/');
    }

    public constrcutDto(): NotificationDetailDto {
        return new NotificationDetailDto();
    }

    public constrcutCriteria(): NotificationDetailCriteria {
        return new NotificationDetailCriteria();
    }
}
