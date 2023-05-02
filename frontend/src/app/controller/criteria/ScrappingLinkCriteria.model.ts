import {WebSiteCriteria} from './WebSiteCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ScrappingLinkCriteria  extends   BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public webSite: WebSiteCriteria ;
  public webSites: Array<WebSiteCriteria> ;

}
