import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AffliateService} from 'src/app/controller/service/Affliate.service';
import {AffliateDto} from 'src/app/controller/model/Affliate.model';
import {AffliateCriteria} from 'src/app/controller/criteria/AffliateCriteria.model';

import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
@Component({
  selector: 'app-affliate-view-admin',
  templateUrl: './affliate-view-admin.component.html'
})
export class AffliateViewAdminComponent extends AbstractViewController<AffliateDto, AffliateCriteria, AffliateService> implements OnInit {


    constructor(private affliateService: AffliateService, private clientService: ClientService){
        super(affliateService);
    }

    ngOnInit(): void {
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }


    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }


}
