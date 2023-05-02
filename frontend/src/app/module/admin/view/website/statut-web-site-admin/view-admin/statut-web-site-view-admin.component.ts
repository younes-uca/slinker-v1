import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {StatutWebSiteService} from 'src/app/controller/service/StatutWebSite.service';
import {StatutWebSiteDto} from 'src/app/controller/model/StatutWebSite.model';
import {StatutWebSiteCriteria} from 'src/app/controller/criteria/StatutWebSiteCriteria.model';

@Component({
  selector: 'app-statut-web-site-view-admin',
  templateUrl: './statut-web-site-view-admin.component.html'
})
export class StatutWebSiteViewAdminComponent extends AbstractViewController<StatutWebSiteDto, StatutWebSiteCriteria, StatutWebSiteService> implements OnInit {


    constructor(private statutWebSiteService: StatutWebSiteService){
        super(statutWebSiteService);
    }

    ngOnInit(): void {
    }




}
