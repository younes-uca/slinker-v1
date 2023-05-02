import {StatutWebSiteDto} from './StatutWebSite.model';
import {ScrappingLinkDto} from './ScrappingLink.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class WebSiteDto  extends BaseDto{

    public id: number;
    public url: string;
    public libelle: string;
    public jsonSummary: string;
    public statutWebSite: StatutWebSiteDto ;
    public client: ClientDto ;
     public scrappingLinks: Array<ScrappingLinkDto>;

}
