import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {NotificationDto} from '../model/Notification.model';
import {NotificationCriteria} from '../criteria/NotificationCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {NotificationDetailDto} from '../model/NotificationDetail.model';
import {StatutNotificationDto} from '../model/StatutNotification.model';

@Injectable({
  providedIn: 'root'
})
export class NotificationService extends AbstractService<NotificationDto, NotificationCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/notification/');
    }

    public constrcutDto(): NotificationDto {
        return new NotificationDto();
    }

    public constrcutCriteria(): NotificationCriteria {
        return new NotificationCriteria();
    }
}
