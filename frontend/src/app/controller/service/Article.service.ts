import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ArticleDto} from '../model/Article.model';
import {ArticleCriteria} from '../criteria/ArticleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {CommentaireDto} from '../model/Commentaire.model';

@Injectable({
  providedIn: 'root'
})
export class ArticleService extends AbstractService<ArticleDto, ArticleCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/article/');
    }

    public constrcutDto(): ArticleDto {
        return new ArticleDto();
    }

    public constrcutCriteria(): ArticleCriteria {
        return new ArticleCriteria();
    }
}
