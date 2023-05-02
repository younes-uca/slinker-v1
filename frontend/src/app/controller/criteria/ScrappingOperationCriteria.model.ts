import {ScrappingOperationItemCriteria} from './ScrappingOperationItemCriteria.model';
import {WebSiteCriteria} from './WebSiteCriteria.model';
import {AffliateCriteria} from './AffliateCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ScrappingOperationCriteria  extends   BaseCriteria  {

    public id: number;
    public dateDebutScrappingOperation: Date;
    public dateDebutScrappingOperationFrom: Date;
    public dateDebutScrappingOperationTo: Date;
    public dateFinScrappingOperation: Date;
    public dateFinScrappingOperationFrom: Date;
    public dateFinScrappingOperationTo: Date;
    public url: string;
    public urlLike: string;
  public affliate: AffliateCriteria ;
  public affliates: Array<AffliateCriteria> ;
  public webSite: WebSiteCriteria ;
  public webSites: Array<WebSiteCriteria> ;
      public scrappingOperationItems: Array<ScrappingOperationItemCriteria>;

}
