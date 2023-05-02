import {StatutWebSiteCriteria} from './StatutWebSiteCriteria.model';
import {ScrappingLinkCriteria} from './ScrappingLinkCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class WebSiteCriteria  extends   BaseCriteria  {

    public id: number;
    public url: string;
    public urlLike: string;
    public libelle: string;
    public libelleLike: string;
    public jsonSummary: string;
    public jsonSummaryLike: string;
  public statutWebSite: StatutWebSiteCriteria ;
  public statutWebSites: Array<StatutWebSiteCriteria> ;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
      public scrappingLinks: Array<ScrappingLinkCriteria>;

}
