import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CommentaireDto} from '../model/Commentaire.model';
import {CommentaireCriteria} from '../criteria/CommentaireCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ArticleDto} from '../model/Article.model';

@Injectable({
  providedIn: 'root'
})
export class CommentaireService extends AbstractService<CommentaireDto, CommentaireCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/commentaire/');
    }

    public constrcutDto(): CommentaireDto {
        return new CommentaireDto();
    }

    public constrcutCriteria(): CommentaireCriteria {
        return new CommentaireCriteria();
    }
}
