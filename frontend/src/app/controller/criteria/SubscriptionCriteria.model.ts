import {SubscriptionTypeCriteria} from './SubscriptionTypeCriteria.model';
import {SubscriptionPackCriteria} from './SubscriptionPackCriteria.model';
import {SubscriptionEtatCriteria} from './SubscriptionEtatCriteria.model';
import {TypePaiementCriteria} from './TypePaiementCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SubscriptionCriteria  extends   BaseCriteria  {

    public id: number;
    public dateDebut: Date;
    public dateDebutFrom: Date;
    public dateDebutTo: Date;
    public dateFin: Date;
    public dateFinFrom: Date;
    public dateFinTo: Date;
     public delai: number;
     public delaiMin: number;
     public delaiMax: number;
     public nombrePage: number;
     public nombrePageMin: number;
     public nombrePageMax: number;
     public montantPaye: number;
     public montantPayeMin: number;
     public montantPayeMax: number;
    public datePaiement: Date;
    public datePaiementFrom: Date;
    public datePaiementTo: Date;
  public subscriptionType: SubscriptionTypeCriteria ;
  public subscriptionTypes: Array<SubscriptionTypeCriteria> ;
  public subscriptionPack: SubscriptionPackCriteria ;
  public subscriptionPacks: Array<SubscriptionPackCriteria> ;
  public subscriptionEtat: SubscriptionEtatCriteria ;
  public subscriptionEtats: Array<SubscriptionEtatCriteria> ;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public typePaiement: TypePaiementCriteria ;
  public typePaiements: Array<TypePaiementCriteria> ;

}
