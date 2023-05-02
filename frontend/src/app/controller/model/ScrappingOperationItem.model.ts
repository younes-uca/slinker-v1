import {TypeProduitDto} from './TypeProduit.model';
import {ScrappingOperationDto} from './ScrappingOperation.model';
import {ScrappingLinkDto} from './ScrappingLink.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ScrappingOperationItemDto  extends BaseDto{

    public id: number;
    public prix: number;
    public stock: string;
    public image: string;
    public description: string;
    public review: string;
    public prixMax: string ;
    public prixMin: string ;
    public scrappingLink: ScrappingLinkDto ;
    public typeProduit: TypeProduitDto ;
    public scrappingOperation: ScrappingOperationDto ;

}
