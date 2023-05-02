import {WebSiteDto} from './WebSite.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ScrappingLinkDto  extends BaseDto{

    public id: number;
    public code: string;
    public libelle: string;
    public webSite: WebSiteDto ;

}
