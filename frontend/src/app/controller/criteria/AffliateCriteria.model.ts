import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class AffliateCriteria  extends   BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;

}
