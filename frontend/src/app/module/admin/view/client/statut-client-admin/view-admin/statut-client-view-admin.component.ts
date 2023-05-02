import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {StatutClientService} from 'src/app/controller/service/StatutClient.service';
import {StatutClientDto} from 'src/app/controller/model/StatutClient.model';
import {StatutClientCriteria} from 'src/app/controller/criteria/StatutClientCriteria.model';

@Component({
  selector: 'app-statut-client-view-admin',
  templateUrl: './statut-client-view-admin.component.html'
})
export class StatutClientViewAdminComponent extends AbstractViewController<StatutClientDto, StatutClientCriteria, StatutClientService> implements OnInit {


    constructor(private statutClientService: StatutClientService){
        super(statutClientService);
    }

    ngOnInit(): void {
    }




}
