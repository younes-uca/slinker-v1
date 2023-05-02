import {ScrappingOperationItemDto} from './ScrappingOperationItem.model';
import {WebSiteDto} from './WebSite.model';
import {AffliateDto} from './Affliate.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ScrappingOperationDto  extends BaseDto{

    public id: number;
   public dateDebutScrappingOperation: Date;
   public dateFinScrappingOperation: Date;
    public url: string;
    public dateDebutScrappingOperationMax: string ;
    public dateDebutScrappingOperationMin: string ;
    public dateFinScrappingOperationMax: string ;
    public dateFinScrappingOperationMin: string ;
    public affliate: AffliateDto ;
    public webSite: WebSiteDto ;
     public scrappingOperationItems: Array<ScrappingOperationItemDto>;

}
