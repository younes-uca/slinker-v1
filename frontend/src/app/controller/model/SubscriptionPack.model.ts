import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SubscriptionPackDto  extends BaseDto{

    public id: number;
    public code: string;
    public libelle: string;
    public prix: number;
    public prixMax: string ;
    public prixMin: string ;

}
