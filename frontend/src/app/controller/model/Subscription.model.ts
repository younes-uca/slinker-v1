import {SubscriptionTypeDto} from './SubscriptionType.model';
import {SubscriptionPackDto} from './SubscriptionPack.model';
import {SubscriptionEtatDto} from './SubscriptionEtat.model';
import {TypePaiementDto} from './TypePaiement.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SubscriptionDto  extends BaseDto{

    public id: number;
   public dateDebut: Date;
   public dateFin: Date;
    public delai: number;
   public nombrePage: number;
    public montantPaye: number;
   public datePaiement: Date;
    public dateDebutMax: string ;
    public dateDebutMin: string ;
    public dateFinMax: string ;
    public dateFinMin: string ;
    public delaiMax: string ;
    public delaiMin: string ;
    public nombrePageMax: string ;
    public nombrePageMin: string ;
    public montantPayeMax: string ;
    public montantPayeMin: string ;
    public datePaiementMax: string ;
    public datePaiementMin: string ;
    public subscriptionType: SubscriptionTypeDto ;
    public subscriptionPack: SubscriptionPackDto ;
    public subscriptionEtat: SubscriptionEtatDto ;
    public client: ClientDto ;
    public typePaiement: TypePaiementDto ;

}
