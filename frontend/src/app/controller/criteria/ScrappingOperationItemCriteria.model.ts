import {TypeProduitCriteria} from './TypeProduitCriteria.model';
import {ScrappingOperationCriteria} from './ScrappingOperationCriteria.model';
import {ScrappingLinkCriteria} from './ScrappingLinkCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ScrappingOperationItemCriteria  extends   BaseCriteria  {

    public id: number;
     public prix: number;
     public prixMin: number;
     public prixMax: number;
    public stock: string;
    public stockLike: string;
    public image: string;
    public imageLike: string;
    public description: string;
    public descriptionLike: string;
    public review: string;
    public reviewLike: string;
  public scrappingLink: ScrappingLinkCriteria ;
  public scrappingLinks: Array<ScrappingLinkCriteria> ;
  public typeProduit: TypeProduitCriteria ;
  public typeProduits: Array<TypeProduitCriteria> ;
  public scrappingOperation: ScrappingOperationCriteria ;
  public scrappingOperations: Array<ScrappingOperationCriteria> ;

}
