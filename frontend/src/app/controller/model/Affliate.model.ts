import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class AffliateDto  extends BaseDto{

    public id: number;
    public code: string;
    public libelle: string;
    public client: ClientDto ;

}
